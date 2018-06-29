package com.shoumipay.domain;

import java.util.Date;

public class DataMAC {
    private Long id;

    private Long goodsId;

    private String channel;

    private Long alizhimaCall;

    private Long blacklist;

    private Long jiaoCall;

    private Long bankCall;

    private Long smsCall;

    private Long thirdParty1;

    private Long thirdParty2;

    private Long thirdParty3;

    private Date time;

    public DataMAC(){}
    public DataMAC(DataMAC dataMAC){
        this.goodsId=1L;
        this.channel="system";
        this.alizhimaCall = (dataMAC.alizhimaCall == null ? 0L : dataMAC.alizhimaCall);
        this.blacklist = (dataMAC.blacklist == null ? 0L : dataMAC.blacklist);
        this.jiaoCall = (dataMAC.jiaoCall == null ? 0L : dataMAC.jiaoCall);
        this.bankCall = (dataMAC.bankCall == null ? 0L : dataMAC.bankCall);
        this.smsCall = (dataMAC.smsCall == null ? 0L : dataMAC.smsCall);
        this.time = new Date();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Long getAlizhimaCall() {
        return alizhimaCall;
    }

    public void setAlizhimaCall(Long alizhimaCall) {
        this.alizhimaCall = alizhimaCall;
    }

    public Long getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Long blacklist) {
        this.blacklist = blacklist;
    }

    public Long getJiaoCall() {
        return jiaoCall;
    }

    public void setJiaoCall(Long jiaoCall) {
        this.jiaoCall = jiaoCall;
    }

    public Long getBankCall() {
        return bankCall;
    }

    public void setBankCall(Long bankCall) {
        this.bankCall = bankCall;
    }

    public Long getSmsCall() {
        return smsCall;
    }

    public void setSmsCall(Long smsCall) {
        this.smsCall = smsCall;
    }

    public Long getThirdParty1() {
        return thirdParty1;
    }

    public void setThirdParty1(Long thirdParty1) {
        this.thirdParty1 = thirdParty1;
    }

    public Long getThirdParty2() {
        return thirdParty2;
    }

    public void setThirdParty2(Long thirdParty2) {
        this.thirdParty2 = thirdParty2;
    }

    public Long getThirdParty3() {
        return thirdParty3;
    }

    public void setThirdParty3(Long thirdParty3) {
        this.thirdParty3 = thirdParty3;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}