package com.shoumipay.dao;

import com.shoumipay.domain.NoticeMember;
import com.shoumipay.domain.NoticeMemberExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface NoticeMemberMapper {
    long countByExample(NoticeMemberExample example);

    int deleteByExample(NoticeMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NoticeMember record);

    int insertSelective(NoticeMember record);

    List<NoticeMember> selectByExample(NoticeMemberExample example);

    NoticeMember selectByPrimaryKey(Long id);

    NoticeMember selectByNoticeIdMemberId(@Param("noticeId") Long noticeId, @Param("memberId") Long memberId);

    void updateRead(Long id);

    void updateAllRead(Long memberId);

    int updateByExampleSelective(@Param("record") NoticeMember record, @Param("example") NoticeMemberExample example);

    int updateByExample(@Param("record") NoticeMember record, @Param("example") NoticeMemberExample example);

    int updateByPrimaryKeySelective(NoticeMember record);

    int updateByPrimaryKey(NoticeMember record);
}