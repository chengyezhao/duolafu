package com.shoumipay.service.impl;

import com.shoumipay.pay.ActiveRepaymentApi;
import com.shoumipay.service.admin.ActiveRepaymentApiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service
public class ActiveRepaymentApiServiceImpl implements ActiveRepaymentApiService {
    @Override
    public String activeRepayment(String user_id,String no_order,Date dt_order,String name_goods,String info_order,BigDecimal money_order,String notify_url,String url_return,String id_no,String acct_name,String risk_item,String card_no) {
        return ActiveRepaymentApi.activeRepayment(user_id,no_order,dt_order,name_goods,info_order,money_order,notify_url,url_return,id_no,acct_name,risk_item,card_no);
    }

    @Override
    public String queryOrder(String no_order,Date dt_order,String oid_paybill) {
        return ActiveRepaymentApi.queryOrder(no_order,dt_order,oid_paybill);
    }
}
