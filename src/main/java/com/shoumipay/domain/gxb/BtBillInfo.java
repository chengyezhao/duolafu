package com.shoumipay.domain.gxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yaojun on 2017/9/27.
 */
public class BtBillInfo implements Serializable {
    private static final long serialVersionUID = 6299267171655938115L;
    private BigDecimal billBalance;
    private Date billDate;
    private Date billLimitDate;
    private BigDecimal payedBalance;
    private BigDecimal minPayment;
    private Integer status;

    public BigDecimal getBillBalance() {
        return billBalance;
    }

    public void setBillBalance(BigDecimal billBalance) {
        this.billBalance = billBalance;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Date getBillLimitDate() {
        return billLimitDate;
    }

    public void setBillLimitDate(Date billLimitDate) {
        this.billLimitDate = billLimitDate;
    }

    public BigDecimal getPayedBalance() {
        return payedBalance;
    }

    public void setPayedBalance(BigDecimal payedBalance) {
        this.payedBalance = payedBalance;
    }

    public BigDecimal getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(BigDecimal minPayment) {
        this.minPayment = minPayment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
