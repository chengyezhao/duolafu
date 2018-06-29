package com.shoumipay.v2.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.service.admin.MemberDetailService;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import com.shoumipay.v2.service.BQSdataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service()
public class BQSdataServiceImpl implements BQSdataService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${bqs.partnerId}")
    public String partnerId;
    @Value("${bqs.verifyKey}")
    public String verifyKey;


    @Autowired
    private MemberDetailService memberDetailService;

    @Override
    public String login(Member member,String userName,String pwd,String reqId,String authCode) {
        MemberDetail detail = memberDetailService.selectByMemberId(member.getUid());
        String url = "https://credit.baiqishi.com/clweb/api/tb/login";
        JSONObject json = new JSONObject();
        json.put("partnerId", partnerId);
        json.put("certNo", detail.getIdCard());
        json.put("mobile", member.getPhoneNumber());
        json.put("name", detail.getFullname());
        json.put("type","1");
        json.put("userName", userName);
        json.put("pwd", pwd);
        if (authCode != null){
            json.put("reqId",reqId);
            json.put("smsCode",authCode);
        }
        String data = HttpRequestUtils.sendPost(url, json.toJSONString(),true);
        return data;
    }


    @Override
    public String getTaobao(Member member) {
        String url = "https://credit.baiqishi.com/clweb/api/tb/getoriginal";
        MemberDetail detail = memberDetailService.selectByMemberId(member.getUid());
        JSONObject json = new JSONObject();
        json.put("partnerId", partnerId);
        json.put("verifyKey", verifyKey);
        json.put("name", detail.getFullname());
        json.put("certNo", detail.getIdCard());
        json.put("mobile", member.getPhoneNumber());
        String data = HttpRequestUtils.sendPost(url, json.toJSONString(),true);
        JSONObject jsonObject = json.parseObject(data);
        logger.info("---"+jsonObject.getString(""));
        return data;
    }
}
