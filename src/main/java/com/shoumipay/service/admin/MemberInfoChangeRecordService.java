package com.shoumipay.service.admin;

import com.shoumipay.domain.MemberInfoChangeRecord;
import com.shoumipay.domain.MemberInfoChangeRecordExample;

import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
public interface MemberInfoChangeRecordService {
    List<MemberInfoChangeRecord> selectByExample(MemberInfoChangeRecordExample example);
    MemberInfoChangeRecord selectByLatestPhoneChange(Long memberId);
    void insert(MemberInfoChangeRecord record);
}
