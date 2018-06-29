package com.shoumipay.domain;

import java.math.BigDecimal;

public class LevelOfRisk {
    private String levelOfRisk;

    private BigDecimal annualInterestRate;

    private BigDecimal productRate;

    private BigDecimal totalRate;

    private BigDecimal platformManagementFee;

    public String getLevelOfRisk() {
        return levelOfRisk;
    }

    public void setLevelOfRisk(String levelOfRisk) {
        this.levelOfRisk = levelOfRisk == null ? null : levelOfRisk.trim();
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(BigDecimal annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public BigDecimal getProductRate() {
        return productRate;
    }

    public void setProductRate(BigDecimal productRate) {
        this.productRate = productRate;
    }

    public BigDecimal getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(BigDecimal totalRate) {
        this.totalRate = totalRate;
    }

    public BigDecimal getPlatformManagementFee() {
        return platformManagementFee;
    }

    public void setPlatformManagementFee(BigDecimal platformManagementFee) {
        this.platformManagementFee = platformManagementFee;
    }
}