package com.shoumipay.service.impl;

import com.shoumipay.constants.SmsEnum;
import com.shoumipay.domain.SmsMessage;
import com.shoumipay.domain.SmsTemplate;
import com.shoumipay.service.admin.MessageSendService;
import com.shoumipay.service.SmsMessageService;
import com.shoumipay.service.SmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017/10/19.
 */
@Service
public class MessageSendServiceImpl implements MessageSendService {
    @Autowired
    private SmsMessageService smsMessageService;
    @Autowired
    private SmsTemplateService smsTemplateService;

    @Override
    public int messSend(List<String> phoneList,SmsEnum type,Long memberid,String... content) {
        int flag = 0;
        SmsMessage smsMessage = new SmsMessage();
        SmsTemplate smsTemplate = new SmsTemplate();
        smsTemplate.setTouch(type.toString());
        List<SmsTemplate> smsTemplateList = smsTemplateService.findBySmsTemplate(smsTemplate);
        if(smsTemplateList.get(0).getEnable()!=0){
            flag = -100;
            return flag;
        }
        String conten = smsTemplateList.get(0).getContent();
        String contents = null;
        for(int i = 0;i<content.length;i++){
            contents = conten.replace("{"+i+"}",content[i]);
        }
        Date createTime = new Date();
        Integer number = phoneList.size();
        StringBuffer phonesBuffer = new StringBuffer();
        for (String phone:phoneList){
            phonesBuffer = phonesBuffer.append(phone+",");
        }
        String phones = phonesBuffer.toString();
        smsMessage.setNumber(number);
        smsMessage.setPhones(phones);
        smsMessage.setContent(contents);
        smsMessage.setCreatetime(createTime);
        smsMessage.setFlag(0);
    //    smsMessage.setFlag(1); //不要发送短信呗
        smsMessage.setMemberid(memberid);
        smsMessage.setMessagetype(1);
        smsMessage.setFailuretimes(0);
        smsMessage.setMaxfail(2);
        smsMessage.setSendplatform("1");
        if (type.equals(SmsEnum.RESET_PASSWORD)||type.equals(SmsEnum.CODE)||type.equals(SmsEnum.LOGIN)||type.equals(SmsEnum.BIND_CARD)||type.equals(SmsEnum.LOAN)){
            smsMessage.setMessagetype(1);
        } else if (type.equals(SmsEnum.REMIND_D0)||type.equals(SmsEnum.REMIND_D1)){
            smsMessage.setMessagetype(2);
        }
        smsMessage.setSendtransmission(smsTemplateList.get(0).getName());
        try{
             flag = smsMessageService.addSmsMessages(smsMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
