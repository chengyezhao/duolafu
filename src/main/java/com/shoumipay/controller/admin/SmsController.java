package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.SmsMessage;
import com.shoumipay.domain.SmsTemplate;
import com.shoumipay.service.SmsMessageService;
import com.shoumipay.service.SmsTemplateService;
import com.shoumipay.tools.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Czy on 2017/10/18.
 * 短信系统页面
 */
@Controller
@RequestMapping("/sms")
public class SmsController {
    @Autowired
    private SmsMessageService smsMessageService;
    @Autowired
    SmsTemplateService smsTemplateService;

    @RequestMapping("")
    @RequiresPermissions("sms:all")
    public String sms() {
        return "sms";
    }

    @RequestMapping(value = "/querySmsList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void querySmsList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jo = new JSONObject();
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String phone = request.getParameter("phone");
        if (phone != null && phone != "" && !ValidatorUtil.isMobile(phone)) {
            jo.put("message", "手机号码非法");
            jo.put("flag", false);
            ServletUtil.createSuccessResponse(200, jo, response);
        }
        if (startTime == null && endTime == null) {
            startTime = DateUtil.formatNormalDateString(DateUtil.addTime(new Date(), -15));
            endTime = DateUtil.formatNormalDateString(new Date());
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("page", page);
        params.put("rows", rows);
        List<SmsMessage> smsList = smsMessageService.findByCreateTime(params, phone);
        PageInfo<SmsMessage> pageInfo = new PageInfo<SmsMessage>(smsList);
        jo.put("rows", smsList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    @RequestMapping(value = "/repeatSms", method = RequestMethod.POST)
    public void repeatSms(HttpServletRequest request, HttpServletResponse response) {
        String sid = request.getParameter("sid");
        int index = 0;
        try {
            SmsMessage smsMessage = smsMessageService.findById(Long.parseLong(sid));
            smsMessage.setFailuretimes(0);
            smsMessage.setFlag(0);
            index = smsMessageService.updateSmsMessages(smsMessage);
        } catch (Exception e) {
            ServletUtil.createSuccessResponse(200, index, response);
            e.printStackTrace();
        }
        // jo.put("rows", smsTemplateList);
        ServletUtil.createSuccessResponse(200, index, response);
    }

    @RequestMapping(value = "/adds", method = RequestMethod.POST)
    public void addsSms(HttpServletRequest request, HttpServletResponse response) {
        //  JSONObject jo = new JSONObject();
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        Map<String, String> params = new HashMap<String, String>();
        List<SmsTemplate> smsTemplateList = smsTemplateService.findAllSmsTemplate(params);
        // jo.put("rows", smsTemplateList);
        ServletUtil.createSuccessResponse(200, smsTemplateList, response);
    }

    /**
     * 新添短信
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addSms(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String phones = request.getParameter("phone");
        String content = request.getParameter("content");
        String name = request.getParameter("name");
        Date createtime = new Date();
        String[] phoneList = null;
        String phoneNew = "";
        if (phones.length() > 20) {
            phoneList = phones.split(",");
            for (String phone : phoneList) {
                phone = phone.replaceAll(" ", "");
                phone = phone.replaceAll("-", "");
                phone = phone.replaceAll("\\+86", "");
                phone = phone.replaceAll("\\+", "");
                if (!ValidatorUtil.isMobile(phone)) {
                    MessageUtil.failMessageFlag("手机号码非法",response);
                    return;
                }
                phoneNew += phone + ",";
            }
        } else {
            phones = phones.replaceAll(" ", "");
            phones = phones.replaceAll("-", "");
            phones = phones.replaceAll("\\+86", "");
            phones = phones.replaceAll("\\+", "");
            phones = phones.replaceAll(",", "");
            if (!ValidatorUtil.isMobile(phones)) {
                MessageUtil.failMessageFlag("手机号码非法",response);
                return;
            }
            phoneNew += phones + ",";
        }

        String message = checkInfo(phones, content);
        if (!StringUtil.isNull(message)) {
            result.put("message", message);
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }

        SmsMessage smsMessage = new SmsMessage();
        smsMessage.setPhones(phoneNew);
        smsMessage.setContent(content);
        smsMessage.setCreatetime(createtime);
        smsMessage.setFailuretimes(0);
        //暂时设置为成功 避免发送无效短信
        // smsMessage.setFlag(1);
        smsMessage.setFlag(0);
        smsMessage.setSendtransmission(name);
        smsMessage.setMaxfail(2);
        smsMessage.setSendplatform("1");
        int index = smsMessageService.addSmsMessages(smsMessage);
        if (index > 0) {
            result.put("message", "短信发送成功");
            result.put("flag", true);
        } else {
            result.put("message", "短信发送失败");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 删除短信
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteSms(HttpServletRequest request, HttpServletResponse response) {
        String ids = request.getParameter("ids");
        JSONObject result = new JSONObject();
        //删除操作
        int index = smsMessageService.deleteByIds(ids.split(","));
        if (index > 0) {
            result.put("message", "信息删除成功!");
            result.put("flag", true);
        } else {
            result.put("message", "信息删除失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    private String checkInfo(String phone, String content) {
        if (StringUtil.isNull(phone)) {
            return "手机号码不能为空!";
        }
        if (StringUtil.isNull(content)) {
            return "内容不能为空!";
        }
        return null;
    }
}
