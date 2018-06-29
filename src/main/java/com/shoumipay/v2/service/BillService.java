package com.shoumipay.v2.service;

import com.shoumipay.domain.Member;
import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.domain.enums.BillStatus;
import com.shoumipay.v2.domain.enums.RepaymentStatus;
import org.springframework.data.util.Pair;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BillService {

    //根据订单的创建时间计算所有的账单和还款日期
    List<Pair<Date, Date>> calcBillAndPayDate(Member member, Date createdDate, int term);

    //把DaifuOrderLeg计入到账单，俺需要生成新的账单，或者在把leg加入到已有账单里面
    List<DaifuOrderLeg> appendDaifuOrderLeg(List<DaifuOrderLeg> orderLegs, Member member, Date currentTime);

    //查看账单
    BillCollection getBillCollection(Long billId);

    //查询当前账单的后续账单
    BillCollection getNextBill(Long memberId, Long billId);

    //查看当期已出账单信息
    BillCollection getCurrentBillCollection(Long memberId, Date currentTime);

    //按照账单出账日期的时间范围查看用户的账单
    List<BillCollection> getBillCollectionByDateRange(Long memberId, Date rangeStart, Date rangeEnd);

    //查看用户的账单
    List<BillCollection> getBillCollections(Long memberId, BillStatus billStatus);

    //计算子订单是否逾期，如果有逾期，则重新计算罚息
    DaifuOrderLeg calcOverDueOrderLeg(DaifuOrderLeg orderLeg, Date currentTime);

    //计算订单的还款记录
    List<Repayment> getRepaymentInBill(Long billId, boolean onlyPaid);

    //计算子订单的付款记录
    List<Repayment> getRepaymentInOrderLeg(Long orderLegId, boolean onlyPaid);

    Repayment getRepaymentById(Long repaymentId);

    List<Repayment> getRepaymentByTransId(String transId);

    //计算账单内的已经还款总值
    BigDecimal getPaidAmountPlusInterestInBill(Long billId);

    //计算账单总的需要还款的总值
    BigDecimal getTotalAmountPlusInterestInBill(Long billId);

    //计算需要退款的数量
    BigDecimal calculateReFundAmount(Long orderId);

    //添加repayemnt
    void createRepaymentForOrderLeg(Long orderLegId, String transId, Member member);

    //结束付款
    Repayment finishRepayment(Long repaymentId, RepaymentStatus status);

    //针对退款生成需要的冲销还款
    void createRepaymentsForRefund(Long orderId, String transId, String operatorId);

    List<Repayment> getAllPendingRepayment();


}
