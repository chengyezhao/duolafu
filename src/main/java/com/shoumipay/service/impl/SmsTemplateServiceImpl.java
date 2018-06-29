package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.SmsTemplateMapper;
import com.shoumipay.domain.SmsTemplate;
import com.shoumipay.domain.SmsTemplateExample;
import com.shoumipay.domain.SmsTemplateExample.Criteria;
import com.shoumipay.service.SmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by Administrator on 2017/10/26.
 */
@Service
public class SmsTemplateServiceImpl implements SmsTemplateService{
    @Autowired
    private SmsTemplateMapper smsTemplateMapper;
    @Override
    public SmsTemplate findById(long id) {
        return smsTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addSmsTemplate(SmsTemplate smsTemplate) {
        return this.smsTemplateMapper.insert(smsTemplate);
    }

    @Override
    public List<SmsTemplate> findAllSmsTemplate(Map<String,String> params) {
        SmsTemplateExample smsTemplateExample = new SmsTemplateExample();
        if (params.size()>0){
            PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
            return this.smsTemplateMapper.selectByExample(smsTemplateExample);
        }
        return this.smsTemplateMapper.selectByExample(smsTemplateExample);
    }

    @Override
    public int updateSmstemplate(SmsTemplate smsTemplate) {
        return this.smsTemplateMapper.updateByPrimaryKey(smsTemplate);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return smsTemplateMapper.deleteByIds(ids);
    }

    @Override
    public List<SmsTemplate> findBySmsTemplate(SmsTemplate smsTemplate) {
        SmsTemplateExample smsTemplateExample = new SmsTemplateExample();
        Criteria criteria = smsTemplateExample.createCriteria();
        if (smsTemplate.getTouch()!=null&&smsTemplate.getTouch().trim().length()>0){
            criteria.andTouchEqualTo(smsTemplate.getTouch());
        }
        return smsTemplateMapper.selectByExample(smsTemplateExample);
    }
}
