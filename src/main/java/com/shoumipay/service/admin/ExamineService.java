package com.shoumipay.service.admin;

import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;

/**
 * Created by Tang on 2017/10/26.
 */
public interface ExamineService {
    int examine(Member member);
    String getDesc();
}
