package com.shoumipay.service.cache;

import com.shoumipay.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.shoumipay.constants.SMSConstants.*;

/**
 * Created by Tang on 2017/10/24.
 */
@Service
public class SMSCacheService {
    //缓存中的键名，加phoneNumber表示有无发送短信，再加_code表示有无验证码
    private static final String CODE_REGISTER = "CODE_REGISTER_";
    private static final String CODE_LOGIN = "CODE_LOGIN_";
    private static final String CODE_FORGET_PASSWORD = "CODE_FORGET_PASSWORD_";
    private static final String CODE_MODIFY_PASSWORD = "CODE_MODIFY_PASSWORD_";
    private static final String CODE_MODIFY_PHONE_NUMBER = "CODE_MODIFY_PHONE_NUMBER_";
    private static final String CODE_BING_BANKNUMBER = "CODE_BING_BANKNUMBER_";

    @Autowired
    private RedisService redisService;
    @Autowired
    private SystemCacheService systemCacheService;

    /**
     * 根据短信类型和手机号获取key
     * @param flag
     * @param phoneNumber
     * @return
     */
    private String getKey(Integer flag, String phoneNumber){
        switch (flag) {
            case FLAG_REGISTER: return CODE_REGISTER + phoneNumber;
            case FLAG_LOGIN: return CODE_LOGIN + phoneNumber;
            case FLAG_FORGET_PASSWORD: return CODE_FORGET_PASSWORD + phoneNumber;
            case FLAG_MODIFY_PASSWORD: return CODE_MODIFY_PASSWORD + phoneNumber;
            case FLAG_MODIFY_PHONE_NUMBER: return CODE_MODIFY_PHONE_NUMBER + phoneNumber;
            case FLAG_BING_BANKNUMBER: return CODE_BING_BANKNUMBER + phoneNumber;
            case FLAG_MODIFY_PHONE_NUMBER_TWO:return CODE_MODIFY_PHONE_NUMBER + phoneNumber;

        }
        return null;
    }

    /**
     * 查看有无该缓存
     * @param key
     * @return
     */
    private boolean get(String key) {
        if (null != key) {
            Object send = redisService.get(key);
            if (null != send && (Boolean) send) return true;
        }
        return false;
    }


    /**
     * 对外的方法调用，查看该短信类型有无发送短信
     * @param flag
     * @param phoneNumber
     * @return
     */
    public boolean get(Integer flag, String phoneNumber) {
        return get(getKey(flag, phoneNumber));
    }

    /**
     *存入缓存
     * @param flag
     * @param phoneNumber
     * @param code
     */
    public void save(Integer flag, String phoneNumber, String code) {
        String key = getKey(flag, phoneNumber);
        redisService.set(key, true, systemCacheService.identifyingCodeTime());
        redisService.set(key + "_" + code, true, systemCacheService.identifyingCodeTime());
    }

    /**
     * 检查验证码是否正确
     * @param flag
     * @param phoneNumber
     * @param code
     * @return
     */
    public boolean check(Integer flag, String phoneNumber, String code) {
        String key = getKey(flag, phoneNumber);
        String keyCode = key + "_" + code;
        if (get(key) && get(keyCode)) {
            redisService.delete(key);
            redisService.delete(keyCode);
            return true;
        }
        return false;
    }

}
