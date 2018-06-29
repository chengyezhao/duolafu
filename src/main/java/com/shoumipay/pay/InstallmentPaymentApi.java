package com.shoumipay.pay;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.shoumipay.pay.PaymentApi.createRiskItem;

/**
 * Created by Czy on 2017/10/24.
 * 分期付
 */
public class InstallmentPaymentApi {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
    private static final SimpleDateFormat sdf__ = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String args[]) throws Exception {
        //授权申请
        //String result = agreenoauthapply("", "", "", "", "", "", "");
        // String result = requestCardInfo("6212261202022276878");

       String plan = createRepaymentPlan(sdf__.parse("2017-12-04"), new BigDecimal(1));
        //String result = signcreatebill("uid0001", "刘永利", new Date(), "130524198512303018", "6212261202022276878", "13858095883", new Date());
        //String result = signapplyAPI("uid0001", "6212261202022276878", "CC81C690B0939515E4A8E787E0BECFE3");
        //String result = signverifyAPI("uid0001", "6212261202022276878",  "CC81C690B0939515E4A8E787E0BECFE3", "767345");
        //-------------------
        //String result = checkSign("uid0001", "6212261202022276878");
        //String result = signApply("uid0001", "刘永利", "130524198512303018", "6222868870330882", PayParamter.NOTIFY_URL_INSTALL, riskItem);
        //String result = agreenoauthapply("53", "159_1_1", "2017111509972625", plan);
        String result = repaymentplanchange("53", "159_1_1", plan, false);
        //String result = bankcardRepayment("uid0001", "uid0001t20171110", new Date(), "rid20171110", new BigDecimal(1), riskItem, "2017-11-10", "2017110339835765");
        //2017110339835765
        //String result = checkPayResult("uid0001t20171110", "20171110083105");
        System.out.println("结果报文为：" + result);
//        System.out.println(SignUtils.checkSign(result, PayParamter.PUBLICKEY_INSTALL));
        //还款
        //testBankcardrepayment();
        //授权
        //   checkPayResult();
        //      checkSign("18368883616","ED63AB852F7B00AA93BFF25E1614C197","20160211000022");
    }

    private static String formatMoneyValue(double value) {
        return String.format("%.2f", value+0.0001);
    }
    public static String createRepaymentPlan(Date time, BigDecimal value) {
        return "{\"repaymentPlan\":["+
                    "{\"date\":\""+sdf__.format(time)+"\",\"amount\":\""+formatMoneyValue(value.doubleValue())+"\"}"
                +"]}";
    }

    private static String getNoOrder(String uid, String cardNo) {
        return "U"+uid+"C"+cardNo;
    }

    /**
     * 四要素签约绑卡申请
     * @return token 在签约绑卡验证接口需要（有效期半小时）
     */
    public static String signcreatebill(String uid, String name, Date dt_order, String cid,  String cardNo, String phone, Date regtime,String LOCAL_HOST) {
        BankCardAgreeBean bankCardAgreeBean = new BankCardAgreeBean();
        bankCardAgreeBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardAgreeBean.setUser_id(uid);
        bankCardAgreeBean.setSign_type("RSA");
        bankCardAgreeBean.setApi_version("1.0");
        bankCardAgreeBean.setDt_order(sdf.format(dt_order));//商户订单时间
        bankCardAgreeBean.setNo_order(getNoOrder(uid, cardNo));//商户唯一标识 签约唯一标识
        bankCardAgreeBean.setTime_stamp(sdf.format(new Date()));
        bankCardAgreeBean.setRisk_item(createRiskItem(uid, name, phone, cid, regtime));
        bankCardAgreeBean.setFlag_pay_product("8");
        bankCardAgreeBean.setFlag_chnl("3");
        bankCardAgreeBean.setId_type("0");
        bankCardAgreeBean.setId_no(cid);
        bankCardAgreeBean.setAcct_name(name);
        bankCardAgreeBean.setCard_no(cardNo);
        bankCardAgreeBean.setBind_mob(phone);
        //bankCardAgreeBean.setRepayment_no("990021");
        //bankCardAgreeBean.setRepayment_plan("{\"repaymentPlan\":[{\"date\":\"2017-11-05\",\"amount\":\"0\"}]}");
        //bankCardAgreeBean.setSms_param(PayParamter.SMS_PARAM_INSTALL);
        bankCardAgreeBean.setNotify_url(LOCAL_HOST+"/services/receiveNotify");
        bankCardAgreeBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardAgreeBean))));
        String reqJson = JSON.toJSONString(bankCardAgreeBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://fourelementapi.lianlianpay.com/repay/signcreatebill");
        System.out.println("结果报文为:" + result);
        // {"sign":"hLe8iAS/QJKWVEkBuO2IKrqeSRSKwMsdxwToGebMb1nDIq2DloYmqEIymWhD7lkOmtD7GJudnB/NG6IXGUoEUEhw1gU/6jJYBWdhn19BNf++wVGHAE/D9SwzPXb4OPeCpY4Q4UOPiCObYMNLrNl5YF+Ux6d7ZCDA8CmlAVgGl30=","correlationID":"82841993-11f3-48e1-9461-9f16b6fc973f","ret_code":"0000","repayment_no":"990021","no_order":"Uuid0001C6212261202022276878","oid_partner":"201711010001092244","token":"CC81C690B0939515E4A8E787E0BECFE3","sign_type":"RSA","ret_msg":"交易成功","user_id":"uid0001"}
        return result;
    }



    /**
     * 申请绑定，请求验证码
     */
    public static String signapplyAPI(String user_id, String cardNo, String token) {
        BankCardAgreeBean bankCardAgreeBean = new BankCardAgreeBean();
        bankCardAgreeBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardAgreeBean.setUser_id(user_id);
        bankCardAgreeBean.setToken(token);
        bankCardAgreeBean.setNo_order(getNoOrder(user_id, cardNo));
        bankCardAgreeBean.setApi_version("1.0");
        bankCardAgreeBean.setFlag_chnl("3");
        //bankCardAgreeBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardAgreeBean))));
        String reqJson = JSON.toJSONString(bankCardAgreeBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://fourelementapi.lianlianpay.com/signapply");
        System.out.println("结果报文为:" + result);
        return result;
    }


    /**
     * 绑定，提交验证码
     */
    public static String signverify(String user_id, String cardNo, String token, String verify_code) {
        BankCardAgreeBean bankCardAgreeBean = new BankCardAgreeBean();
        bankCardAgreeBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardAgreeBean.setUser_id(user_id);
        bankCardAgreeBean.setToken(token);
        bankCardAgreeBean.setNo_order(getNoOrder(user_id, cardNo));
        bankCardAgreeBean.setApi_version("1.0");
        bankCardAgreeBean.setFlag_chnl("3");
        bankCardAgreeBean.setVerify_code(verify_code);
        //bankCardAgreeBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardAgreeBean))));
        String reqJson = JSON.toJSONString(bankCardAgreeBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://fourelementapi.lianlianpay.com/signverify");
        System.out.println("结果报文为:" + result);
        //{"correlationID":"12fc13e9-1379-46a7-9f2e-f0428a102c66","ret_code":"0000","sign_notify":{"sign":"MXZcXagFluq4iuu0qV93xZmIKTVTCv137KTwlG/HNPnfXX4psIeg/IqzpLCc+8D53RlyCAzrCh2InUAIb7T3kn/aouNaoff0lU4Sv/GOV6wAE35FaGRWZClQdQx1p3oLR34XGlng+c905FPam+wxKTMeL9gYsAvJ0RHIiRvu/HU=","ret_code":"0000","no_order":"Uuid0001C6212261202022276878","oid_partner":"201711010001092244","no_agree":"2017110339835765","sign_type":"RSA","ret_msg":"交易成功","dt_order":"20171111093517","user_id":"uid0001"},"ret_msg":"交易成功"}
        return result;
    }


    //WAP签约
    public static String signApply(String uid, String name, String cid,  String cardNo, String notify_url, String risk_item) {
        BankCardAgreeBean bankCardAgreeBean = new BankCardAgreeBean();
        bankCardAgreeBean.setApi_version("1.0");
        bankCardAgreeBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardAgreeBean.setUser_id(uid);
        bankCardAgreeBean.setApp_request("3");
        bankCardAgreeBean.setSign_type("RSA");
        bankCardAgreeBean.setId_type("0");
        bankCardAgreeBean.setId_no(cid);
        bankCardAgreeBean.setAcct_name(name);
        bankCardAgreeBean.setCard_no(cardNo);
        bankCardAgreeBean.setPay_type("1");
        bankCardAgreeBean.setRisk_item(risk_item);
        bankCardAgreeBean.setUrl_return(notify_url);
        bankCardAgreeBean.setSms_param(PayParamter.SMS_PARAM_INSTALL);

        bankCardAgreeBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardAgreeBean))));
        String reqJson = JSON.toJSONString(bankCardAgreeBean);
        String result = RedirectForm.autoPost("https://wap.lianlianpay.com/signApply.htm", "req_data", reqJson);
        return result;
    }

    /**
     * 签约查询
     */
    public static String bankcardbindlist(String user_id, String cardNo) {
        BankCardPayBean bankCardPayBean = new BankCardPayBean();
        bankCardPayBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardPayBean.setUser_id(user_id);
        bankCardPayBean.setPay_type("D");
        bankCardPayBean.setSign_type("RSA");
        bankCardPayBean.setCard_no(cardNo);
        bankCardPayBean.setOffset("0");
        bankCardPayBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardPayBean))));
        String reqJson = JSON.toJSONString(bankCardPayBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://queryapi.lianlianpay.com/bankcardbindlist.htm");
        System.out.println("结果报文为:" + result);
        //{"agreement_list":[{"bank_code":"01020000","bank_name":"中国工商银行","card_no":"6878","card_type":"2","no_agree":"2017110339835765"}],"count":"1","ret_code":"0000","ret_msg":"交易成功","sign":"IUG4lbuntOLXbEYVg4w8M2eTOH2JP8tcNCtSobMwaavtVTK4RRgw3zIyXbcBtaC6ioDcIV4cJ8zrCgzUlkzRqfkWClwiuLdfHdnSuZU4KfuPzFedhjXv4bxJl+0oC4m7BhxTz1aks6EL5CWRiZuZHJfuQzWeaFsn3p0GPl/oCTQ=","sign_type":"RSA","user_id":"uid0001"}
        return result;
    }

    /**
     * 指定还款计划
     */
    public static String agreenoauthapply(String user_id, String repayment_no, String no_agree, String repayment_plan) {
        BankCardAgreeBean bankCardAgreeBean = new BankCardAgreeBean();
        bankCardAgreeBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardAgreeBean.setApi_version("1.0");
        bankCardAgreeBean.setUser_id(user_id);
        bankCardAgreeBean.setSign_type("RSA");
        bankCardAgreeBean.setPay_type("D");
        bankCardAgreeBean.setRepayment_no(repayment_no);
        bankCardAgreeBean.setNo_agree(no_agree);
        bankCardAgreeBean.setRepayment_plan(repayment_plan);
        bankCardAgreeBean.setSms_param(PayParamter.SMS_PARAM_INSTALL);
        bankCardAgreeBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardAgreeBean))));
        String reqJson = JSON.toJSONString(bankCardAgreeBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://repaymentapi.lianlianpay.com/agreenoauthapply.htm");
        System.out.println("结果报文为:" + result);
        //{"sign":"ew8I6EfyK41byb9ic+NWNKHgPj+UnmD1tSDsfDqgY2c0JVdk6WHRS+LwVCR3gyb75BiHx+i6rXGhVvKzpIEJ14U1XfrJQFJI3s2EnzHXijBt33AWIUt6BJPU62SFxD/IWNC4xmiinTkARxAuhn8XP7H9lcVitA4HvA+OEp45tnk=","correlationID":"f85f0d5c-57ef-4ff9-a396-8dd0493f0bfe","ret_code":"0000","repayment_no":"rid20171110","oid_partner":"201711010001092244","no_agree":"2017110339835765","sign_type":"RSA","ret_msg":"交易成功"}
        return result;
    }

    /**
     * 变更还款计划
     */
    public static String repaymentplanchange(String user_id, String repayment_no, String repayment_plan, boolean stop) {
        BankCardAgreeBean bankCardAgreeBean = new BankCardAgreeBean();
        bankCardAgreeBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardAgreeBean.setUser_id(user_id);
        bankCardAgreeBean.setSign_type("RSA");
        bankCardAgreeBean.setRepayment_no(repayment_no);
        bankCardAgreeBean.setRepayment_plan(repayment_plan);
        if (stop) {
            bankCardAgreeBean.setRepayment_state("1");
        }
        bankCardAgreeBean.setSms_param(PayParamter.SMS_PARAM_INSTALL);
        bankCardAgreeBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardAgreeBean))));
        String reqJson = JSON.toJSONString(bankCardAgreeBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://repaymentapi.lianlianpay.com/repaymentplanchange.htm");
        System.out.println("结果报文为:" + result);
        return result;
    }

    /**
     * 银行卡还款扣款接口
     */
    public static String bankcardRepayment(String user_id, String no_order, Date dt_order, String repayment_no, BigDecimal money_order, String risk_item, String schedule_repayment_date, String no_agree,String LOCAL_HOST) {
        BankCardPayBean bankCardPayBean = new BankCardPayBean();
        bankCardPayBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardPayBean.setBusi_partner("101001");
        bankCardPayBean.setUser_id(user_id);
        bankCardPayBean.setSign_type("RSA");
        bankCardPayBean.setApi_version("1.0");
        bankCardPayBean.setNo_order(no_order);
        bankCardPayBean.setDt_order(sdf.format(dt_order));
        bankCardPayBean.setRepayment_no(repayment_no);
        bankCardPayBean.setName_goods("还款");
//        bankCardPayBean.setMoney_order(formatMoneyValue(money_order.doubleValue()));
        bankCardPayBean.setMoney_order("0.10");
        bankCardPayBean.setSchedule_repayment_date(schedule_repayment_date);
        bankCardPayBean.setRisk_item(risk_item);
        bankCardPayBean.setNotify_url(LOCAL_HOST+"/services/notify/deduct");
        bankCardPayBean.setPay_type("D");
        bankCardPayBean.setNo_agree(no_agree);
        bankCardPayBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardPayBean))));
        String reqJson = JSON.toJSONString(bankCardPayBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://repaymentapi.lianlianpay.com/bankcardrepayment.htm");
        System.out.println("结果报文为:" + result);
        //Fail:{"correlationID":"fd92160e-e6fa-45cb-93d0-5cc5109a3c4f","ret_code":"3003","ret_msg":"签约信息不存在，请联系商户传输银行卡信息进行支付[3003]"}
        //Success:{"sign":"kCtG9m4TcA3Cq4S0pwWwaVrLutaqqYfqWfe6jg+CS5O+VScA9SfGtcHhubhbajytXZh3Ex2X6UadUl/An+LDVlepodnjM7cg2uczIa+Ips55VgZSOg9paUpiUT15w8p0CBK7LkSVDezBJI0Yin+CZM0JAdoaijXvF6L1vfgmvXA=","oid_paybill":"2017111091556221","correlationID":"94b1e058-a803-4d59-8815-b635610aa744","ret_code":"0000","repayment_no":"rid20171110","no_order":"uid0001t20171110","oid_partner":"201711010001092244","sign_type":"RSA","ret_msg":"交易成功","dt_order":"20171110083105","settle_date":"20171110","money_order":"1.00"}
        return result;
    }

    /**
     * 支付结果查询服务接口
     */
    public static String checkPayResult(String no_order, String dt_order) {
        BankCardPayBean bankCardPayBean = new BankCardPayBean();
        bankCardPayBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardPayBean.setSign_type("RSA");
        bankCardPayBean.setNo_order(no_order);
        bankCardPayBean.setDt_order(dt_order);
        bankCardPayBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardPayBean))));
        String reqJson = JSON.toJSONString(bankCardPayBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://queryapi.lianlianpay.com/orderquery.htm");
        System.out.println("结果报文为:" + result);
        //{"bank_code":"01020000","card_no":"621226*********6878","dt_order":"20171110083105","money_order":"1.00","no_order":"uid0001t20171110","oid_partner":"201711010001092244","oid_paybill":"2017111091556221","pay_type":"D","result_pay":"SUCCESS","ret_code":"0000","ret_msg":"交易成功","settle_date":"20171110","sign":"QEbPCVE5n+KwMgK8aL+RvlbCdtEtGGFFZjfprQ3QZi4+87OIDpDtMJhemvyKCYZdPDNHz16OPAI1hJ66Sg9sQc4Vk4gFUnOwyYK3k58SXdBkn3ERRsxnv9Yw8FqlteS68x76BK9lG7Tt2t265TE2i+e+ynvdqcnx1tOZ7qmtG48=","sign_type":"RSA"}
        return result;
    }

    /**
     * 银行卡信息
     */
    public static String requestCardInfo(String cardNo) {
        BankCardPayBean bankCardPayBean = new BankCardPayBean();
        bankCardPayBean.setOid_partner(PayParamter.OID_PARTNER_INSTALL);
        bankCardPayBean.setCard_no(cardNo);
        bankCardPayBean.setSign_type("RSA");
        bankCardPayBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardPayBean))));
        String reqJson = JSON.toJSONString(bankCardPayBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://queryapi.lianlianpay.com/bankcardbin.htm");
        System.out.println("结果报文为:" + result);
        return result;
    }
    /**
     * 异步通知接口
     *
     * @param
     * @return
     */
    public static String notifyPay() {

        return null;
    }


}
