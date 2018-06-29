package com.shoumipay.service.wechat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface JXLDataService {
    String JXLAccessToken();
    void JXLDatasources();
    JSONObject JXLReturnMsg(String name, String phone, String idcard);
    JSONObject JXLCollectReq(String token,String phone,String password,String website,String code);
    JSONObject JXLData(String name,String phone,String idcard);
    JSONObject JXLReportData(String name,String phone,String idcard);
    String JXLStatusToken(String name,String phone,String idcard);
    JSONArray JXLTokenData(String token);
    String JXLCollectResp(String token,String phone,String password,String website,String code);
    String returnData(Date startTime, Date endTime, String token, String phone, String password, String website, String code);
    String returnStatusData(Date startTime,Date endTime,String name,String phone,String idcard);
}
