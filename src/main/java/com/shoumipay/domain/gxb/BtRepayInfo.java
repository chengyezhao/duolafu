package com.shoumipay.domain.gxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yaojun on 2017/9/27.
 */
public class BtRepayInfo implements Serializable {
    private static final long serialVersionUID = 1184192047250590707L;
    private String bankName;
    private Integer cardType;
    private Date payTime;
    private BigDecimal amount;
    private String cardNum;
    //1:"主动还款",2:"模拟还款",3:"线下还款",4:"自动还款"
    private Integer status;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
