package com.shoumipay;

import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.tools.DateUtil;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.service.BillService;
import com.shoumipay.v2.service.DaifuCodeService;
import com.shoumipay.v2.service.DaifuOrderService;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.v2.tasks.OverdueTask;
import com.shoumipay.v2.tasks.RepayTipTask;
import com.shoumipay.v2.tasks.StatementDateTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("prod")
public class TestCalculateBill {

    @Autowired
    private MongoRepository repository;

    @Autowired
    private MemberService memberService;
    @Autowired
    private BillService billService;
    @Autowired
    private DaifuOrderService orderService;
    @Autowired
    private DaifuCodeService codeService;

    @Autowired
    private OverdueTask task;
    @Autowired
    private StatementDateTask statementDateTask;
    @Autowired
    private RepayTipTask repayTipTask;

    @Test
    public void insertRiskDocument(){
//        Member member = memberService.queryByUid(503L);
//        DaifuCode code = codeService.selectById(95);
//        orderService.createDaifuOrder(member, code,
//                new BigDecimal(40), 1, new BigDecimal(0),
//                true, true, DateUtil.parse("20180308", DateUtil.DEFAULT_DAY_DATE));
//        task.run();
//            statementDateTask.run();
//        repayTipTask.run();
    }

}
