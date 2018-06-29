package com.shoumipay.service.admin;

import com.shoumipay.domain.GoodsRepaymentPlan;

import java.util.Date;
import java.util.List;

/**
 * Created by Tang on 2017/10/27.
 */
public interface GoodsRepaymentPlanService {
    long countUnRepay(Long memberId);
    int insert(GoodsRepaymentPlan record);
    List<GoodsRepaymentPlan> selectByMemberId(Long memberId);
    List<GoodsRepaymentPlan> selectUnRepayByOrderId(Long orderId);
    List<GoodsRepaymentPlan> selectByOrderId(Long orderId);
    List<GoodsRepaymentPlan> selectRepayTip(Date start, Date end);
    GoodsRepaymentPlan selectByOrderIdTimes(Long orderId, Integer times);
    GoodsRepaymentPlan selectLatest(Long orderId);
    int updateByPrimaryKeySelective(GoodsRepaymentPlan record);
}
