package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.service.admin.DaifuOrderLegManageService;
import com.shoumipay.service.admin.DaifuOrderManageService;
import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.mapper.DaifuOrderLegMapper;
import com.shoumipay.v2.mapper.DaifuOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaifuOrderLegManageServiceImpl implements DaifuOrderLegManageService {

    @Autowired
    private DaifuOrderLegMapper daifuOrderLegMapper;


    @Override
    public List<DaifuOrderLeg> query(DaifuOrderLeg daifuOrderLeg, Integer page, Integer rows) {
        if (page != null && rows != null && page > 0 && rows > 0) {
            PageHelper.startPage(page, rows);
        }
        List<DaifuOrderLeg> list = daifuOrderLegMapper.queryList(daifuOrderLeg);
        return list;
    }
}
