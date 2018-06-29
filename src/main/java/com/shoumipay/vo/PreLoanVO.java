package com.shoumipay.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Tang on 2017/11/3.
 */
public class PreLoanVO {
    private String phoneNumber;
    private String goodAlias;
    private Date applyStart;
    private Date applyEnd;
    private BigDecimal minApplyAmount;
    private BigDecimal maxApplyAmount;
    private BigDecimal minApprovalAmount;
    private BigDecimal maxApprovalAmount;
    private Date approvalStart;
    private Date approvalEnd;
    private Integer status;

    public PreLoanVO() {}

    public PreLoanVO(String phoneNumber, String goodAlias, Date applyStart, Date applyEnd, BigDecimal minApplyAmount, BigDecimal maxApplyAmount, BigDecimal minApprovalAmount, BigDecimal maxApprovalAmount, Date approvalStart, Date approvalEnd, Integer status) {
        this.phoneNumber = phoneNumber;
        this.goodAlias = goodAlias;
        this.applyStart = applyStart;
        this.applyEnd = applyEnd;
        this.minApplyAmount = minApplyAmount;
        this.maxApplyAmount = maxApplyAmount;
        this.minApprovalAmount = minApprovalAmount;
        this.maxApprovalAmount = maxApprovalAmount;
        this.approvalStart = approvalStart;
        this.approvalEnd = approvalEnd;
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGoodAlias() {
        return goodAlias;
    }

    public void setGoodAlias(String goodAlias) {
        this.goodAlias = goodAlias;
    }

    public Date getApplyStart() {
        return applyStart;
    }

    public void setApplyStart(Date applyStart) {
        this.applyStart = applyStart;
    }

    public Date getApplyEnd() {
        return applyEnd;
    }

    public void setApplyEnd(Date applyEnd) {
        this.applyEnd = applyEnd;
    }

    public BigDecimal getMinApplyAmount() {
        return minApplyAmount;
    }

    public void setMinApplyAmount(BigDecimal minApplyAmount) {
        this.minApplyAmount = minApplyAmount;
    }

    public BigDecimal getMaxApplyAmount() {
        return maxApplyAmount;
    }

    public void setMaxApplyAmount(BigDecimal maxApplyAmount) {
        this.maxApplyAmount = maxApplyAmount;
    }

    public BigDecimal getMinApprovalAmount() {
        return minApprovalAmount;
    }

    public void setMinApprovalAmount(BigDecimal minApprovalAmount) {
        this.minApprovalAmount = minApprovalAmount;
    }

    public BigDecimal getMaxApprovalAmount() {
        return maxApprovalAmount;
    }

    public void setMaxApprovalAmount(BigDecimal maxApprovalAmount) {
        this.maxApprovalAmount = maxApprovalAmount;
    }

    public Date getApprovalStart() {
        return approvalStart;
    }

    public void setApprovalStart(Date approvalStart) {
        this.approvalStart = approvalStart;
    }

    public Date getApprovalEnd() {
        return approvalEnd;
    }

    public void setApprovalEnd(Date approvalEnd) {
        this.approvalEnd = approvalEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
        if (-1 == status) this.status = null;
    }

}
