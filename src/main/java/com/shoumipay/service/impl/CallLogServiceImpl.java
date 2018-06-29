package com.shoumipay.service.impl;

import com.shoumipay.dao.CallLogMapper;
import com.shoumipay.domain.CallLog;
import com.shoumipay.service.admin.CallLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CallLogServiceImpl implements CallLogService {
    @Autowired
    CallLogMapper callLogMapper;

    @Override
    public Map<String, String> getCallLogByMemberId(Long memberId) {
        List<CallLog> callLogList = callLogMapper.selectByMemberId(memberId);
        Map<String,String> map=new LinkedHashMap<>();
        for (CallLog callLog:callLogList){
            map.put(callLog.getNumber(),callLog.getName());
        }
        return map;
    }

    @Override
    public int insert(CallLog callLog) {
        return callLogMapper.insertSelective(callLog);
    }
}
