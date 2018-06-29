package com.shoumipay.v2.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CodeVo {

    //链接或者口令
    private String shareUrl;

    private Long memerId;

    //状态：init 待解析, parsed 解析完成, paying: 等待付款, payed 付款完成, closed 关闭
    private String status = "closed";

    //生成的代付记录的id
    private String daifuId;

    //订单标题
    private String items;

    //价格
    private BigDecimal price;

    private Date createdDate;

    private String error;

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CodeVo() {
    }

    public CodeVo(String status, String error) {
        this.status = status;
        this.error = error;
    }

    public String  getDaifuId() {
        return daifuId;
    }

    public void setDaifuId(String daifuId) {
        this.daifuId = daifuId;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Long getMemerId() {
        return memerId;
    }

    public void setMemerId(Long memerId) {
        this.memerId = memerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
