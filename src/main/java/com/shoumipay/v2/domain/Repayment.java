package com.shoumipay.v2.domain;

import java.math.BigDecimal;
import java.util.Date;

//用户还款记录
public class Repayment {

    // 主键，自增
    private Long repaymentId;

    //对应订单Id
    private Long orderId;

    //对应的orderLegId
    private Long orderLegId;

    //付款用户Id
    private Long memberId;

    //操作员id，可以空
    private String operatorId;

    //外部交易id，可以空
    private String transId;

    //类型，见RepaymentType
    private String type;

    //状态，见RepaymentStatus
    private String status;

    //支付的本金，默认0
    private BigDecimal price;

    //支付的手续费，默认0
    private BigDecimal fee;

    //支付的罚息，默认0
    private BigDecimal interest;

    private Date createdDate;

    private Date lastUpdatedDate;

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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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


    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getOrderLegId() {
        return orderLegId;
    }

    public void setOrderLegId(Long orderLegId) {
        this.orderLegId = orderLegId;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
