package com.shoumipay.task;

import com.shoumipay.domain.DataMAC;
import com.shoumipay.domain.FinancialMAC;
import com.shoumipay.domain.Netraffic;
import com.shoumipay.service.admin.FinanceService;
import com.shoumipay.tools.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * Created by Zhw on 2017/11/23.
 */
@Configuration
//@EnableScheduling
public class FinanceTask {
    @Autowired
    private FinanceService financeService;
    @Scheduled(cron= "0 0 1 * * ?")//每天1点执行
    public void financeTask(){
        String startTime=DateUtil.format(DateUtil.getStartTime(DateUtil.addTime(new Date(),-1)),DateUtil.DEFAULT_DATE_TIME2);
        String endTime=DateUtil.format(DateUtil.getEndTime(DateUtil.addTime(new Date(),-1)),DateUtil.DEFAULT_DATE_TIME2);
        Netraffic netraffic=financeService.queryNetByTime(startTime,endTime);
        Netraffic netraffic1=new Netraffic(netraffic);
        financeService.addNetraffic(netraffic1);
        FinancialMAC financialMAC=financeService.queryFinanceByTime(startTime,endTime);
        FinancialMAC financialMAC1=new FinancialMAC(financialMAC);
        financeService.addFinancialMAC(financialMAC1);
        DataMAC dataMAC=financeService.queryDataMACByTime(startTime,endTime);
        DataMAC dataMAC1=new DataMAC(dataMAC);
        financeService.addDataMAC(dataMAC1);
    }
}
