package com.shoumipay.service.cache;

import com.alibaba.fastjson.JSON;
import com.shoumipay.domain.Config;
import com.shoumipay.domain.VersionInfo;
import com.shoumipay.service.admin.ConfigService;
import com.shoumipay.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/10/25.
 */
@Service
public class VersionInfoCacheService {
    private static final String VERSION_INFO_FORCE = "VERSION_INFO_FORCE_";
    private static final String VERSION_INFO_SELECT = "VERSION_INFO_SELECT_";

    @Autowired
    private RedisService redisService;
    @Autowired
    private ConfigService configService;

    public void refresh(String type) {
        String key = VERSION_INFO_FORCE + type;
        redisService.delete(key);
        key = VERSION_INFO_SELECT + type;
        redisService.delete(key);
    }

    public void save(boolean force, String type, VersionInfo versionInfo) {
        String key;
        if (force) key = VERSION_INFO_FORCE + type;
        else key = VERSION_INFO_SELECT + type;
        redisService.set(key, versionInfo);
        Config config = configService.selectByKey(key);
        if (null == config) configService.insert(new Config(key, JSON.toJSONString(versionInfo), ""));
        else {
            config.setValue(JSON.toJSONString(versionInfo));
            configService.updateByPrimaryKey(config);
        }
    }

    public VersionInfo get(boolean force, String type) {
        String key;
        if (force) key = VERSION_INFO_FORCE + type;
        else key = VERSION_INFO_SELECT + type;
        VersionInfo versionInfo = (VersionInfo) redisService.get(key);
        if (null == versionInfo) {
            Config info = configService.selectByKey(key);
            if (null != info) versionInfo = JSON.parseObject(info.getValue(), VersionInfo.class);
            if (null != versionInfo) redisService.set(key, versionInfo);
        }
        return versionInfo;
    }

}
