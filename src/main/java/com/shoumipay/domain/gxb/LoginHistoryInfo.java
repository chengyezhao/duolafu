package com.shoumipay.domain.gxb;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaojun on 2017/9/27.
 */
public class LoginHistoryInfo implements Serializable {
    private static final long serialVersionUID = -4593326601330031364L;
    private Date loginTime;
    private String location;
    private String ip;
    private String loginType;

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
