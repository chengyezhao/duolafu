package com.shoumipay.v2.domain;

import java.math.BigDecimal;
import java.util.Date;

//子订单
public class DaifuOrderLeg {

    // 主键，自增
    private Long orderlegId;

    // 订单id
    private Long orderId;

    //账单id，可以是NULL
    private Long billId;

    //应付金额，默认0
    private BigDecimal amount;

    //应付手续费，默认0
    private BigDecimal fee;

    //应付罚息，默认0
    private BigDecimal interest;

    //订单的状态,见OrderLegStatus
    private String status;

    //逾期状态，见OverDueStatus
    private String overdueStatus;

    private Integer sequence;

    private Date createdDate;

    private Date lastUpdatedDate;

    private Long memberId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderlegId() {
        return orderlegId;
    }

    public void setOrderlegId(Long orderlegId) {
        this.orderlegId = orderlegId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getOverdueStatus() {
        return overdueStatus;
    }

    public void setOverdueStatus(String overdueStatus) {
        this.overdueStatus = overdueStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DaifuOrderLeg{" +
                "orderlegId=" + orderlegId +
                ", orderId=" + orderId +
                ", billId=" + billId +
                ", amount=" + amount +
                ", fee=" + fee +
                ", interest=" + interest +
                ", status='" + status + '\'' +
                ", overdueStatus='" + overdueStatus + '\'' +
                ", sequence=" + sequence +
                ", createdDate=" + createdDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", memberId=" + memberId +
                '}';
    }
}
