package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Long id;

    private String name;

    private String alias;

    private Integer timeLimit;

    private Integer repaymentType;

    private Date addtime;

    private Date upptime;

    private String uppname;

    private String version;

    private String costname;

    private Integer billingMethods;

    private BigDecimal cost;

    private BigDecimal productRate;

    private BigDecimal totalRate;

    private BigDecimal overdueInterest;

private BigDecimal maxamount;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(Integer repaymentType) {
        this.repaymentType = repaymentType;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpptime() {
        return upptime;
    }

    public void setUpptime(Date upptime) {
        this.upptime = upptime;
    }

    public String getUppname() {
        return uppname;
    }

    public void setUppname(String uppname) {
        this.uppname = uppname == null ? null : uppname.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getCostname() {
        return costname;
    }

    public void setCostname(String costname) {
        this.costname = costname == null ? null : costname.trim();
    }

    public Integer getBillingMethods() {
        return billingMethods;
    }

    public void setBillingMethods(Integer billingMethods) {
        this.billingMethods = billingMethods;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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

    public BigDecimal getOverdueInterest() {
        return overdueInterest;
    }

    public void setOverdueInterest(BigDecimal overdueInterest) {
        this.overdueInterest = overdueInterest;
    }
public BigDecimal getMaxamount() {
        return maxamount;
    }

    public void setMaxamount(BigDecimal maxamount) {
        this.maxamount = maxamount;
    }
    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", timeLimit=" + timeLimit +
                ", repaymentType=" + repaymentType +
                ", addtime=" + addtime +
                ", upptime=" + upptime +
                ", uppname='" + uppname + '\'' +
                ", version='" + version + '\'' +
                ", costname='" + costname + '\'' +
                ", billingMethods=" + billingMethods +
                ", cost=" + cost +
                ", productRate=" + productRate +
                ", totalRate=" + totalRate +
                ", overdueInterest=" + overdueInterest +
                '}';
    }
}