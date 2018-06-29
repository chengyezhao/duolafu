package com.shoumipay.dao;

import com.shoumipay.domain.LevelOfRisk;
import com.shoumipay.domain.LevelOfRiskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LevelOfRiskMapper {
    long countByExample(LevelOfRiskExample example);

    int deleteByExample(LevelOfRiskExample example);

    int deleteByPrimaryKey(String levelOfRisk);

    int insert(LevelOfRisk record);

    int insertSelective(LevelOfRisk record);

    List<LevelOfRisk> selectByExample(LevelOfRiskExample example);

    LevelOfRisk selectByPrimaryKey(String levelOfRisk);

    int updateByExampleSelective(@Param("record") LevelOfRisk record, @Param("example") LevelOfRiskExample example);

    int updateByExample(@Param("record") LevelOfRisk record, @Param("example") LevelOfRiskExample example);

    int updateByPrimaryKeySelective(LevelOfRisk record);

    int updateByPrimaryKey(LevelOfRisk record);
}