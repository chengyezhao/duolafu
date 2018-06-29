package com.shoumipay.constants;

/**
 * Created by Zhw on 2018/3/12.
 */
public enum RiskEnum {
    level_of_risk_1(1, 1.5),
    level_of_risk_2(2, 1.2),
    level_of_risk_3(3, 1),
    level_of_risk_4(4, 0.8);
    /*level_of_risk_5(5, 0),
    level_of_risk_6(6, 0);*/

    private int level;
    private double risk;

    public static double getRisk(int level) {
        for (RiskEnum q : RiskEnum.values()) {
            if (q.getLevel() == level) {
                return q.risk;
            }
        }
        return 0;
    }

    private RiskEnum(int level, double risk) {
        this.level = level;
        this.risk = risk;
    }

    public int getLevel() {
        return level;
    }

    public double getRisk() {
        return risk;
    }
}
