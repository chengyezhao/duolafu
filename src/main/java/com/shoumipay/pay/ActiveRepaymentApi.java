package com.shoumipay.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/27.
 * 主动还款
 */
public class ActiveRepaymentApi {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
    public static String activeRepayment(String user_id,String no_order,Date dt_order,String name_goods,String info_order,BigDecimal money_order,String notify_url,String url_return,String id_no,String acct_name,String risk_item,String card_no){
        BankCardPayBean bankCardPayBean = new BankCardPayBean();
        bankCardPayBean.setVersion("1.1");
        bankCardPayBean.setOid_partner(PayParamter.OID_PARTNER_WAP);
        bankCardPayBean.setUser_id(user_id);
        bankCardPayBean.setApp_request("3");
        bankCardPayBean.setSign_type("RSA");
        bankCardPayBean.setBusi_partner("101001");
        bankCardPayBean.setNo_order(no_order);
        bankCardPayBean.setDt_order(sdf.format(dt_order));
        bankCardPayBean.setName_goods(name_goods);
        bankCardPayBean.setInfo_order(info_order);
        bankCardPayBean.setMoney_order(money_order.toString());
        bankCardPayBean.setNotify_url(notify_url);
        bankCardPayBean.setUrl_return(url_return);
        bankCardPayBean.setId_type("0");
        bankCardPayBean.setId_no(id_no);
        bankCardPayBean.setAcct_name(acct_name);
        bankCardPayBean.setRisk_item(risk_item);
        bankCardPayBean.setCard_no(card_no);
        bankCardPayBean.setSign(SignUtils.genSignWap(JSON.parseObject(JSON.toJSONString(bankCardPayBean))));
        String reqJson = JSON.toJSONString(bankCardPayBean);
        System.out.println(reqJson);
        String result = YTHttpHandler.getInstance().doRequestPostString(reqJson,"https://wap.lianlianpay.com/authpay.htm");
        System.out.println("结果报文为:" + result);
        return result;
    }
    /**
     * 商户 支付结果查询服务 接口
     *
     */
    public static String queryOrder(String no_order,Date dt_order,String oid_paybill){
        BankCardPayBean bankCardPayBean = new BankCardPayBean();
        bankCardPayBean.setOid_partner(PayParamter.OID_PARTNER_WAP);
        bankCardPayBean.setSign_type("RSA");
        bankCardPayBean.setNo_order(no_order);
        bankCardPayBean.setDt_order(sdf.format(dt_order));
        bankCardPayBean.setOid_partner(oid_paybill);
        bankCardPayBean.setSign(SignUtils.genSign(JSON.parseObject(JSON.toJSONString(bankCardPayBean))));
        String reqJson = JSON.toJSONString(bankCardPayBean);
        JSONObject jo = new JSONObject();
        jo.put("req_data",reqJson);
        String req = JSON.toJSONString(jo);
        System.out.println(req);
        String result = YTHttpHandler.getInstance().doRequestPostString(req," https://queryapi.lianlianpay.com/orderquery.htm");
        System.out.println("结果报文为:" + result);
        return result;
    }
}
