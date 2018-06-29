package com.shoumipay.service.admin;



import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */

public interface ActiveRepaymentApiService {
    //主动还款
    String activeRepayment(String user_id, String no_order, Date dt_order, String name_goods, String info_order, BigDecimal money_order, String notify_url, String url_return, String id_no, String acct_name, String risk_item, String card_no);
    //商户 支付结果查询服务 接口
    String queryOrder(String no_order, Date dt_order, String oid_paybill);
}
