package com.shoumipay.service.admin;

import com.shoumipay.domain.CallLog;

import java.util.Map;


public interface CallLogService {
    int insert(CallLog callLog);
    Map<String,String> getCallLogByMemberId(Long memberId);
}
