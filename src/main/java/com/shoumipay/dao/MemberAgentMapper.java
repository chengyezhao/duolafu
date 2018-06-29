package com.shoumipay.dao;

import com.shoumipay.domain.MemberAgent;
import com.shoumipay.domain.MemberAgentExample;

import java.util.Date;
import java.util.List;

import com.shoumipay.vo.AgentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface MemberAgentMapper {
    long countByExample(MemberAgentExample example);

    int deleteByExample(MemberAgentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberAgent record);

    int insertSelective(MemberAgent record);

    List<MemberAgent> selectByExample(MemberAgentExample example);

    List<AgentVO> selectVO(@Param("agentId") Long agentId,@Param("memberId") Long memberId, @Param("start") Date start,@Param("end") Date end);

    List<AgentVO> selectAgentRecordVO(@Param("id") Long id,@Param("agentId") Long agentId, @Param("start") Date start,@Param("end") Date end);

    List<AgentVO> queryByTimeIdVO(@Param("memberId") Long memberId,@Param("agentType") String agentType, @Param("startTime") Date start,@Param("endTime") Date end);

    MemberAgent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberAgent record, @Param("example") MemberAgentExample example);

    int updateByExample(@Param("record") MemberAgent record, @Param("example") MemberAgentExample example);

    int updateByPrimaryKeySelective(MemberAgent record);

    int updateByPrimaryKey(MemberAgent record);

}