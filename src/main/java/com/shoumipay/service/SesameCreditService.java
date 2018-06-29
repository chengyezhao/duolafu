package com.shoumipay.service;

import com.shoumipay.domain.SesameCredit;

/**
 * Created by Tang on 2017/10/27.
 */
public interface SesameCreditService {
    SesameCredit selectByLatest(Long memberId);
    Boolean valid(Long memberId);
    int addSesameCredit(SesameCredit sesameCredit);
    int updateSesameCredit(SesameCredit sesameCredit);
    SesameCredit selectByOrderId(String orderId);
}
