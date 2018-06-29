package com.shoumipay.service.admin;

import com.shoumipay.domain.Goods;
import com.shoumipay.domain.GoodsOrder;

/**
 * Created by Tang on 2017/11/1.
 */
public interface RepayService {

    /**
     * 实际针对每个产品类型修改放款表，生成还款表和还款计划
     * @param order
     * @param goods
     */
    void repay(GoodsOrder order, Goods goods, String makeLoanId);
}
