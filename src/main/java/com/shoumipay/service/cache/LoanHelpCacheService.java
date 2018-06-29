package com.shoumipay.service.cache;

import com.shoumipay.domain.Config;
import com.shoumipay.service.admin.ConfigService;
import com.shoumipay.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/10/30.
 */
@Service
public class LoanHelpCacheService {

    private static final String LOAN_HELP_URL = "LOAN_HELP_URL";

    @Autowired
    private RedisService redisService;
    @Autowired
    private ConfigService configService;

    public String get() {
        String url = (String) redisService.get(LOAN_HELP_URL);
        if (null == url) url = configService.selectByKey(LOAN_HELP_URL).getValue();
        return url;
    }

    public void save(String url) {
        redisService.set(LOAN_HELP_URL, url);
        Config config = configService.selectByKey(LOAN_HELP_URL);
        config.setValue(url);
        configService.updateByPrimaryKey(config);
    }

}
