package com.shoumipay.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.google.common.cache.CacheLoader;
import com.shoumipay.dao.ConfigMapper;
import com.shoumipay.domain.Config;
import com.shoumipay.domain.ConfigExample;
import com.shoumipay.service.RedisService;
import com.shoumipay.service.admin.ConfigService;
import com.shoumipay.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/10/25.
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public void insert(Config config) {
        configMapper.insert(config);
        redisService.set(config.getKey(), config.getValue(), 60 * 10);
    }

    @Override
    public void remove(String key) {
        configMapper.deleteByKey(key);
        redisService.delete(key);
    }

    @Override
    public Config selectByKey(String key) {
        String value = (String) redisService.get(key);
        if(StringUtils.isEmpty(value)) {
            Config config = configMapper.selectByKey(key);
            if (config != null) {
                //缓存10分钟
                redisService.set(key, config.getValue(), 60 * 10);
                return config;
            }
            return null;
        }else {
            Config config = new Config();
            config.setKey(key);
            config.setValue(value);
            return config;
        }
    }

    @Override
    public Config selectByKey(String key, String defaultValue) {
        Config config = selectByKey(key);
        if(config == null) {
            config = new Config();
            config.setKey(key);
            config.setValue(defaultValue);
            return config;
        }
        return config;
    }

    @Override
    public String selectValueByKey(String key) {
        Config config = selectByKey(key);
        if(config != null){
            return config.getValue();
        }
        return "";
    }

    public void updateByPrimaryKey(Config config) {
        configMapper.updateByPrimaryKey(config);
    }
}
