package com.shoumipay.service.admin;

import com.shoumipay.domain.NoticeMember;

/**
 * Created by Tang on 2017/10/31.
 */
public interface NoticeMemberService {
    NoticeMember selectByNoticeIdMemberId(Long noticeId, Long memberId);
    void updateRead(Long id);
    void updateAllRead(Long memberId);
}
