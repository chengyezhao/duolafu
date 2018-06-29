package com.shoumipay.service.admin;

import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.GoodsOrderExample;
import com.shoumipay.vo.PreLoanOrderVO;
import com.shoumipay.vo.PreLoanVO;
import com.shoumipay.vo.RepaymentVO;

import java.util.Date;
import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
public interface GoodsOrderService  {
    List<GoodsOrder> selectByExample(GoodsOrderExample example);
    List<GoodsOrder> selectNormal();
    int updateByPrimaryKeySelective(GoodsOrder record);
    GoodsOrder selectByPrimaryKey(Long id);
    GoodsOrder selectByOrderNumber(String orderNumber);
    GoodsOrder selectLatest(Long memberId);
    GoodsOrder getOrderById(Long orderId);
    GoodsOrder getOrderByIdAndMemberId(Long orderId,Long memberId);
    List<RepaymentVO> queryRepayList(Long memberId, Date start, Date end);
    List<PreLoanOrderVO> queryByPreLoanVO(PreLoanVO vo);
    List<PreLoanOrderVO> queryByPreLoanVOOverdue(PreLoanVO vo);
    List<GoodsOrder> selectByMemberid(Long memberId);
    int countTimesByTime();//获取当天申请订单量
    /**
     * 批量更新订单状态
     * */
    int updateOrderStatus(String[] ids,Integer status);
}
