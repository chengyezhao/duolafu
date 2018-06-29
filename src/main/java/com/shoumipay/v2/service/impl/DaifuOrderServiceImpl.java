package com.shoumipay.v2.service.impl;


import com.shoumipay.domain.*;
import com.shoumipay.service.admin.*;
import com.shoumipay.v2.NumberUtils;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.domain.enums.*;
import com.shoumipay.v2.mapper.DaifuOrderLegMapper;
import com.shoumipay.v2.mapper.DaifuOrderMapper;
import com.shoumipay.v2.mapper.RepaymentMapper;
import com.shoumipay.v2.service.*;
import com.shoumipay.service.wechat.JdDaiFuService;
import com.shoumipay.service.wechat.WeChatService;
import com.shoumipay.v2.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DaifuOrderServiceImpl implements DaifuOrderService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdDaiFuService jdDaiFuService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private WeChatService weChatService;
    @Autowired
    private MemberBankcardService memberBankcardService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private DaifuCodeService daifuCodeService;
    @Autowired
    private BillService repayService;
    @Autowired
    private BQSRiskService bqsService;
    @Autowired
    private ConfigService configService;
    @Autowired
    private DaifuOrderMapper orderMapper;
    @Autowired
    private DaifuOrderLegMapper legMapper;
    @Autowired
    private RepaymentMapper repaymentMapper;
    @Autowired
    private BillService billService;

    @Override
    public BigDecimal calculateCommission(int term, BigDecimal price, BigDecimal downPayment) {
        if(term == 1){
            return (price.subtract(downPayment)).multiply(new BigDecimal(0.05)).setScale(2, RoundingMode.HALF_DOWN);
        }else if(term == 3){
            return (price.subtract(downPayment)).multiply(new BigDecimal(0.07)).setScale(2, RoundingMode.HALF_DOWN);
        }else if(term == 6){
            return (price.subtract(downPayment)).multiply(new BigDecimal(0.14)).setScale(2, RoundingMode.HALF_DOWN);
        }
        return new BigDecimal(0.0);
    }

    @Override
    public BigDecimal calculateMonthlyFee(int term, BigDecimal price, BigDecimal downPayment) {
        return (price.subtract(downPayment)).divide(new BigDecimal(100));
    }

    @Override
    @Transactional
    public DaifuOrder createDaifuOrder(Member member, DaifuCode code, BigDecimal downPayment,
                                       int term, BigDecimal commissionPaid, boolean addToBill,
                                       boolean toOpen, Date currentTime) {
        //添加order
        DaifuOrder order = new DaifuOrder();
        if(toOpen) {
            order.setStatus(OrderStatus.open.name());
        }else{
            order.setStatus(OrderStatus.pending.name());
        }
        order.setCodeId(code.getCodeId());
        order.setCommission(calculateCommission(term ,code.getPrice(), downPayment).setScale(2, RoundingMode.HALF_DOWN));
        order.setMonthlyFee(calculateMonthlyFee(term, code.getPrice(), downPayment).setScale(2, RoundingMode.HALF_DOWN));
        order.setTotalTerm(term);
        order.setMemberId(member.getUid());
        order.setTitle(code.getItems());
        order.setOverdueStatus(OverDueStatus.no.name());
        order.setDownPayment(downPayment);
        order.setPrice(code.getPrice());
        order.setPaidCommission(commissionPaid);
        orderMapper.insert(order);
        logger.info("新order：" + order);

        //重新获取order
        order = selectOrderByCodeId(code.getCodeId());
        if(order != null) {
            List<DaifuOrderLeg> legs = new ArrayList<>(term);
            double reverse_term = 1.0 / term;
            BigDecimal legAmount = (order.getPrice().
                    subtract(order.getDownPayment())).multiply(new BigDecimal(reverse_term))
                    .setScale(2, RoundingMode.HALF_DOWN);
            BigDecimal monthlyFee = order.getMonthlyFee();
            //添加子order
            for (int i = 0; i < term; i++) {
                DaifuOrderLeg leg = new DaifuOrderLeg();
                leg.setStatus(OrderLegStatus.open.name());
                leg.setAmount(legAmount);
                leg.setFee(monthlyFee);
                leg.setInterest(new BigDecimal(0.0));
                leg.setOrderId(order.getOrderId());
                leg.setSequence(i+1);
                leg.setMemberId(member.getUid());
                leg.setCreatedDate(new Date());
                leg.setOverdueStatus(OverDueStatus.no.name());
                leg.setLastUpdatedDate(new Date());
                legs.add(leg);
                legMapper.insert(leg);
                logger.info("leg：" + order);
            }

            //把子order添加到账单
            if(addToBill) {
                legs = queryAllOrderLegsInOrder(order.getOrderId(), false, false);
                billService.appendDaifuOrderLeg(legs, member, currentTime);
            }
        }

        return order;
    }

    @Override
    public DaifuOrder selectOrderByCodeId(Long daifuId) {
        return orderMapper.selectOrderByCodeId(daifuId);
    }

    @Override
    public DaifuOrder selectOne(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }


    @Override
    public List<DaifuOrderLeg> queryAllOrderLegsInBill(Long billId, Boolean onlyOpen, Boolean onlyOverDue) {
        return legMapper.selectByBillId(billId).stream().filter(leg -> {
            if(onlyOpen && !leg.getStatus().equals(OrderLegStatus.open.name())){
                return false;
            }
            if(onlyOverDue && !leg.getOverdueStatus().equals(OverDueStatus.yes.name())){
                return false;
            }
            return true;
        }).collect(Collectors.toList());
    }

    @Override
    public List<DaifuOrderLeg> queryAllOrderLegsInOrder(Long orderId, Boolean onlyOpen, Boolean onlyOverDue) {
        return legMapper.selectByOrderId(orderId).stream().filter(leg -> {
            if(onlyOpen && !leg.getStatus().equals(OrderLegStatus.open.name())){
                return false;
            }
            if(onlyOverDue && !leg.getOverdueStatus().equals(OverDueStatus.yes.name())){
                return false;
            }
            return true;
        }).collect(Collectors.toList());
    }

    @Override
    public List<DaifuOrderLeg> queryAllOrderLegsOfMember(Long memberId, Boolean onlyOpen, Boolean onlyOverDue) {
        return legMapper.selectByMemberId(memberId).stream().filter(leg -> {
            if(onlyOpen && !leg.getStatus().equals(OrderLegStatus.open.name())){
                return false;
            }
            if(onlyOverDue && !leg.getOverdueStatus().equals(OverDueStatus.yes.name())){
                return false;
            }
            return true;
        }).collect(Collectors.toList());
    }

    @Override
    public List<DaifuOrder> queryOrderByUser(Long memberId, Boolean onlyOpen, Boolean onlyOverDue) {
        return orderMapper.selectByMemberId(memberId).stream().filter(order -> {
            if(onlyOpen && !order.getStatus().equals(OrderStatus.open.name())){
                return false;
            }
            if(onlyOverDue && !order.getOverdueStatus().equals(OverDueStatus.yes.name())){
                return false;
            }
            return true;
        }).collect(Collectors.toList());
    }

    @Override
    public OrderLegStatus checkAndCloseOrderLeg(Long orderLegId, boolean forceClose) {
        DaifuOrderLeg leg = legMapper.selectByPrimaryKey(orderLegId);
        if(leg == null){
            return OrderLegStatus.paid;
        }
        if(!leg.getStatus().equals(OrderLegStatus.open.name())){
            return OrderLegStatus.valueOf(leg.getStatus());
        }

        List<Repayment> repayments = billService.getRepaymentInOrderLeg(orderLegId, true);
        BigDecimal paidAmount = new BigDecimal(0.0);
        BigDecimal paidFee = new BigDecimal(0.0);
        BigDecimal paidInterest = new BigDecimal(0.0);
        for(Repayment r : repayments){
            paidAmount = paidAmount.add(r.getPrice());
            paidFee = paidFee.add(r.getFee());
            paidInterest = paidInterest.add(r.getFee());
        }
        if(NumberUtils.bigDecimalCompare(paidAmount, leg.getAmount()) >= 0 &&
                NumberUtils.bigDecimalCompare(paidFee, leg.getFee()) >= 0){
            //暂时先不检查罚息
//                paidInterest.compareTo(leg.getInterest()) >= 0){
            //如果所有款项结清，则关闭leg
            leg.setStatus(OrderLegStatus.paid.name());
            leg.setLastUpdatedDate(new Date());
            legMapper.updateByPrimaryKey(leg);
            return OrderLegStatus.paid;
        }else if(forceClose){
            leg.setStatus(OrderLegStatus.closed.name());
            leg.setLastUpdatedDate(new Date());
            legMapper.updateByPrimaryKey(leg);
            return OrderLegStatus.closed;
        }
        return OrderLegStatus.open;

    }

    @Override
    public OrderStatus checkAndCloseOrder(Long orderId, boolean forceClose, String operatorId, String comments) {
        DaifuOrder order = selectOne(orderId);
        if(order == null){
            return OrderStatus.paid;
        }
        if(!(order.getStatus().equals(OrderStatus.open.name()))){
            return OrderStatus.valueOf(order.getStatus());
        }
        boolean allPaid = true;
        boolean hasOpenLeg = false;
        List<DaifuOrderLeg> legs = queryAllOrderLegsInOrder(orderId, true, false);
        for(DaifuOrderLeg leg : legs){
            //如果子订单没有关闭
            if(leg.getStatus().equals(OrderLegStatus.open.name())){
                //尝试关闭子订单
                OrderLegStatus legStatus =
                        checkAndCloseOrderLeg(leg.getOrderlegId(), forceClose);
                if(legStatus.equals(OrderLegStatus.closed)){
                    allPaid = false;
                }else if(legStatus.equals(OrderLegStatus.open)){
                    //如果还有未完成的订单，则直接返回
                    hasOpenLeg = true;
                }
            }
        }
        if(hasOpenLeg){
            return OrderStatus.open;
        }
        //如果所有子订单关闭了
        if(allPaid){
            order.setStatus(OrderStatus.paid.name());
        }else{
            order.setStatus(OrderStatus.closed.name());
        }
        order.setOperatorId(operatorId);
        order.setComments(comments);
        order.setLastUpdateDate(new Date());
        orderMapper.updateByPrimaryKeySelective(order);
        return OrderStatus.valueOf(order.getStatus());
    }


}
