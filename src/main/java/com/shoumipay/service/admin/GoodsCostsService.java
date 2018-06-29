package com.shoumipay.service.admin;

import com.shoumipay.domain.GoodsCosts;

/**
 * Created by Tang on 2017/11/1.
 */
public interface GoodsCostsService {
    GoodsCosts selectByGoodsIdName(Long goodsId, Integer name);
}
