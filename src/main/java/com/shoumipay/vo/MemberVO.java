package com.shoumipay.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhw on 2017/11/13.
 */
public class MemberVO {
    private Long uid;

    private String name;

    private String username;

    private Integer authenticationStatus;

    private String phoneNumber;

    private Date addtime;

    private String fullname;

    private String idCard;

    private String status;

    private Integer orderStatus;

    private Integer orderNum;

    private String levelOfRisk;

    private BigDecimal maxAmount;

    private BigDecimal prepaymentAmount;

    public BigDecimal getPrepaymentAmount() {
        return prepaymentAmount;
    }

    public void setPrepaymentAmount(BigDecimal prepaymentAmount) {
        this.prepaymentAmount = prepaymentAmount;
    }

    private BigDecimal useAmount;

    public BigDecimal getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(BigDecimal useAmount) {
        this.useAmount = useAmount;
    }

    private BigDecimal billsTrueAmount;//已出账金额

    private BigDecimal billsFalseAmount;//未出账金额

    public String getLevelOfRisk() {
        return levelOfRisk;
    }

    public void setLevelOfRisk(String levelOfRisk) {
        this.levelOfRisk = levelOfRisk;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
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

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(Integer authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
