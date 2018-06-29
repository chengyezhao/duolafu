package com.shoumipay.domain;

import java.math.BigDecimal;
import java.util.List;

public class JdDaiFu {
    private Long id;

    private String customerName;

    private Integer weiXinDaiFuStatus;

    private String imageUrl;

    private Integer code;

    private Integer disableWishList;

    private String title;

    private Long failureTime;

    private String description;

    private String shareUrl;

    private BigDecimal orderPrice;

    private String friendTitle;

    private Long memberId;

    private String appid;

    private String payid;

    private Integer poundagePayFlag;

    private BigDecimal poundagePayMoney;

    private List<JdItem> itemList;

    public List<JdItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<JdItem> itemList) {
        this.itemList = itemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getWeiXinDaiFuStatus() {
        return weiXinDaiFuStatus;
    }

    public void setWeiXinDaiFuStatus(Integer weiXinDaiFuStatus) {
        this.weiXinDaiFuStatus = weiXinDaiFuStatus;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getDisableWishList() {
        return disableWishList;
    }

    public void setDisableWishList(Integer disableWishList) {
        this.disableWishList = disableWishList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Long failureTime) {
        this.failureTime = failureTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getFriendTitle() {
        return friendTitle;
    }

    public void setFriendTitle(String friendTitle) {
        this.friendTitle = friendTitle == null ? null : friendTitle.trim();
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid == null ? null : payid.trim();
    }

    public Integer getPoundagePayFlag() {
        return poundagePayFlag;
    }

    public void setPoundagePayFlag(Integer poundagePayFlag) {
        this.poundagePayFlag = poundagePayFlag;
    }
 public BigDecimal getPoundagePayMoney() {
        return poundagePayMoney;
    }

    public void setPoundagePayMoney(BigDecimal poundagePayMoney) {
        this.poundagePayMoney = poundagePayMoney;
    }
}