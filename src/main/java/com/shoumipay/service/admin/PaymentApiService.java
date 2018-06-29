package com.shoumipay.service.admin;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface PaymentApiService {
    //付款申请 实时付款  放款
    String wapPay(String user_id, String no_order, Date dt_order, String acct_name, String card_no, String id_no, String info_order, BigDecimal money_order, String notify_url, String risk_item);
    //确认付款
    String confirmPay(String no_order, String Confirm_code, String notify_url);
   //付款结果查询
    String checkResult(String no_order, String oid_paybill);
}
