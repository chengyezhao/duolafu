package com.shoumipay.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Netraffic {
    private Long id;

    private Long goodsId;

    private String channel;

    private Long registerNumber;

    private Long applyForNumber;

    private Long submitNumber;

    private Long passNumber;

    private BigDecimal passAmount;

    private Long submitAmountNumber;

    private BigDecimal submitAmount;

    private Long successAmountNumber;

    private BigDecimal successAmount;

    private BigDecimal passRate;

    private BigDecimal submitAmountRate;

    private BigDecimal successAmountRate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date time;

    public Netraffic() {
    }

    public Netraffic(Netraffic netraffic) {
        this.goodsId=1L;
        this.channel="system";
        this.registerNumber = (netraffic.registerNumber == null ? 0L : netraffic.registerNumber);
        this.applyForNumber = (netraffic.applyForNumber == null ? 0L : netraffic.applyForNumber);
        this.submitNumber = (netraffic.submitNumber == null ? 0L : netraffic.submitNumber);
        this.passNumber = (netraffic.passNumber == null ? 0L : netraffic.passNumber);
        this.passAmount = (netraffic.passAmount == null ? new BigDecimal(0) : netraffic.passAmount);
        this.submitAmountNumber = (netraffic.submitAmountNumber == null ? 0L : netraffic.submitAmountNumber);
        this.submitAmount = (netraffic.submitAmount == null ? new BigDecimal(0) : netraffic.submitAmount);
        this.successAmountNumber = (netraffic.successAmountNumber == null ? 0L : netraffic.successAmountNumber);
        this.successAmount = (netraffic.successAmount == null ? new BigDecimal(0) : netraffic.successAmount);
        if (netraffic.applyForNumber != null && netraffic.applyForNumber > 0) {
            this.passRate = new BigDecimal(netraffic.passNumber).divide(new BigDecimal(netraffic.applyForNumber));
            this.submitAmountRate = new BigDecimal(netraffic.submitAmountNumber).divide(new BigDecimal(netraffic.applyForNumber));
            this.successAmountRate = new BigDecimal(netraffic.successAmountNumber).divide(new BigDecimal(netraffic.applyForNumber));
        } else {
            this.passRate = new BigDecimal(0);
            this.submitAmountRate = new BigDecimal(0);
            this.successAmountRate = new BigDecimal(0);
        }
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

    public Long getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Long registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Long getApplyForNumber() {
        return applyForNumber;
    }

    public void setApplyForNumber(Long applyForNumber) {
        this.applyForNumber = applyForNumber;
    }

    public Long getSubmitNumber() {
        return submitNumber;
    }

    public void setSubmitNumber(Long submitNumber) {
        this.submitNumber = submitNumber;
    }

    public Long getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(Long passNumber) {
        this.passNumber = passNumber;
    }

    public BigDecimal getPassAmount() {
        return passAmount;
    }

    public void setPassAmount(BigDecimal passAmount) {
        this.passAmount = passAmount;
    }

    public Long getSubmitAmountNumber() {
        return submitAmountNumber;
    }

    public void setSubmitAmountNumber(Long submitAmountNumber) {
        this.submitAmountNumber = submitAmountNumber;
    }

    public BigDecimal getSubmitAmount() {
        return submitAmount;
    }

    public void setSubmitAmount(BigDecimal submitAmount) {
        this.submitAmount = submitAmount;
    }

    public Long getSuccessAmountNumber() {
        return successAmountNumber;
    }

    public void setSuccessAmountNumber(Long successAmountNumber) {
        this.successAmountNumber = successAmountNumber;
    }

    public BigDecimal getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(BigDecimal successAmount) {
        this.successAmount = successAmount;
    }

    public BigDecimal getPassRate() {
        return passRate;
    }

    public void setPassRate(BigDecimal passRate) {
        this.passRate = passRate;
    }

    public BigDecimal getSubmitAmountRate() {
        return submitAmountRate;
    }

    public void setSubmitAmountRate(BigDecimal submitAmountRate) {
        this.submitAmountRate = submitAmountRate;
    }

    public BigDecimal getSuccessAmountRate() {
        return successAmountRate;
    }

    public void setSuccessAmountRate(BigDecimal successAmountRate) {
        this.successAmountRate = successAmountRate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}