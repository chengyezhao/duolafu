package com.shoumipay.constants;

/**
 * Created by Zhw on 2018/3/1.
 * 根据风险等级获取用户最大额度
 */
public enum QuotaEnum {
    level_of_risk_1(1, 3000),
    level_of_risk_2(2, 2500),
    level_of_risk_3(3, 2000),
    level_of_risk_4(4, 1500);
    /*level_of_risk_5(5, 0),
    level_of_risk_6(6, 0);*/

    private int level;
    private int amount;

    public static int getAmount(int level) {
        for (QuotaEnum q : QuotaEnum.values()) {
            if (q.getLevel() == level) {
                return q.amount;
            }
        }
        return 0;
    }

    private QuotaEnum(int level, int amount) {
        this.level = level;
        this.amount = amount;
    }

    public int getLevel() {
        return level;
    }

    public int getAmount() {
        return amount;
    }
}
