package com.shoumipay.v2.service.impl;

import com.shoumipay.v2.mapper.InfoMapper;
import com.shoumipay.v2.service.InfoService;
import com.shoumipay.v2.vo.InfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public int addInfo(InfoVO infoVO) {
        return infoMapper.addInfo(infoVO);
    }
}
