package com.shoumipay.service;

import com.shoumipay.domain.SmsTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface SmsTemplateService {
    SmsTemplate findById(long id);

    List<SmsTemplate> findBySmsTemplate(SmsTemplate smsTemplate);

    int addSmsTemplate(SmsTemplate smsTemplate);

    List<SmsTemplate> findAllSmsTemplate(Map<String,String> params);

    int updateSmstemplate(SmsTemplate smsTemplate);

    int deleteByIds(String[] ids);
}
