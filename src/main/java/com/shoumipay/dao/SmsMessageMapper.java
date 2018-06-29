package com.shoumipay.dao;

import com.shoumipay.domain.SmsMessage;
import com.shoumipay.domain.SmsMessageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SmsMessageMapper {
    long countByExample(SmsMessageExample example);

    int deleteByExample(SmsMessageExample example);

    int deleteByPrimaryKey(Long sid);

    int deleteByIds(String[] ids);

    int insert(SmsMessage record);

    int insertSelective(SmsMessage record);

    List<SmsMessage> selectByExample(SmsMessageExample example);

    SmsMessage selectByPrimaryKey(Long sid);

    int updateByExampleSelective(@Param("record") SmsMessage record, @Param("example") SmsMessageExample example);

    int updateByExample(@Param("record") SmsMessage record, @Param("example") SmsMessageExample example);

    int updateByPrimaryKeySelective(SmsMessage record);

    int updateByPrimaryKey(SmsMessage record);
}