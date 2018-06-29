package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.service.admin.DaifuCodeManageService;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.mapper.DaifuCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class DaifuCodeManageServiceImpl implements DaifuCodeManageService {

    @Autowired
    private DaifuCodeMapper daifuCodeMapper;


    @Override
    public List<DaifuCode> query(DaifuCode daifuCode, Integer page, Integer rows) {
        if (page != null && rows != null && page > 0 && rows > 0) {
            PageHelper.startPage(page, rows);
        }
        List<DaifuCode> list = daifuCodeMapper.queryList(daifuCode);
        return list;
    }

    @Override
    public int update(DaifuCode daifuCode) {
        return daifuCodeMapper.update(daifuCode);
    }


}
