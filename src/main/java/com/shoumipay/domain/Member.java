package com.shoumipay.domain;

import com.shoumipay.constants.UserConstants;
import com.shoumipay.tools.CalculateUtil;
import com.shoumipay.tools.Md5Util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Member implements Serializable {
    private Long uid;

    private String name;

    private String username;

    private String password;

    private String salt;

    private Byte state;

    private Integer authenticationStatus;

    private String paymentPassword;

    private String levelOfRisk;

    private String phoneNumber;

    private Date addtime;

    private Date upptime;

    private BigDecimal cost;
    private String headIcon;

    private String wechatOpenid;

    private String wechatNickname;

    private String wechatHeadimgurl;

    private String jdData;
    private String tbData;
    private String jxlData;

    private BigDecimal maxAmount;

    private BigDecimal billsTrueAmount;

    private BigDecimal billsFalseAmount;
    private BigDecimal prepaymentAmount;

    /**
     * 密码盐.
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
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
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getAuthenticationStatus() {
        return authenticationStatus;
    }

    public boolean hasAuthentication() {
        return authenticationStatus >= 1;
    }

    public void setAuthenticationStatus(Integer authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public String getPaymentPassword() {
        return paymentPassword;
    }

    public void setPaymentPassword(String paymentPassword) {
        this.paymentPassword = paymentPassword == null ? null : paymentPassword.trim();
    }

    public String getLevelOfRisk() {
        return levelOfRisk;
    }

    public void setLevelOfRisk(String levelOfRisk) {
        this.levelOfRisk = levelOfRisk == null ? null : levelOfRisk.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpptime() {
        return upptime;
    }

    public void setUpptime(Date upptime) {
        this.upptime = upptime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon == null ? null : headIcon.trim();
    }

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid == null ? null : wechatOpenid.trim();
    }

    public String getWechatNickname() {
        return wechatNickname;
    }

    public void setWechatNickname(String wechatNickname) {
        this.wechatNickname = wechatNickname == null ? null : wechatNickname.trim();
    }

    public String getWechatHeadimgurl() {
        return wechatHeadimgurl;
    }

    public void setWechatHeadimgurl(String wechatHeadimgurl) {
        this.wechatHeadimgurl = wechatHeadimgurl == null ? null : wechatHeadimgurl.trim();
    }

    public String getJdData() {
        return jdData;
    }

    public void setJdData(String jdData) {
        this.jdData = jdData == null ? null : jdData.trim();
    }

    public String getTbData() {
        return tbData;
    }

    public void setTbData(String tbData) {
        this.tbData = tbData;
    }

    public String getJxlData() {
        return jxlData;
    }

    public void setJxlData(String jxlData) {
        this.jxlData = jxlData == null ? null : jxlData.trim();
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

    public BigDecimal getPrepaymentAmount() {
        return prepaymentAmount;
    }

    public void setPrepaymentAmount(BigDecimal prepaymentAmount) {
        this.prepaymentAmount = prepaymentAmount;
    }

    public Member() {
    }

    public Member(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.addtime = new Date();
//        this.upptime = new Date(); //刚注册就更新？
        this.salt = CalculateUtil.generateMixRandomCode(UserConstants.saltLength);
        this.password = Md5Util.getMD5(Md5Util.getMD5(this.username + password + getCredentialsSalt()));
    }

    public void resetPassword(String password) {
        this.upptime = new Date();
        this.password = Md5Util.getMD5(Md5Util.getMD5(this.username + password + getCredentialsSalt()));
    }

    @Override
    public String toString() {
        return "Member{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", authenticationStatus=" + authenticationStatus +
                ", paymentPassword='" + paymentPassword + '\'' +
                ", levelOfRisk='" + levelOfRisk + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addtime=" + addtime +
                ", upptime=" + upptime +
                ", headIcon='" + headIcon + '\'' +
                ", wechatOpenid='" + wechatOpenid + '\'' +
                ", wechatNickname='" + wechatNickname + '\'' +
                ", wechatHeadimgurl='" + wechatHeadimgurl + '\'' +
                '}';
    }
}