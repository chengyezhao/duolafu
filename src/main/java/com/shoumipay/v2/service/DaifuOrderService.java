package com.shoumipay.v2.service;

import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.domain.enums.OrderLegStatus;
import com.shoumipay.v2.domain.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface DaifuOrderService {

    //计算手续费
    BigDecimal calculateCommission(int term, BigDecimal price, BigDecimal downPayment);

    //计算月管理费
    BigDecimal calculateMonthlyFee(int term, BigDecimal price, BigDecimal downPayment);

    //新建DaifuOrder和OrderLeg
    DaifuOrder createDaifuOrder(Member member, DaifuCode code, BigDecimal downPayment,
                                int term, BigDecimal commissionPaid, boolean addToBill, boolean toOpen, Date currentTime);

    DaifuOrder selectOrderByCodeId(Long codeId);

    DaifuOrder selectOne(Long orderId);

    //查询账单里所有的子订单
    List<DaifuOrderLeg> queryAllOrderLegsInBill(Long billId, Boolean onlyOpen, Boolean onlyOverDue);

    //查询订单里所有的子订单
    List<DaifuOrderLeg> queryAllOrderLegsInOrder(Long orderId, Boolean onlyOpen, Boolean onlyOverDue);

    //查询用户的所有子订单
    List<DaifuOrderLeg> queryAllOrderLegsOfMember(Long memberId, Boolean onlyOpen, Boolean onlyOverDue);

    //查询用户的订单
    List<DaifuOrder> queryOrderByUser(Long memberId, Boolean onlyOpen, Boolean onlyOverDue);

    //检查子订单，如果子订单完成则关闭订单
    OrderLegStatus checkAndCloseOrderLeg(Long orderLegId, boolean forceClose);

    //关闭订单（检查所有子订单是否已经完成），如果forceClose=true，则即使子订单没有完成也关闭订单
    OrderStatus checkAndCloseOrder(Long orderId, boolean forceClose, String operatorId, String comments);

}
