package com.shoumipay.service.impl;

import com.shoumipay.dao.NoticeMemberMapper;
import com.shoumipay.domain.NoticeMember;
import com.shoumipay.service.admin.NoticeMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/10/31.
 */
@Service
public class NoticeMemberServiceImpl implements NoticeMemberService {

    @Autowired
    private NoticeMemberMapper mapper;


    @Override
    public NoticeMember selectByNoticeIdMemberId(Long noticeId, Long memberId) {
        return mapper.selectByNoticeIdMemberId(noticeId, memberId);
    }

    @Override
    public void updateRead(Long id) {
        mapper.updateRead(id);
    }

    @Override
    public void updateAllRead(Long memberId) {
        mapper.updateAllRead(memberId);
    }
}
