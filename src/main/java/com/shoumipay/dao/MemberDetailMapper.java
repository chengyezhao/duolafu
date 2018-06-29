package com.shoumipay.dao;

import com.shoumipay.domain.MemberDetail;
import com.shoumipay.domain.MemberDetailExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface MemberDetailMapper {
    long countByExample(MemberDetailExample example);

    int deleteByExample(MemberDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberDetail record);

    int insertSelective(MemberDetail record);

    List<MemberDetail> selectByExample(MemberDetailExample example);

    MemberDetail selectByMemberId(Long memberId);

    MemberDetail selectByPrimaryKey(Long id);

    List<MemberDetail> selectByBirthday(@Param("day") int day);

    int updateByExampleSelective(@Param("record") MemberDetail record, @Param("example") MemberDetailExample example);

    int updateByExample(@Param("record") MemberDetail record, @Param("example") MemberDetailExample example);

    int updateByPrimaryKeySelective(MemberDetail record);

    int updateByPrimaryKey(MemberDetail record);
}