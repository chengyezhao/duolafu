package com.shoumipay.domain.gxb;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yaojun on 2017/9/27.
 */
public class JDData implements Serializable {
    private static final long serialVersionUID = -2867534076354921012L;
    private AccountInfo accountInfo;
    private CertificationInfo certificationInfo;
    private List<BankCardInfo> bankCardList;
    private List<AddressInfo> addressList;
    private List<GradeHistoryInfo> gradeHistoryList;
    private List<LoginHistoryInfo> loginHistoryList;
    private List<InvoiceInfo> invoiceList;
    private List<BtBillInfo> btBillList;
    private List<BtRepayInfo> btRepayInfoList;
    private List<OrderInfo> orderList;

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public CertificationInfo getCertificationInfo() {
        return certificationInfo;
    }

    public void setCertificationInfo(CertificationInfo certificationInfo) {
        this.certificationInfo = certificationInfo;
    }

    public List<BankCardInfo> getBankCardList() {
        return bankCardList;
    }

    public void setBankCardList(List<BankCardInfo> bankCardList) {
        this.bankCardList = bankCardList;
    }

    public List<AddressInfo> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressInfo> addressList) {
        this.addressList = addressList;
    }

    public List<GradeHistoryInfo> getGradeHistoryList() {
        return gradeHistoryList;
    }

    public void setGradeHistoryList(List<GradeHistoryInfo> gradeHistoryList) {
        this.gradeHistoryList = gradeHistoryList;
    }

    public List<LoginHistoryInfo> getLoginHistoryList() {
        return loginHistoryList;
    }

    public void setLoginHistoryList(List<LoginHistoryInfo> loginHistoryList) {
        this.loginHistoryList = loginHistoryList;
    }

    public List<InvoiceInfo> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<InvoiceInfo> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<BtBillInfo> getBtBillList() {
        return btBillList;
    }

    public void setBtBillList(List<BtBillInfo> btBillList) {
        this.btBillList = btBillList;
    }

    public List<BtRepayInfo> getBtRepayInfoList() {
        return btRepayInfoList;
    }

    public void setBtRepayInfoList(List<BtRepayInfo> btRepayInfoList) {
        this.btRepayInfoList = btRepayInfoList;
    }

    public List<OrderInfo> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderInfo> orderList) {
        this.orderList = orderList;
    }
}
