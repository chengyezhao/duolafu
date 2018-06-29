package com.shoumipay.vo;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsRepaymentCollectionVO {
    private Long id;

    private String username;

    private String orderNumber;

    private Long orderId;

    private Long repaymentId;

    private Integer repaymentCollectionTimeLimit;

    private BigDecimal repaymentCollectionAmount;

    private BigDecimal repaymentCollectionCapital;

    private BigDecimal repaymentCollectionInterest;

    private Date repaymentCollectionAddTime;

    private BigDecimal repaymentCollectionIncome;

    private String repaymentCollectionAuditor;

    private String repaymentCollectionInstitutionCode;

    private Integer repaymentCollectionStatus;

    private String maxRepayTime;
    private String minRepayTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Integer getRepaymentCollectionTimeLimit() {
        return repaymentCollectionTimeLimit;
    }

    public void setRepaymentCollectionTimeLimit(Integer repaymentCollectionTimeLimit) {
        this.repaymentCollectionTimeLimit = repaymentCollectionTimeLimit;
    }

    public BigDecimal getRepaymentCollectionAmount() {
        return repaymentCollectionAmount;
    }

    public void setRepaymentCollectionAmount(BigDecimal repaymentCollectionAmount) {
        this.repaymentCollectionAmount = repaymentCollectionAmount;
    }

    public BigDecimal getRepaymentCollectionCapital() {
        return repaymentCollectionCapital;
    }

    public void setRepaymentCollectionCapital(BigDecimal repaymentCollectionCapital) {
        this.repaymentCollectionCapital = repaymentCollectionCapital;
    }

    public BigDecimal getRepaymentCollectionInterest() {
        return repaymentCollectionInterest;
    }

    public void setRepaymentCollectionInterest(BigDecimal repaymentCollectionInterest) {
        this.repaymentCollectionInterest = repaymentCollectionInterest;
    }

    public Date getRepaymentCollectionAddTime() {
        return repaymentCollectionAddTime;
    }

    public void setRepaymentCollectionAddTime(Date repaymentCollectionAddTime) {
        this.repaymentCollectionAddTime = repaymentCollectionAddTime;
    }

    public BigDecimal getRepaymentCollectionIncome() {
        return repaymentCollectionIncome;
    }

    public void setRepaymentCollectionIncome(BigDecimal repaymentCollectionIncome) {
        this.repaymentCollectionIncome = repaymentCollectionIncome;
    }

    public String getRepaymentCollectionAuditor() {
        return repaymentCollectionAuditor;
    }

    public void setRepaymentCollectionAuditor(String repaymentCollectionAuditor) {
        this.repaymentCollectionAuditor = repaymentCollectionAuditor == null ? null : repaymentCollectionAuditor.trim();
    }

    public String getRepaymentCollectionInstitutionCode() {
        return repaymentCollectionInstitutionCode;
    }

    public void setRepaymentCollectionInstitutionCode(String repaymentCollectionInstitutionCode) {
        this.repaymentCollectionInstitutionCode = repaymentCollectionInstitutionCode == null ? null : repaymentCollectionInstitutionCode.trim();
    }

    public Integer getRepaymentCollectionStatus() {
        return repaymentCollectionStatus;
    }

    public void setRepaymentCollectionStatus(Integer repaymentCollectionStatus) {
        this.repaymentCollectionStatus = repaymentCollectionStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMaxRepayTime() {
        return maxRepayTime;
    }

    public void setMaxRepayTime(String maxRepayTime) {
        this.maxRepayTime = maxRepayTime;
    }

    public String getMinRepayTime() {
        return minRepayTime;
    }

    public void setMinRepayTime(String minRepayTime) {
        this.minRepayTime = minRepayTime;
    }
}