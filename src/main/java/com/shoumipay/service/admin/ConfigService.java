package com.shoumipay.service.admin;

import com.shoumipay.domain.Config;

/**
 * Created by Tang on 2017/10/25.
 */
public interface ConfigService {
    void insert(Config config);
    void remove(String key);
    Config selectByKey(String key);
    Config selectByKey(String key, String defaultValue);
    String selectValueByKey(String key);
    void updateByPrimaryKey(Config config);
}
