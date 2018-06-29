package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsMakeLoans {
    private Long id;

    private Long orderId;

    private Long memberId;

    private Date makeLoansCreateTime;

    private BigDecimal makeLoansAmount;

    private Date makeLoansExpirationTime;

    private Date makeLoansClosingTime;

    private Integer makeLoansTimeLimit;

    private Integer makeLoansPaymentMethod;

    private Integer makeLoansStatus;

    private String makeLoansSerialNumber;

    private String makeLoansInstitutionCode;

    private Long makeLoansCardid;

    private Long makeLoansId;

    private String makeLoansCode;

    private BigDecimal makeLoansDayRate;

    private BigDecimal makeLoansServiceCost;

    private BigDecimal makeLoansManageCost;

    private BigDecimal makeLoansTimeCost;

    private BigDecimal makeLoansOverdueRate;

    private Boolean active;

    public GoodsMakeLoans(){}

    public GoodsMakeLoans(Long orderId, Long memberId, Date makeLoansCreateTime, BigDecimal makeLoansAmount, Date makeLoansExpirationTime, Date makeLoansClosingTime, Integer makeLoansTimeLimit, Integer makeLoansPaymentMethod, Integer makeLoansStatus, String makeLoansSerialNumber, String makeLoansInstitutionCode, Long makeLoansCardid, Long makeLoansId, String makeLoansCode, BigDecimal makeLoansDayRate, BigDecimal makeLoansServiceCost, BigDecimal makeLoansManageCost, BigDecimal makeLoansTimeCost, BigDecimal makeLoansOverdueRate, Boolean active) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.makeLoansCreateTime = makeLoansCreateTime;
        this.makeLoansAmount = makeLoansAmount;
        this.makeLoansExpirationTime = makeLoansExpirationTime;
        this.makeLoansClosingTime = makeLoansClosingTime;
        this.makeLoansTimeLimit = makeLoansTimeLimit;
        this.makeLoansPaymentMethod = makeLoansPaymentMethod;
        this.makeLoansStatus = makeLoansStatus;
        this.makeLoansSerialNumber = makeLoansSerialNumber;
        this.makeLoansInstitutionCode = makeLoansInstitutionCode;
        this.makeLoansCardid = makeLoansCardid;
        this.makeLoansId = makeLoansId;
        this.makeLoansCode = makeLoansCode;
        this.makeLoansDayRate = makeLoansDayRate;
        this.makeLoansServiceCost = makeLoansServiceCost;
        this.makeLoansManageCost = makeLoansManageCost;
        this.makeLoansTimeCost = makeLoansTimeCost;
        this.makeLoansOverdueRate = makeLoansOverdueRate;
        this.active = active;
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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getMakeLoansCreateTime() {
        return makeLoansCreateTime;
    }

    public void setMakeLoansCreateTime(Date makeLoansCreateTime) {
        this.makeLoansCreateTime = makeLoansCreateTime;
    }

    public BigDecimal getMakeLoansAmount() {
        return makeLoansAmount;
    }

    public void setMakeLoansAmount(BigDecimal makeLoansAmount) {
        this.makeLoansAmount = makeLoansAmount;
    }

    public Date getMakeLoansExpirationTime() {
        return makeLoansExpirationTime;
    }

    public void setMakeLoansExpirationTime(Date makeLoansExpirationTime) {
        this.makeLoansExpirationTime = makeLoansExpirationTime;
    }

    public Date getMakeLoansClosingTime() {
        return makeLoansClosingTime;
    }

    public void setMakeLoansClosingTime(Date makeLoansClosingTime) {
        this.makeLoansClosingTime = makeLoansClosingTime;
    }

    public Integer getMakeLoansTimeLimit() {
        return makeLoansTimeLimit;
    }

    public void setMakeLoansTimeLimit(Integer makeLoansTimeLimit) {
        this.makeLoansTimeLimit = makeLoansTimeLimit;
    }

    public Integer getMakeLoansPaymentMethod() {
        return makeLoansPaymentMethod;
    }

    public void setMakeLoansPaymentMethod(Integer makeLoansPaymentMethod) {
        this.makeLoansPaymentMethod = makeLoansPaymentMethod;
    }

    public Integer getMakeLoansStatus() {
        return makeLoansStatus;
    }

    public void setMakeLoansStatus(Integer makeLoansStatus) {
        this.makeLoansStatus = makeLoansStatus;
    }

    public String getMakeLoansSerialNumber() {
        return makeLoansSerialNumber;
    }

    public void setMakeLoansSerialNumber(String makeLoansSerialNumber) {
        this.makeLoansSerialNumber = makeLoansSerialNumber == null ? null : makeLoansSerialNumber.trim();
    }

    public String getMakeLoansInstitutionCode() {
        return makeLoansInstitutionCode;
    }

    public void setMakeLoansInstitutionCode(String makeLoansInstitutionCode) {
        this.makeLoansInstitutionCode = makeLoansInstitutionCode == null ? null : makeLoansInstitutionCode.trim();
    }

    public Long getMakeLoansCardid() {
        return makeLoansCardid;
    }

    public void setMakeLoansCardid(Long makeLoansCardid) {
        this.makeLoansCardid = makeLoansCardid;
    }

    public Long getMakeLoansId() {
        return makeLoansId;
    }

    public void setMakeLoansId(Long makeLoansId) {
        this.makeLoansId = makeLoansId;
    }

    public String getMakeLoansCode() {
        return makeLoansCode;
    }

    public void setMakeLoansCode(String makeLoansCode) {
        this.makeLoansCode = makeLoansCode == null ? null : makeLoansCode.trim();
    }

    public BigDecimal getMakeLoansDayRate() {
        return makeLoansDayRate;
    }

    public void setMakeLoansDayRate(BigDecimal makeLoansDayRate) {
        this.makeLoansDayRate = makeLoansDayRate;
    }

    public BigDecimal getMakeLoansServiceCost() {
        return makeLoansServiceCost;
    }

    public void setMakeLoansServiceCost(BigDecimal makeLoansServiceCost) {
        this.makeLoansServiceCost = makeLoansServiceCost;
    }

    public BigDecimal getMakeLoansManageCost() {
        return makeLoansManageCost;
    }

    public void setMakeLoansManageCost(BigDecimal makeLoansManageCost) {
        this.makeLoansManageCost = makeLoansManageCost;
    }

    public BigDecimal getMakeLoansTimeCost() {
        return makeLoansTimeCost;
    }

    public void setMakeLoansTimeCost(BigDecimal makeLoansTimeCost) {
        this.makeLoansTimeCost = makeLoansTimeCost;
    }

    public BigDecimal getMakeLoansOverdueRate() {
        return makeLoansOverdueRate;
    }

    public void setMakeLoansOverdueRate(BigDecimal makeLoansOverdueRate) {
        this.makeLoansOverdueRate = makeLoansOverdueRate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}