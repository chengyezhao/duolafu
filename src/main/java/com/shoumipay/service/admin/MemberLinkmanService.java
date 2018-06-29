package com.shoumipay.service.admin;

import com.shoumipay.domain.MemberLinkman;

/**
 * Created by Tang on 2017/10/31.
 */
public interface MemberLinkmanService {
    MemberLinkman selectByMemberId(Long memberId);
}
