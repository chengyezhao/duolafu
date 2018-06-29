package com.shoumipay.service.admin;

import com.shoumipay.domain.MemberDetail;

/**
 * Created by Tang on 2017/10/25.
 */
public interface MemberDetailService {
    MemberDetail selectByMemberId(Long uid);

}
