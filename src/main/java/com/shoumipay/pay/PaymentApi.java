package com.shoumipay.pay;

import com.alibaba.fastjson.JSON;
import com.shoumipay.smsmessage.SecretKeyUtils;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by Administrator on 2017/10/25.
 */

public class PaymentApi {
    public static void main(String[] args) {
        //wapPay("uid0001", "pid00001d",new Date(), "刘永利", "6212261202022276878", "130524198512303018", "付款", new BigDecimal(10), "http://www.baidu.com", "{}");
        //payment("P000001", new Date(), "刘永利", "6212261202022276878", new BigDecimal(0.1));
        //queryPayResult("pid00001c",new Date());
        // String result =   checkResult();
        // SignUtils.checkSign(result,PayParamter.PUBLICKEY_WAP);
        ///   pay();
    }

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

    /**
     * 付款申请 实时还款
     */
    public static String wapPay(String user_id, String no_order, Date dt_order, String acct_name, String card_no, String id_no, BigDecimal money_order, String risk_item,String LOCAL_HOST) {
        PaymentInfo payInfo = new PaymentInfo();
        payInfo.setApp_request("3");
        payInfo.setBusi_partner("101001");
        payInfo.setDt_order(sdf.format(dt_order));
        payInfo.setInfo_order("还款");
        payInfo.setMoney_order("0.1");//String.format("%.2f", money_order.doubleValue()));
        payInfo.setName_goods("还款");
        payInfo.setNo_order(no_order);
        payInfo.setNotify_url(LOCAL_HOST+"/services/notify/repay");
        payInfo.setOid_partner(PayParamter.OID_PARTNER_WAP);
        payInfo.setRisk_item(risk_item);
        payInfo.setSign_type("RSA");
        //payInfo.setUrl_return("");

        payInfo.setSign(SignUtils.genSignWap(JSON.parseObject(JSON.toJSONString(payInfo))));
        //payInfo.setNo_agree(no_agree);
        payInfo.setCard_no(card_no);
        payInfo.setId_no(id_no);
        payInfo.setAcct_name(acct_name);
        payInfo.setUser_id(user_id);

        String json = JSON.toJSONString(payInfo);

        String html = RedirectForm.autoPost("https://wap.lianlianpay.com/authpay.htm", "req_data", json);
        System.out.println(html);
        return html;
    }

    /**
     * 付款申请 实时付款  放款
     */
    public static String queryPayResult(String no_order, Date dt_order) {
        PaymentInfo payInfo = new PaymentInfo();
        payInfo.setDt_order(sdf.format(dt_order));
        payInfo.setNo_order(no_order);
        payInfo.setOid_partner(PayParamter.OID_PARTNER_WAP);
        payInfo.setSign_type("RSA");

        payInfo.setSign(SignUtils.genSignWap(JSON.parseObject(JSON.toJSONString(payInfo))));
        String json = JSON.toJSONString(payInfo);

        String result = YTHttpHandler.getInstance().doRequestPostString(json, "https://queryapi.lianlianpay.com/orderquery.htm");
        System.out.println(json);
        System.out.println(result);
        return result;
    }


    //确认付款
    public static String pay(String no_order, String Confirm_code, String notify_url) {
        BankCardPayBean bankCardPayBean = new BankCardPayBean();
        bankCardPayBean.setOid_partner(PayParamter.OID_PARTNER_WAP);
        bankCardPayBean.setApi_version("1.0");
        bankCardPayBean.setSign_type("RSA");
        bankCardPayBean.setNo_order(no_order);
        bankCardPayBean.setConfirm_code(Confirm_code);//确认付款验证码，来自付款申请接口返回
        bankCardPayBean.setNotify_url(notify_url);
        bankCardPayBean.setSign(SignUtils.genSignWap(JSON.parseObject(JSON.toJSONString(bankCardPayBean))));
        String reqJson = JSON.toJSONString(bankCardPayBean);
        String req = SecretKeyUtils.encryptByPublicKey(reqJson, PayParamter.PUBLICKEY_WAP);
        System.out.println(req);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pay_load", req);
        jsonObject.put("oid_partner", PayParamter.OID_PARTNER_WAP);
        String json = JSON.toJSONString(jsonObject);
        json = json.replace("\\r\\n", "");
        System.out.println(json);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://instantpay.lianlianpay.com/paymentapi/confirmPayment.htm");
        System.out.println("结果报文为:" + result);
        return result;
    }

    //付款结果查询
    public static String checkResult(String no_order, String oid_paybill) {
        BankCardPayBean bankCardPayBean = new BankCardPayBean();
        bankCardPayBean.setOid_partner(PayParamter.OID_PARTNER_WAP);
        bankCardPayBean.setApi_version("1.0");
        bankCardPayBean.setSign_type("RSA");
        bankCardPayBean.setNo_order(no_order);
        bankCardPayBean.setOid_paybill(oid_paybill);
        bankCardPayBean.setSign(SignUtils.genSignWap(JSON.parseObject(JSON.toJSONString(bankCardPayBean))));
        String reqJson = JSON.toJSONString(bankCardPayBean);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson, "https://instantpay.lianlianpay.com/paymentapi/queryPayment.htm");
        System.out.println("结果报文为:" + result);
        return result;
    }

    private static String formatJSON(String key, String value) {
        return "\"" + key + "\":" + "\"" + value + "\"";
    }

    public static String createRiskItem(String uid, String name, String phone, String id_no, Date regtime) {
        return "{" + formatJSON("frms_ware_category", "2010") + "," +
                formatJSON("user_info_mercht_userno", uid) + "," +
                formatJSON("user_info_bind_phone", phone) + "," +
                formatJSON("user_info_dt_register", PaymentApi.sdf.format(regtime)) + "," +
                formatJSON("user_info_full_name", name) + "," +
                formatJSON("user_info_id_no", id_no) + "," +
                formatJSON("user_info_id_type ", "1") + "," +
                formatJSON("user_info_identify_type", "1") + "," +
                formatJSON("user_info_identify_state", "1") + "}";
    }
}
