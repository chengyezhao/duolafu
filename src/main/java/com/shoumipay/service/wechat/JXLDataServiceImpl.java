package com.shoumipay.service.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.service.RedisService;
import com.shoumipay.tools.StringUtil;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.Map;
@Service
public class JXLDataServiceImpl implements JXLDataService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String JXL_ACCESS_TOKEN = "JXL_ACCESS_TOKEN";
    private static final String JXL_USERID = "zhjfkj";
    private static final String JXL_PASSWORD = "17a2c2";
    private static final String client_secret = "003bbdc1f49f4bb4a6a4a7b42b87289c";
    private static final String JXL_TOKEN_URL = "https://www.juxinli.com/api/v2/access_report_token";//获取access_token
    private static final String JXL_DATA_URL = "https://www.juxinli.com/api/access_raw_data";//获取运营商数据
    private static final String JXL_DATA_REPORT_URL = "https://www.juxinli.com/api/access_report_data";//获取用户报告数据
    private static final String JXL_STATUS_TOKEN_URL = "https://www.juxinli.com/api/v2/job/access_jobs_status_by_user_info";//获取报告状态接口
    private static final String JXL_DATASOURCES_URL = "https://www.juxinli.com/orgApi/rest/orgs/{orgAccount}/datasources";//获取支持的数据源列表
    private static final String JXL_RETURN_URL = "https://www.juxinli.com/orgApi/rest/applications/{orgAccount}";//提交申请表单获取回执信息
    private static final String JXL_COLLECT_REQ_URL = "https://www.juxinli.com/orgApi/rest/messages/collect/req";//提交采集请求
    private static final String JXL_COLLECT_RESP_URL = "https://www.juxinli.com/orgApi/rest/messages/collect/resp";//获取采集响应信息
    private static final String JXL_COLLECT_TOKEN_URL = "https://www.juxinli.com/api/access_raw_data_by_token";//根据采集TOKEN获取用户移动运营商原始数据接口

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisService redisService;

    @Override
    public String returnStatusData(Date startTime,Date endTime,String name, String phone, String idcard) {
        String flag = "fail";
        String type = null;
        long time = endTime.getTime()-startTime.getTime();
        while(time < 60 * 1000){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            type = JXLStatusToken(name, phone, idcard);
            if("20003".equals(type)){
                return  "机构账号冻结，请联系爱代付客服人员";
            } else if ("20032".equals(type)){
                return "获取报告状态失败";
            }else if ("20001".equals(type)){
                return "确认client_secret是否正确";
            }else if ("20033".equals(type)){
                return  "获取用户报告数据为空";
            }else if ("30015".equals(type)){
                return "获取报告状态成功";
            }else if("20007".equals(type)){
                //get access token again
                redisService.delete(JXL_ACCESS_TOKEN);
            }
            time = System.currentTimeMillis() - startTime.getTime();
        }
        return "等待输入验证码超时";
    }

    @Override
    public String returnData(Date startTime,Date endTime,String token,String phone,String password,String website,String code) {
        String flag = "fail";
        String type = null;
        long time = endTime.getTime()-startTime.getTime();
        while(time <= 60*1000){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            type = JXLCollectResp( token, phone, password, website, code);
            if("10002".equals(type)){
                return  "输入验证码";
            } else if ("10008".equals(type)){
                return "采集结束";
            } else if (time>2*60*1000&&type.equals("0")){
                return "采集请求超时";
            }else if ("10003".equals(type)){
                return  "服务密码错误";
            }else if ("10004".equals(type)){
                return "短信验证码错误";
            }else if ("30000".equals(type)){
                return "网络异常、运营商异常，请联系爱代付客服人员";
            }else if("20007".equals(type)){
                //get access token again
                redisService.delete(JXL_ACCESS_TOKEN);
            }
            time = System.currentTimeMillis() - startTime.getTime();
        }
        return "等待输入验证码超时";
    }

    //获取采集相应信息
    @Override
    public String JXLCollectResp(String token, String phone, String password, String website, String code) {
        JSONObject json = new JSONObject();
        String type = "";
        json.put("token",token);
        json.put("account",phone);
        json.put("password",password);
        json.put("captcha",code);
        if (!StringUtils.isEmpty(code)){
            type =  "SUBMIT_CAPTCHA";
        }
        json.put("type",type);
        json.put("website",website);
        String result = HttpRequestUtils.sendPost(JXL_COLLECT_RESP_URL,json.toString(),true);
        logger.info(result);
        JSONObject jsonObject = JSON.parseObject(result);
        String data = jsonObject.getJSONObject("data").getString("process_code");
        return  data;
    }

    //提交采集接口
    @Override
    public JSONObject JXLCollectReq(String token, String phone, String password,String website,String code) {
        JSONObject json = new JSONObject();
        String type = "";
        json.put("token",token);
        json.put("account",phone);
        json.put("password",password);
        json.put("captcha",code);
        if (!StringUtils.isEmpty(code)){
            type =  "SUBMIT_CAPTCHA";
        }
        json.put("type",type);
        json.put("website",website);
        String result = HttpRequestUtils.sendPost(JXL_COLLECT_REQ_URL,json.toString(),true);
       // System.out.println(result);
        logger.info(result);
        /*JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(result);
        }catch (Exception e){
            jsonObject.put("success",false);
            jsonObject.put("message","系统连接超时,请重试");
        }*/
        JSONObject jsonObject = JSON.parseObject(result);
        return jsonObject;
    }

    //提交申请表单信息接口
    @Override
    public JSONObject JXLReturnMsg(String name,String phone,String idcard) {
        JSONObject resultJson = new JSONObject();
        String url = JXL_RETURN_URL.replace("{orgAccount}",JXL_USERID);
        JSONObject jsonAll=new JSONObject();
        JSONObject json=new JSONObject();
        /*json.put("name","jingdong");
        json.put("category","e_business");*/
        JSONArray jsonArray =new JSONArray();
        /*jsonArray.add(json);*/
        jsonAll.put("selected_website",jsonArray);
        jsonAll.put("skip_mobile",false);
        //jsonAll.put("uid",null);
        json=new JSONObject();
        json.put("name",name);
        json.put("id_card_num",idcard);
        json.put("cell_phone_num",phone);
        jsonAll.put("basic_info",json);
        /*jsonArray =new JSONArray();
        json=new JSONObject();
        json.put("contact_tel","188XXXXXXXX");
        json.put("contact_name","张三");jsonObject
        json.put("contact_type","1");
        jsonArray.add(json);
        jsonAll.put("contacts",jsonArray);*/
        String result = HttpRequestUtils.sendPost(url,jsonAll.toString(),true);
        //System.out.println(result);
        JSONObject jsonObject = JSON.parseObject(result);
        if ((Boolean)jsonObject.get("success")){
            JSONObject josn =  jsonObject.getJSONObject("data");
            String token = josn.get("token").toString();
            String website = josn.getJSONObject("datasource").getString("website");
            resultJson.put("msg","success");
            resultJson.put("token",token);
            resultJson.put("website",website);
            return resultJson;
        } else {
            resultJson.put("msg","fail");
            return resultJson;
        }
    }

    //获取支持的数据源列表
    @Override
    public void JXLDatasources() {
        String url = JXL_DATASOURCES_URL.replace("{orgAccount}",JXL_USERID);
        String result = HttpRequestUtils.sendGet(url,null);
        System.out.println(result);
        JSONObject jsonObject = JSON.parseObject(result);
        if ((Boolean)jsonObject.get("success")){

        } else {

        }
    }
    //获得安全凭证码（access_report_token）
    @Override
    public  String JXLAccessToken() {
        String access_token = (String) redisService.get(JXL_ACCESS_TOKEN);
        if (StringUtil.isNull(access_token)) {
            String param = "client_secret=" + client_secret + "&hours=" + 24 + "&org_name=" + JXL_USERID;
            String json = HttpRequestUtils.sendGet(JXL_TOKEN_URL, param);
            //System.out.println(json);
            Map<String, String> map = (Map<String, String>) JSON.parse(json);
            //System.out.println(map);
            if (map.get("success").equals("true")) {
                access_token = map.get("access_token");
                redisService.set(JXL_ACCESS_TOKEN, access_token,3600 * 22);
                log.info(access_token);
                return access_token;
            } else {
                return "access_token数据获取异常";
            }
        }
        return access_token;
    }
    //根据用户基本信息返回移动运营商JSON原始数据的接口
    @Override
    public JSONObject JXLData(String name,String phone,String idcard) {
        logger.info("JXLData" +name+"手机"+phone+"的JXL信息");
        JSONObject jsonError = new JSONObject();
        String access_token = (String) redisService.get(JXL_ACCESS_TOKEN);
        if (!StringUtil.isNull(access_token)) {
            String param = "access_token=" + access_token + "&name=" + name + "&phone=" + phone+"&client_secret="+client_secret+"&idcard="+idcard;
            String json = HttpRequestUtils.sendGet(JXL_DATA_URL, param);
            JSONObject jsonObject = JSON.parseObject(json);
            if (jsonObject.get("success").equals("true")){
                /*JSONArray transactions = jsonObject.getJSONObject("raw_data").getJSONObject("members").getJSONArray("transactions");
                JSONArray calls = JSON.parseArray(transactions.getJSONObject(0).get("calls").toString());
                System.out.println(calls);*/
                return jsonObject;
            } else {
                jsonError.put("msg","运营商数据获取异常");
                return jsonError;
            }
        }
        jsonError.put("msg","access_token为空");
        return jsonError;
    }
    //根据用户基本信息获取用户报告数据
    public JSONObject JXLReportData(String name,String phone,String idcard){
        logger.info("JXLReportData" +name+"手机"+phone+"的JXL信息");
        JSONObject jsonErr = new JSONObject();
        String access_token = (String) redisService.get(JXL_ACCESS_TOKEN);
        if (!StringUtil.isNull(access_token)) {
            String param = "access_token=" + access_token + "&name=" + name + "&phone=" + phone+"&client_secret="+client_secret+"&idcard="+idcard;
            String json = HttpRequestUtils.sendGet(JXL_DATA_REPORT_URL, param);
            JSONObject jsonObject = JSON.parseObject(json);
            return jsonObject;
        }
        jsonErr.put("success","false");
        return jsonErr;
    }
//根据采集TOKEN获取用户移动运营商原始数据接口
    @Override
    public JSONArray JXLTokenData(String token) {
        JSONArray jsonArray = new JSONArray();
        String access_token = (String) redisService.get(JXL_ACCESS_TOKEN);
        if (!StringUtil.isNull(access_token)) {
            String param = "client_secret="+client_secret+"&access_token="+access_token+"&token"+token;
            String json = HttpRequestUtils.sendGet(JXL_COLLECT_TOKEN_URL, param);
            System.out.println(json);
            JSONObject jsonObject = JSON.parseObject(json);
            System.out.println(jsonObject);
            if ((Boolean)jsonObject.get("success")){
                JSONArray transactions = jsonObject.getJSONArray("transactions");
                JSONArray calls = JSON.parseArray(transactions.getJSONObject(1).get("calls").toString());
                return calls;
            } else {
                jsonArray.set(1,"运营商数据获取异常");
                return jsonArray;
            }
        }
        jsonArray.set(1,"access_token为空");
        return jsonArray;
    }



    //根据用户基本信息获取报告状态接口
    @Override
    public String JXLStatusToken(String name, String phone, String idcard) {
        logger.info("JXLStatusToken尝试获取用户" +name+"手机"+phone+"的JXL信息");
        String access_token = JXLAccessToken();
        if (!access_token.contains("异常")) {
            String param = "client_secret=" + client_secret + "&access_token=" + access_token + "&name=" + name + "&idCard=" + idcard + "&phone=" + phone+"&rptCheck=false&category=mobile";
            String json = HttpRequestUtils.sendGet(JXL_STATUS_TOKEN_URL, param);
            //System.out.println(json);
            JSONObject jsonObject = JSON.parseObject(json);
            logger.info(jsonObject.toString());
            String code = jsonObject.getString("code");
            return code;
        }
        return null;
    }
}
