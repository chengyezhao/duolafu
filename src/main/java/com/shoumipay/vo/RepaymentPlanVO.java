package com.shoumipay.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Tang on 2017/11/2.
 */
public class RepaymentPlanVO {
    private Integer times;
    private Integer timesLimit;
    @JSONField(format = "yyyy-MM-dd")
    private Date endTime;
    @JSONField(format = "yyyy-MM-dd")
    private Date closeTime;
    private BigDecimal amount;
    private String status;

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getTimesLimit() {
        return timesLimit;
    }

    public void setTimesLimit(Integer timesLimit) {
        this.timesLimit = timesLimit;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}
