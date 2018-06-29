package com.shoumipay.dao;

import com.shoumipay.domain.MemberLinkman;
import com.shoumipay.domain.MemberLinkmanExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface MemberLinkmanMapper {
    long countByExample(MemberLinkmanExample example);

    int deleteByExample(MemberLinkmanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberLinkman record);

    int insertSelective(MemberLinkman record);

    List<MemberLinkman> selectByExample(MemberLinkmanExample example);

    MemberLinkman selectByPrimaryKey(Long id);

    MemberLinkman selectByMemberId(Long memberId);

    int updateByExampleSelective(@Param("record") MemberLinkman record, @Param("example") MemberLinkmanExample example);

    int updateByExample(@Param("record") MemberLinkman record, @Param("example") MemberLinkmanExample example);

    int updateByPrimaryKeySelective(MemberLinkman record);

    int updateByPrimaryKey(MemberLinkman record);
}