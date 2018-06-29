package com.shoumipay.controller.admin;

/**
 * Created by Administrator on 2017/10/23.
 */

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.SmsMessage;
import com.shoumipay.service.SmsMessageService;
import com.shoumipay.tools.MessageUtil;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.tools.StringUtil;
import com.shoumipay.tools.ValidatorUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Czy on 2017/10/18.
 * 短信系统页面
 */
@Controller
@RequestMapping("/smsfind")
public class FindSmsController {
    @Autowired
    private SmsMessageService smsMessageService;

    @RequestMapping("")
    @RequiresPermissions("smsfind:all")
    public String sms() {
        return "smsfind";
    }

    @RequestMapping(value = "/findSmsList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void findSmsList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jo = new JSONObject();
        String mobile = request.getParameter("mobile");
        if (!ValidatorUtil.isMobile(mobile)) {
            MessageUtil.failMessageFlag("手机号码非法", response);
            return;
        }
        if (!StringUtil.isNull(mobile)) {
            SmsMessage smsMessage = new SmsMessage();
            smsMessage.setPhones(mobile + ",");
            List<SmsMessage> list = smsMessageService.findByPhone(smsMessage);
            PageInfo<SmsMessage> pageInfo = new PageInfo<SmsMessage>(list);
            jo.put("rows", list);
            jo.put("total", pageInfo.getPages());//总页数
            jo.put("records", pageInfo.getTotal());//查询出的总记录数
            ServletUtil.createSuccessResponse(200, jo, response);
        }
    }
}
