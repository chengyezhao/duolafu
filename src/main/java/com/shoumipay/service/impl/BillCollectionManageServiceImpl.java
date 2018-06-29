package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.service.admin.BillCollectionManageService;
import com.shoumipay.service.admin.DaifuOrderLegManageService;
import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.mapper.BillCollectionMapper;
import com.shoumipay.v2.mapper.DaifuOrderLegMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillCollectionManageServiceImpl implements BillCollectionManageService {

    @Autowired
    private BillCollectionMapper billCollectionMapper;


    @Override
    public List<BillCollection> query(BillCollection billCollection, Integer page, Integer rows) {
        if (page != null && rows != null && page > 0 && rows > 0) {
            PageHelper.startPage(page, rows);
        }
        List<BillCollection> list = billCollectionMapper.queryList(billCollection);
        return list;
    }
}
