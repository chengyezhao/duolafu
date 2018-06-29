package com.shoumipay.service.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface InstallmentPaymentService {
    //     * 四要素签约绑卡申请  返回jsonString
    JSONObject signcreatebill(String uid, String name, Date dt_order, String cid, String cardNo, String phone, Date regtime);
     /**
     * 申请绑定，请求验证码
     */
     JSONObject signapplyAPI(String user_id, String cardNo, String token);
    /**
     * 绑定，提交验证码
     */
    JSONObject signverify(String user_id, String cardNo, String token, String verify_code);
    /**
     * 银行卡信息
     */
    JSONObject requestCardInfo(String cardNo);

    /**
     * 签约查询
     * @param user_id
     * @param cardNo
     * @return
     */
    JSONObject bankcardbindlist(String user_id, String cardNo);
    //签约
    //String signverify(String user_id, String cardNo, String token, String verify_code);
    //授权API 给已经签约过的用户进行单独授权(指定还款计划)
    JSONObject agreenoauthapply(String user_id, String repayment_no, String no_agree, String repayment_plan);
    //银行卡还款扣款接口
    JSONObject bankcardRepayment(String user_id, String no_order, Date dt_order, String repayment_no, BigDecimal money_order, String risk_item, String schedule_repayment_date, String no_agree);
    //还款计划变更
    JSONObject repaymentplanchange(String user_id,String repayment_plan,String repayment_no,boolean stop);
    //支付结果查询服务接口
    String checkPayResult(String no_order, String dt_order);
    //异步通知接口
    String notifyPay();
}
