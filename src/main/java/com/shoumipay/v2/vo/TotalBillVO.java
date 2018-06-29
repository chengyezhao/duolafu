package com.shoumipay.v2.vo;


import java.math.BigDecimal;

/**
 * 已出未出账单
 */
public class TotalBillVO {

    private BigDecimal billsTrueAmount = new BigDecimal(0.0);//已出账单

    private BigDecimal billsFalseAmount= new BigDecimal(0.0);//未出账单

    private BigDecimal leftBillAmount= new BigDecimal(0.0); //本月未还款金额

    private Long payDay = 0L;//付款日

    private Long currentBillId; //当期账单id

    public Long getPayDay() {
        return payDay;
    }

    public void setPayDay(Long payDay) {
        this.payDay = payDay;
    }

    public BigDecimal getBillsTrueAmount() {
        return billsTrueAmount;
    }

    public void setBillsTrueAmount(BigDecimal billsTrueAmount) {
        this.billsTrueAmount = billsTrueAmount;
    }

    public BigDecimal getBillsFalseAmount() {
        return billsFalseAmount;
    }

    public void setBillsFalseAmount(BigDecimal billsFalseAmount) {
        this.billsFalseAmount = billsFalseAmount;
    }

    public BigDecimal getLeftBillAmount() {
        return leftBillAmount;
    }

    public void setLeftBillAmount(BigDecimal leftBillAmount) {
        this.leftBillAmount = leftBillAmount;
    }

    public Long getCurrentBillId() {
        return currentBillId;
    }

    public void setCurrentBillId(Long currentBillId) {
        this.currentBillId = currentBillId;
    }
}
