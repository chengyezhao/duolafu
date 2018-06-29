package com.shoumipay.service.admin;

import com.shoumipay.domain.GoodsRepayment;

import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
public interface GoodsRepaymentService {
    long countOverdue(Long orderId, Integer days);
    long countOverdue7(Long orderId);
    int insert(GoodsRepayment record);
    GoodsRepayment selectUnRepayByOrderIdTimes(Long orderId, Integer times);
    GoodsRepayment selectByPrimaryKey(Long repaymentId);
    List<GoodsRepayment> selectRepayByOrderIdTimes(Long orderId);
    List<GoodsRepayment> selectByOrderIdTimes(Long orderId, Integer times);
    int updateByPrimaryKeySelective(GoodsRepayment record);
}
