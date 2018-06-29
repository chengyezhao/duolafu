package com.shoumipay.service.impl;


import com.shoumipay.domain.SmsConfig;
import com.shoumipay.service.SmsConfigService;
import com.shoumipay.service.SmsSendService;
import com.shoumipay.smsmessage.HttpClientUtil;
import com.shoumipay.smsmessage.SecretKeyUtils;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Service
public class SmsSendServiceImpl implements SmsSendService{
    /**
     *
     * http post 请求
     */
    @Autowired
    private SmsConfigService smsConfigService;

    private static final String SEND_URL_HX = "http://sh2.ipyy.com/smsJson.aspx";
    private static final String SEND_URL_YXT = "http://smssh1.253.com/msg/send/json";
    private static final String SEND_PARAMETER_TEMPLATE_HX = "action=send&userid=&account={SMS_USER}&password={SMS_PWD}&mobile={MOBILE}&content={URL_ENCODE_CONTENT}&sendTime=&extno=";
    private static final String SEND_PARAMETER_TEMPLATE_YXT = "{\"account\":\"{ACCOUNT}\",\n" +
            "\"password\":\"{PASSWORD}\",\n" +
            "\"msg\":\"{MSG}\",\n" +
            "\"phone\":\"{PHONE}\"}";
    @Override
    public JSONObject sendhx(String mobile, String content,String name) {
        //发送短信
        try {
            java.net.URL postUrl = new java.net.URL(SEND_URL_HX);
            HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            String urlEncodeContent = URLEncoder.encode(content, "UTF-8");
            SmsConfig smsConfig = new SmsConfig();
            smsConfig.setName(name);
            List<SmsConfig> list =smsConfigService.findBySmsConfig(smsConfig);
            String mobile_content = SEND_PARAMETER_TEMPLATE_HX.replace("{SMS_USER}", list.get(0).getAccount()).replace("{SMS_PWD}", SecretKeyUtils.Md5_32(list.get(0).getPassword())).replace("{MOBILE}", mobile).replace("{URL_ENCODE_CONTENT}", urlEncodeContent);
            out.writeBytes(mobile_content);
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String temp = null;
            while ((temp = reader.readLine())!=null){
                sb.append(temp);
            }
            reader.close();
            connection.disconnect();
            JSONObject jsonObject = new JSONObject(sb.toString());
            return jsonObject;
        } catch (IOException e)  {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  JSONObject sendyxt(String mobile, String content,String name) {
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        SmsConfig smsConfig = new SmsConfig();
        smsConfig.setName(name);
        List<SmsConfig> list =smsConfigService.findBySmsConfig(smsConfig);
        String mobile_content = SEND_PARAMETER_TEMPLATE_YXT.replace("{ACCOUNT}", list.get(0).getAccount()).replace("{PASSWORD}", list.get(0).getPassword()).replace("{PHONE}", mobile).replace("{MSG}", content);
        String result = httpClientUtil.doPost(SEND_URL_YXT,mobile_content);
        JSONObject jsonObject = new JSONObject(result);
        return jsonObject;
    }
}
