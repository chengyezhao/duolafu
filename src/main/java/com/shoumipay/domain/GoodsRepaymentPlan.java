package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsRepaymentPlan {
    private Long id;

    private Long orderId;

    private Integer repaymentPlanTimes;

    private BigDecimal repaymentPlanAmount;

    private BigDecimal repaymentPlanCapital;

    private BigDecimal repaymentPlanInterest;

    private Date repaymentPlanEndTime;

    private Integer status;

    private Date created;

    public GoodsRepaymentPlan(){}

    public GoodsRepaymentPlan(GoodsRepaymentPlan plan, BigDecimal capital, BigDecimal interest) {
        this.orderId = plan.orderId;
        this.repaymentPlanTimes = plan.repaymentPlanTimes;
        this.repaymentPlanCapital = plan.getRepaymentPlanCapital().subtract(capital);
        this.repaymentPlanInterest = interest;
        this.repaymentPlanAmount = this.repaymentPlanCapital.add(interest);
        this.repaymentPlanEndTime = plan.repaymentPlanEndTime;
        this.status = 0;
        this.created = new Date();
    }

    public GoodsRepaymentPlan(Long orderId, Integer repaymentPlanTimes, BigDecimal repaymentPlanAmount, BigDecimal repaymentPlanCapital, BigDecimal repaymentPlanInterest, Date repaymentPlanEndTime, Integer status, Date created) {
        this.orderId = orderId;
        this.repaymentPlanTimes = repaymentPlanTimes;
        this.repaymentPlanAmount = repaymentPlanAmount;
        this.repaymentPlanCapital = repaymentPlanCapital;
        this.repaymentPlanInterest = repaymentPlanInterest;
        this.repaymentPlanEndTime = repaymentPlanEndTime;
        this.status = status;
        this.created = created;
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

    public Integer getRepaymentPlanTimes() {
        return repaymentPlanTimes;
    }

    public void setRepaymentPlanTimes(Integer repaymentPlanTimes) {
        this.repaymentPlanTimes = repaymentPlanTimes;
    }

    public BigDecimal getRepaymentPlanAmount() {
        return repaymentPlanAmount;
    }

    public void setRepaymentPlanAmount(BigDecimal repaymentPlanAmount) {
        this.repaymentPlanAmount = repaymentPlanAmount;
    }

    public BigDecimal getRepaymentPlanCapital() {
        return repaymentPlanCapital;
    }

    public void setRepaymentPlanCapital(BigDecimal repaymentPlanCapital) {
        this.repaymentPlanCapital = repaymentPlanCapital;
    }

    public BigDecimal getRepaymentPlanInterest() {
        return repaymentPlanInterest;
    }

    public void setRepaymentPlanInterest(BigDecimal repaymentPlanInterest) {
        this.repaymentPlanInterest = repaymentPlanInterest;
    }

    public Date getRepaymentPlanEndTime() {
        return repaymentPlanEndTime;
    }

    public void setRepaymentPlanEndTime(Date repaymentPlanEndTime) {
        this.repaymentPlanEndTime = repaymentPlanEndTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}