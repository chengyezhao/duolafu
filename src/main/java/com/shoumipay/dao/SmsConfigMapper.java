package com.shoumipay.dao;

import com.shoumipay.domain.SmsConfig;
import com.shoumipay.domain.SmsConfigExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SmsConfigMapper {
    long countByExample(SmsConfigExample example);

    int deleteByExample(SmsConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsConfig record);

    int insertSelective(SmsConfig record);

    List<SmsConfig> selectByExample(SmsConfigExample example);

    SmsConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsConfig record, @Param("example") SmsConfigExample example);

    int updateByExample(@Param("record") SmsConfig record, @Param("example") SmsConfigExample example);

    int updateByPrimaryKeySelective(SmsConfig record);

    int updateByPrimaryKey(SmsConfig record);
}