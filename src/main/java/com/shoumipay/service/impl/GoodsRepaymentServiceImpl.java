package com.shoumipay.service.impl;

import com.shoumipay.dao.GoodsRepaymentMapper;
import com.shoumipay.domain.GoodsRepayment;
import com.shoumipay.service.admin.GoodsRepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
@Service
public class GoodsRepaymentServiceImpl implements GoodsRepaymentService {
    @Autowired
    private GoodsRepaymentMapper goodsRepaymentMapper;


    @Override
    public long countOverdue(Long orderId, Integer days) {
        return goodsRepaymentMapper.countOverdue(orderId, days);
    }

    @Override
    public long countOverdue7(Long orderId) {
        return goodsRepaymentMapper.countOverdue7(orderId);
    }

    @Override
    public int insert(GoodsRepayment record) {
        return goodsRepaymentMapper.insert(record);
    }

    @Override
    public GoodsRepayment selectUnRepayByOrderIdTimes(Long orderId, Integer times) {
        return goodsRepaymentMapper.selectUnRepayByOrderIdTimes(orderId, times);
    }

    @Override
    public GoodsRepayment selectByPrimaryKey(Long repaymentId) {
        return goodsRepaymentMapper.selectByPrimaryKey(repaymentId);
    }

    @Override
    public List<GoodsRepayment> selectRepayByOrderIdTimes(Long orderId) {
        return goodsRepaymentMapper.selectRepayByOrderIdTimes(orderId);
    }

    @Override
    public List<GoodsRepayment> selectByOrderIdTimes(Long orderId, Integer times) {
        return goodsRepaymentMapper.selectByOrderIdTimes(orderId, times);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsRepayment record) {
        return goodsRepaymentMapper.updateByPrimaryKeySelective(record);
    }
}
