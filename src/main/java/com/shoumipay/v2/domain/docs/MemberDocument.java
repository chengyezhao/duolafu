package com.shoumipay.v2.domain.docs;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class MemberDocument {

    @Id
    private ObjectId objectId;

    private Long memberId;
    private String type;
    private Object doc;
    private Date lastUpatedDate;

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getDoc() {
        return doc;
    }

    public void setDoc(Object doc) {
        this.doc = doc;
    }

    public Date getLastUpatedDate() {
        return lastUpatedDate;
    }

    public void setLastUpatedDate(Date lastUpatedDate) {
        this.lastUpatedDate = lastUpatedDate;
    }
}
