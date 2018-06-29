package com.shoumipay.v2.tasks;

import com.shoumipay.constants.GoodsOrderConstants;
import com.shoumipay.controller.wechat.base.BaseController;
import com.shoumipay.domain.GoodsMakeLoans;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.service.admin.*;
import com.shoumipay.service.wechat.WeChatService;
import com.shoumipay.tools.DateUtil;
import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.domain.enums.BillStatus;
import com.shoumipay.v2.domain.enums.OrderLegStatus;
import com.shoumipay.v2.mapper.BillCollectionMapper;
import com.shoumipay.v2.mapper.DaifuOrderLegMapper;
import com.shoumipay.v2.mapper.DaifuOrderMapper;
import com.shoumipay.v2.service.BillService;
import com.shoumipay.v2.service.DaifuOrderService;
import com.shoumipay.v2.service.MemberService;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhw on 2018/1/24.
 */

@Configuration
@EnableScheduling
public class StatementDateTask extends BaseController{

    @Autowired
    private BillService billService;
    @Autowired
    private DaifuOrderService orderService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private DaifuOrderMapper orderMapper;
    @Autowired
    private DaifuOrderLegMapper legMapper;
    @Autowired
    private BillCollectionMapper billCollectionMapper;
    @Autowired
    private WeChatService weChatService;


    public void run(){
        task();
    }

    @Scheduled(cron = "0 0 2 * * ?")//每天2点执行
    public void task() {
        logger.info("账单生成--------->start");
        for(Member member : memberService.getAllMember()) {
            List<BillCollection> bills = billService.getBillCollections(member.getUid(), BillStatus.waiting);
            if(bills.size() > 0){
                BillCollection bill = bills.get(0);
                if(bill.getBillDate().compareTo(new Date()) <= 0) {
                    logger.info("bill " + bill.getBillId() + " change to published");
                    bill.setStatus(BillStatus.published.name());
                    billCollectionMapper.updateByPrimaryKey(bill);

                    String[] message = new String[2];
                    message[0] = DateUtil.format(DateUtil.addTimeMonth(new Date(), -1), DateUtil.DEFAULT_SHORT_DATE)
                            + DateUtil.format(DateUtil.getStartTime(), DateUtil.DEFAULT_SHORT_DATE);
                    message[1] = String.valueOf(billService.getTotalAmountPlusInterestInBill(bill.getBillId()).setScale(2, RoundingMode.HALF_DOWN)
                            .doubleValue());

                    weChatService.sendMessge(member.getWechatOpenid(),
                            "4XP-afn_75oTXS1o1JwpL4-KU7aRaLqZKc2Q3S3sOr0",
                            "",
                            "亲，代购费用本期账单：",
                            "请前往账单页还款",
                            message);
                }
            }
        }
        logger.info("账单生成--------->end");

    }


}
