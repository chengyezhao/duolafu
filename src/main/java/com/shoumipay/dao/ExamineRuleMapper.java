package com.shoumipay.dao;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.ExamineRuleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper @Component
public interface ExamineRuleMapper {
    long countByExample(ExamineRuleExample example);

    int deleteByExample(ExamineRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExamineRule record);

    int insertSelective(ExamineRule record);

    List<ExamineRule> selectByExample(ExamineRuleExample example);

    List<ExamineRule> selectByUsing(boolean using);

    ExamineRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExamineRule record, @Param("example") ExamineRuleExample example);

    int updateByExample(@Param("record") ExamineRule record, @Param("example") ExamineRuleExample example);

    int updateByPrimaryKeySelective(ExamineRule record);

    int updateByPrimaryKey(ExamineRule record);
}