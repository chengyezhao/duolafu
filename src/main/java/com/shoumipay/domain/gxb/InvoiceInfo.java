package com.shoumipay.domain.gxb;

import java.io.Serializable;

/**
 * Created by yaojun on 2017/9/27.
 */
public class InvoiceInfo implements Serializable {
    private static final long serialVersionUID = 4747234811901244722L;
    private String tradeNo;
    private String InvoiceType;
    private String InvoiceContent;
    private String invoiceHeader;
    private String name;
    private String phone;
    private String area;
    private String address;
    private Integer status;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getInvoiceType() {
        return InvoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        InvoiceType = invoiceType;
    }

    public String getInvoiceContent() {
        return InvoiceContent;
    }

    public void setInvoiceContent(String invoiceContent) {
        InvoiceContent = invoiceContent;
    }

    public String getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(String invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
