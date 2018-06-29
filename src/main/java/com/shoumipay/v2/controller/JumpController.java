package com.shoumipay.v2.controller;

import com.alibaba.druid.util.StringUtils;
import com.shoumipay.domain.Config;
import com.shoumipay.service.admin.ConfigService;
import com.shoumipay.service.RedisService;
import com.shoumipay.tools.wechat.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/j")
public class JumpController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConfigService configService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value="/",method= RequestMethod.GET)
    @Permission(loginReqired=false)
    public String redirect(@RequestParam("id") String id,
                           HttpServletRequest request, HttpServletResponse response){
        if(StringUtils.isEmpty(id) || id.length() > 100){
            return "error";
        }
        Config partner = configService.selectByKey("PARTNER." + id);
        if (partner == null) {
            return "error";
        }
        String ipAddress = request.getHeader("X-Real-IP");
        String userAgent = request.getHeader("X-Real-AGENT");
        try {
            logger.info("partner redirect|" + ipAddress + "|" + userAgent + "|" + partner.getValue());
            return "redirect:"  + partner.getValue();
        }catch (Exception e){
            logger.info("partner redirect failed |" + ipAddress + "|" + userAgent + "|" + partner.getValue());
            return "error";
        }
    }

    @RequestMapping(value="/v",method= RequestMethod.GET)
    @Permission(loginReqired=false)
    public String redirectV2(HttpServletRequest request, HttpServletResponse response){
        return "daoliu/jump";
    }
}
