package com.shoumipay.dao;

import com.shoumipay.domain.MemberJobs;
import com.shoumipay.domain.MemberJobsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface MemberJobsMapper {
    long countByExample(MemberJobsExample example);

    int deleteByExample(MemberJobsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberJobs record);

    int insertSelective(MemberJobs record);

    List<MemberJobs> selectByExample(MemberJobsExample example);

    MemberJobs selectByPrimaryKey(Long id);

    MemberJobs selectByMemberId(Long memberId);

    int updateByExampleSelective(@Param("record") MemberJobs record, @Param("example") MemberJobsExample example);

    int updateByExample(@Param("record") MemberJobs record, @Param("example") MemberJobsExample example);

    int updateByPrimaryKeySelective(MemberJobs record);

    int updateByPrimaryKey(MemberJobs record);
}