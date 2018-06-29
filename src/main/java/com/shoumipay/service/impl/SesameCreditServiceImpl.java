package com.shoumipay.service.impl;

import com.shoumipay.dao.SesameCreditMapper;
import com.shoumipay.domain.SesameCredit;
import com.shoumipay.service.SesameCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/10/27.
 */
@Service
public class SesameCreditServiceImpl implements SesameCreditService {
    @Autowired
    private SesameCreditMapper sesameCreditMapper;


    @Override
    public SesameCredit selectByLatest(Long memberId) {
        return sesameCreditMapper.selectByLatest(memberId);
    }

    @Override
    public int addSesameCredit(SesameCredit sesameCredit) {
        return sesameCreditMapper.insert(sesameCredit);
    }

    @Override
    public int updateSesameCredit(SesameCredit sesameCredit) {
        return sesameCreditMapper.updateByPrimaryKey(sesameCredit);
    }

    @Override
    public SesameCredit selectByOrderId(String orderId) {
        return sesameCreditMapper.selectByOrderId(orderId);
    }

    @Override
    public Boolean valid(Long memberId) {
        SesameCredit sesameCredit = sesameCreditMapper.selectByLatest(memberId);
        if (null == sesameCredit) return false;
        if (sesameCredit.getUpdateTime().getTime() + 1000L * 60 * 60 * 24 * 30 < System.currentTimeMillis())
            return false;
        return true;
    }
}
