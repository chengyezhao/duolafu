package com.shoumipay.domain;

import java.util.Date;

public class SmsMessage {
    private Long sid;

    private Long memberid;

    private String phones;

    private String content;

    private Date sendtime;

    private Date createtime;

    private Integer flag;

    private Integer failuretimes;

    private Integer maxfail;

    private Integer number;

    private Integer messagetype;

    private String sendtransmission;

    private String sendplatform;

    private String code;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones == null ? null : phones.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getFailuretimes() {
        return failuretimes;
    }

    public void setFailuretimes(Integer failuretimes) {
        this.failuretimes = failuretimes;
    }

    public Integer getMaxfail() {
        return maxfail;
    }

    public void setMaxfail(Integer maxfail) {
        this.maxfail = maxfail;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(Integer messagetype) {
        this.messagetype = messagetype;
    }

    public String getSendtransmission() {
        return sendtransmission;
    }

    public void setSendtransmission(String sendtransmission) {
        this.sendtransmission = sendtransmission == null ? null : sendtransmission.trim();
    }

    public String getSendplatform() {
        return sendplatform;
    }

    public void setSendplatform(String sendplatform) {
        this.sendplatform = sendplatform == null ? null : sendplatform.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}