package com.shoumipay.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.shoumipay.domain.Banner;

import java.util.Date;

/**
 * Created by Tang on 2017/10/31.
 */
public class BannerVO {
    private Long id;

    private String title;

    private String url;

    private String link;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Long processor;

    private String processorName;

    private Integer order;

    private Byte active;

    public BannerVO(){}

    public BannerVO(Banner banner) {
        this.id = banner.getId();
        this.title = banner.getTitle();
        this.url = banner.getUrl();
        this.link = banner.getLink();
        this.updateTime = banner.getUpdateTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getProcessor() {
        return processor;
    }

    public void setProcessor(Long processor) {
        this.processor = processor;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }
}
