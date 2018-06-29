package com.shoumipay.dao;

import com.shoumipay.domain.VerifyParameter;
import com.shoumipay.domain.VerifyParameterExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface VerifyParameterMapper {
    long countByExample(VerifyParameterExample example);

    int deleteByExample(VerifyParameterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VerifyParameter record);

    int insertSelective(VerifyParameter record);

    List<VerifyParameter> selectByExample(VerifyParameterExample example);

    VerifyParameter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VerifyParameter record, @Param("example") VerifyParameterExample example);

    int updateByExample(@Param("record") VerifyParameter record, @Param("example") VerifyParameterExample example);

    int updateByPrimaryKeySelective(VerifyParameter record);

    int updateByPrimaryKey(VerifyParameter record);
}