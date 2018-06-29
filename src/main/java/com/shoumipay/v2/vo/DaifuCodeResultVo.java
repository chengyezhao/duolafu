package com.shoumipay.v2.vo;

import java.math.BigDecimal;

public class DaifuCodeResultVo {

    private Long codeId;

    private String orderStatus;

    private String parsingStatus;

    private BigDecimal amount;

    private String goods;

    private String username;

    private  String phonenum;

    public String getParsingStatus() {
        return parsingStatus;
    }

    public void setParsingStatus(String parsingStatus) {
        this.parsingStatus = parsingStatus;
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Override
    public String toString() {
        return "DaifuCodeResultVo{" +
                "codeId='" + codeId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", parsingStatus='" + parsingStatus + '\'' +
                ", amount=" + amount +
                ", goods='" + goods + '\'' +
                ", username='" + username + '\'' +
                ", phonenum='" + phonenum + '\'' +
                '}';
    }
}
