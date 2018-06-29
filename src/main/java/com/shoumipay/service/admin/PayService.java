package com.shoumipay.service.admin;

import com.shoumipay.domain.*;

/**
 * Created by Tang on 2017/11/15.
 */
public interface PayService {
    String makeLoan(MemberDetail detail, GoodsOrder order, MemberBankcard bankcard, Long id, String[] institutionCode, String[] errMsg);
    String repay(GoodsOrder order, GoodsRepayment repayment, MemberDetail detail, MemberBankcard bankcard, Member member);
}
