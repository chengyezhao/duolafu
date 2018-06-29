package com.shoumipay.service.impl;

import com.shoumipay.dao.MemberJobsMapper;
import com.shoumipay.domain.MemberJobs;
import com.shoumipay.service.admin.MemberJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tang on 2017/10/31.
 */
@Service
public class MemberJobsServiceImpl  implements MemberJobsService {
    @Autowired
    private MemberJobsMapper memberJobsMapper;

    @Override
    public MemberJobs selectByMemberId(Long memberId) {
        return memberJobsMapper.selectByMemberId(memberId);
    }
}
