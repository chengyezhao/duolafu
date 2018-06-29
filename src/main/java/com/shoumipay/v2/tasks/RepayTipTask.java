package com.shoumipay.v2.tasks;

import com.shoumipay.domain.GoodsRepaymentPlan;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.service.SmsSendService;
import com.shoumipay.service.SmsTemplateService;
import com.shoumipay.service.admin.*;
import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.enums.BillStatus;
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
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static com.shoumipay.tools.TimeUtil.SIMPLE_DATE;

/**
 * Created by Tang on 2017/10/26.
 */
@Configuration
@EnableScheduling
public class RepayTipTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BillService billService;
    @Autowired
    private DaifuOrderService orderService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberDetailService memberDetailService;
    @Autowired
    private DaifuOrderMapper orderMapper;
    @Autowired
    private DaifuOrderLegMapper legMapper;
    @Autowired
    private BillCollectionMapper billCollectionMapper;
    @Autowired
    private SmsSendService smsSendService;
    @Autowired
    private SmsTemplateService templateService;

    public void run(){
        task();
    }

    @Scheduled(cron = "0 30 8 * * *")
    private void task() {
        for (Member member : memberService.getAllMember()) {
            List<BillCollection> bills = billService.getBillCollections(member.getUid(), BillStatus.published);
            for(BillCollection bill: bills) {
                if (bill.getDueDate().compareTo(new Date()) < 0) {
                    BigDecimal total = billService.getTotalAmountPlusInterestInBill(bill.getBillId());
                    BigDecimal paid = billService.getPaidAmountPlusInterestInBill(bill.getBillId());
                    if (paid.compareTo(total) < 0) {
                        BigDecimal needPay = total.subtract(paid).setScale(2, RoundingMode.HALF_DOWN);
                        logger.info("发当天提醒短信 --> " );
                        MemberDetail memberDetail = memberDetailService.selectByMemberId(member.getUid());
                        smsSendService.sendyxt(member.getPhoneNumber(),
                                        memberDetail.getFullname() + "，您的爱代付" + bill.getBillNumber() +
                                        "账单已逾期，截至今天累计应还" + needPay + "元，请尽快还至您的账户中。如还请忽略。"
                                , "253-通知");
                    }
                }
            }
        }
    }
}
