package com.shoumipay.service.impl;

import com.shoumipay.dao.GoodsMakeLoansMapper;
import com.shoumipay.domain.GoodsMakeLoans;
import com.shoumipay.domain.GoodsMakeLoansExample;
import com.shoumipay.service.admin.GoodsMakeLoansService;
import com.shoumipay.tools.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Tang on 2017/10/28.
 */
@Service
public class GoodsMakeLoansServiceImpl implements GoodsMakeLoansService {
    @Autowired
    private GoodsMakeLoansMapper goodsMakeLoansMapper;


    @Override
    public int insert(GoodsMakeLoans record) {
        return goodsMakeLoansMapper.insertSelective(record);
    }

    @Override
    public GoodsMakeLoans selectByPrimaryKey(Long orderId) {
        return goodsMakeLoansMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public GoodsMakeLoans selectLastActiveByOrder(Long orderId, Boolean active) {
        GoodsMakeLoansExample ex = new GoodsMakeLoansExample();
        if (active != null){
            ex.or().andOrderIdEqualTo(orderId).andActiveEqualTo(active);
        } else {
            ex.or().andOrderIdEqualTo(orderId);
        }
        ex.setOrderByClause("id DESC");
        List<GoodsMakeLoans> goodsMakeLoanses = goodsMakeLoansMapper.selectByExample(ex);
        if (goodsMakeLoanses!=null && goodsMakeLoanses.size()>0) {
            return goodsMakeLoanses.get(0);
        }
        return null;
    }

    @Override
    public Double sumLoanAmount() {
        Date startTime = DateUtil.getStartTime();
        Date endTime = DateUtil.getEndTime();
        return goodsMakeLoansMapper.sumLoanAmount(startTime,endTime);
    }

    @Override
    public int countLoanTimes() {
        Date startTime = DateUtil.getStartTime();
        Date endTime = DateUtil.getEndTime();
        return goodsMakeLoansMapper.countLoanTimes(startTime,endTime);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsMakeLoans record) {
        return goodsMakeLoansMapper.updateByPrimaryKeySelective(record);
    }
}
