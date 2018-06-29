package com.shoumipay.vo;

import com.shoumipay.domain.Notice;

import java.util.Date;

public class MessageVO {
    private Long id;

    private String type;

    private String acceptor;

    private Boolean read;

    private String title;

    private String content;

    private String more;

    private Date createTime;

    private String processor;

    private Date updateTime;

    private Byte active;
    public MessageVO(){}

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

    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
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

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public MessageVO(Notice notice){
        this.id = notice.getId();
        this.type = notice.getType();
        this.read = notice.getRead();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.updateTime = notice.getUpdateTime();
        this.more = notice.getMore();
        this.active = notice.getActive();
        this.createTime = notice.getCreateTime();
    }

}
