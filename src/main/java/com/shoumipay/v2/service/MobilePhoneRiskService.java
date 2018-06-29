package com.shoumipay.v2.service;

import com.shoumipay.domain.Member;

public interface MobilePhoneRiskService {
    int riskRating(Member member);
}
