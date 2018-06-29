package com.shoumipay.v2.tasks;

import com.shoumipay.domain.*;
import com.shoumipay.service.admin.GoodsMakeLoansService;
import com.shoumipay.service.admin.GoodsOrderService;
import com.shoumipay.service.admin.GoodsRepaymentPlanService;
import com.shoumipay.service.admin.GoodsRepaymentService;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.shoumipay.tools.TimeUtil.SIMPLE_DATE;

/**
 * ovedue order leg
 * Created by Tang on 2017/10/26.
 */
@Configuration
@EnableScheduling
public class OverdueTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

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

    public void run(){
        task();
    }

    @Scheduled(cron = "0 10 2 * * ?")//每天2点10执行
    private void task() {
        for(Member member : memberService.getAllMember()) {
            List<BillCollection> bills = billService.getBillCollections(member.getUid(), BillStatus.published);
            for(BillCollection bill: bills) {
                if(bill.getDueDate().compareTo(new Date()) < 0) {
                    BigDecimal total = billService.getTotalAmountPlusInterestInBill(bill.getBillId());
                    BigDecimal paid = billService.getPaidAmountPlusInterestInBill(bill.getBillId());
                    if (paid.compareTo(total) < 0) {
                        //overdue day count
                        long dayPassed = (new Date().getTime() - bill.getDueDate().getTime()) / (24L * 3600 * 1000);
                        //get all legs in bill
                        for (DaifuOrderLeg leg : orderService.queryAllOrderLegsInBill(bill.getBillId(),
                                false, false)) {
                            //check is leg is paid or closed
                            OrderLegStatus status = orderService.checkAndCloseOrderLeg(leg.getOrderlegId(), false);
                            if (status.equals(OrderLegStatus.open)) {
                                //if leg is overdue
                                logger.info("find order leg " + leg.getOrderlegId() + " is overdue");
                                leg.setOverdueStatus("yes");
                                //calculate interest
                                BigDecimal interest = leg.getAmount().multiply(new BigDecimal(dayPassed))
                                        .multiply(new BigDecimal(0.002)).setScale(2, RoundingMode.HALF_DOWN);
                                leg.setInterest(interest);
                                legMapper.updateByPrimaryKey(leg);
                                //update order
                                DaifuOrder order = orderService.selectOne(leg.getOrderId());
                                if (order != null) {
                                    order.setOverdueStatus("yes");
                                    orderMapper.updateByPrimaryKeySelective(order);
                                }
                                //update bill
                                bill.setOverdueStatus("yes");
                                billCollectionMapper.updateByPrimaryKey(bill);
                            }
                        }
                    }
                }
            }
        }
    }


}
