package com.shoumipay.dao;

import com.shoumipay.domain.MemberInfoChangeRecord;
import com.shoumipay.domain.MemberInfoChangeRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper @Component
public interface MemberInfoChangeRecordMapper {
    long countByExample(MemberInfoChangeRecordExample example);

    int deleteByExample(MemberInfoChangeRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberInfoChangeRecord record);

    int insertSelective(MemberInfoChangeRecord record);

    List<MemberInfoChangeRecord> selectByExample(MemberInfoChangeRecordExample example);

    MemberInfoChangeRecord selectByPrimaryKey(Long id);

    MemberInfoChangeRecord selectByLatestPhoneChange(Long memberId);

    int updateByExampleSelective(@Param("record") MemberInfoChangeRecord record, @Param("example") MemberInfoChangeRecordExample example);

    int updateByExample(@Param("record") MemberInfoChangeRecord record, @Param("example") MemberInfoChangeRecordExample example);

    int updateByPrimaryKeySelective(MemberInfoChangeRecord record);

    int updateByPrimaryKey(MemberInfoChangeRecord record);
}