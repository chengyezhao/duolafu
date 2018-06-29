package com.shoumipay.service.gxb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.tools.Md5Util;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Zhw on 2017/12/29.
 */
@Service
public class GxbServiceImpl implements GxbService {

    @Value("${gxb.jd.appid}")
    private String jdappid;
    @Value("${gxb.jd.secret}")
    private String jdsecret;
    @Value("${gxb.tb.appid}")
    private String tbappid;
    @Value("${gxb.tb.secret}")
    private String tbsecret;

    private static final String token_url = "https://prod.gxb.io/crawler/auth/v2/get_auth_token";
    private static String h5_url = "https://prod.gxb.io/v2/auth";

    @Override
    public String getToken(String phone, String name, String idcard, String authItem, Long sequenceNo) {
        String appid;
        String secret;
        if ("jd".equals(authItem)) {
            appid = jdappid;
            secret = jdsecret;
        } else {
            appid = tbappid;
            secret = tbsecret;
        }
        Long timestamp = System.currentTimeMillis();
        JSONObject object = new JSONObject();
        object.put("sequenceNo", sequenceNo);
        object.put("phone", phone);
        object.put("authItem", authItem);
        object.put("name", name);
        object.put("idcard", idcard);
        object.put("appId", appid);
        object.put("timestamp", timestamp);
        String sign = Md5Util.getMD5(appid + secret + authItem + timestamp + sequenceNo);
        object.put("sign", sign);
        String result = HttpRequestUtils.sendPost(token_url, object.toJSONString(), true);
        JSONObject jsonObject = JSON.parseObject(result);
        Integer retCode = (Integer) jsonObject.get("retCode");
        if (retCode == 1) {
            jsonObject = (JSONObject) jsonObject.get("data");
            return (String) jsonObject.get("token");
        } else {
            return "error";
        }
    }

    @Override
    public String getH5Url(String token, String returnUrl) {
        return h5_url += ("?returnUrl=" + returnUrl + "&token=" + token + "&title=京东授权");
    }
}
