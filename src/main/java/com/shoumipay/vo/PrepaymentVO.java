package com.shoumipay.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Zhw on 2017/11/23.
 */
public class PrepaymentVO {
    private Long id;

    private Long orderId;

    private String orderNumber;

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

    private String minRepayAmount;
    private String maxRepayAmount;
    private String minRepayTime;
    private String maxRepayTime;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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
        this.repaymentNumber = repaymentNumber;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getMinRepayAmount() {
        return minRepayAmount;
    }

    public void setMinRepayAmount(String minRepayAmount) {
        this.minRepayAmount = minRepayAmount;
    }

    public String getMaxRepayAmount() {
        return maxRepayAmount;
    }

    public void setMaxRepayAmount(String maxRepayAmount) {
        this.maxRepayAmount = maxRepayAmount;
    }

    public String getMinRepayTime() {
        return minRepayTime;
    }

    public void setMinRepayTime(String minRepayTime) {
        this.minRepayTime = minRepayTime;
    }

    public String getMaxRepayTime() {
        return maxRepayTime;
    }

    public void setMaxRepayTime(String maxRepayTime) {
        this.maxRepayTime = maxRepayTime;
    }
}
