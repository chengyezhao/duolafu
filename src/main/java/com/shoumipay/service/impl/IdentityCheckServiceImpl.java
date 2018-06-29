package com.shoumipay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shoumipay.service.admin.IdentityCheckService;
import com.shoumipay.service.cache.SystemCacheService;
import com.shoumipay.smsmessage.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import static com.shoumipay.service.cache.SystemCacheService.LOCAL_HOST;

/**
 * Created by Administrator on 2017/10/20.
 */
@Service
public class IdentityCheckServiceImpl implements IdentityCheckService{

    @Autowired
    SystemCacheService systemCacheService;
 @Override
    public Map<String, String> educationXmlMap(String name,Date sendTime, String cid, String degree,String channelOrderId) {
        return XmlUtils.getReturnMap(XmlUtils.createEducationXml(name,sendTime, cid, degree,channelOrderId));
    }

    @Override
    public Map<String, String> phoneNameCidXmlMap(String name, String cid, String phone, Date sendTime, String channelOrderId) {
        return XmlUtils.getReturnMap(XmlUtils.createPhoneNameCidXml(name,cid,phone,sendTime,channelOrderId));
    }

    @Override
    public Map<String, String> nameXmlMap(String name, String cid, Date sendTime, String channelOrderId) {
        return XmlUtils.getReturnMap(XmlUtils.createNameXml(name,cid,sendTime,channelOrderId));
    }

    @Override
    public Map<String, String> brokeXmlMap(String name, String cid,Date sendTime,String channelOrderId) {
        return XmlUtils.getReturnMap(XmlUtils.createBrokeXml(name, cid,sendTime,channelOrderId));
    }

    @Override
    public Map<String, String> personXmlMap(String name, String cid,Date sendTime,String channelOrderId) {
        return XmlUtils.getReturnMap(XmlUtils.createPersonXml(name,cid,sendTime,channelOrderId));
    }

    @Override
    public Map<String, String> cardXmlMap(String name, String cid, String phone, String cardNo,Date sendTime,String channelOrderId) {
        return XmlUtils.getReturnMap(XmlUtils.createCardXml(name,cid,phone,cardNo,sendTime,channelOrderId));
    }

    @Override
    public JSONObject querySesameXmlMap(String openId, Date sendTime, String channelOrderId) {
        return XmlUtils.getReturnMapSea(XmlUtils.querySesameXml(openId,sendTime,channelOrderId));
    }

    @Override
    public JSONObject sesameXmlMap(String name, String cid, Date sendTime, String channelOrderId) {
        return XmlUtils.getReturnMapSea(XmlUtils.createSesameXml(name,cid,sendTime,channelOrderId,systemCacheService.get(LOCAL_HOST).getValue()));
    }
}
