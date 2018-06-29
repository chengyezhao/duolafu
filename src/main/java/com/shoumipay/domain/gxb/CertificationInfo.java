package com.shoumipay.domain.gxb;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaojun on 2017/9/27.
 */
public class CertificationInfo implements Serializable {
    private static final long serialVersionUID = -1373496515403503978L;
    private String name;
    private String idCard;
    private Date certifyDate;
    private String bindingPhone;
    private String certifyChannel;
    private String financialService;
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getCertifyDate() {
        return certifyDate;
    }

    public void setCertifyDate(Date certifyDate) {
        this.certifyDate = certifyDate;
    }

    public String getBindingPhone() {
        return bindingPhone;
    }

    public void setBindingPhone(String bindingPhone) {
        this.bindingPhone = bindingPhone;
    }

    public String getCertifyChannel() {
        return certifyChannel;
    }

    public void setCertifyChannel(String certifyChannel) {
        this.certifyChannel = certifyChannel;
    }

    public String getFinancialService() {
        return financialService;
    }

    public void setFinancialService(String financialService) {
        this.financialService = financialService;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
