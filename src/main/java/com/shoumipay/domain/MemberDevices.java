package com.shoumipay.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MemberDevices {
    private Long id;

    private Long memberid;

    private String devicesPhone;

    private String devicesIfa;

    private String devicesMac;

    private String devicesWifi;

    private String devicesIp;

    private String devicesSystemType;

    private String devicesSystemVersion;

    private String devicesAppVersion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date devicesAddtime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date devicesUpptime;

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

    public String getDevicesPhone() {
        return devicesPhone;
    }

    public void setDevicesPhone(String devicesPhone) {
        this.devicesPhone = devicesPhone == null ? null : devicesPhone.trim();
    }

    public String getDevicesIfa() {
        return devicesIfa;
    }

    public void setDevicesIfa(String devicesIfa) {
        this.devicesIfa = devicesIfa == null ? null : devicesIfa.trim();
    }

    public String getDevicesMac() {
        return devicesMac;
    }

    public void setDevicesMac(String devicesMac) {
        this.devicesMac = devicesMac == null ? null : devicesMac.trim();
    }

    public String getDevicesWifi() {
        return devicesWifi;
    }

    public void setDevicesWifi(String devicesWifi) {
        this.devicesWifi = devicesWifi == null ? null : devicesWifi.trim();
    }

    public String getDevicesIp() {
        return devicesIp;
    }

    public void setDevicesIp(String devicesIp) {
        this.devicesIp = devicesIp == null ? null : devicesIp.trim();
    }

    public String getDevicesSystemType() {
        return devicesSystemType;
    }

    public void setDevicesSystemType(String devicesSystemType) {
        this.devicesSystemType = devicesSystemType == null ? null : devicesSystemType.trim();
    }

    public String getDevicesSystemVersion() {
        return devicesSystemVersion;
    }

    public void setDevicesSystemVersion(String devicesSystemVersion) {
        this.devicesSystemVersion = devicesSystemVersion == null ? null : devicesSystemVersion.trim();
    }

    public String getDevicesAppVersion() {
        return devicesAppVersion;
    }

    public void setDevicesAppVersion(String devicesAppVersion) {
        this.devicesAppVersion = devicesAppVersion == null ? null : devicesAppVersion.trim();
    }

    public Date getDevicesAddtime() {
        return devicesAddtime;
    }

    public void setDevicesAddtime(Date devicesAddtime) {
        this.devicesAddtime = devicesAddtime;
    }

    public Date getDevicesUpptime() {
        return devicesUpptime;
    }

    public void setDevicesUpptime(Date devicesUpptime) {
        this.devicesUpptime = devicesUpptime;
    }
}