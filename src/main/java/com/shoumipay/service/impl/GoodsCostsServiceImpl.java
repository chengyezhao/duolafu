package com.shoumipay.service.impl;

import com.shoumipay.dao.GoodsCostsMapper;
import com.shoumipay.domain.GoodsCosts;
import com.shoumipay.service.admin.GoodsCostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/11/1.
 */
@Service
public class GoodsCostsServiceImpl implements GoodsCostsService {
    @Autowired
    private GoodsCostsMapper goodsCostsMapper;

    @Override
    public GoodsCosts selectByGoodsIdName(Long goodsId, Integer name) {
        return goodsCostsMapper.selectByGoodsIdName(goodsId, name);
    }
}
