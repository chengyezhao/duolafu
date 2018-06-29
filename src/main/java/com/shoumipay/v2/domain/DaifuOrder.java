package com.shoumipay.v2.domain;

import java.math.BigDecimal;
import java.util.Date;

//订单的分期信息
public class DaifuOrder {

    // 主键，自增
    //订单Id
    private Long orderId;

    //daifu_code表的codeId
    private Long codeId;

    //账单id，可以是NULL
    private Long billId;

    //用户id
    private Long memberId;

    //订单的名称
    private String title;

    //订单的状态,见OrderStatus
    private String status;

    //期数
    private int totalTerm;

    //首付
    private BigDecimal downPayment;

    //总本金，默认0
    private BigDecimal price;

    //手续费，默认0
    private BigDecimal commission;

    //实际支付的手续费，默认0
    private BigDecimal paidCommission;

    //每月管理费，默认0
    private BigDecimal monthlyFee;

    //逾期状态，见OverDueStatus
    private String overdueStatus;

    private Date createdDate;

    private Date lastUpdateDate;

    private String operatorId;

    private String comments;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalTerm() {
        return totalTerm;
    }

    public void setTotalTerm(int totalTerm) {
        this.totalTerm = totalTerm;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getPaidCommision() {
        return paidCommission;
    }

    public void setPaidCommision(BigDecimal paidCommission) {
        this.paidCommission = paidCommission;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public String getOverdueStatus() {
        return overdueStatus;
    }

    public void setOverdueStatus(String overdueStatus) {
        this.overdueStatus = overdueStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public BigDecimal getPaidCommission() {
        return paidCommission;
    }

    public void setPaidCommission(BigDecimal paidCommission) {
        this.paidCommission = paidCommission;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


}
