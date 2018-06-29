package com.shoumipay.v2.service;

import com.shoumipay.domain.Member;

public interface BQSRiskService {
     enum BQSRisk{
        Accepted, Rejected, Review, Unknown
    }

    BQSRisk isMemberInBlackList(Member member);
    BQSRisk isMemberHasLoanRisk(Member member);
}
