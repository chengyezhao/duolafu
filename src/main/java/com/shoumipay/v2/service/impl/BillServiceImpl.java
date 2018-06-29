package com.shoumipay.v2.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableTable;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.tools.DateUtil;
import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.domain.enums.*;
import com.shoumipay.v2.mapper.BillCollectionMapper;
import com.shoumipay.v2.mapper.DaifuOrderLegMapper;
import com.shoumipay.v2.mapper.RepaymentMapper;
import com.shoumipay.v2.service.BillService;
import com.shoumipay.v2.service.DaifuOrderService;
import com.shoumipay.v2.service.MemberService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.shoumipay.tools.DateUtil.DEFAULT_DAY_DATE;

@Service
public class BillServiceImpl implements BillService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DaifuOrderService orderService;
    @Autowired
    private RepaymentMapper repaymentMapper;
    @Autowired
    private BillCollectionMapper billCollectionMapper;
    @Autowired
    private MemberService memberService;
    @Autowired
    private DaifuOrderLegMapper orderLegMapper;


    @Override
    public List<Pair<Date, Date>> calcBillAndPayDate(Member member, Date createdDate, int term) {
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        String dateOfBirth = memberDetail.getDateOfBirth();
        if(StringUtils.isEmpty(dateOfBirth)){
            return ImmutableList.of();
        }
        //计算账单日
        String birthDay = dateOfBirth.substring(dateOfBirth.length() - 2,
                dateOfBirth.length());
        int billDay = ObjectUtils.min(Integer.parseInt(birthDay), 28);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createdDate);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        //计算这个月是否还有账单日
        calendar.set(Calendar.DAY_OF_MONTH, billDay);
        if(currentDay >= billDay){
            //赶不上本月的账单
            calendar.add(Calendar.MONTH, 1);
            //账单日最大不超过28
            calendar.set(Calendar.DAY_OF_MONTH, Math.min(28, calendar.get(Calendar.DAY_OF_MONTH)));
        }
        List<Pair<Date, Date>> dates = new ArrayList<>();
        for(int i = 0; i <term; i++){
            //TODO: 计算还款日，采取往后推10天的做法
            Pair<Date, Date> pair = Pair.of(calendar.getTime(), DateUtils.addDays(calendar.getTime(), 10));
            dates.add(pair);
            calendar.add(Calendar.MONTH, 1);
            //账单日最大不超过28
            calendar.set(Calendar.DAY_OF_MONTH, Math.min(28, calendar.get(Calendar.DAY_OF_MONTH)));
        }

        //取得用户的birthDate
        //计算用户的账单日
        //获取从当前日期出发的term个账单日和还款日
        return dates;
    }

    @Override
    public List<DaifuOrderLeg> appendDaifuOrderLeg(List<DaifuOrderLeg> orderLegs, Member member, Date currentTime) {
        Collections.sort(orderLegs, Comparator.comparing(DaifuOrderLeg::getSequence));
        List<Pair<Date, Date>> dates = calcBillAndPayDate(member, currentTime, orderLegs.size());
        List<BillCollection> bills = getBillCollectionByDateRange(member.getUid(), currentTime, null);
        //把orderLeg插入到bill
        int i = 0;
        for(Pair<Date,Date> date: dates){
            Date billDate = date.getFirst();
            BillCollection matchedBill = null;
            //遍历已有的billcreate
            for(BillCollection bill: bills) {
                if (DateUtils.isSameDay(billDate, bill.getBillDate())){
                    matchedBill = bill;
                    break;
                }
            }
            if(matchedBill == null){
                //新增一个bill
                matchedBill = new BillCollection();
                matchedBill.setBillDate(billDate);
                matchedBill.setDueDate(date.getSecond());
                String billNumber = DateUtil.format(billDate, DEFAULT_DAY_DATE);
                matchedBill.setBillNumber(billNumber);
                matchedBill.setMemberId(member.getUid());
                matchedBill.setOverdueStatus(OverDueStatus.no.name());
                matchedBill.setStatus(BillStatus.waiting.name());
                billCollectionMapper.insert(matchedBill);
                //重新查询
                matchedBill = billCollectionMapper.selectByBillNumber(member.getUid(), billNumber);

            }
            if(matchedBill != null){
                orderLegs.get(i).setBillId(matchedBill.getBillId());
                orderLegs.get(i).setLastUpdatedDate(new Date());
                orderLegMapper.updateByPrimaryKey(orderLegs.get(i));
            }
            i++;
        }
        return orderLegs;
    }

    @Override
    public BillCollection getBillCollection(Long billId) {
        return billCollectionMapper.selectByPrimaryKey(billId);
    }

    @Override
    public BillCollection getNextBill(Long memberId, Long billId) {
        BillCollection bill = getBillCollection(billId);
        if(bill != null) {
            //从当前账单往后最多推31天
            List<BillCollection> bills = getBillCollectionByDateRange(memberId, bill.getBillDate(),
                    DateUtils.addDays(bill.getBillDate(), 31));
            if(bills.size() > 0){
                return bills.get(0);
            }
            return null;
        }
        return null;
    }

    @Override
    public BillCollection getCurrentBillCollection(Long memberId, Date currentTime) {
        //查询当前时间前31天范围内的已出账单
        List<BillCollection> bills = getBillCollectionByDateRange(memberId,
                DateUtils.addDays(currentTime, -31),  currentTime).stream()
                .filter(l -> l.getStatus().equals(BillStatus.published.name()))
                .collect(Collectors.toList());
        //当前日期最近，并且已经出的账单
        if(bills.size() > 0){
            return bills.get(bills.size() - 1);
        }else{
            return null;
        }
    }

    @Override
    public List<BillCollection> getBillCollectionByDateRange(Long memberId, Date rangeStart, Date rangeEnd) {
        return billCollectionMapper.selectByMemberId(memberId).stream()
                .filter(bill -> {
                    if(bill.getBillDate().compareTo(rangeStart) >= 0){
                        if(rangeEnd == null){
                            return true;
                        }
                        if(bill.getBillDate().compareTo(rangeEnd) >= 0) {
                            return true;
                        }
                    }
                    return false;
                })
                .sorted(Comparator.comparing(BillCollection::getBillDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<BillCollection> getBillCollections(Long memberId, BillStatus billStatus) {
        //按照用户查询账单，按照状态过滤，按照账单日期排序
        return billCollectionMapper.selectByMemberId(memberId).stream()
                .filter(bill -> {
                    if(billStatus == null){
                        return true;
                    }
                    return bill.getStatus().equals(billStatus.name());
                })
                .sorted(Comparator.comparing(BillCollection::getBillDate))
                .collect(Collectors.toList());
    }

    @Override
    public DaifuOrderLeg calcOverDueOrderLeg(DaifuOrderLeg orderLeg, Date currentTime) {
        if(orderLeg.getBillId() == null){
            return orderLeg;
        }
        BillCollection billCollection = getBillCollection(orderLeg.getBillId());
        if(billCollection == null){
            return orderLeg;
        }
        //如果账单还款日期已过
        if(billCollection.getDueDate().compareTo(currentTime) < 0){
            OrderLegStatus orderLegStatus = orderService.checkAndCloseOrderLeg(orderLeg.getOrderlegId(), false);
            //如果经过检查，订单还没有完成还款，则计算罚息
            if(orderLegStatus.equals(OrderLegStatus.open)){
                //按照商品未还款金额计算罚息
                long passDays = (currentTime.getTime() - billCollection.getDueDate().getTime()) / (1000L * 3600 * 24);
                BigDecimal interest = new BigDecimal(0.02).multiply(new BigDecimal(passDays)).multiply(orderLeg.getAmount());
                orderLeg.setInterest(interest);
                orderLeg.setLastUpdatedDate(new Date());
                orderLegMapper.updateByPrimaryKey(orderLeg);
                return orderLeg;
            }
        }else{
            return orderLeg;
        }
        return orderLeg;
    }


    @Override
    public List<Repayment> getRepaymentInBill(Long billId, boolean onlyPaid) {
        List<DaifuOrderLeg> legs = orderService.queryAllOrderLegsInBill(billId, false, false);
        List<Repayment> repayments = new ArrayList<>();
        for(DaifuOrderLeg leg : legs) {
            repayments.addAll(getRepaymentInOrderLeg(leg.getOrderlegId(), onlyPaid));
        }
        return repayments;
    }

    @Override
    public List<Repayment> getRepaymentInOrderLeg(Long orderLegId, boolean onlyPaid) {
       return repaymentMapper.selectByOrderLegId(orderLegId).stream()
               .filter(l -> {
                   if(onlyPaid){
                       return l.getStatus().equals(OrderLegStatus.paid.name());
                   }
                   return true;
               })
               .collect(Collectors.toList());
    }

    @Override
    public Repayment getRepaymentById(Long repaymentId) {
        return repaymentMapper.selectByPrimaryKey(repaymentId);
    }

    @Override
    public List<Repayment> getRepaymentByTransId(String transId) {
        return repaymentMapper.selectByTransId(transId);
    }

    @Override
    public BigDecimal getPaidAmountPlusInterestInBill(Long billId) {
        List<Repayment> repayments = this.getRepaymentInBill(billId, true);
        BigDecimal totalAmount = new BigDecimal(0.0);
        for(Repayment repayment: repayments){
            if(repayment.getStatus().equals(RepaymentStatus.paid.name())) {
                totalAmount = totalAmount.add(repayment.getPrice());
                totalAmount = totalAmount.add(repayment.getInterest());
                totalAmount = totalAmount.add(repayment.getFee());
            }
        }
        return totalAmount;
    }

    @Override
    public BigDecimal getTotalAmountPlusInterestInBill(Long billId) {
        List<DaifuOrderLeg> legs = orderService.queryAllOrderLegsInBill(billId, true, false);
        BigDecimal totalAmount = new BigDecimal(0.0);
        for(DaifuOrderLeg leg: legs){
            totalAmount = totalAmount.add(leg.getAmount());
            totalAmount = totalAmount.add(leg.getFee());
            totalAmount = totalAmount.add(leg.getInterest());
        }
        return totalAmount;
    }

    @Override
    public BigDecimal calculateReFundAmount(Long orderId) {
        //TODO：计算退款金额
        return new BigDecimal(0.0);
    }


    @Override
    public void createRepaymentsForRefund(Long orderId, String transId, String operatorId) {
        //查询所有open状态的orderLeg
        List<DaifuOrderLeg> legs = orderService.queryAllOrderLegsInOrder(orderId, true, false);
        //构建还款
        for(DaifuOrderLeg leg : legs){
            //TODO: 查看之前已经付款的值是否大于0，如果有已经有过本金还款，则累计本金还款额，生成一笔Refund记录
            //TODO： 针对之前没有付款的部分，自动生成repayment（type=refund进行冲销）
            Repayment repayment = new Repayment();
            repayment.setCreatedDate(new Date());
            repayment.setInterest(leg.getInterest());
            repayment.setFee(leg.getFee());
            repayment.setTransId(transId);
            repayment.setInterest(leg.getInterest());
            repayment.setPrice(leg.getAmount());
            repayment.setMemberId(leg.getMemberId());
            repayment.setOrderId(leg.getOrderId());
            repayment.setOrderLegId(leg.getOrderlegId());
            repayment.setOperatorId(operatorId);
            repayment.setStatus(RepaymentStatus.paid.name());
            repayment.setType(RepaymentType.refund.name());
            repaymentMapper.insert(repayment);
        }
    }

    @Override
    public void createRepaymentForOrderLeg(Long orderLegId, String transId, Member member) {
        DaifuOrderLeg leg = orderLegMapper.selectByPrimaryKey(orderLegId);
        if(leg == null){
            return ;
        }
        Repayment repayment = new Repayment();
        repayment.setType(RepaymentType.repay.name());
        repayment.setStatus(RepaymentStatus.pending.name());
        repayment.setOrderLegId(orderLegId);
        repayment.setOrderId(leg.getOrderId());
        repayment.setMemberId(member.getUid());
        repayment.setPrice(leg.getAmount());
        repayment.setTransId(transId);
        repayment.setInterest(leg.getInterest());
        repayment.setFee(leg.getFee());
        repaymentMapper.insert(repayment);
    }

    @Override
    public Repayment finishRepayment(Long repaymentId, RepaymentStatus status) {
        Repayment repayment = repaymentMapper.selectByPrimaryKey(repaymentId);
        repayment.setStatus(status.name());
        repayment.setLastUpdatedDate(new Date());
        repaymentMapper.updateByPrimaryKey(repayment);
        return repayment;
    }

    @Override
    public List<Repayment> getAllPendingRepayment() {
        return repaymentMapper.selectPendingRepayment();
    }
}
