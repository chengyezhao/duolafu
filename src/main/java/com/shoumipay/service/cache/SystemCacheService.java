package com.shoumipay.service.cache;

import com.shoumipay.domain.Config;
import com.shoumipay.service.admin.ConfigService;
import com.shoumipay.service.RedisService;
import com.shoumipay.tools.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/11/9.
 */
@Service
public class SystemCacheService {
    public static final String APPLY_ORDER = "SYSTEM_CONFIG_APPLY_ORDER";
    public static final String DO_LOAN = "SYSTEM_CONFIG_DO_LOAN";
    public static final String IDENTIFYING_CODE_TIME = "SYSTEM_CONFIG_IDENTIFYING_CODE_TIME";
    public static final String LOAN_TIMES_LIMIT = "SYSTEM_CONFIG_LOAN_TIMES_LIMIT";
    public static final String APPLY_TIMES_LIMIT = "SYSTEM_CONFIG_APPLY_TIMES_LIMIT";
    public static final String LOAN_MONEY_LIMIT = "SYSTEM_CONFIG_LOAN_MONEY_LIMIT";
    public static final String LOCAL_HOST = "LOCAL_HOST";

    @Autowired
    private RedisService redisService;

    @Autowired
    private ConfigService configService;

    public Config get(String key) {
        Config config = (Config) redisService.get(key);
        if (null != config) return config;
        config = configService.selectByKey(key);
        if (null != config) redisService.set(key, config);
        return config;
    }

    public Message update(Config config) {
        Config c = configService.selectByKey(config.getKey());
        if (null != c) {
            c.update(config);
            configService.updateByPrimaryKey(c);
            redisService.set(c.getKey(), c);
            applyOrder = null;
            doLoan = null;
            identifyingCodeTime = null;
            applyTimes = null;
            loanTimes = null;
            loanMoney = null;
            applyOrder();
            doLoan();
            identifyingCodeTime();
            getApplyTimes();
            getLoanTimes();
            getLoanMoney();
            return Message.success();
        }
        return Message.fail();
    }

    private Boolean applyOrder = null;

    public boolean applyOrder() {
        if (null == applyOrder) {
            Config config = get(APPLY_ORDER);
            if (null != config) applyOrder = "true".equals(config.getValue());
        }
        return applyOrder;
    }

    private Boolean doLoan = null;

    public boolean doLoan() {
        if (null == doLoan) {
            Config config = get(DO_LOAN);
            if (null != config) doLoan = "true".equals(config.getValue());
        }
        return doLoan;
    }

    private Integer identifyingCodeTime = null;

    public int identifyingCodeTime() {
        if (null == identifyingCodeTime) {
            Config config = get(IDENTIFYING_CODE_TIME);
            if (null != config) {
                try {
                    identifyingCodeTime = Integer.parseInt(config.getValue());
                } catch (Exception e) {
                    identifyingCodeTime = 180;
                    config.setValue(identifyingCodeTime.toString());
                    update(config);
                }
            }
        }
        return identifyingCodeTime;
    }

    private Integer applyTimes = null;

    public int getApplyTimes() {
        if (null == applyTimes) {
            Config config = get(APPLY_TIMES_LIMIT);
            if (null != config) {
                try {
                    applyTimes = Integer.parseInt(config.getValue());
                } catch (Exception e) {
                    applyTimes = 200;
                    config.setValue(applyTimes.toString());
                    update(config);
                }
            }
        }
        return applyTimes;
    }

    private Integer loanTimes = null;

    public int getLoanTimes() {
        if (null == loanTimes) {
            Config config = get(LOAN_TIMES_LIMIT);
            if (null != config) {
                try {
                    loanTimes = Integer.parseInt(config.getValue());
                } catch (Exception e) {
                    loanTimes = 100;
                    config.setValue(loanTimes.toString());
                    update(config);
                }
            }
        }
        return loanTimes;
    }

    private Double loanMoney = null;

    public Double getLoanMoney() {
        if (null == loanMoney) {
            Config config = get(LOAN_MONEY_LIMIT);
            if (null != config) {
                try {
                    loanMoney = Double.parseDouble(config.getValue());
                } catch (Exception e) {
                    loanMoney = 10000.00;
                    config.setValue(loanMoney.toString());
                    update(config);
                }
            }
        }
        return loanMoney;
    }

    public void clear() {
        redisService.delete(APPLY_ORDER);
        redisService.delete(DO_LOAN);
        redisService.delete(IDENTIFYING_CODE_TIME);
        redisService.delete(LOAN_TIMES_LIMIT);
        redisService.delete(APPLY_TIMES_LIMIT);
        redisService.delete(LOAN_MONEY_LIMIT);
    }

}
