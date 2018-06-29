package com.shoumipay.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MemberLinkman {
    private Long id;

    private Long memberid;

    private String linkmanName;

    private Integer linkmanRelation;

    private String linkmanPhone;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date linkmanAddtime;

    private String linkmanAddChannel;

    private String linkmanNameTwo;

    private Integer linkmanRelationTwo;

    private String linkmanPhoneTwo;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date linkmanAddtimeTwo;

    private String linkmanAddChannelTwo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName == null ? null : linkmanName.trim();
    }

    public Integer getLinkmanRelation() {
        return linkmanRelation;
    }

    public void setLinkmanRelation(Integer linkmanRelation) {
        this.linkmanRelation = linkmanRelation;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone == null ? null : linkmanPhone.trim();
    }

    public Date getLinkmanAddtime() {
        return linkmanAddtime;
    }

    public void setLinkmanAddtime(Date linkmanAddtime) {
        this.linkmanAddtime = linkmanAddtime;
    }

    public String getLinkmanAddChannel() {
        return linkmanAddChannel;
    }

    public void setLinkmanAddChannel(String linkmanAddChannel) {
        this.linkmanAddChannel = linkmanAddChannel == null ? null : linkmanAddChannel.trim();
    }

    public String getLinkmanNameTwo() {
        return linkmanNameTwo;
    }

    public void setLinkmanNameTwo(String linkmanNameTwo) {
        this.linkmanNameTwo = linkmanNameTwo == null ? null : linkmanNameTwo.trim();
    }

    public Integer getLinkmanRelationTwo() {
        return linkmanRelationTwo;
    }

    public void setLinkmanRelationTwo(Integer linkmanRelationTwo) {
        this.linkmanRelationTwo = linkmanRelationTwo;
    }

    public String getLinkmanPhoneTwo() {
        return linkmanPhoneTwo;
    }

    public void setLinkmanPhoneTwo(String linkmanPhoneTwo) {
        this.linkmanPhoneTwo = linkmanPhoneTwo == null ? null : linkmanPhoneTwo.trim();
    }

    public Date getLinkmanAddtimeTwo() {
        return linkmanAddtimeTwo;
    }

    public void setLinkmanAddtimeTwo(Date linkmanAddtimeTwo) {
        this.linkmanAddtimeTwo = linkmanAddtimeTwo;
    }

    public String getLinkmanAddChannelTwo() {
        return linkmanAddChannelTwo;
    }

    public void setLinkmanAddChannelTwo(String linkmanAddChannelTwo) {
        this.linkmanAddChannelTwo = linkmanAddChannelTwo == null ? null : linkmanAddChannelTwo.trim();
    }
}