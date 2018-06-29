package com.shoumipay.task;


import com.shoumipay.domain.SmsConfig;
import com.shoumipay.domain.SmsMessage;
import com.shoumipay.service.SmsConfigService;
import com.shoumipay.service.SmsMessageService;
import com.shoumipay.service.SmsSendService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Configuration
@EnableScheduling
public class SmsTask {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SmsMessageService smsMessageService;
    @Autowired
    private SmsConfigService smsConfigService;
    @Autowired
    private SmsSendService smsSendService;

    @Scheduled(cron = "0/5 * * * * *")//每5秒运行一次
    private void sendSms() {
        SmsMessage smsMessage = new SmsMessage();
        smsMessage.setFlag(0);
        smsMessage.setFailuretimes(2);
        List<SmsMessage> SmsList = smsMessageService.findByFlag(smsMessage);
        for (SmsMessage sms : SmsList) {
            String phones = sms.getPhones();
            String content = sms.getContent();
            Integer failTimes = sms.getFailuretimes();
            Integer maxFail = sms.getMaxfail();
            if (failTimes < maxFail) {
                //短信发送
                if (sms.getSendtransmission().equals("ipyy-通知") || sms.getSendtransmission().equals("ipyy-营销")) {
                    JSONObject jsonObject = smsSendService.sendhx(phones, content, sms.getSendtransmission());
                    String returnstatus = jsonObject.get("returnstatus").toString();
                    String remainpoint = jsonObject.get("remainpoint").toString();
                    String message = jsonObject.get("message").toString();
                    if (returnstatus.equals("Success")) {
                        SmsConfig smsConfig = new SmsConfig();
                        smsConfig.setName(sms.getSendtransmission());
                        List<SmsConfig> smsConfigList = smsConfigService.findBySmsConfig(smsConfig);
                        smsConfigList.get(0).setRemainpoint(remainpoint);
                        smsConfigService.updateConfig(smsConfigList.get(0));
                        sms.setSendtime(new Date());
                        sms.setFlag(1);
                        sms.setCode(message);
                        smsMessageService.updateSmsMessages(sms);
                        logger.info("短信发送成功" + sms.getPhones());
                    } else {
                        sms.setSendtime(new Date());
                        sms.setFailuretimes(failTimes + 1);
                        sms.setCode(message);
                        smsMessageService.updateSmsMessages(sms);
                        logger.info("短信发送失败" + sms.getPhones());
                    }
                } else if (sms.getSendtransmission().equals("253-通知") || sms.getSendtransmission().equals("253-营销")) {
                    JSONObject jo = smsSendService.sendyxt(phones, content, sms.getSendtransmission());
                    String errorMsg = jo.get("errorMsg").toString();
                    String code = jo.get("code").toString();
                    if (errorMsg == null) {
                        SmsConfig smsConfig = new SmsConfig();
                        smsConfig.setName(sms.getSendtransmission());
                        List<SmsConfig> smsConfigList = smsConfigService.findBySmsConfig(smsConfig);
                        smsConfigList.get(0).setRemainpoint(jo.get("balance").toString());
                        smsConfigService.updateConfig(smsConfigList.get(0));
                        sms.setSendtime(new Date());
                        sms.setFlag(1);
                        sms.setCode(code);
                        smsMessageService.updateSmsMessages(sms);
                        logger.info("短信发送成功" + sms.getPhones());
                    } else {
                        sms.setSendtime(new Date());
                        sms.setFailuretimes(failTimes + 1);
                        sms.setCode(code);
                        smsMessageService.updateSmsMessages(sms);
                        logger.info("短信发送失败" + sms.getPhones());
                    }
                }
            } else {
                logger.info("短信发送失败次数高于最大失败次数，不再重复发送" + sms.getPhones());
            }
        }
    }
}
