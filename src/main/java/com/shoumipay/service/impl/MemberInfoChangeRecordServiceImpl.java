package com.shoumipay.service.impl;

import com.shoumipay.dao.MemberInfoChangeRecordMapper;
import com.shoumipay.domain.MemberInfoChangeRecord;
import com.shoumipay.domain.MemberInfoChangeRecordExample;
import com.shoumipay.service.admin.MemberInfoChangeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
@Service
public class MemberInfoChangeRecordServiceImpl implements MemberInfoChangeRecordService {
    @Autowired
    private MemberInfoChangeRecordMapper memberInfoChangeRecordMapper;


    @Override
    public List<MemberInfoChangeRecord> selectByExample(MemberInfoChangeRecordExample example) {
        return memberInfoChangeRecordMapper.selectByExample(example);
    }

    @Override
    public MemberInfoChangeRecord selectByLatestPhoneChange(Long memberId) {
        return memberInfoChangeRecordMapper.selectByLatestPhoneChange(memberId);
    }

    @Override
    public void insert(MemberInfoChangeRecord record) {
        memberInfoChangeRecordMapper.insert(record);
    }
}
