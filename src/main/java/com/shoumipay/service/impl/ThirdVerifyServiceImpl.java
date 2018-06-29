package com.shoumipay.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.domain.VerifyParameter;
import com.shoumipay.service.admin.IdentityCheckService;
import com.shoumipay.service.ThirdVerifyService;
import com.shoumipay.service.admin.VerifyParameterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ThirdVerifyServiceImpl implements ThirdVerifyService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private VerifyParameterService verifyParameterService;
    @Autowired
    private IdentityCheckService identityCheckService;

    @Override
    public JSONObject phoneNameCidVerify(String name, String cid, String phone, Date sendTime, String channelOrderId) {
        JSONObject result = new JSONObject();
        VerifyParameter verifyParameter = new VerifyParameter("手机姓名身份证认证", "https://ds.bypay.cn/ds/service.ac", "name", "cid", "phone", "", "", "", null, null);
        List<VerifyParameter> verifyParameterList1 = verifyParameterService.queryVerifyParameterList(verifyParameter);
        if (verifyParameterList1 != null && verifyParameterList1.size() > 0) {
            String result1 = verifyParameterList1.get(0).getResult();
            JSONObject jsonObject = JSONObject.parseObject(result1);
            result.put("result", jsonObject);
            result.put("msg", "手机姓名身份证认证获取数据成功");
            return result;
        } /*else {
                JSONObject jsonObjects = new JSONObject();
                jsonObjects.put("name", name);
                jsonObjects.put("respCode", "0000");
                jsonObjects.put("tranCode", "100060");
                jsonObjects.put("phone", phone);
                jsonObjects.put("version", "1.0.0");
                jsonObjects.put("cid", cid);
                jsonObjects.put("respDesc", "验证成功");
                jsonObjects.put("application", "GwBiz.Req");
                jsonObjects.put("sendTime", sendTime);
                jsonObjects.put("channelOrderId", channelOrderId);*/
            logger.info("开始手机姓名身份证认证");
            Map<String ,String> result2 = identityCheckService.phoneNameCidXmlMap(name,cid,phone,sendTime,channelOrderId);
            String jsonObject = JSON.toJSONString(result2,true);
            JSONObject jsonObjects = JSON.parseObject(jsonObject);
            if (jsonObjects.containsKey("respCode") && jsonObjects.get("respCode").equals("0000")) {
                verifyParameter.setResult(jsonObjects.toString());
                verifyParameter.setCreatetime(new Date());
                verifyParameter.setNumber(1);
                //插入数据库保存
                List<VerifyParameter> verifyParameterList = verifyParameterService.queryVerifyParameterList(verifyParameter);
                if (verifyParameterList != null && verifyParameterList.size() > 0) {
                    verifyParameterList.get(0).setResult(jsonObjects.toString());
                    verifyParameterList.get(0).setCreatetime(new Date());
                    int number = verifyParameterList.get(0).getNumber();
                    verifyParameterList.get(0).setNumber(number + 1);
                    try{
                        int index = verifyParameterService.updateVerifyParameter(verifyParameterList.get(0));
                        if (index>0){
                            logger.info("手机姓名身份证认证结果更新成功");
                        } else {
                            logger.info("手机姓名身份证认证结果更新失败");
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                } else {
                    try{
                        int index =  verifyParameterService.addVerifyParameter(verifyParameter);
                        if (index>0){
                            logger.info("手机姓名身份证认证结果录入成功");
                        } else {
                            logger.info("手机姓名身份证认证结果录入失败");
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                result.put("result", jsonObjects);
                result.put("msg", "手机姓名身份证认证获取数据成功");
                return result;
            } else {
                result.put("msg", "手机姓名身份证认证获取数据失败,错误原因：" + jsonObjects);
                return result;
            }
      //}
    }

    @Override
    public JSONObject nameVerify(String name, String cid, Date sendTime, String channelOrderId) {
        JSONObject result = new JSONObject();
        VerifyParameter verifyParameter = new VerifyParameter("实名认证", "https://ds.bypay.cn/ds/service.ac", name, cid, "", "", "", "", null, null);
      /*  List<VerifyParameter> verifyParameterList = verifyParameterService.queryVerifyParameterList(verifyParameter);
        if (verifyParameterList != null && verifyParameterList.size() > 0) {
            String result1 = verifyParameterList.get(0).getResult();
            JSONObject jsonObject = JSONObject.parseObject(result1);
            result.put("result", jsonObject);
            result.put("msg", "实名认证获取数据成功");
            return result;
        } else {*/
            /*JSONObject jsonObjects = new JSONObject();
            jsonObjects.put("name", name);
            jsonObjects.put("respCode", "0000");
            jsonObjects.put("tranCode", "100048");
            jsonObjects.put("version", "1.0.0");
            jsonObjects.put("cid", cid);
            jsonObjects.put("respDesc", "验证成功");
            jsonObjects.put("application", "GwBiz.Req");
            jsonObjects.put("sendTime", sendTime);
            jsonObjects.put("channelOrderId", channelOrderId);*/
            logger.info("开始实名认证");
            Map<String ,String> result2 = identityCheckService.nameXmlMap(name,cid,sendTime,channelOrderId);
            String jsonObject = JSON.toJSONString(result2,true);
            JSONObject jsonObjects = JSON.parseObject(jsonObject);
            if (jsonObjects.containsKey("respCode") && jsonObjects.get("respCode").equals("0000")) {
                verifyParameter.setResult(jsonObjects.toString());
                verifyParameter.setCreatetime(new Date());
                verifyParameter.setNumber(1);
                //插入数据库保存
                List<VerifyParameter> verifyParameterList = verifyParameterService.queryVerifyParameterList(verifyParameter);
                if (verifyParameterList != null && verifyParameterList.size() > 0) {
                    verifyParameterList.get(0).setResult(jsonObjects.toString());
                    verifyParameterList.get(0).setCreatetime(new Date());
                    int number = verifyParameterList.get(0).getNumber();
                    verifyParameterList.get(0).setNumber(number + 1);
                    int index = verifyParameterService.updateVerifyParameter(verifyParameterList.get(0));
                    if (index>0){
                        logger.info("实名认证结果更新成功");
                    } else {
                        logger.info("实名认证结果更新失败");
                    }
                } else {
                    int index =  verifyParameterService.addVerifyParameter(verifyParameter);
                    if (index>0){
                        logger.info("实名认证结果录入成功");
                    } else {
                        logger.info("实名认证结果录入失败");
                    }
                }
                result.put("result", jsonObjects);
                result.put("msg", "实名认证获取数据成功");
                return result;
            } else {
                result.put("msg", "实名认证获取数据失败,错误原因：" + jsonObjects);
                return result;
            }
       // }
    }

    @Override
    public JSONObject cardVerify(String name, String cid, String phone, String cardNo, Date sendTime, String channelOrderId) {
        JSONObject result = new JSONObject();
        VerifyParameter verifyParameter = new VerifyParameter("银行卡账户认证", "https://ds.bypay.cn/ds/service.ac", name, cid, phone, cardNo, "", "", null, null);
        /*List<VerifyParameter> verifyParameterList = verifyParameterService.queryVerifyParameterList(verifyParameter);
        if (verifyParameterList != null && verifyParameterList.size() > 0) {
            String result1 = verifyParameterList.get(0).getResult();
            JSONObject jsonObject = JSONObject.parseObject(result1);
            result.put("result", jsonObject);
            result.put("msg", "银行卡账户认证获取数据成功");
            return result;
        } else {*/
           /* JSONObject jsonObjects = new JSONObject();
            jsonObjects.put("name", name);
            jsonObjects.put("idCard", cid);
            jsonObjects.put("respCode", "0000");
            jsonObjects.put("tranCode", "100054");
            jsonObjects.put("version", "1.0.0");
            jsonObjects.put("phone", phone);
            jsonObjects.put("respDesc", "验证成功");
            jsonObjects.put("type", "1");
            jsonObjects.put("application", "GwBiz.Req");
            jsonObjects.put("sendTime", sendTime);
            jsonObjects.put("channelOrderId", channelOrderId);*/
            logger.info("开始银行卡账户认证");
            Map<String ,String> result2 = identityCheckService.cardXmlMap(name,cid,phone,cardNo,sendTime,channelOrderId);
            String jsonObject = JSON.toJSONString(result2,true);
            JSONObject jsonObjects = JSON.parseObject(jsonObject);
            if (jsonObjects.containsKey("respCode") && jsonObjects.get("respCode").equals("0000")) {
                verifyParameter.setResult(jsonObjects.toString());
                verifyParameter.setCreatetime(new Date());
                verifyParameter.setNumber(1);
                //插入数据库保存
                List<VerifyParameter> verifyParameterList = verifyParameterService.queryVerifyParameterList(verifyParameter);
                if (verifyParameterList != null && verifyParameterList.size() > 0) {
                    verifyParameterList.get(0).setResult(jsonObjects.toString());
                    verifyParameterList.get(0).setCreatetime(new Date());
                    int number = verifyParameterList.get(0).getNumber();
                    verifyParameterList.get(0).setNumber(number + 1);
                    int index = verifyParameterService.updateVerifyParameter(verifyParameterList.get(0));
                    if (index>0){
                        logger.info("银行卡账户认证结果更新成功");
                    } else {
                        logger.info("银行卡账户认证结果更新失败");
                    }
                } else {
                    int index =  verifyParameterService.addVerifyParameter(verifyParameter);
                    if (index>0){
                        logger.info("银行卡账户认证结果录入成功");
                    } else {
                        logger.info("银行卡账户认证结果录入失败");
                    }
                    result.put("result", jsonObjects);
                    result.put("msg", "银行卡账户认证获取数据成功");
                    return result;
                }
                result.put("result", jsonObjects);
                result.put("msg", "银行卡账户认证获取数据成功");
                return result;
            } else {
                result.put("msg", "银行卡账户认证获取数据失败,错误原因：" + jsonObjects);
                return result;
            }
       // }
    }

    @Override
    public JSONObject sesameVerify(String name, String cid, Date sendTime, String channelOrderId) {
       JSONObject result = new JSONObject();
        VerifyParameter verifyParameter = new VerifyParameter("芝麻授权", "https://ds.bypay.cn/ds/service.ac", name, cid, "", "", "", "", null, null);
       /* JSONObject jsonObjects = new JSONObject();
        jsonObjects.put("name", name);
        jsonObjects.put("resultCode", "0000");
        jsonObjects.put("tranCode", "100060");
        jsonObjects.put("version", "1.0.0");
        jsonObjects.put("cid", cid);
        jsonObjects.put("url", "http://www.baidu.com");
        jsonObjects.put("resultMessage", "查询成功");
        jsonObjects.put("application", "GwBiz.Req");
        jsonObjects.put("sendTime", sendTime);
        jsonObjects.put("channelOrderId", channelOrderId);*/
        logger.info("开始芝麻授权");
        JSONObject jsonObjects = identityCheckService.sesameXmlMap(name,cid,sendTime,channelOrderId);
        if (jsonObjects.containsKey("resultCode") && jsonObjects.get("resultCode").equals("9999")) {
            verifyParameter.setResult(jsonObjects.toString());
            verifyParameter.setCreatetime(new Date());
            verifyParameter.setNumber(1);
            //插入数据库保存
            List<VerifyParameter> verifyParameterList = verifyParameterService.queryVerifyParameterList(verifyParameter);
            if (verifyParameterList != null && verifyParameterList.size() > 0) {
                verifyParameterList.get(0).setResult(jsonObjects.toString());
                verifyParameterList.get(0).setCreatetime(new Date());
                int number = verifyParameterList.get(0).getNumber();
                verifyParameterList.get(0).setNumber(number + 1);
                int index = verifyParameterService.updateVerifyParameter(verifyParameterList.get(0));
                if (index>0){
                    logger.info("芝麻授权结果更新成功");
                } else {
                    logger.info("芝麻授权结果更新失败");
                }
            } else {
                int index = verifyParameterService.addVerifyParameter(verifyParameter);
                if (index>0){
                    logger.info("芝麻授权结果录入成功");
                } else {
                    logger.info("芝麻授权结果录入失败");
                }
            }
            result.put("result", jsonObjects);
            result.put("msg", "芝麻授权获取数据成功");
            return result;
        } else {
            result.put("msg", "芝麻授权获取数据失败,错误原因：" + jsonObjects);
            logger.info("芝麻授权获取数据失败,错误原因："+jsonObjects);
            return result;
        }
    }


    @Override
    public JSONObject querySesameVerify(String openId, Date sendTime, String channelOrderId) {
        JSONObject result = new JSONObject();
        VerifyParameter verifyParameter = new VerifyParameter("芝麻分查询", "https://ds.bypay.cn/ds/service.ac", "", "", "", "", openId, "", null, null);
        /*JSONObject jsonObjects = new JSONObject();
        jsonObjects.put("resCode", "0000");
        jsonObjects.put("tranCode", "100060");
        jsonObjects.put("version", "1.0.0");
        jsonObjects.put("resMsg", "查询成功");
        jsonObjects.put("application", "GwBiz.Req");
        jsonObjects.put("sendTime", sendTime);
        jsonObjects.put("channelOrderId", channelOrderId);
        jsonObjects.put("score", "666");*/
        logger.info("开始芝麻分查询");
        JSONObject  jsonObjects = identityCheckService.querySesameXmlMap(openId,sendTime,channelOrderId);
        if (jsonObjects.containsKey("resCode") && jsonObjects.get("resCode").equals("0000")) {
            verifyParameter.setResult(jsonObjects.toString());
            verifyParameter.setCreatetime(new Date());
            verifyParameter.setNumber(1);
            List<VerifyParameter> verifyParameterList = verifyParameterService.queryVerifyParameterList(verifyParameter);
            if (verifyParameterList != null && verifyParameterList.size() > 0) {
                verifyParameterList.get(0).setResult(jsonObjects.toString());
                verifyParameterList.get(0).setCreatetime(new Date());
                int number = verifyParameterList.get(0).getNumber();
                verifyParameterList.get(0).setNumber(number + 1);
                int index = verifyParameterService.updateVerifyParameter(verifyParameterList.get(0));
                if (index>0){
                    logger.info("芝麻分查询结果更新成功");
                } else {
                    logger.info("芝麻分查询结果更新失败");
                }
            } else {
               int index = verifyParameterService.addVerifyParameter(verifyParameter);
                if (index>0){
                    logger.info("芝麻分查询结果录入成功");
                } else {
                    logger.info("芝麻分查询结果录入失败");
                }
            }
            result.put("result", jsonObjects);
            result.put("msg", "芝麻分查询获取数据成功");
            return result;
        } else {
            result.put("msg", "芝麻分查询获取数据失败,错误原因：" + jsonObjects);
            logger.info("芝麻分查询获取数据失败,错误原因："+jsonObjects);
            return result;
        }
    }
}
