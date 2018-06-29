package com.shoumipay.service.impl;

import com.shoumipay.dao.MemberDetailMapper;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.service.admin.MemberDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/10/25.
 */
@Service
public class MemberDetailServiceImpl implements MemberDetailService {

    @Autowired
    private MemberDetailMapper memberDetailMapper;

    @Override
    public MemberDetail selectByMemberId(Long uid) {
        return memberDetailMapper.selectByMemberId(uid);
    }
}
