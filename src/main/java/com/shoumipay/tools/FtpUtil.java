package com.shoumipay.tools;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jcraft.jsch.*;
import com.shoumipay.domain.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;


public class FtpUtil {
    /*
    * 从SFTP服务器下载文件
    *
    * @param ftpHost SFTP IP地址
    *
    * @param ftpUserName SFTP 用户名
    *
    * @param ftpPassword SFTP用户名密码
    *
    * @param ftpPort SFTP端口
    *
    * @param ftpPath SFTP服务器中文件所在路径 格式： ftptest/aa
    *
    * @param localPath 下载到本地的位置 格式：H:/download
    *
    * @param fileName 文件名称
    */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final int REPAY_DAY_NAME = 0; //支付类日明细账单 (还款账单)
    public static final int REPAY_MONTH_NAME = 1; //支付类月明细账单 (还款账单)
    public static final int PAY_DAY_NAME = 2; //付款类日明细账单 (放款账单)
    public static final int PAY_MONTH_NAME = 3; //付款类日明细账单 (放款账单)


    public static String[] downloadSftpFile(String ftpHost, String ftpUserName,
                                            String ftpPassword, int ftpPort, String ftpPath,
                                            String fileName, String localPath) throws JSchException {
        Session session = null;
        Channel channel = null;

        JSch jsch = new JSch();
        session = jsch.getSession(ftpUserName, ftpHost, ftpPort);
        session.setPassword(ftpPassword);
        session.setTimeout(100000);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp chSftp = (ChannelSftp) channel;
        String ftpFilePath = ftpPath + "/" + fileName;
        String localFilePath = localPath + "/" + fileName;
        File dest = new File(localFilePath);
        if (!dest.getParentFile().exists()) dest.getParentFile().mkdirs();
        String data = null;
        //JSONArray jsonArray = null;
        try {
            chSftp.get(ftpFilePath, localPath);
            File file = new File(localFilePath);
            if (!file.exists()) {
                return null;
            }
            String[] str = CsvUtil.readcsv(localFilePath);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            chSftp.quit();
            channel.disconnect();
            session.disconnect();
        }
    }

    public static String getFileName(String Oid_partner, int flag) {
        String fileName = null;
        Date oldDay = DateUtil.addTime(new Date(), -1);
        switch (flag) {
            case REPAY_DAY_NAME:
                fileName = "JYMX" + "_" + Oid_partner + "_" + DateUtil.format(oldDay, DateUtil.DEFAULT_DAY_DATE) + ".csv";
                return fileName;
            case REPAY_MONTH_NAME:
                fileName = "JYMX" + "_" + Oid_partner + "_" + DateUtil.format(oldDay, DateUtil.DEFAULT_MONTH_DATE) + ".csv";
                return fileName;
            case PAY_DAY_NAME:
                fileName = "FKMX" + "_" + Oid_partner + "_" + DateUtil.format(oldDay, DateUtil.DEFAULT_DAY_DATE) + ".csv";
                return fileName;
            case PAY_MONTH_NAME:
                fileName = "FKMX" + "_" + Oid_partner + "_" + DateUtil.format(oldDay, DateUtil.DEFAULT_MONTH_DATE) + ".csv";
                return fileName;
        }
        return null;
    }

    public static BankAccount getData(JSONArray jsonArray, int time) {
        JSONObject jo0 = jsonArray.getJSONObject(0);
        JSONObject jo1 = jsonArray.getJSONObject(1);
        JSONObject jo2 = jsonArray.getJSONObject(2);
        JSONObject jo3 = jsonArray.getJSONObject(3);
        JSONObject jo4 = jsonArray.getJSONObject(4);
        JSONObject jo5 = jsonArray.getJSONObject(5);
        JSONObject jo6 = jsonArray.getJSONObject(6);
        JSONObject jo7 = jsonArray.getJSONObject(7);
        JSONObject jo8 = jsonArray.getJSONObject(8);
        JSONObject jo9 = jsonArray.getJSONObject(9);
        JSONObject jo10 = jsonArray.getJSONObject(10);
        JSONObject jo11 = jsonArray.getJSONObject(11);
        JSONObject jo12 = jsonArray.getJSONObject(12);
        JSONObject jo13 = jsonArray.getJSONObject(13);
        JSONObject jo14 = jsonArray.getJSONObject(14);
        JSONObject jo15 = jsonArray.getJSONObject(15);
        JSONObject jo16 = jsonArray.getJSONObject(16);
        String merchantOrderNumberData = getStr(jo0, "Merchant Order Number", time);
        String merchantIdData = getStr(jo1, "Merchant  ID", time);
        Date timeOfOrderCreatedData = DateUtil.parse(getStr(jo2, "Time of Order Created", time), DateUtil.DEFAULT_DATE_TIME3);
        String merchantBusinessTypeData = getStr(jo3, "Merchant Business Type", time);
        String lianlianPaymentNumberData = getStr(jo4, "Lianlian BillPayment Number", time);
        Date lianlianSettlementDateData = DateUtil.parse(getStr(jo5, "Lianlian Settlement Date", time), DateUtil.DEFAULT_DAY_DATE);
        BigDecimal transactionAmountData = BigDecimal.valueOf(Double.parseDouble(getStr(jo6, "Transaction Amount", time)));
        int typeFlagData = Integer.parseInt(getStr(jo7, "Type Flag", time));
        int transactionStatusData = Integer.parseInt(getStr(jo8, "Transaction Status", time));
        Date updateDateData = DateUtil.parse(getStr(jo9, "Update Date", time), DateUtil.DEFAULT_DATE_TIME3);
        BigDecimal serviceFeeData = BigDecimal.valueOf(Double.parseDouble(getStr(jo10, "Service Fee", time)));
        String paymentProductData = getStr(jo11, "BillPayment Product", time);
        String paymentMethodData = getStr(jo12, "BillPayment Method", time);
        String orderInfoData = getStr(jo13, "Order Info", time);
        String beneficiaryBankData = getStr(jo14, "Beneficiary Bank", time);
        String bankAccountNumberData = getStr(jo15, "Bank Account Number", time);
        String beneficiaryData = getStr(jo16, "Beneficiary", time);
        BankAccount bankAccount = new BankAccount(new Date(), merchantOrderNumberData, merchantIdData, timeOfOrderCreatedData,
                merchantBusinessTypeData, lianlianPaymentNumberData, lianlianSettlementDateData, transactionAmountData,
                typeFlagData, transactionStatusData, updateDateData, serviceFeeData, paymentProductData, paymentMethodData,
                orderInfoData, beneficiaryBankData, bankAccountNumberData, beneficiaryData);
        return bankAccount;
    }

    private static String getStr(JSONObject jo, String key, int index) {
        String value = jo.getString(key);
        String[] str = value.split(",");
        String data = str[index];
        return data;
    }

    public static void main(String[] args) {


    }
}
