package com.shoumipay.v2.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.service.admin.MemberDetailService;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.docs.MemberDocument;
import com.shoumipay.v2.service.BQSRiskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.function.Function;

import static com.shoumipay.v2.DocumentUtils.BQS_BL;
import static com.shoumipay.v2.DocumentUtils.BQS_LOAN;

@Service
public class BQSRiskServiceImpl implements BQSRiskService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${bqs.address}")
    public String address;
    @Value("${bqs.partnerId}")
    public String partnerId;
    @Value("${bqs.verifyKey}")
    public String verifyKey;
    @Value("${bqs.appId}")
    public String appId;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberDetailService memberDetailService;

    /**
     * {
         “verifyKey”: “xxxxx”,
         “partnerId”: “xxxxx”,
         “appId”: “xxxxx”,
         “eventType”: “register”,
         “mobile”: “13530874222”,
         “certNo”: “110101198602537066”,
         “name”: “张三”
     }
     * @return
     */
    private Function<Pair<Member, MemberDetail>, String> getBqsApiCallFunc(String verifyKey, String partnerId,
                                                                           String appId, String eventType){
        return info -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("verifyKey", verifyKey);
            jsonObject.put("partnerId", partnerId);
            jsonObject.put("appId", appId);
            jsonObject.put("eventType", eventType);
            jsonObject.put("mobile", info.getFirst().getPhoneNumber());
            jsonObject.put("certNo", info.getSecond().getIdCard());
            jsonObject.put("name", info.getSecond().getFullname());
            int retry = 3;
            while(retry > 0) {
                String result = HttpRequestUtils.sendPost(address, jsonObject.toString(),
                        true);
                if(StringUtils.isEmpty(result)){
                    retry--;
                    continue;
                }else{
                    return result;
                }
            }
            return null;
        };

    }

    private BQSRisk processBQSRisk(Member member, String docType,
                                   Function<Pair<Member, MemberDetail>, String> apiCall){
        if(member == null){
            return BQSRisk.Unknown;
        }
        MemberDetail detail = memberDetailService.selectByMemberId(member.getUid());
        if(detail == null){
            return BQSRisk.Unknown;
        }
        //如果doc是空的，则读取白骑士风控信息
        MemberDocument doc = DocumentUtils.getInstance().getByMemberId(member.getUid(), docType);
        String bkJsonStr = null;
        if(doc == null) {
            bkJsonStr = apiCall.apply(Pair.of(member, detail));
            //如果没有获得黑名单信息，则直接返回拒绝
            if(StringUtils.isEmpty(bkJsonStr)){
                //TODO: 使用应用监控平台报警
                logger.info("无法获取白骑士的信息: " + docType + "," + member.getUid());
                return BQSRisk.Unknown;
            }else {
                DocumentUtils.getInstance().update(member.getUid(), BQS_BL, bkJsonStr);
            }
        }else{
            bkJsonStr = (String) doc.getDoc();
        }
        //解析信息
        try {
            JSONObject json = JSON.parseObject(bkJsonStr);
            //判断白骑士结果是否通过
            String finalDecision = json.getString("finalDecision");
            String resultCode = json.getString("resultCode");
            if(!StringUtils.equals("BQS000", resultCode)){
                return BQSRisk.Unknown;
            }
            if(StringUtils.equals("Accept", finalDecision)){
                return BQSRisk.Accepted;
            }else if(StringUtils.equals("Reject", finalDecision)){
                return BQSRisk.Rejected;
            }else {
                logger.info("白骑士发现用户存在风险: "+ docType + "," + member.getUid());
                return BQSRisk.Review;
            }
        }catch (Exception e){
            //TODO: 使用应用监控平台报警
            DocumentUtils.getInstance().remove(member.getUid(), docType);
            logger.info("无法解析白骑士的信息: " + member.getUid() + ", " +bkJsonStr);
            return BQSRisk.Unknown;
        }

    }

    @Override
    public BQSRisk isMemberInBlackList(Member member) {
        return processBQSRisk(member, BQS_BL, this.getBqsApiCallFunc(this.verifyKey, this.partnerId, this.appId, "blacklist"));
    }

    @Override
    public BQSRisk isMemberHasLoanRisk(Member member) {
        return processBQSRisk(member, BQS_LOAN, this.getBqsApiCallFunc(this.verifyKey, this.partnerId, this.appId, "loan"));
    }
}
