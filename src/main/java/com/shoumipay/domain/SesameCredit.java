package com.shoumipay.domain;

import java.util.Date;

public class SesameCredit {
    private Long id;

    private Long uid;

    private String orderId;

    private String authorizeId;

    private Double sesameScore;

    private Date createTime;

    private Date updateTime;

    private String channel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getAuthorizeId() {
        return authorizeId;
    }

    public void setAuthorizeId(String authorizeId) {
        this.authorizeId = authorizeId == null ? null : authorizeId.trim();
    }

    public Double getSesameScore() {
        return sesameScore;
    }

    public void setSesameScore(Double sesameScore) {
        this.sesameScore = sesameScore == null ? 0 : sesameScore;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    @Override
    public String toString() {
        return "SesameCredit{" +
                "id=" + id +
                ", uid=" + uid +
                ", orderId='" + orderId + '\'' +
                ", authorizeId='" + authorizeId + '\'' +
                ", sesameScore=" + sesameScore +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", channel='" + channel + '\'' +
                '}';
    }
}