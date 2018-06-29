package com.shoumipay.smsmessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.*;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Administrator on 2017/9/27.
 */
public class XmlUtils {
    //RSA 公钥 (String)
    private static String KEY = Config.KEY;
    //渠道代码
    private static String channelId = Config.CHANNELID;
    //请求地址
    private static String requestUrl = Config.REQUESTURL;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
// !!!注意传过来参数中的身份证号码最后一位是字母X,需要大写！！！

    public static void main(String[] args) {
        String a= "<h1>玖易贷借款及服务协议</h1>\n" +
                "            \"<div class=\\\"font01\\\">协议编号：<span class=\\\"border01\\\">{PROTOCOL}</span></div>\n" +
                "            \"<h2>第一部分：借款、服务信息及相关明";
        a= a.replaceAll("\"","\'");
         a = a.replaceAll("\\n' +","");
         System.out.println(a);
    }

    //信息查询map返回
    public static Map<String, String> getReturnMap(String xml) {
        Map<String, String> map = new Hashtable<>();
        //String 转 PublicKey
        PublicKey key = SecretKeyUtils.getPublicKey(KEY);
        //随机生成的秘钥
        String key1 = SecretKeyUtils.generateMixString(24);
        String msg = XmlUtils.createMessage(xml, channelId, key, key1);
        HttpClientUtil clientUtil = new HttpClientUtil();
        String message = clientUtil.doPost(requestUrl, msg);
       // String message = RedirectForm.autoPost(requestUrl,"req_data", msg);
        System.out.println(key1);
        map = XmlUtils.addMessage(message, key1);
        return map;
    }
    //信息查询map返回
    public static JSONObject getReturnMapSea(String xml) {
        JSONObject result = new JSONObject();
        //String 转 PublicKey
        PublicKey key = SecretKeyUtils.getPublicKey(KEY);
        //随机生成的秘钥
        String key1 = SecretKeyUtils.generateMixString(24);
        String msg = XmlUtils.createMessage(xml, channelId, key, key1);
        HttpClientUtil clientUtil = new HttpClientUtil();
        String message = clientUtil.doPost(requestUrl, msg);
        // String message = RedirectForm.autoPost(requestUrl,"req_data", msg);
        System.out.println(key1);
        result = XmlUtils.addMessageSea(message, key1);
        return result;
    }

    //学历信息核查
    public static String createEducationXml(String name, Date sendtime, String cid, String degree, String channelOrderId) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<subatm>" +
                "<application>GwBiz.Req</application>" +
                "<version>1.0.0</version>" +
                "<sendTime>" + sdf.format(sendtime) + "</sendTime>" +
                "<transCode>300502</transCode>" +
                "<channelId>" + channelId + "</channelId>" +
                "<channelOrderId>" + channelOrderId + "</channelOrderId>" +
                "<cid>" + cid + "</cid>" +
                "<name>" + name + "</name>" +
                "<degree>" + degree + "</degree>" +
                "</subatm>";
        return xml;
    }

    //自然人被执行人信息查询
    public static String createPersonXml(String name, String cid, Date sendTime, String channelOrderId) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<subatm>" +
                "<application>GwBiz.Req</application>" +
                "<version>1.0.0</version>" +
                "<sendTime>" + sdf.format(sendTime) + "</sendTime>" +
                "<transCode>300611</transCode>" +
                "<channelId>" + channelId + "</channelId>" +
                "<channelOrderId>" + channelOrderId + "</channelOrderId>" +
                "<name>" + name + "</name>" +
                "<idNumber>" + cid + "</idNumber>" +
                "</subatm>";
        return xml;
    }

    //自然人失信人信息查询
    public static String createBrokeXml(String name, String cid, Date sendTime, String channelOrderId) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<subatm>" +
                "<application>GwBiz.Req</application>" +
                "<version>1.0.0</version>" +
                "<sendTime>" + sdf.format(sendTime) + "</sendTime>" +
                "<transCode>300612</transCode>" +
                "<channelId>" + channelId + "</channelId>" +
                "<channelOrderId>" + channelOrderId + "</channelOrderId>" +
                "<name>" + name + "</name>" +
                "<idNumber>" + cid + "</idNumber>" +
                "<skipAmount></skipAmount>" +
                "<pageSize ></pageSize >" +
                "</subatm>";
        return xml;
    }
    //实名认证
    public static String createNameXml(String name, String cid,Date sendTime, String channelOrderId) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<subatm>" +
                "<application>GwBiz.Req</application>" +
                "<version>1.0.0</version>" +
                "<sendTime>" + sdf.format(sendTime) + "</sendTime>" +
                "<transCode>100048</transCode>" +
                "<channelId>" + channelId + "</channelId>" +
                "<channelOrderId>" + channelOrderId + "</channelOrderId>" +
                "<name>" + name + "</name>" +
                "<cid>" + cid + "</cid>" +
                "</subatm>";
        return xml;
    }
    //手机姓名身份证认证
    public static String createPhoneNameCidXml(String name, String cid,String phone, Date sendTime, String channelOrderId) {
        //将身份证号码转大写字母
        cid = cid.toUpperCase();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<subatm>" +
                "<application>GwBiz.Req</application>" +
                "<version>1.0.0</version>" +
                "<sendTime>" + sdf.format(sendTime) + "</sendTime>" +
                "<transCode>100054</transCode>" +
                "<channelId>" + channelId + "</channelId>" +
                "<channelOrderId>" + channelOrderId + "</channelOrderId>" +
                "<phone>" + phone + "</phone>" +
                "<name>" + name + "</name>" +
                "<idCard>" + cid + "</idCard>" +
                "<type>1</type>" +
                "</subatm>";
        return xml;
    }
    //银行卡账户认证
    public static String createCardXml(String name, String cid, String phone, String cardNo, Date sendTime, String channelOrderId) {
        //将身份证号码转大写字母
        cid = cid.toUpperCase();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<subatm>" +
                "<application>GwBiz.Req</application>" +
                "<version>1.0.0</version>" +
                "<sendTime>" + sdf.format(sendTime) + "</sendTime>" +
                "<transCode>100060</transCode>" +
                "<channelId>" + channelId + "</channelId>" +
                "<verifyMode>1</verifyMode>" +
                "<channelOrderId>" + channelOrderId + "</channelOrderId>" +
                "<name>" + name + "</name>" +
                "<cid>" + cid + "</cid>" +
                "<phone>" + phone + "</phone>" +
                "<cardNo>" + cardNo + "</cardNo>" +
                "</subatm>";
        return xml;
    }

    //芝麻分授权(linkedMerchantId 回调地址)
    public static String createSesameXml(String name, String cid, Date sendTime, String channelOrderId,String LOCAL_HOST) {
        //将身份证号码转大写字母
        cid = cid.toUpperCase();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<subatm>" +
                "<application>GwBiz.Req</application>" +
                "<version>1.0.0</version>" +
                "<sendTime>" + sdf.format(sendTime) + "</sendTime>" +
                "<transCode>101007</transCode>" +
                "<channelId>"+channelId+"</channelId>" +
              "<channelOrderId>" + channelOrderId + "</channelOrderId>" +
                "<returnUrl>"+LOCAL_HOST+"/services/notify/Sea</returnUrl>" +
                "<linkedMerchantId>2088721565805397</linkedMerchantId>" +
                "    <authCode>M_H5</authCode>" +
                "<name>" + name + "</name>" +
                "<certNo>" + cid + "</certNo>" +
                "<personality>1</personality>" +
                "</subatm>";
        System.out.println(xml);
        return xml;
    }
    //芝麻分查询
    public static String querySesameXml(String openId, Date sendTime, String channelOrderId) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<subatm>" +
                "<application>GwBiz.Req</application>" +
                "<version>1.0.0</version>" +
                "<sendTime>" + sdf.format(sendTime) + "</sendTime>" +
                "<transCode>100101</transCode>" +
                "<channelId>"+channelId+"</channelId>" +
                "<channelOrderId>" + channelOrderId + "</channelOrderId>" +
                "<linkedMerchantId>2088721565805397</linkedMerchantId>" +
                "<openId>" + openId + "</openId>" +
                "<productItemCode>" + 101008 + "</productItemCode>" +
                "</subatm>";
        return xml;
    }

    //请求报文进行加密
    private static String createMessage(String xml, String ChannelIdentification, PublicKey KEY, String key1) {
        try {
            //渠道标识 BASE64(渠道标识)
            String channel = SecretKeyUtils.encryptBASE64(ChannelIdentification.getBytes("UTF-8"));
            //报文加密秘钥 BASE64(RSA(报文加密密钥))
            String key = SecretKeyUtils.encryptBASE64(SecretKeyUtils.RSAEncode(KEY, key1.getBytes("UTF-8")));
            //报文原文 BASE64(3DES(报文原文))
            String xmls = SecretKeyUtils.encryptBASE64(SecretKeyUtils.encryptMode(key1.getBytes("UTF-8"), xml.getBytes("UTF-8")));
            //加密报文 BASE64(渠道标识)| BASE64(RSA(报文加密密钥))| BASE64(3DES(报文原文))
            String msg = channel + "|" + key + "|" + xmls;
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //对验证平台返回的响应报文解密
    private static Map<String, String> addMessage(String msg, String key) {
        //String msg 响应报文
        Map<String, String> map = new Hashtable<>();
        if (msg == null) {
            map.put("error", "第三方响应报文为空");
            return map;
        }
        String errorCode = null;
        String content = null;
        String[] contentStrArray = msg.split("\\|");
        if ("1".equals(contentStrArray[0])) {
            content = contentStrArray[1];
            try {
                content = new String(SecretKeyUtils.decryptMode(key.getBytes("UTF-8"), SecretKeyUtils.decryptBASE64(content)));
                System.out.println(content);
                Document doc = DocumentHelper.parseText(content);//将xml转为dom对象
                Element root = doc.getRootElement();//获取根节点
                //     Element element = root.element("subatm");//获取名称为subatm的子节点
                List<Element> elements = root.elements();//获取这个子节点里面的所有子元素，也可以element.elements("userList")指定获取子元素
                for (Element obj : elements) {  //遍历子元素
                    //    element = (Element) obj;
                    map.put(obj.getName(), obj.getTextTrim());
                    //     System.out.println(obj.getName()+"--"+obj.getTextTrim());
                }
            } catch (DocumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("0".equals(contentStrArray[0])) {
            errorCode = contentStrArray[1];
            content = contentStrArray[2];
            content = new String(SecretKeyUtils.decryptBASE64(content));
            map.put(errorCode, content);
        }
        return map;
    }
    //对验证平台返回的响应报文解密(芝麻信用)
    private static JSONObject addMessageSea(String msg, String key) {
        //String msg 响应报文
        JSONObject result = new JSONObject();
        if (msg == null) {
            result.put("error", "第三方响应报文为空");
            return result;
        }
        String errorCode = null;
        String content = null;
        String[] contentStrArray = msg.split("\\|");
        if ("1".equals(contentStrArray[0])) {
            content = contentStrArray[1];
            try {
                content = new String(SecretKeyUtils.decryptMode(key.getBytes("UTF-8"), SecretKeyUtils.decryptBASE64(content)));
                System.out.println(content);
                result = JSON.parseObject(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("0".equals(contentStrArray[0])) {
            errorCode = contentStrArray[1];
            content = contentStrArray[2];
            content = new String(SecretKeyUtils.decryptBASE64(content));
            result.put(errorCode, content);
        }
        return result;
    }
    //获取渠道订单
    public static String getChannelId(String uid){
        return uid+sdf.format(new Date());
    }
}
