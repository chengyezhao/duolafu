package com.shoumipay.v2;

import com.shoumipay.v2.domain.docs.MemberDocument;
import com.shoumipay.v2.repository.MemberDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * 保存从第三方抓取的用户的信息
 */
@Service
public class DocumentUtils {

    public static String JXL = "JXL";
    public static String TAOBAO = "TB";
    public static String JD = "JD";
    public static String BQS_BL = "BQS_BL";
    public static String BQS_LOAN = "BQS_LOAN";
    public static String ADF = "ADF";

    @Autowired
    private MongoTemplate template;
    @Autowired
    private MemberDocumentRepository repository;

    public MemberDocumentRepository getRepository() {
        return repository;
    }

    public void setRepository(MemberDocumentRepository repository) {
        this.repository = repository;
    }

    private static DocumentUtils instance;

    public DocumentUtils(){
        DocumentUtils.instance = this;
    }

    public static DocumentUtils getInstance(){
        return instance;
    }

    public MemberDocument getByMemberId(Long memberId, String type){
       List<MemberDocument> docs = repository.findByMemberIdAndType(memberId, type);
       if(docs.size() > 0){
           return docs.get(0);
       }
       return null;
    }

    public boolean hasDocument(Long memberId, String type){
        return repository.countByMemberIdAndType(memberId, type) > 0;
    }

    public void update(Long memberId, String type, Object document){
        if(hasDocument(memberId, type)) {
            template.updateFirst(query(where("memberId").is(memberId).and("type").is(type)),
                    new Update().set("doc", document).set("lastUpdatedDate", new Date()),
                    MemberDocument.class);
        }else{
            MemberDocument memberDocument = new MemberDocument();
            memberDocument.setMemberId(memberId);
            memberDocument.setDoc(document);
            memberDocument.setType(type);
            memberDocument.setLastUpatedDate(new Date());
            template.save(memberDocument);
        }
    }

    public void remove(Long memberId, String type){
        template.remove(query(where("memberId").is(memberId).and("type").is(type)), MemberDocument.class);
    }

}
