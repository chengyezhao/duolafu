package com.shoumipay.service.impl;

import com.shoumipay.dao.GoodsRepaymentPlanMapper;
import com.shoumipay.domain.GoodsRepaymentPlan;
import com.shoumipay.service.admin.GoodsRepaymentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Tang on 2017/10/27.
 */
@Service
public class GoodsRepaymentPlanServiceImpl implements GoodsRepaymentPlanService {

    @Autowired
    private GoodsRepaymentPlanMapper goodsRepaymentPlanMapper;


    @Override
    public long countUnRepay(Long memberId) {
        return goodsRepaymentPlanMapper.countUnRepay(memberId);
    }

    @Override
    public int insert(GoodsRepaymentPlan record) {
        return goodsRepaymentPlanMapper.insert(record);
    }

    @Override
    public List<GoodsRepaymentPlan> selectByMemberId(Long memberId) {
        return goodsRepaymentPlanMapper.selectByMemberId(memberId);
    }

    @Override
    public List<GoodsRepaymentPlan> selectUnRepayByOrderId(Long orderId) {
        return goodsRepaymentPlanMapper.selectUnRepayByOrderId(orderId);
    }

    @Override
    public List<GoodsRepaymentPlan> selectByOrderId(Long orderId) {
        return goodsRepaymentPlanMapper.selectByOrderId(orderId);
    }

    @Override
    public List<GoodsRepaymentPlan> selectRepayTip(Date start, Date end) {
        return goodsRepaymentPlanMapper.selectRepayTip(start, end);
    }


    @Override
    public GoodsRepaymentPlan selectByOrderIdTimes(Long orderId, Integer times) {
        return goodsRepaymentPlanMapper.selectByOrderIdTimes(orderId, times);
    }

    @Override
    public GoodsRepaymentPlan selectLatest(Long orderId) {
        return goodsRepaymentPlanMapper.selectLatest(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsRepaymentPlan record) {
        return goodsRepaymentPlanMapper.updateByPrimaryKeySelective(record);
    }
}
