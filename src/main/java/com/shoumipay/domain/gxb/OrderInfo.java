package com.shoumipay.domain.gxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yaojun on 2017/9/27.
 */
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 6683986099614216342L;
    private String tradeNo;
    private Date tradeTime;
    private String payWay;
    private String receiveName;
    private BigDecimal amount;
    private String orderStatus;
    private String otherSide;
    private Integer isBtPay;
    private Integer isBtOverDue;
    private Integer isBtRepay;
    private Integer btInterestNum;
    private List<OrderItemInfo> itemList;
    private String address;
    private String phone;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOtherSide() {
        return otherSide;
    }

    public void setOtherSide(String otherSide) {
        this.otherSide = otherSide;
    }

    public Integer getIsBtPay() {
        return isBtPay;
    }

    public void setIsBtPay(Integer isBtPay) {
        this.isBtPay = isBtPay;
    }

    public Integer getIsBtOverDue() {
        return isBtOverDue;
    }

    public void setIsBtOverDue(Integer isBtOverDue) {
        this.isBtOverDue = isBtOverDue;
    }

    public Integer getIsBtRepay() {
        return isBtRepay;
    }

    public void setIsBtRepay(Integer isBtRepay) {
        this.isBtRepay = isBtRepay;
    }

    public Integer getBtInterestNum() {
        return btInterestNum;
    }

    public void setBtInterestNum(Integer btInterestNum) {
        this.btInterestNum = btInterestNum;
    }

    public List<OrderItemInfo> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItemInfo> itemList) {
        this.itemList = itemList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
