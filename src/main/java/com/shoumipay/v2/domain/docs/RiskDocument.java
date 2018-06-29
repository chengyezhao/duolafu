package com.shoumipay.v2.domain.docs;

import java.math.BigDecimal;

public class RiskDocument {

    private Long memberId;
    private BigDecimal maxAmountP1 = new BigDecimal(0.0);
    private BigDecimal maxAmountP3 = new BigDecimal(0.0);
    private BigDecimal maxAmountP6 = new BigDecimal(0.0);
    private Integer mobilePhoneRiskLevel = 0;
    private String riskLayer = "F";

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getMaxAmountP1() {
        return maxAmountP1;
    }

    public void setMaxAmountP1(BigDecimal maxAmountP1) {
        this.maxAmountP1 = maxAmountP1;
    }

    public BigDecimal getMaxAmountP3() {
        return maxAmountP3;
    }

    public void setMaxAmountP3(BigDecimal maxAmountP3) {
        this.maxAmountP3 = maxAmountP3;
    }

    public BigDecimal getMaxAmountP6() {
        return maxAmountP6;
    }

    public void setMaxAmountP6(BigDecimal maxAmountP6) {
        this.maxAmountP6 = maxAmountP6;
    }

    public Integer getMobilePhoneRiskLevel() {
        return mobilePhoneRiskLevel;
    }

    public void setMobilePhoneRiskLevel(Integer mobilePhoneRiskLevel) {
        this.mobilePhoneRiskLevel = mobilePhoneRiskLevel;
    }

    public String getRiskLayer() {
        return riskLayer;
    }

    public void setRiskLayer(String riskLayer) {
        this.riskLayer = riskLayer;
    }

    public BigDecimal getMaxAmountAll(){
       return maxAmountP1.max(maxAmountP3).max(maxAmountP6);
    }


    @Override
    public String toString() {
        return "RiskDocument{" +
                "memberId=" + memberId +
                ", maxAmountP1=" + maxAmountP1 +
                ", maxAmountP3=" + maxAmountP3 +
                ", maxAmountP6=" + maxAmountP6 +
                ", mobilePhoneRiskLevel=" + mobilePhoneRiskLevel +
                ", riskLayer='" + riskLayer  +
                '}';
    }
}
