package com.shoumipay.dao;

import com.shoumipay.domain.FinancialMAC;
import com.shoumipay.domain.FinancialMACExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface FinancialMACMapper {
    long countByExample(FinancialMACExample example);

    int deleteByExample(FinancialMACExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FinancialMAC record);

    int insertSelective(FinancialMAC record);

    List<FinancialMAC> selectByExample(FinancialMACExample example);

    FinancialMAC selectByPrimaryKey(Long id);

    FinancialMAC selectStat(@Param("startTime") String startTime,@Param("endTime") String endTime);

    int updateByExampleSelective(@Param("record") FinancialMAC record, @Param("example") FinancialMACExample example);

    int updateByExample(@Param("record") FinancialMAC record, @Param("example") FinancialMACExample example);

    int updateByPrimaryKeySelective(FinancialMAC record);

    int updateByPrimaryKey(FinancialMAC record);
}