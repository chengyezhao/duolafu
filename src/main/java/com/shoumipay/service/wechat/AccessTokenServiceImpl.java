package com.shoumipay.service.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.service.RedisService;
import com.shoumipay.tools.StringUtil;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Zhw on 2017/12/29.
 */
@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    private static final String WECHAT_ACCESS_TOKEN = "WECHAT_ACCESS_TOKEN";
    private static final String CLIENT_CREDENTIAL = "client_credential";
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    private static final String WEB_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String INFO_URL = " https://api.weixin.qq.com/sns/userinfo";

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String secret;

    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisService redisService;

    @Override
    public String getAccessToken() {
        String access_token = (String) redisService.get(WECHAT_ACCESS_TOKEN);
        //String access_token=null;
        if (StringUtil.isNull(access_token)) {
            String param = "grant_type=" + CLIENT_CREDENTIAL + "&appid=" + appid + "&secret=" + secret;
            String json = HttpRequestUtils.sendGet(ACCESS_TOKEN_URL, param);
            Map<String, String> map = (Map<String, String>) JSON.parse(json);
            access_token = map.get("access_token");
            redisService.set(WECHAT_ACCESS_TOKEN, access_token, 7000);
            log.info(map.toString());
        }
        return access_token;
    }

    @Override
    public Map<String, String> getWebAccessToken(String code) {
        String param = "grant_type=" + AUTHORIZATION_CODE + "&appid=" + appid + "&secret=" + secret + "&code=" + code;
        String json = HttpRequestUtils.sendGet(WEB_ACCESS_TOKEN_URL, param);
        Map<String, String> map = (Map<String, String>) JSON.parse(json);
        String access_token = map.get("access_token");
        if (StringUtil.isNull(access_token)) {
            return null;
        }
        log.info(map.toString());
        return map;
    }

    @Override
    public Map<String, String> getWebUserInfo(Map<String, String> map) {
        String param = "access_token=" + map.get("access_token") + "&openid=" + map.get("openid") + "&lang=zh_CN";
        String json = HttpRequestUtils.sendGet(INFO_URL, param);
        Map<String, String> map2 = (Map<String, String>) JSON.parse(json);
        log.info(map2.toString());
        return map2;
    }

    public String getJsapiTicket(String access_token) {
        String jsapi_ticket = (String) redisService.get("jsapi_ticket");
        if (StringUtil.isNull(jsapi_ticket)) {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
            String params = "access_token=" + access_token + "&type=jsapi";
            String result = HttpRequestUtils.sendGet(url, params);
            JSONObject jo = JSON.parseObject(result);
            jsapi_ticket = jo.getString("ticket");
            redisService.set("jsapi_ticket", jsapi_ticket, 7000);
        }
        return jsapi_ticket;
    }
}
