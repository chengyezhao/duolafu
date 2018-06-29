package com.shoumipay.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.smsmessage.SecretKeyUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public class SignUtils {
    public static String genSign(JSONObject reqObj)
    {
        String sign = reqObj.getString("sign");
        String sign_type=reqObj.getString("sign_type");
        // // 生成待签名串
        String sign_src = genSignData(reqObj);
        System.out.println("商户[" + reqObj.getString("oid_partner") + "]待签名原串"
                + sign_src);
        System.out.println("商户[" + reqObj.getString("oid_partner") + "]签名串"
                + sign);

        if("MD5".equals(sign_type)){
            sign_src += "&key=" + PayParamter.TRADER_MD5_KEY_INSTALL;
            return signMD5(sign_src);
        }
        if("RSA".equals(sign_type)){
            return getSignRSA(sign_src);
        }
        return null;
    }
    public static String genSignWap(JSONObject reqObj)
    {
        String sign = reqObj.getString("sign");
        String sign_type=reqObj.getString("sign_type");
        // // 生成待签名串
        String sign_src = genSignData(reqObj);
        System.out.println("商户[" + reqObj.getString("oid_partner") + "]待签名原串"
                + sign_src);
        System.out.println("商户[" + reqObj.getString("oid_partner") + "]签名串"
                + sign);

        if("MD5".equals(sign_type)){
            sign_src += "&key=" + PayParamter.TRADER_MD5_KEY_WAP;
            return signMD5(sign_src);
        }
        if("RSA".equals(sign_type)){
            return getSignRSAWAP(sign_src);
        }
        return null;
    }

    private static String signMD5(String signSrc)
    {

        try
        {
            return Md5Algorithm.getInstance().md5Digest(
                    signSrc.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * RSA私钥签名
     *
     * @param
     * @return
     */
    public static String getSignRSA(String sign_src) {
        return SecretKeyUtils.sign(sign_src,PayParamter.PRIVATEKEY_INSTALL,"utf-8" );

    }
    public static String getSignRSAWAP(String sign_src) {
        return SecretKeyUtils.sign(sign_src,PayParamter.PRIVATEKEY_WAP,"utf-8");
    }
    /**
     * RSA公钥签名验证
     *
     * @param
     * @return
     */
    public static Boolean verity(String sign_src,String sign){
        return SecretKeyUtils.checksign(PayParamter.PUBLICKEY_INSTALL,sign_src,sign);
    }
    public static Boolean verityWap(String sign_src,String sign){
        return SecretKeyUtils.checksign(PayParamter.PUBLICKEY_WAP, sign_src, sign);
    }


    /**
     * 生成待签名串
     *
     * @param
     * @return
     */
    public static String genSignData(JSONObject jsonObject)
    {
        StringBuffer content = new StringBuffer();

        // 按照key做首字母升序排列
        List<String> keys = new ArrayList<String>(jsonObject.keySet());
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < keys.size(); i++)
        {
            String key = (String) keys.get(i);
            // sign 和ip_client 不参与签名
            if ("sign".equals(key))
            {
                continue;
            }
            String value = (String) jsonObject.getString(key);
            // 空串不参与签名
            if (null==value)
            {
                continue;
            }
            content.append((i == 0 ? "" : "&") + key + "=" + value);

        }
        String signSrc = content.toString();
        if (signSrc.startsWith("&"))
        {
            signSrc = signSrc.replaceFirst("&", "");
        }
        return signSrc;
    }
    /**
     * 对结果进行验签
     *
     */
    public static  Boolean checkSign(String result,String publicKey){
        JSONObject reqObj = JSON.parseObject(result);
        System.out.println("进入商户[" + reqObj.getString("oid_partner")
                + "]RSA签名验证");
        if (reqObj == null)
        {
            return false;
        }
        String sign = reqObj.getString("sign");
        // 生成待签名串
        String sign_src = genSignData(reqObj);
        System.out.println("商户[" + reqObj.getString("oid_partner") + "]待签名原串"
                + sign_src);
        System.out.println("商户[" + reqObj.getString("oid_partner") + "]签名串"
                + sign);
        try
        {
            if (SecretKeyUtils.checksign(publicKey, sign_src, sign))
            {
                System.out.println("商户[" + reqObj.getString("oid_partner")
                        + "]RSA签名验证通过");
                return true;
            } else
            {
                System.out.println("商户[" + reqObj.getString("oid_partner")
                        + "]RSA签名验证未通过");
                return false;
            }
        } catch (Exception e)
        {
            System.out.println("商户[" + reqObj.getString("oid_partner")
                    + "]RSA签名验证异常" + e.getMessage());
            return false;
        }
    }

    /**
     * 获取错误信息
     */
    public static String getMsg(JSONObject result){
        if (result.getString("ret_msg")!=null){
            return result.getString("ret_msg");
        }
        if (result.getString("ret_code")!=null){
            return result.getString("ret_code");
        }
        return "您的银行卡或者手机号码有误，请检查";
    }
}
