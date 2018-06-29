package com.shoumipay.domain;

import java.io.Serializable;

/**
 * Created by Tang on 2017/10/25.
 */
public class VersionInfo implements Serializable{
    private int code;
    private String version;
    private String url;
    private String desc;

    public VersionInfo(){}

    public VersionInfo(int code, String version, String url, String desc) {
        this.code = code;
        this.version = version;
        this.url = url;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
