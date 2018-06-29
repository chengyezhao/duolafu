package com.shoumipay.service.impl;

import com.shoumipay.pay.PaymentApi;
import com.shoumipay.service.admin.PaymentApiService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service
public class PaymentApiServiceImpl implements PaymentApiService {
    @Override
    public String wapPay(String user_id, String no_order, Date dt_order, String acct_name, String card_no, String id_no, String info_order, BigDecimal money_order, String notify_url, String risk_item) {
//        return PaymentApi.wapPay(user_id,no_order,dt_order,acct_name,card_no,id_no, info_order,money_order,notify_url, risk_item);
        return null;
    }

    @Override
    public String confirmPay(String no_order, String Confirm_code, String notify_url) {
        return PaymentApi.pay(no_order,Confirm_code,notify_url);
    }

    @Override
    public String checkResult(String no_order, String oid_paybill) {
        return PaymentApi.checkResult(no_order,oid_paybill);
    }
}
