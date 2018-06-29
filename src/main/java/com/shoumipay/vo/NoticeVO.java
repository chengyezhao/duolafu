package com.shoumipay.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.shoumipay.domain.Notice;

import java.util.Date;

/**
 * Created by Tang on 2017/10/31.
 */
public class NoticeVO {
    private Long id;

    private String type;

    private Boolean read;

    private String title;

    private String content;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public NoticeVO() {}

    public NoticeVO(Notice notice) {
        this.id = notice.getId();
        this.type = notice.getType();
        this.read = notice.getRead();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.updateTime = notice.getUpdateTime();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
