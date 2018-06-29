package com.shoumipay.service.wechat;

import java.util.Map;

/**
 * Created by Zhw on 2017/12/28.
 */

public interface AccessTokenService {
    /**
     * 获取微信access_token todo 并发
     * */
     String getAccessToken();

     /**
      * 微信根据code 获取oauth2 access_token
      * */
     Map<String, String> getWebAccessToken(String code);

     /**
      * 微信根据web access_token 与openid 获取用户信息
      * */
     Map<String,String> getWebUserInfo(Map<String,String> map);

     /**
      * 微信根据access_token获取jsapi_ticket
      * @param access_token
      * @return
      */
      String getJsapiTicket(String access_token);
}
