package com.shoumipay.service;

import com.shoumipay.domain.SmsMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by Czy on 2017/10/17.
 */
public interface SmsMessageService {
    /**
     * 根据短信订单创建时间筛选
     * */
    List<SmsMessage> findByCreateTime(Map<String, String> params,String phone);
    /**
     * 条件筛选
     */
    List<SmsMessage> findByFlag(SmsMessage smsMessage);
    /**
     * 根据短信
     */
    /**
     * 根据sid筛选
     * */
    SmsMessage findById(long sid);
    /**
     * add
     * */
    int addSmsMessages(SmsMessage smsMessage);
    /**
     * updateByPrimaryKey
     * */
    int updateSmsMessages(SmsMessage smsMessage);
    /**
     * del
     * */
    int delSmsMessages(long sid);

    int deleteByIds(String[] ids);
    /**
     * 通过手机号码模糊查询发送短信内容
     */
    List<SmsMessage> findByPhone(SmsMessage smsMessage);
}
