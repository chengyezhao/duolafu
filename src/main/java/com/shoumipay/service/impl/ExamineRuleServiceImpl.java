package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.ExamineRuleMapper;
import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.ExamineRuleExample;
import com.shoumipay.service.admin.ExamineRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tang on 2017/10/26.
 */
@Service
public class ExamineRuleServiceImpl implements ExamineRuleService {
    @Autowired
    private ExamineRuleMapper examineRuleMapper;


    @Override
    public List<ExamineRule> selectByUsing(boolean using) {
        return examineRuleMapper.selectByUsing(using);
    }

    @Override
    public List<ExamineRule> selectAllExamineRule(Map<String, String> param) {
        ExamineRuleExample examineRuleExample = new ExamineRuleExample();
        if (param.size()>0){
            PageHelper.startPage(Integer.parseInt(param.get("page").toString()), Integer.parseInt(param.get("rows").toString()));
            return this.examineRuleMapper.selectByExample(examineRuleExample);
        }
        return this.examineRuleMapper.selectByExample(examineRuleExample);
    }

    @Override
    public ExamineRule selectById(Long id) {
        return examineRuleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateExamineRule(ExamineRule examineRule) {
        return examineRuleMapper.updateByPrimaryKeySelective(examineRule);
    }
}
