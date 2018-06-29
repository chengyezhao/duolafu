package com.shoumipay.service.admin;

import com.shoumipay.domain.DataMAC;
import com.shoumipay.domain.FinancialMAC;
import com.shoumipay.domain.Netraffic;

import java.util.Date;
import java.util.List;

/**
 * Created by Zhw on 2017/11/20.
 */
public interface FinanceService {
    List<DataMAC> queryDataMAC(DataMAC dataMAC,Integer page, Integer rows, Date startTime, Date endTime);
    List<Netraffic> queryNetraffic(Netraffic netraffic,Integer page, Integer rows, Date startTime, Date endTime);
    List<FinancialMAC> queryFinancialMAC(FinancialMAC financialMAC,Integer page, Integer rows, Date startTime, Date endTime);

    /**
     * 根据时间查询流量监控数据
     * */
    Netraffic queryNetByTime(String startTime,String endTime);
    int addNetraffic(Netraffic netraffic);
    /**
     *  财务监控
     */
    FinancialMAC queryFinanceByTime(String startTime,String endTime);
    int addFinancialMAC(FinancialMAC financialMAC);
    /**
     * 数据调用
     * */
    DataMAC queryDataMACByTime(String startTime,String endTime);
    int addDataMAC(DataMAC dataMAC);
}
