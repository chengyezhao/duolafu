package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsRepayment {
    private Long id;

    private Long orderId;

    private Integer repaymentTimes;

    private BigDecimal repaymentAmount;

    private BigDecimal repaymentCost;

    private BigDecimal repaymentCapital;

    private BigDecimal repaymentInterest;

    private BigDecimal repaymentDefaultInterest;

    private BigDecimal repaymentManageCost;

    private BigDecimal realAmount;

    private BigDecimal realCost;

    private BigDecimal realCapital;

    private BigDecimal realInterest;

    private BigDecimal realDefaultInterest;

    private BigDecimal realManageCost;

    private Integer repaymentStatus;

    private Integer repaymentType;

    private Long repaymentCardid;

    private Date repaymentTime;

    private String repaymentNumber;

    private Integer active;

    public GoodsRepayment() { }

    public GoodsRepayment(Long orderId, Integer repaymentTimes, BigDecimal repaymentAmount, BigDecimal repaymentCost, BigDecimal repaymentCapital, BigDecimal repaymentInterest, BigDecimal repaymentDefaultInterest, BigDecimal repaymentManageCost, BigDecimal realAmount, BigDecimal realCost, BigDecimal realCapital, BigDecimal realInterest, BigDecimal realDefaultInterest, BigDecimal realManageCost, Integer repaymentStatus, Integer repaymentType, Long repaymentCardid, Date repaymentTime, String repaymentNumber, Integer active) {
        this.orderId = orderId;
        this.repaymentTimes = repaymentTimes;
        this.repaymentAmount = repaymentAmount;
        this.repaymentCost = repaymentCost;
        this.repaymentCapital = repaymentCapital;
        this.repaymentInterest = repaymentInterest;
        this.repaymentDefaultInterest = repaymentDefaultInterest;
        this.repaymentManageCost = repaymentManageCost;
        this.realAmount = realAmount;
        this.realCost = realCost;
        this.realCapital = realCapital;
        this.realInterest = realInterest;
        this.realDefaultInterest = realDefaultInterest;
        this.realManageCost = realManageCost;
        this.repaymentStatus = repaymentStatus;
        this.repaymentType = repaymentType;
        this.repaymentCardid = repaymentCardid;
        this.repaymentTime = repaymentTime;
        this.repaymentNumber = repaymentNumber;
        this.active = active;
    }

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

    public Integer getRepaymentTimes() {
        return repaymentTimes;
    }

    public void setRepaymentTimes(Integer repaymentTimes) {
        this.repaymentTimes = repaymentTimes;
    }

    public BigDecimal getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(BigDecimal repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public BigDecimal getRepaymentCost() {
        return repaymentCost;
    }

    public void setRepaymentCost(BigDecimal repaymentCost) {
        this.repaymentCost = repaymentCost;
    }

    public BigDecimal getRepaymentCapital() {
        return repaymentCapital;
    }

    public void setRepaymentCapital(BigDecimal repaymentCapital) {
        this.repaymentCapital = repaymentCapital;
    }

    public BigDecimal getRepaymentInterest() {
        return repaymentInterest;
    }

    public void setRepaymentInterest(BigDecimal repaymentInterest) {
        this.repaymentInterest = repaymentInterest;
    }

    public BigDecimal getRepaymentDefaultInterest() {
        return repaymentDefaultInterest;
    }

    public void setRepaymentDefaultInterest(BigDecimal repaymentDefaultInterest) {
        this.repaymentDefaultInterest = repaymentDefaultInterest;
    }

    public BigDecimal getRepaymentManageCost() {
        return repaymentManageCost;
    }

    public void setRepaymentManageCost(BigDecimal repaymentManageCost) {
        this.repaymentManageCost = repaymentManageCost;
    }


    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public BigDecimal getRealCost() {
        return realCost;
    }

    public void setRealCost(BigDecimal realCost) {
        this.realCost = realCost;
    }

    public BigDecimal getRealCapital() {
        return realCapital;
    }

    public void setRealCapital(BigDecimal realCapital) {
        this.realCapital = realCapital;
    }

    public BigDecimal getRealInterest() {
        return realInterest;
    }

    public void setRealInterest(BigDecimal realInterest) {
        this.realInterest = realInterest;
    }

    public BigDecimal getRealDefaultInterest() {
        return realDefaultInterest;
    }

    public void setRealDefaultInterest(BigDecimal realDefaultInterest) {
        this.realDefaultInterest = realDefaultInterest;
    }

    public BigDecimal getRealManageCost() {
        return realManageCost;
    }

    public void setRealManageCost(BigDecimal realManageCost) {
        this.realManageCost = realManageCost;
    }
    public Integer getRepaymentStatus() {
        return repaymentStatus;
    }

    public void setRepaymentStatus(Integer repaymentStatus) {
        this.repaymentStatus = repaymentStatus;
    }

    public Integer getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(Integer repaymentType) {
        this.repaymentType = repaymentType;
    }

    public Long getRepaymentCardid() {
        return repaymentCardid;
    }

    public void setRepaymentCardid(Long repaymentCardid) {
        this.repaymentCardid = repaymentCardid;
    }

    public Date getRepaymentTime() {
        return repaymentTime;
    }

    public void setRepaymentTime(Date repaymentTime) {
        this.repaymentTime = repaymentTime;
    }

    public String getRepaymentNumber() {
        return repaymentNumber;
    }

    public void setRepaymentNumber(String repaymentNumber) {
        this.repaymentNumber = repaymentNumber == null ? null : repaymentNumber.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

}