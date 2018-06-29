package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.service.admin.BillCollectionManageService;
import com.shoumipay.service.admin.RepaymentManageService;
import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.mapper.BillCollectionMapper;
import com.shoumipay.v2.mapper.RepaymentMapper;
import com.shoumipay.v2.vo.RepaymentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepaymentManageServiceImpl implements RepaymentManageService {

    @Autowired
    private RepaymentMapper repaymentMapper;


    @Override
    public List<RepaymentVo> query(RepaymentVo repaymentVo, Integer page, Integer rows) {
        if (page != null && rows != null && page > 0 && rows > 0) {
            PageHelper.startPage(page, rows);
        }
        List<RepaymentVo> list = repaymentMapper.queryList(repaymentVo);
        return list;
    }
}
