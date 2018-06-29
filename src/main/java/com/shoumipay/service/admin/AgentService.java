package com.shoumipay.service.admin;

import com.shoumipay.domain.MemberAgent;
import com.shoumipay.vo.AgentVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AgentService {
    int insertAgent(MemberAgent memberAgent);
    List<AgentVO> queryByTimeId(Map<String,String> param,Long memberId,String agentType);
    List<AgentVO> selectVo(Map<String,String> param,Long agentId,Long memberId);
    List<AgentVO> selectAgentRecordVO(Map<String, String> param, Long id,Long agentId);
}
