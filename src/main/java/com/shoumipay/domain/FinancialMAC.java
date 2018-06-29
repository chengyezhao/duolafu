package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.Date;

public class FinancialMAC {
    private Long id;

    private Long goodsId;

    private String channel;

    private Long todayAmountNumber;

    private Long totalAmountNumber;

    private BigDecimal todayRepayShould;

    private BigDecimal todayRealityAmount;

    private BigDecimal todayRepayShouldPrc;

    private BigDecimal todayRealityPrc;

    private Long deductionNumber;

    private Long successDeductionNumber;

    private BigDecimal dcAmount;

    private BigDecimal dcAmountPrc;

    private BigDecimal dcReceivedAmoutn;

    private BigDecimal dcReceivedAmoutnPrc;

    private BigDecimal amountOfFunds;

    private Date time;

    public FinancialMAC() {
    }

    public FinancialMAC(FinancialMAC financialMAC) {
        this.goodsId=1L;
        this.channel="system";
        this.todayAmountNumber = (financialMAC.todayAmountNumber == null ? 0L : financialMAC.todayAmountNumber);
        this.totalAmountNumber = (financialMAC.totalAmountNumber == null ? 0L : financialMAC.totalAmountNumber);
        this.todayRepayShould = (financialMAC.todayRepayShould == null ? new BigDecimal(0) : financialMAC.todayRepayShould);
        this.todayRealityAmount = (financialMAC.todayRealityAmount == null ? new BigDecimal(0) : financialMAC.todayRealityAmount);
        this.todayRepayShouldPrc = (financialMAC.todayRepayShouldPrc == null ? new BigDecimal(0) : financialMAC.todayRepayShouldPrc);
        this.todayRealityPrc = (financialMAC.todayRealityPrc == null ? new BigDecimal(0) : financialMAC.todayRealityPrc);
        this.deductionNumber = (financialMAC.deductionNumber == null ? 0L : financialMAC.deductionNumber);
        this.successDeductionNumber = (financialMAC.successDeductionNumber == null ? 0L : financialMAC.successDeductionNumber);
        this.dcAmount = (financialMAC.dcAmount == null ? new BigDecimal(0) : financialMAC.dcAmount);
        this.dcAmountPrc = (financialMAC.dcAmountPrc == null ? new BigDecimal(0) : financialMAC.dcAmountPrc);
        this.dcReceivedAmoutn = (financialMAC.dcReceivedAmoutn == null ? new BigDecimal(0) : financialMAC.dcReceivedAmoutn);
        this.dcReceivedAmoutnPrc = (financialMAC.dcReceivedAmoutnPrc == null ? new BigDecimal(0) : financialMAC.dcReceivedAmoutnPrc);
        this.amountOfFunds = (financialMAC.amountOfFunds == null ? new BigDecimal(0) : financialMAC.amountOfFunds);
        this.time = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Long getTodayAmountNumber() {
        return todayAmountNumber;
    }

    public void setTodayAmountNumber(Long todayAmountNumber) {
        this.todayAmountNumber = todayAmountNumber;
    }

    public Long getTotalAmountNumber() {
        return totalAmountNumber;
    }

    public void setTotalAmountNumber(Long totalAmountNumber) {
        this.totalAmountNumber = totalAmountNumber;
    }

    public BigDecimal getTodayRepayShould() {
        return todayRepayShould;
    }

    public void setTodayRepayShould(BigDecimal todayRepayShould) {
        this.todayRepayShould = todayRepayShould;
    }

    public BigDecimal getTodayRealityAmount() {
        return todayRealityAmount;
    }

    public void setTodayRealityAmount(BigDecimal todayRealityAmount) {
        this.todayRealityAmount = todayRealityAmount;
    }

    public BigDecimal getTodayRepayShouldPrc() {
        return todayRepayShouldPrc;
    }

    public void setTodayRepayShouldPrc(BigDecimal todayRepayShouldPrc) {
        this.todayRepayShouldPrc = todayRepayShouldPrc;
    }

    public BigDecimal getTodayRealityPrc() {
        return todayRealityPrc;
    }

    public void setTodayRealityPrc(BigDecimal todayRealityPrc) {
        this.todayRealityPrc = todayRealityPrc;
    }

    public Long getDeductionNumber() {
        return deductionNumber;
    }

    public void setDeductionNumber(Long deductionNumber) {
        this.deductionNumber = deductionNumber;
    }

    public Long getSuccessDeductionNumber() {
        return successDeductionNumber;
    }

    public void setSuccessDeductionNumber(Long successDeductionNumber) {
        this.successDeductionNumber = successDeductionNumber;
    }

    public BigDecimal getDcAmount() {
        return dcAmount;
    }

    public void setDcAmount(BigDecimal dcAmount) {
        this.dcAmount = dcAmount;
    }

    public BigDecimal getDcAmountPrc() {
        return dcAmountPrc;
    }

    public void setDcAmountPrc(BigDecimal dcAmountPrc) {
        this.dcAmountPrc = dcAmountPrc;
    }

    public BigDecimal getDcReceivedAmoutn() {
        return dcReceivedAmoutn;
    }

    public void setDcReceivedAmoutn(BigDecimal dcReceivedAmoutn) {
        this.dcReceivedAmoutn = dcReceivedAmoutn;
    }

    public BigDecimal getDcReceivedAmoutnPrc() {
        return dcReceivedAmoutnPrc;
    }

    public void setDcReceivedAmoutnPrc(BigDecimal dcReceivedAmoutnPrc) {
        this.dcReceivedAmoutnPrc = dcReceivedAmoutnPrc;
    }

    public BigDecimal getAmountOfFunds() {
        return amountOfFunds;
    }

    public void setAmountOfFunds(BigDecimal amountOfFunds) {
        this.amountOfFunds = amountOfFunds;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}