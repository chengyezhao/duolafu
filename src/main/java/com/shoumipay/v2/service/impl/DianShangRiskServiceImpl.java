package com.shoumipay.v2.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.docs.MemberDocument;
import com.shoumipay.v2.service.DianShangRiskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DianShangRiskServiceImpl implements DianShangRiskService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int getHuabeiQuota(Member member) {
        MemberDocument document = DocumentUtils.getInstance().getByMemberId(member.getUid(), DocumentUtils.TAOBAO);
        if(document != null && !StringUtils.isEmpty((String) document.getDoc())){
            try{
                JSONObject object = JSON.parseObject((String) document.getDoc());
                JSONObject authJson = object.getJSONObject("authJson");
                if(authJson != null){
                    JSONObject ecommerceBaseInfo = authJson.getJSONObject("ecommerceBaseInfo");
                    if(ecommerceBaseInfo != null){
                        Integer huabeiAmount = ecommerceBaseInfo.getInteger("huabeiAmount");
                        if(null != huabeiAmount){
                            return huabeiAmount;
                        }
                    }
                }
            }catch (Exception e){
                logger.info("解析淘宝数据失败：" + member.getUid());
            }
        }
        return 0;
    }
}
