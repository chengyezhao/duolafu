package com.shoumipay.domain;

public class NoticeMember {
    private Long id;

    private Long noticeId;

    private Long memberId;

    private Boolean read;


    public NoticeMember() {}

    public NoticeMember(Long noticeId, Long memberId, Boolean read) {
        this.noticeId = noticeId;
        this.memberId = memberId;
        this.read = read;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}