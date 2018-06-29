package com.shoumipay.service.admin;

import com.shoumipay.domain.MemberJobs;

/**
 * Created by Tang on 2017/10/31.
 */
public interface MemberJobsService {
    MemberJobs selectByMemberId(Long memberId);
}
