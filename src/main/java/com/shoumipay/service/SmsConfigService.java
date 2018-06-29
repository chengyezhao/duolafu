package com.shoumipay.service;

import com.shoumipay.domain.SmsConfig;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
public interface SmsConfigService {
    /**
     * 插入add
     */
    int addConfigService(SmsConfig config);
    /**
     * updateByPrimaryKey
     */
    int updateConfig(SmsConfig config);
    /**
     * 通过id查询
     */
    SmsConfig findById(int id);
    List<SmsConfig> findBySmsConfig(SmsConfig smsConfig);
}
