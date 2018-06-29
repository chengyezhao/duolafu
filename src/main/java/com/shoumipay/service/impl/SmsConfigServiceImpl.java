package com.shoumipay.service.impl;


import com.shoumipay.dao.SmsConfigMapper;
import com.shoumipay.domain.SmsConfigExample.Criteria;
import com.shoumipay.domain.SmsConfig;
import com.shoumipay.domain.SmsConfigExample;
import com.shoumipay.service.SmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Service
public class SmsConfigServiceImpl implements SmsConfigService {
    @Autowired
    private SmsConfigMapper smsConfigMapper;
    @Override
    public int addConfigService(SmsConfig config) {
        return  this.smsConfigMapper.insert(config);
    }

    @Override
    public int updateConfig(SmsConfig config) {
        SmsConfigExample smsConfigExample = new SmsConfigExample();
        Criteria criteria = smsConfigExample.createCriteria();
        if (config.getRemainpoint()!=null){
            criteria.andRemainpointIsNotNull();
        }
        return this.smsConfigMapper.updateByExample(config,smsConfigExample);
    }

    @Override
    public List<SmsConfig> findBySmsConfig(SmsConfig smsConfig) {
        SmsConfigExample smsConfigExample = new SmsConfigExample();
        Criteria criteria = smsConfigExample.createCriteria();
        if (smsConfig.getName()!=null&&smsConfig.getName().trim().length()>0){
            criteria.andNameEqualTo(smsConfig.getName());
        }
        return this.smsConfigMapper.selectByExample(smsConfigExample);
    }

    @Override
    public SmsConfig findById(int id){
        return this.smsConfigMapper.selectByPrimaryKey(id);
    }
}
