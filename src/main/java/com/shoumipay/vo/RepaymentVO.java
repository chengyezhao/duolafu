package com.shoumipay.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Tang on 2017/11/2.
 */
public class RepaymentVO {
    private Long orderId;
    private BigDecimal unRepay;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date loanTime;
    private BigDecimal amount;
    private Integer remainderTimes;
    private String status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getUnRepay() {
        return unRepay;
    }

    public void setUnRepay(BigDecimal unRepay) {
        this.unRepay = unRepay;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getRemainderTimes() {
        return remainderTimes;
    }

    public void setRemainderTimes(Integer remainderTimes) {
        this.remainderTimes = remainderTimes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
