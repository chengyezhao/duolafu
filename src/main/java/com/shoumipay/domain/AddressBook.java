package com.shoumipay.domain;

import java.util.Date;

public class AddressBook {
    private Long id;

    private Long memberid;

    private String name;

    private String number;

    private Date upptime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getUpptime() {
        return upptime;
    }

    public void setUpptime(Date upptime) {
        this.upptime = upptime;
    }
}