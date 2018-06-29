package com.shoumipay;

import com.shoumipay.domain.Member;
import com.shoumipay.v2.NumberUtils;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.domain.enums.BillStatus;
import com.shoumipay.v2.domain.enums.RepaymentStatus;
import com.shoumipay.v2.mapper.BillCollectionMapper;
import com.shoumipay.v2.mapper.DaifuOrderLegMapper;
import com.shoumipay.v2.mapper.DaifuOrderMapper;
import com.shoumipay.v2.mapper.RepaymentMapper;
import com.shoumipay.v2.service.BillService;
import com.shoumipay.v2.service.DaifuCodeService;
import com.shoumipay.v2.service.DaifuOrderService;
import com.shoumipay.v2.service.MemberService;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("chengye")
public class TestOrderService {

    @Autowired
    private DaifuOrderService orderService;
    @Autowired
    private BillService billService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private DaifuCodeService codeService;
    @Autowired
    private DaifuOrderMapper orderMapper;
    @Autowired
    private DaifuOrderLegMapper orderLegMapper;
    @Autowired
    private RepaymentMapper repaymentMapper;
    @Autowired
    private BillCollectionMapper billCollectionMapper;


    @Before
    public void prepareData(){
        Member member = memberService.getMemberByUid(242L);
        DaifuCode code = new DaifuCode();
        code.setCodeId(1L);
        code.setDaifuId("1");
        code.setPrice(new BigDecimal(100.0));
        code.setItems("测试商品");
        orderService.createDaifuOrder(member, code, new BigDecimal(7.0), 3, new BigDecimal(7.0),
                true, true, new Date());
    }

    @After
    public void clearData(){
        DaifuOrder order =  orderService.selectOrderByCodeId(1L);
        orderMapper.deleteByPrimaryKey(order.getOrderId());
        for (DaifuOrderLeg leg : orderService.queryAllOrderLegsInOrder(order.getOrderId(), false, false)) {
            if(leg.getBillId() != null) {
                billCollectionMapper.deleteByPrimaryKey(leg.getBillId());
            }
        }
        for (DaifuOrderLeg leg : orderService.queryAllOrderLegsInOrder(order.getOrderId(), false, false)) {
            for(Repayment r: billService.getRepaymentInOrderLeg(leg.getOrderlegId(), false)) {
                repaymentMapper.deleteByPrimaryKey(r.getRepaymentId());
            }
            orderLegMapper.deleteByPrimaryKey(leg.getOrderlegId());
        }

    }

    @Test
    public void testCalculateCommission(){
        assertTrue(NumberUtils.bigDecimalCompare(orderService.calculateCommission(1, new BigDecimal(100), new BigDecimal(0))
               , new BigDecimal(5.0)) == 0);
    }

    @Test
    public void testCalculateMonthlyFee(){
        assertTrue(NumberUtils.bigDecimalCompare(orderService.calculateMonthlyFee(1, new BigDecimal(100), new BigDecimal(0.0))
            ,new BigDecimal(1.0)) == 0);
    }

    @Test
    public void testQuery(){
        assertTrue(orderService.selectOrderByCodeId(1L) != null);
        assertTrue(orderService.queryAllOrderLegsOfMember(242L, false,
                false).size() == 3);
        assertTrue(orderService.queryOrderByUser(242L, false,
                false).size() == 1);
    }

    @Test
    public void testCheck(){
        DaifuOrder order =  orderService.selectOrderByCodeId(1L);
        orderService.checkAndCloseOrder(order.getOrderId(), false, "test", "test purpose");
        assertTrue(billService.calculateReFundAmount(order.getOrderId()).equals(BigDecimal.ZERO));
        billService.createRepaymentsForRefund(order.getOrderId(), "1111", "test");
    }

    @Test
    public void testCurrentBill(){
        DaifuOrder order =  orderService.selectOrderByCodeId(1L);
        assertNotNull(billService.getCurrentBillCollection(242L, new Date()) == null);
        assertNotNull(billService.getBillCollections(242L, BillStatus.waiting).size() == 3);
    }

    @Test
    public void testCalcOverDueOrderLeg(){
        DaifuOrder order =  orderService.selectOrderByCodeId(1L);
        List<DaifuOrderLeg> legs = orderService.queryAllOrderLegsInOrder(order.getOrderId(), false, false);
        billService.calcOverDueOrderLeg(legs.get(0), DateUtils.addDays(new Date(), 40));
    }

    @Test
    public void testCheckAndClose(){
        //添加还款
        Member member = memberService.getMemberByUid(242L);
        DaifuOrder order =  orderService.selectOrderByCodeId(1L);
        List<DaifuOrderLeg> legs = orderService.queryAllOrderLegsInOrder(order.getOrderId(), false, false);
        for(DaifuOrderLeg leg : legs){
            billService.createRepaymentForOrderLeg(leg.getOrderlegId(),"test", member);
            assertTrue(billService.getRepaymentByTransId("test").size() > 0);
            billService.getRepaymentInOrderLeg(leg.getOrderlegId(), false).forEach(r ->{
                billService.finishRepayment(r.getRepaymentId(), RepaymentStatus.paid);
            });
            assertTrue(billService.getRepaymentInBill(leg.getBillId(), false).size() > 0);
        }
        orderService.checkAndCloseOrder(order.getOrderId(), false, "test", "test");
    }
}
