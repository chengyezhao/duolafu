package com.shoumipay.v2.controller;

import com.alibaba.druid.util.StringUtils;
import com.shoumipay.domain.Registration;
import com.shoumipay.service.RegistrationService;
import com.shoumipay.tools.IntegerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String keySesame = "YX_ZHIMAFENG_MING";
    private final String keyUrl = "YX_3RD_URL";
    private final String keyWX = "YX_WX_URL";

    @RequestMapping(value="/",method= RequestMethod.GET  )
    public String index(){
        return "daoliu/index";
    }

    @RequestMapping(value="/index",method= RequestMethod.GET  )
    public String home(){
        return "daoliu/index";
    }

    @RequestMapping(value="/save",method= RequestMethod.POST  )
    public String save(Registration registration,HttpServletRequest request,HttpServletResponse response){

        // 检查数据
        if(!registration.verify()){
            return "redirect:/registration/";
        }

        //保存到数据库
        registrationService.save(registration);
        //获取个人芝麻分
        String sesame = registration.getSesame();
        String jobHours = registration.getJobHours();
        //获取借款用途
        String instructions =  registration.getInstructions();

        logger.info("个人芝麻分:" + sesame + "---------------------");
        logger.info("工作时间："+jobHours+"------------");

        //获取芝麻分等级
        String valueSesame = registrationService.selectByKey(keySesame);
        //获取到第三方连接
        String valueUrl = registrationService.selectByKey(keyUrl);
        //微信跳转链接
        String wxUrl = registrationService.selectByKey(keyWX);

        if(StringUtils.isEmpty(valueSesame)){
            return "redirect:/registration/";
        }
        if(StringUtils.isEmpty(valueUrl)){
            return "redirect:/registration/";
        }
        if(StringUtils.isEmpty(wxUrl)){
            return "redirect:/registration/";
        }

        logger.info("芝麻分等级:" + valueSesame +"--------------------");

        if ( IntegerUtil.parseInt(sesame).intValue()<IntegerUtil.parseInt(valueSesame).intValue()){
            logger.info("你的芝麻分较低--------------------");
            return "redirect:" + valueUrl;
        }else{
            if ("现金提现".equals(instructions)){
                logger.info("你选择了现金提现--------------------");
                return "redirect:" +  valueUrl;
            }else {
                logger.info("你进入了微信--------------------");
                return "redirect:" +  wxUrl;
            }
        }
    }

}
