package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BankAccount {
    private Long id;

    private Date createtime;

    private String merchantOrderNumber;

    private String merchantId;

    private Date timeOfOrderCreated;

    private String merchantBusinessType;

    private String lianlianPaymentNumber;

    private Date lianlianSettlementDate;

    private BigDecimal transactionAmount;

    private Integer typeFlag;

    private Integer transactionStatus;

    private Date updateDate;

    private BigDecimal serviceFee;

    private String paymentProduct;

    private String paymentMethod;

    private String orderInfo;

    private String beneficiaryBank;

    private String bankAccountNumber;

    private String beneficiary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMerchantOrderNumber() {
        return merchantOrderNumber;
    }

    public void setMerchantOrderNumber(String merchantOrderNumber) {
        this.merchantOrderNumber = merchantOrderNumber == null ? null : merchantOrderNumber.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public Date getTimeOfOrderCreated() {
        return timeOfOrderCreated;
    }

    public void setTimeOfOrderCreated(Date timeOfOrderCreated) {
        this.timeOfOrderCreated = timeOfOrderCreated;
    }

    public String getMerchantBusinessType() {
        return merchantBusinessType;
    }

    public void setMerchantBusinessType(String merchantBusinessType) {
        this.merchantBusinessType = merchantBusinessType == null ? null : merchantBusinessType.trim();
    }

    public String getLianlianPaymentNumber() {
        return lianlianPaymentNumber;
    }

    public void setLianlianPaymentNumber(String lianlianPaymentNumber) {
        this.lianlianPaymentNumber = lianlianPaymentNumber == null ? null : lianlianPaymentNumber.trim();
    }

    public Date getLianlianSettlementDate() {
        return lianlianSettlementDate;
    }

    public void setLianlianSettlementDate(Date lianlianSettlementDate) {
        this.lianlianSettlementDate = lianlianSettlementDate;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(Integer typeFlag) {
        this.typeFlag = typeFlag;
    }

    public Integer getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getPaymentProduct() {
        return paymentProduct;
    }

    public void setPaymentProduct(String paymentProduct) {
        this.paymentProduct = paymentProduct == null ? null : paymentProduct.trim();
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo == null ? null : orderInfo.trim();
    }

    public String getBeneficiaryBank() {
        return beneficiaryBank;
    }

    public void setBeneficiaryBank(String beneficiaryBank) {
        this.beneficiaryBank = beneficiaryBank == null ? null : beneficiaryBank.trim();
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber == null ? null : bankAccountNumber.trim();
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary == null ? null : beneficiary.trim();
    }
    public BankAccount(){}
    public BankAccount(Date createtime, String merchantOrderNumber, String merchantId, Date timeOfOrderCreated, String merchantBusinessType, String lianlianPaymentNumber, Date lianlianSettlementDate, BigDecimal transactionAmount, Integer typeFlag, Integer transactionStatus, Date updateDate, BigDecimal serviceFee, String paymentProduct, String paymentMethod, String orderInfo, String beneficiaryBank, String bankAccountNumber, String beneficiary) {
        this.createtime = createtime;
        this.merchantOrderNumber = merchantOrderNumber;
        this.merchantId = merchantId;
        this.timeOfOrderCreated = timeOfOrderCreated;
        this.merchantBusinessType = merchantBusinessType;
        this.lianlianPaymentNumber = lianlianPaymentNumber;
        this.lianlianSettlementDate = lianlianSettlementDate;
        this.transactionAmount = transactionAmount;
        this.typeFlag = typeFlag;
        this.transactionStatus = transactionStatus;
        this.updateDate = updateDate;
        this.serviceFee = serviceFee;
        this.paymentProduct = paymentProduct;
        this.paymentMethod = paymentMethod;
        this.orderInfo = orderInfo;
        this.beneficiaryBank = beneficiaryBank;
        this.bankAccountNumber = bankAccountNumber;
        this.beneficiary = beneficiary;
    }
}