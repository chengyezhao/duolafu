package com.shoumipay.service;


import org.json.JSONObject;

/**
 * Created by Czy on 2017/10/20.
 */
//短信发送接口
public interface SmsSendService {
    public JSONObject sendhx(String mobile,String content,String name);
    public JSONObject sendyxt(String mobile,String content,String name);
}
