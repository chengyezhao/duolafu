package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.SmsMessageMapper;
import com.shoumipay.domain.SmsMessage;
import com.shoumipay.domain.SmsMessageExample;
import com.shoumipay.domain.SmsMessageExample.Criteria;
import com.shoumipay.service.SmsMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/17.
 */
@Service
public class SmsMessageServiceImpl implements SmsMessageService {
    @Autowired
    private SmsMessageMapper smsMessageMapper;

    @Override
    public int deleteByIds(String[] ids) {
        return this.smsMessageMapper.deleteByIds(ids);
    }

    @Override
    public List<SmsMessage> findByFlag(SmsMessage smsMessage) {
        SmsMessageExample smsMessageExample = new SmsMessageExample();
        Criteria criteria = smsMessageExample.createCriteria();
        proSearchParam(smsMessage, criteria);
        return smsMessageMapper.selectByExample(smsMessageExample);
    }

    @Override
    public List<SmsMessage> findByCreateTime(Map<String, String> params,String phone) {
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startTime = null;
        Date endTime = null;
        try {
            if (params.get("startTime")!=""&&params.get("endTime")!="") {
                 startTime = bartDateFormat.parse(params.get("startTime"));
                 endTime = bartDateFormat.parse(params.get("endTime"));
            }
            SmsMessageExample smsMessageExample = new SmsMessageExample();
            Criteria criteria = smsMessageExample.createCriteria();
            if(phone!=null&&phone!=""){
                criteria.andPhonesLike(phone+",");
            }
            if (startTime != null && endTime != null) {
                criteria.andCreatetimeBetween(startTime, endTime);
            }
            PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
            return smsMessageMapper.selectByExample(smsMessageExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SmsMessage findById(long sid) {
        return smsMessageMapper.selectByPrimaryKey(sid);
    }

    @Override
    public int addSmsMessages(SmsMessage smsMessage) {
        return smsMessageMapper.insert(smsMessage);
    }

    @Override
    public int updateSmsMessages(SmsMessage smsMessage) {
        return this.smsMessageMapper.updateByPrimaryKeySelective(smsMessage);
    }

    @Override
    public List<SmsMessage> findByPhone(SmsMessage smsMessage) {
        SmsMessageExample smsMessageExample = new SmsMessageExample();
        Criteria criteria = smsMessageExample.createCriteria();
        if(smsMessage.getPhones()!=null){
            criteria.andPhonesLike(smsMessage.getPhones());
        }
        return this.smsMessageMapper.selectByExample(smsMessageExample);
    }

    @Override
    public int delSmsMessages(long sid) {
        return smsMessageMapper.deleteByPrimaryKey(sid);
    }

    /**
     * 处理查询条件
     */
    private void proSearchParam(SmsMessage smsMessage, SmsMessageExample.Criteria criteria) {
        if (smsMessage != null) {
            if (smsMessage.getFlag() != null) {
                criteria.andFlagEqualTo(smsMessage.getFlag());
            }
            if (smsMessage.getFailuretimes()!=null){
                criteria.andFailuretimesLessThan(smsMessage.getFailuretimes());
            }
        }
    }
}
