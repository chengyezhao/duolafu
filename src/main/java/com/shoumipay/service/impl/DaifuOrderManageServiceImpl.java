package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.service.admin.DaifuCodeManageService;
import com.shoumipay.service.admin.DaifuOrderManageService;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.mapper.DaifuCodeMapper;
import com.shoumipay.v2.mapper.DaifuOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaifuOrderManageServiceImpl implements DaifuOrderManageService {

    @Autowired
    private DaifuOrderMapper daifuOrderMapper;


    @Override
    public List<DaifuOrder> query(DaifuOrder daifuOrder, Integer page, Integer rows) {
        if (page != null && rows != null && page > 0 && rows > 0) {
            PageHelper.startPage(page, rows);
        }
        List<DaifuOrder> list = daifuOrderMapper.queryList(daifuOrder);
        return list;
    }

    @Override
    public int update(DaifuOrder daifuOrder) {
        return daifuOrderMapper.update(daifuOrder);
    }
}
