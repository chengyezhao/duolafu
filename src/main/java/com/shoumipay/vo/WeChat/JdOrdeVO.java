package com.shoumipay.vo.WeChat;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

/**
 * Created by Zhw on 2018/1/20.
 */
public class JdOrdeVO {
    private Long goodsId;
    private Long memberId;
    private Long daifuId;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private String orderCreateTime;
    private String orderNumber;
    private BigDecimal price;
    private Integer count;
    private String wareName;
    private String imageUrl;
    private Integer orderStatus;
    private String statusMsg;

    private String shareUrl;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getDaifuId() {
        return daifuId;
    }

    public void setDaifuId(Long daifuId) {
        this.daifuId = daifuId;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        if(shareUrl!=null&&shareUrl.contains("吱口令")){
            this.shareUrl="1";//todo 显示用
        }else{
            this.shareUrl=shareUrl;
        }
    }
}
