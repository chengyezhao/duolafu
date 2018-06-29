package com.shoumipay.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MemberBankcard {
    private Long cardid;

    private String bankcardNumber;

    private Integer cardType;

    private String bankCardName;

    private String bankOfDeposit;

    private String provincesAndCities;

    private String openingBranch;

    private String phonenumber;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date bankCardValidity;

    private String auditor;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cardAddtime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cardUpptime;

    private Integer cardBindType;

    private Integer cardState;

    private Integer cardnum;

    private Long memberid;
    private String cardProtocol;

    public Long getCardid() {
        return cardid;
    }

    public void setCardid(Long cardid) {
        this.cardid = cardid;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber == null ? null : bankcardNumber.trim();
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getBankCardName() {
        return bankCardName;
    }

    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName == null ? null : bankCardName.trim();
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit == null ? null : bankOfDeposit.trim();
    }

    public String getProvincesAndCities() {
        return provincesAndCities;
    }

    public void setProvincesAndCities(String provincesAndCities) {
        this.provincesAndCities = provincesAndCities == null ? null : provincesAndCities.trim();
    }

    public String getOpeningBranch() {
        return openingBranch;
    }

    public void setOpeningBranch(String openingBranch) {
        this.openingBranch = openingBranch == null ? null : openingBranch.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Date getBankCardValidity() {
        return bankCardValidity;
    }

    public void setBankCardValidity(Date bankCardValidity) {
        this.bankCardValidity = bankCardValidity;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Date getCardAddtime() {
        return cardAddtime;
    }

    public void setCardAddtime(Date cardAddtime) {
        this.cardAddtime = cardAddtime;
    }

    public Date getCardUpptime() {
        return cardUpptime;
    }

    public void setCardUpptime(Date cardUpptime) {
        this.cardUpptime = cardUpptime;
    }

    public Integer getCardBindType() {
        return cardBindType;
    }

    public void setCardBindType(Integer cardBindType) {
        this.cardBindType = cardBindType;
    }

    public Integer getCardState() {
        return cardState;
    }

    public void setCardState(Integer cardState) {
        this.cardState = cardState;
    }

    public Integer getCardnum() {
        return cardnum;
    }

    public void setCardnum(Integer cardnum) {
        this.cardnum = cardnum;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }
 public String getCardProtocol() {
        return cardProtocol;
    }

    public void setCardProtocol(String cardProtocol) {
        this.cardProtocol = cardProtocol == null ? null : cardProtocol.trim();
    }
}