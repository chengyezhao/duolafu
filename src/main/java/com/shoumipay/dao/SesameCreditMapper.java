package com.shoumipay.dao;

import com.shoumipay.domain.SesameCredit;
import com.shoumipay.domain.SesameCreditExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface SesameCreditMapper {
    long countByExample(SesameCreditExample example);

    int deleteByExample(SesameCreditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SesameCredit record);

    int insertSelective(SesameCredit record);

    List<SesameCredit> selectByExample(SesameCreditExample example);

    SesameCredit selectByPrimaryKey(Long id);

    SesameCredit selectByLatest(Long memberId);

    SesameCredit selectByOrderId(String orderId);

    int updateByExampleSelective(@Param("record") SesameCredit record, @Param("example") SesameCreditExample example);

    int updateByExample(@Param("record") SesameCredit record, @Param("example") SesameCreditExample example);

    int updateByPrimaryKeySelective(SesameCredit record);

    int updateByPrimaryKey(SesameCredit record);
}