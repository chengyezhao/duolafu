package com.shoumipay.dao;

import com.shoumipay.domain.DataMAC;
import com.shoumipay.domain.DataMACExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface DataMACMapper {
    long countByExample(DataMACExample example);

    int deleteByExample(DataMACExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DataMAC record);

    int insertSelective(DataMAC record);

    List<DataMAC> selectByExample(DataMACExample example);

    DataMAC selectByPrimaryKey(Long id);

    DataMAC selectState(@Param("startTime") String startTime,@Param("endTime") String endTime);

    int updateByExampleSelective(@Param("record") DataMAC record, @Param("example") DataMACExample example);

    int updateByExample(@Param("record") DataMAC record, @Param("example") DataMACExample example);

    int updateByPrimaryKeySelective(DataMAC record);

    int updateByPrimaryKey(DataMAC record);
}