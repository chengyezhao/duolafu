package com.shoumipay.dao;

import com.shoumipay.domain.SesameCreditRecord;
import com.shoumipay.domain.SesameCreditRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SesameCreditRecordMapper {
    long countByExample(SesameCreditRecordExample example);

    int deleteByExample(SesameCreditRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SesameCreditRecord record);

    int insertSelective(SesameCreditRecord record);

    List<SesameCreditRecord> selectByExample(SesameCreditRecordExample example);

    SesameCreditRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SesameCreditRecord record, @Param("example") SesameCreditRecordExample example);

    int updateByExample(@Param("record") SesameCreditRecord record, @Param("example") SesameCreditRecordExample example);

    int updateByPrimaryKeySelective(SesameCreditRecord record);

    int updateByPrimaryKey(SesameCreditRecord record);
}