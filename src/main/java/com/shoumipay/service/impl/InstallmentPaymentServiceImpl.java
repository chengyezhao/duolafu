package com.shoumipay.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.pay.InstallmentPaymentApi;
import com.shoumipay.pay.SignUtils;
import com.shoumipay.service.admin.InstallmentPaymentService;
import com.shoumipay.service.cache.SystemCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by Administrator on 2017/10/30.
 */
@Service
public class InstallmentPaymentServiceImpl implements InstallmentPaymentService {
    @Autowired
    SystemCacheService systemCacheService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public JSONObject signcreatebill(String uid, String name, Date dt_order, String cid, String cardNo, String phone, Date regtime) {
        JSONObject jsonObject = new JSONObject();
        String result = InstallmentPaymentApi.signcreatebill(uid, name, dt_order, cid, cardNo, phone, regtime,systemCacheService.get("LOCAL_HOST").getValue());
        try{
            JSONObject resultJSON = JSON.parseObject(result);
            String ret_msg = SignUtils.getMsg(resultJSON);
            if (("0000").equals(resultJSON.getString("ret_code"))){
                jsonObject.put("msg","银行卡申请绑定成功");
                jsonObject.put("resultJSON",resultJSON);
                return jsonObject;
            } else {
                jsonObject.put("msg","银行卡申请绑定失败");
                jsonObject.put("ret_msg",ret_msg);
                logger.info("银行卡申请绑定失败,错误原因："+ret_msg);
                return jsonObject;
            }
        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("msg","银行卡申请绑定失败,网络异常");
            logger.info("银行卡申请绑定失败,错误原因：系统异常");
            return jsonObject;
        }
    }

    @Override
    public JSONObject signapplyAPI(String user_id, String cardNo, String token) {
        JSONObject jsonObject = new JSONObject();
        String result = InstallmentPaymentApi.signapplyAPI( user_id,  cardNo, token);
        try{
            JSONObject resultJSON = JSON.parseObject(result);
            String ret_msg = SignUtils.getMsg(resultJSON);
            if (("8888").equals(resultJSON.getString("ret_code"))){
                jsonObject.put("msg","银行卡申请绑定获取验证码成功");
                jsonObject.put("resultJSON",resultJSON);
                return jsonObject;
            } else {
                jsonObject.put("msg","银行卡申请绑定获取验证码失败");
                jsonObject.put("ret_msg",ret_msg);
                logger.info("银行卡申请绑定获取验证码失败,错误原因："+ret_msg);
                return jsonObject;
            }
        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("msg","银行卡申请绑定获取验证码失败,网络异常");
            logger.info("银行卡申请绑定失败,错误原因：系统异常");
            return jsonObject;
        }
    }

    @Override
    public JSONObject signverify(String user_id, String cardNo, String token, String verify_code) {
        JSONObject jsonObject = new JSONObject();
        String result = InstallmentPaymentApi.signverify(user_id, cardNo, token, verify_code);
        try{
            JSONObject resultJSON = JSON.parseObject(result);
            String ret_msg = SignUtils.getMsg(resultJSON);
            if (("0000").equals(resultJSON.getString("ret_code"))){
                jsonObject.put("msg","银行卡绑定成功");
                jsonObject.put("resultJSON",resultJSON);
                return jsonObject;
            } else {
                jsonObject.put("msg","银行卡绑定失败");
                jsonObject.put("ret_msg",ret_msg);
                logger.info("银行卡绑定失败,错误原因："+ret_msg);
                return jsonObject;
            }
        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("msg","银行卡绑定失败,网络异常");
            logger.info("银行卡绑定失败,错误原因：系统异常");
            return jsonObject;
        }
    }

    @Override
    public JSONObject requestCardInfo(String cardNo) {
        JSONObject jsonObject = new JSONObject();
        String result = InstallmentPaymentApi.requestCardInfo(cardNo);
        try{
            JSONObject resultJSON = JSON.parseObject(result);
            String ret_msg = SignUtils.getMsg(resultJSON);
            if (("0000").equals(resultJSON.getString("ret_code"))){
                jsonObject.put("msg","银行卡信息查询成功");
                jsonObject.put("resultJSON",resultJSON);
                return jsonObject;
            } else {
                jsonObject.put("msg","银行卡信息查询失败");
                jsonObject.put("ret_msg",ret_msg);
                logger.info("银行卡信息查询失败,错误原因："+ret_msg);
                return jsonObject;
            }
        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("msg","银行卡信息查询失败,网络异常");
            logger.info("银行卡信息查询失败,失败原因：系统异常");
            return jsonObject;
        }
    }

    @Override
    public JSONObject bankcardbindlist(String user_id, String cardNo) {
        JSONObject jsonObject = new JSONObject();
        String result = InstallmentPaymentApi.bankcardbindlist(user_id,cardNo);
        try{
            JSONObject resultJSON = JSON.parseObject(result);
            String ret_msg = SignUtils.getMsg(resultJSON);
            if (("0000").equals(resultJSON.getString("ret_code"))){
                JSONArray agreement_listArray = resultJSON.getJSONArray("agreement_list");
                JSONObject agreement_list = agreement_listArray.getJSONObject(0);
                if (agreement_list!=null&&agreement_list.getString("no_agree")!=null){
                    jsonObject.put("msg","签约查询成功");
                    jsonObject.put("resultJSON",agreement_list);
                    return jsonObject;
                }else {
                    jsonObject.put("msg","签约查询失败");
                    jsonObject.put("ret_msg",ret_msg);
                    logger.info("签约查询失败,错误原因："+ret_msg);
                    return jsonObject;
                }
            } else {
                jsonObject.put("msg","签约查询失败");
                jsonObject.put("ret_msg",ret_msg);
                logger.info("签约查询失败,错误原因："+ret_msg);
                return jsonObject;
            }
        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("msg","签约查询失败,网络异常");
            logger.info("签约查询失败,失败原因：系统异常");
            return jsonObject;
        }
    }

    @Override
    public JSONObject agreenoauthapply(String user_id, String repayment_no, String no_agree, String repayment_plan) {
        JSONObject jsonObject = new JSONObject();
        String result = InstallmentPaymentApi.agreenoauthapply(user_id, repayment_no, no_agree, repayment_plan);
        try{
            JSONObject resultJSON = JSON.parseObject(result);
            String ret_msg = SignUtils.getMsg(resultJSON);
            if (("0000").equals(resultJSON.getString("ret_code"))){
                jsonObject.put("msg","指定还款计划上送成功");
                jsonObject.put("resultJSON",resultJSON);
                return jsonObject;
            } else {
                jsonObject.put("msg","指定还款计划上送失败");
                jsonObject.put("ret_msg",ret_msg);
                logger.info("指定还款计划上送失败,错误原因："+ret_msg);
                return jsonObject;
            }
        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("msg","指定还款计划上送失败,网络异常");
            logger.info("指定还款计划上送失败,失败原因：系统异常");
            return jsonObject;
        }
    }
    @Override
    public JSONObject bankcardRepayment(String user_id, String no_order, Date dt_order, String repayment_no, BigDecimal money_order, String risk_item, String schedule_repayment_date, String no_agree) {
        JSONObject jsonObject = new JSONObject();
        String result = InstallmentPaymentApi.bankcardRepayment(user_id, no_order, dt_order, repayment_no, money_order, risk_item, schedule_repayment_date, no_agree,systemCacheService.get("LOCAL_HOST").getValue());
        try{
            JSONObject resultJSON = JSON.parseObject(result);
            String ret_msg = SignUtils.getMsg(resultJSON);
            if (("0000").equals(resultJSON.getString("ret_code"))){
                jsonObject.put("msg","银行卡还款扣款成功");
                jsonObject.put("resultJSON",resultJSON);
                return jsonObject;
            } else {
                jsonObject.put("msg","银行卡还款扣款失败");
                jsonObject.put("ret_msg",ret_msg);
                logger.info("银行卡还款扣款失败,错误原因："+ret_msg);
                return jsonObject;
            }
        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("msg","银行卡还款扣款失败,网络异常");
            logger.info("银行卡还款扣款失败,失败原因：系统异常");
            return jsonObject;
        }
    }

    @Override
    public JSONObject repaymentplanchange(String user_id, String repayment_plan, String repayment_no, boolean stop) {
        JSONObject jsonObject = new JSONObject();
        String result = InstallmentPaymentApi.repaymentplanchange(user_id, repayment_plan, repayment_no, stop);
        try{
            JSONObject resultJSON = JSON.parseObject(result);
            String ret_msg = SignUtils.getMsg(resultJSON);
            if (("0000").equals(resultJSON.getString("ret_code"))){
                jsonObject.put("msg","还款计划变更成功");
                jsonObject.put("resultJSON",resultJSON);
                return jsonObject;
            } else {
                jsonObject.put("msg","还款计划变更失败");
                jsonObject.put("ret_msg",ret_msg);
                logger.info("还款计划变更失败,错误原因："+ret_msg);
                return jsonObject;
            }
        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("msg","还款计划变更失败,网络异常");
            logger.info("还款计划变更失败,失败原因：系统异常");
            return jsonObject;
        }
    }

    @Override
    public String checkPayResult(String no_order, String dt_order) {
        return InstallmentPaymentApi.checkPayResult(no_order, dt_order);
    }

    @Override
    public String notifyPay(){
        return null;
    }
}
