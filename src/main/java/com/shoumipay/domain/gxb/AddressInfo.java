package com.shoumipay.domain.gxb;

import java.io.Serializable;

/**
 * Created by yaojun on 2017/9/27.
 */
public class AddressInfo implements Serializable {
    private static final long serialVersionUID = -6964833205940634653L;
    private String receiveName;
    private String region;
    private String address;
    private String mobilePhone;
    private String telPhone;
    private String email;

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
