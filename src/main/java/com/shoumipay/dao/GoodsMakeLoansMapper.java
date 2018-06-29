package com.shoumipay.dao;

import com.shoumipay.domain.GoodsMakeLoans;
import com.shoumipay.domain.GoodsMakeLoansExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper @Component
public interface GoodsMakeLoansMapper {
    long countByExample(GoodsMakeLoansExample example);

    int deleteByExample(GoodsMakeLoansExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsMakeLoans record);

    int insertSelective(GoodsMakeLoans record);

    List<GoodsMakeLoans> selectByExample(GoodsMakeLoansExample example);

    List<GoodsMakeLoans> selectByOrderId(Long orderId);

    GoodsMakeLoans selectByPrimaryKey(Long id);

    GoodsMakeLoans selectByOrder(@Param("orderId") Long orderId);

    int updateByExampleSelective(@Param("record") GoodsMakeLoans record, @Param("example") GoodsMakeLoansExample example);

    int updateByExample(@Param("record") GoodsMakeLoans record, @Param("example") GoodsMakeLoansExample example);

    int updateByPrimaryKeySelective(GoodsMakeLoans record);

    int updateByPrimaryKey(GoodsMakeLoans record);

    int countLoanTimes(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Double sumLoanAmount(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}