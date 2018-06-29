package com.shoumipay.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

import static com.shoumipay.constants.GoodsOrderConstants.*;

/**
 * Created by Tang on 2017/11/7.
 */
public class PreLoanOrderVO {
    private Long id;
    private String orderNumber;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime;
    private BigDecimal loanAmount;
    private Long memberId;
    private String phoneNumber;
    private Long goodId;
    private String goodCode;
    private Integer statusCode;
    private String status;
    private Long processorId;
    private String processorName;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date processorTime;
    private String orderChannel;
    private Long orderDiscount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        switch (this.statusCode) {
            case APPROVAL_PENDING: this.status = "未提交";break;
            case APPROVAL :  this.status = "审批通过";break;
            case APPROVAL_REFUSED :  this.status = "审批拒绝";break;
            case WAIT_LEND :  this.status = "待放款";break;
            case LENDING :  this.status = "放款中";break;
            case LOAN_SUCCESS :  this.status = "已放款";break;
            case LOAN_FAILURE :  this.status = "放款失败";break;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProcessorId() {
        return processorId;
    }

    public void setProcessorId(Long processorId) {
        this.processorId = processorId;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public Date getProcessorTime() {
        return processorTime;
    }

    public void setProcessorTime(Date processorTime) {
        this.processorTime = processorTime;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }

    public Long getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Long orderDiscount) {
        this.orderDiscount = orderDiscount;
    }
}
