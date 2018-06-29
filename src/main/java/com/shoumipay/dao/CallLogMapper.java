package com.shoumipay.dao;

import com.shoumipay.domain.CallLog;
import com.shoumipay.domain.CallLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CallLogMapper {
    long countByExample(CallLogExample example);

    int deleteByExample(CallLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CallLog record);

    int insertSelective(CallLog record);

    List<CallLog> selectByExample(CallLogExample example);

    List<CallLog> selectByMemberId(Long MemberId);

    CallLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CallLog record, @Param("example") CallLogExample example);

    int updateByExample(@Param("record") CallLog record, @Param("example") CallLogExample example);

    int updateByPrimaryKeySelective(CallLog record);

    int updateByPrimaryKey(CallLog record);
}