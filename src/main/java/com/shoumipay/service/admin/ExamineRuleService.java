package com.shoumipay.service.admin;

import com.shoumipay.domain.ExamineRule;

import java.util.List;
import java.util.Map;

/**
 * Created by Tang on 2017/10/26.
 */
public interface ExamineRuleService {
    List<ExamineRule> selectByUsing(boolean using);
    List<ExamineRule> selectAllExamineRule(Map<String,String> param);
    ExamineRule selectById(Long id);
    int updateExamineRule(ExamineRule examineRule);
}
