package com.shoumipay.dao;

import com.shoumipay.domain.AgentRecord;
import com.shoumipay.domain.AgentRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgentRecordMapper {
    long countByExample(AgentRecordExample example);

    int deleteByExample(AgentRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AgentRecord record);

    int insertSelective(AgentRecord record);

    List<AgentRecord> selectByExample(AgentRecordExample example);

    AgentRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AgentRecord record, @Param("example") AgentRecordExample example);

    int updateByExample(@Param("record") AgentRecord record, @Param("example") AgentRecordExample example);

    int updateByPrimaryKeySelective(AgentRecord record);

    int updateByPrimaryKey(AgentRecord record);
}