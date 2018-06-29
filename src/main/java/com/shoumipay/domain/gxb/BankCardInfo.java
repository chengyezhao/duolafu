package com.shoumipay.domain.gxb;

import java.io.Serializable;

/**
 * Created by yaojun on 2017/9/27.
 */
public class BankCardInfo implements Serializable {
    private static final long serialVersionUID = -8735232510809564530L;
    private String bankName;
    private String cardNo;
    private String phone;
    private String cardOwnerName;
    // 1储蓄卡/2信用卡
    private Integer cardType;
    // 0非本人/1本人
    private Integer isOwnered;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardOwnerName() {
        return cardOwnerName;
    }

    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getIsOwnered() {
        return isOwnered;
    }

    public void setIsOwnered(Integer isOwnered) {
        this.isOwnered = isOwnered;
    }
}
