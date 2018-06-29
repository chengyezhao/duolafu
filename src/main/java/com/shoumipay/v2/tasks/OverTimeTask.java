package com.shoumipay.v2.tasks;

import com.shoumipay.domain.Config;
import com.shoumipay.service.admin.ConfigService;
import com.shoumipay.service.admin.GoodsOrderService;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.domain.enums.DaifuCodeStatus;
import com.shoumipay.v2.domain.enums.RepaymentStatus;
import com.shoumipay.v2.service.BillService;
import com.shoumipay.v2.service.DaifuCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;
import java.util.Date;

/**
 * 过期的未支付订单
 * Created by Tang on 2017/10/26.
 */
@Configuration
@EnableScheduling
public class OverTimeTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private ConfigService configService;
    @Autowired
    private DaifuCodeService daifuCodeService;
    @Autowired
    private BillService billService;

    //每小时执行
    @Scheduled(cron= "0 0 */1 * * ?")
    private void task(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Config overTime = configService.selectByKey("OVERTIME", "120");
        calendar.add(Calendar.MINUTE, -1 * Integer.valueOf(overTime.getValue()));


        //关闭超时的Repayment
        for (Repayment repayment : billService.getAllPendingRepayment()) {
            if(repayment.getStatus().equals(RepaymentStatus.pending)){
                logger.info("还款超时关闭:" + repayment.getRepaymentId());
                Date createdDate = repayment.getCreatedDate();
                Long currentTs = System.currentTimeMillis();
                Long minPassed = (currentTs - createdDate.getTime()) / 1000 / 60;
                //如果付款超过2小时没付款，则关闭
                if(minPassed > Integer.valueOf(overTime.getValue())){
                    billService.finishRepayment(repayment.getRepaymentId(), RepaymentStatus.close);
                }
            }
        }

    }

}
