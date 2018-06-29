package com.shoumipay.controller.services;

import com.shoumipay.constants.SmsEnum;
import com.shoumipay.controller.tool.BasicController;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.MessageSendService;
import com.shoumipay.service.cache.SMSCacheService;
import com.shoumipay.tools.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

import static com.shoumipay.constants.SMSConstants.*;
import static com.shoumipay.tools.CalculateUtil.generateDigitRandomCode;
import static com.shoumipay.tools.Message.*;
import static com.shoumipay.tools.ValidatorUtil.isMobile;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Tang on 2017/10/23.
 */
@Controller
@RequestMapping("/services")
public class SMSController extends BasicController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private SMSCacheService smsCacheService;
    @Autowired
    private MessageSendService messageSendService;

    /**
     * 统一发送短信验证码的接口
     *
     * @param phoneNumber
     * @param flag
     * @return
     */
    @RequestMapping("/code")
    @ResponseBody  //是否需要登录注解 主要检查session
    public Message code(String phoneNumber, Integer flag) {
        Member member;
        String code;
        String log = null;
        SmsEnum sms = null;
        if (!isBlank(phoneNumber) && isMobile(phoneNumber) && null != flag) {
            member = memberService.queryByPhoneNumber(phoneNumber);
            code = generateDigitRandomCode(6); //生成随机验证码
//            code = "123456"; //生成随机验证码
            switch (flag) {
                case FLAG_REGISTER:
                    if (null != member) return new Message(FLAG_PHONE_NUMBER_ALREADY_EXIST);
                    log = "手机号：" + phoneNumber + "，注册验证码 --> " + code;
                    sms = SmsEnum.CODE;
                    break;
                case FLAG_LOGIN:
                    if (null == member) return new Message(FLAG_PHONE_NUMBER_NOT_REGISTER);
                    log = "手机号：" + phoneNumber + "，登录验证码 --> " + code;
                    sms = SmsEnum.LOGIN;
                    break;
                case FLAG_FORGET_PASSWORD:
                    if (null == member) return new Message(FLAG_PHONE_NUMBER_NOT_REGISTER);
                    log = "手机号：" + phoneNumber + "，忘记密码验证码 --> " + code;
                    sms = SmsEnum.CODE;
                    break;
                case FLAG_MODIFY_PASSWORD:
                    if (null == member) return new Message(FLAG_PHONE_NUMBER_NOT_REGISTER);
                    log = "手机号：" + phoneNumber + "，修改密码验证码 --> " + code;
                    sms = SmsEnum.RESET_PASSWORD;
                    break;
                case FLAG_MODIFY_PHONE_NUMBER:
                    if (null == member) return new Message(FLAG_PHONE_NUMBER_NOT_REGISTER);
                    log = "手机号：" + phoneNumber + "，修改手机号验证码 --> " + code;
                    sms = SmsEnum.CODE;
                    break;
                case FLAG_MODIFY_PHONE_NUMBER_TWO:
                    if (null == member) {
                        log = "手机号：" + phoneNumber + "，修改获取新手机号验证码 --> " + code;
                        sms = SmsEnum.CODE;
                        break;
                    }
                    return new Message(FLAG_PHONE_NUMBER_ALREADY_EXIST);
            }
            if (null != log && null != sms) {
                if (smsCacheService.get(flag, phoneNumber)) return new Message(FLAG_IDENTIFYING_CODE_ALREADY_SEND);
                logger.info(log);
                int index = messageSendService.messSend(Arrays.asList(phoneNumber), sms, null, code);
                if (index == 0) {
                    logger.info("绑定银行卡验证码发送失败,失败原因：插入短信数据库异常");
                    return new Message(FLAG_NORMAL_ERROR);
                }
                if (index == -100) {
                    logger.info("绑定银行卡验证码发送失败,失败原因：该短信模版已失效");
                    return new Message(FLAG_NORMAL_ERROR);
                }
                smsCacheService.save(flag, phoneNumber, code);
                return Message.success("注册验证码发送成功");
            }
        }
        return new Message(FLAG_PARAMETER_IS_INCORRECT);
    }

}
