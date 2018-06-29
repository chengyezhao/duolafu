package com.shoumipay.service.admin;

import com.shoumipay.domain.GoodsMakeLoans;

/**
 * Created by Tang on 2017/10/28.
 */
public interface GoodsMakeLoansService {
    int insert(GoodsMakeLoans record);
    GoodsMakeLoans selectByPrimaryKey(Long id);
    GoodsMakeLoans selectLastActiveByOrder(Long orderId, Boolean active);
    int updateByPrimaryKeySelective(GoodsMakeLoans record);
    int countLoanTimes();
    Double sumLoanAmount();
}
