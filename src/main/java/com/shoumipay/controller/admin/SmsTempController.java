package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.SmsTemplate;
import com.shoumipay.service.SmsTemplateService;
import com.shoumipay.tools.MessageUtil;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.tools.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Czy on 2017/10/28.
 * 短信配置
 */
@Controller
@RequestMapping("/smstemp")
public class SmsTempController {
    @Autowired
    SmsTemplateService smsTemplateService;

    @RequestMapping("")
    @RequiresPermissions("smstemp:all")
    public String smsTemp() {
        return "smstemp";
    }

    @PostMapping("/querySmsTempList")
    public void querySmsTempList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jo = new JSONObject();
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("page", page);
        params.put("rows", rows);
        List<SmsTemplate> smsTemplateList = smsTemplateService.findAllSmsTemplate(params);
        PageInfo<SmsTemplate> pageInfo = new PageInfo<SmsTemplate>(smsTemplateList);
        jo.put("rows", smsTemplateList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    @RequestMapping(value = "/adds", method = RequestMethod.POST)
    public void addsSms(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> params = new HashMap<String, String>();
        List<SmsTemplate> smsTemplateList = smsTemplateService.findAllSmsTemplate(params);
        // jo.put("rows", smsTemplateList);
        for (int i = 0; i < smsTemplateList.size() - 1; i++) {
            for (int j = smsTemplateList.size() - 1; j > i; j--) {
                if (smsTemplateList.get(j).getTouch().equals(smsTemplateList.get(i).getTouch())) {
                    smsTemplateList.remove(j);
                }
            }
        }
        ServletUtil.createSuccessResponse(200, smsTemplateList, response);
    }

    /**
     * 新添短信模版
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    //@RequiresPermissions("learn:add")//权限管理;
    public void addSmsTemplate(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String templatetype = request.getParameter("templatetype");
        String touch = request.getParameter("touch");
        String content = request.getParameter("content");
        String instruction = request.getParameter("instruction");
        String name = request.getParameter("name");
        String enable = request.getParameter("enable");
        String message = checkInfo(templatetype, touch, content, instruction, name, enable);
        if (!StringUtil.isNull(message)) {
            MessageUtil.failMessageFlag(message,response);
            return;
        }
        SmsTemplate smsTemplate = new SmsTemplate();
        smsTemplate.setTouch(touch);
        smsTemplate.setTemplatetype(templatetype);
        smsTemplate.setContent(content);
        smsTemplate.setInstruction(instruction);
        smsTemplate.setName(name);
        smsTemplate.setEnable(Integer.parseInt(enable));
        int index = smsTemplateService.addSmsTemplate(smsTemplate);
        if (index > 0) {
            result.put("message", "模版添加成功!");
            result.put("flag", true);
        } else {
            result.put("message", "模版添加失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 修改短信模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    //@RequiresPermissions("learn:updateByPrimaryKey")//权限管理;
    public void updateLearn(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String id = request.getParameter("id");
        SmsTemplate smsTemplate = smsTemplateService.findById(Long.parseLong(id));
        String templatetype = request.getParameter("templatetype");
        String touch = request.getParameter("touch");
        String content = request.getParameter("content");
        String instruction = request.getParameter("instruction");
        String name = request.getParameter("name");
        String enable = request.getParameter("enable");
        String message = checkInfo(templatetype, touch, content, instruction, name, enable);
        if (!StringUtil.isNull(message)) {
            MessageUtil.failMessageFlag(message,response);
            return;
        }
        smsTemplate.setTouch(touch);
        smsTemplate.setEnable(Integer.parseInt(enable));
        smsTemplate.setTemplatetype(templatetype);
        smsTemplate.setContent(content);
        smsTemplate.setInstruction(instruction);
        smsTemplate.setName(name);
        int index = smsTemplateService.updateSmstemplate(smsTemplate);
        if (index > 0) {
            result.put("message", "模版修改成功!");
            result.put("flag", true);
        } else {
            result.put("message", "模版修改失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 删除短信模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String ids = request.getParameter("ids");
        JSONObject result = new JSONObject();
        //删除操作
        int index = smsTemplateService.deleteByIds(ids.split(","));
        if (index > 0) {
            result.put("message", "模版删除成功!");
            result.put("flag", true);
        } else {
            result.put("message", "模版删除失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    private String checkInfo(String templatetype, String touch, String content, String instruction, String name, String enable) {
        if (StringUtil.isNull(templatetype)) {
            return "模板类型不能为空!";
        }
        if (StringUtil.isNull(touch)) {
            return "触发条件不能为空!";
        }
        if (StringUtil.isNull(content)) {
            return "模板内容不能为空!";
        }
        if (StringUtil.isNull(instruction)) {
            return "说明不能为空!";
        }
        if (StringUtil.isNull(name)) {
            return "发送通道不能为空!";
        }
        if (StringUtil.isNull(enable)) {
            return "是否有效不能为空!";
        }
        return null;
    }

}
