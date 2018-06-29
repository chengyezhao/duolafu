package com.shoumipay.domain;

public class SmsConfig {
    private Integer id;

    private String account;

    private String password;

    private String remainpoint;

    private String successcounts;

    private String type;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRemainpoint() {
        return remainpoint;
    }

    public void setRemainpoint(String remainpoint) {
        this.remainpoint = remainpoint == null ? null : remainpoint.trim();
    }

    public String getSuccesscounts() {
        return successcounts;
    }

    public void setSuccesscounts(String successcounts) {
        this.successcounts = successcounts == null ? null : successcounts.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}