package com.shoumipay.service.impl;

import com.shoumipay.dao.MemberLinkmanMapper;
import com.shoumipay.domain.MemberLinkman;
import com.shoumipay.service.admin.MemberLinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/10/31.
 */
@Service
public class MemberLinkmanServiceImpl implements MemberLinkmanService {
    @Autowired
    private MemberLinkmanMapper memberLinkmanMapper;

    @Override
    public MemberLinkman selectByMemberId(Long memberId) {
        return memberLinkmanMapper.selectByMemberId(memberId);
    }
}
