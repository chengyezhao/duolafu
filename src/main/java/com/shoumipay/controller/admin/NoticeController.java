package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.Notice;
import com.shoumipay.service.admin.NoticeService;
import com.shoumipay.tools.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统公告页面
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @RequestMapping("")
    @RequiresPermissions("notice:all")
    public String notice() {
        return "notice";
    }

    @RequestMapping(value = "/queryNoticeList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void querySmsList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jo = new JSONObject();
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String type = request.getParameter("types");
        String processor = request.getParameter("process");
        Byte active = 0;
        Map<String, String> params = new HashMap<String, String>();
        params.put("page", page);
        params.put("rows", rows);
        Notice notice = new Notice();
        notice.setActive(active);
        if (("admin").equals(processor)) {
            notice.setProcessor(9l);
        } else {
            notice.setProcessor(null);
        }
        notice.setType(type);
        if ("".equals(startTime) && "".equals(endTime) || startTime == null && endTime == null) {
            startTime = DateUtil.formatNormalDateString(DateUtil.addTime(new Date(), -360));
            endTime = DateUtil.formatNormalDateString(new Date());
        }
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        if (!StringUtil.isNull(startTime) && !StringUtil.isNull(endTime)) {
            List<Notice> noticeList = noticeService.findByNotice(notice, params);
            PageInfo<Notice> pageInfo = new PageInfo<Notice>(noticeList);
            jo.put("rows", noticeList);
            jo.put("total", pageInfo.getPages());//总页数
            jo.put("records", pageInfo.getTotal());//查询出的总记录数
            ServletUtil.createSuccessResponse(200, jo, response);
        }
    }

    /**
     * 新添系统公告
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    //@RequiresPermissions("learn:add")//权限管理;
    public void addNotice(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String more = "";
        String message = checkInfo(type, title, content);
        Long processor = UserUtil.getLoginUserId();
        Byte active = 0;
        if (!StringUtil.isNull(message)) {
            MessageUtil.failMessageFlag(message,response);
            return;
        }
        if (content.length() > 40) {
            more = content.substring(0, 40);
        } else {
            more = content;
        }
        Notice notice = new Notice();
        notice.setType(type);
        notice.setActive(active);
        notice.setContent(content);
        notice.setMore(more);
        notice.setTitle(title);
        notice.setCreateTime(new Date());
        notice.setProcessor(processor);
        int index = noticeService.addNotice(notice);
        if (index > 0) {
            result.put("message", "系统公告添加成功!");
            result.put("flag", true);
        } else {
            result.put("message", "系统公告添加失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 修改系统公告
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    //@RequiresPermissions("learn:add")//权限管理;
    public void updateNotice(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String id = request.getParameter("id");
        Notice notice = noticeService.selectByPrimaryKey(Long.parseLong(id));
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String message = checkInfo(type, title, content);
        String more = "";
        Long processor = UserUtil.getLoginUserId();
        Byte active = 0;
        if (!StringUtil.isNull(message)) {
            MessageUtil.failMessageFlag(message,response);
            return;
        }
        if (content.length() > 40) {
            more = content.substring(0, 40);
        } else {
            more = content;
        }
        notice.setProcessor(processor);
        notice.setType(type);
        notice.setActive(active);
        notice.setTitle(title);
        notice.setContent(content);
        notice.setMore(more);
        int index = noticeService.updateNotice(notice);
        if (index > 0) {
            result.put("message", "系统公告修改成功!");
            result.put("flag", true);
        } else {
            result.put("message", "系统公告修改失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 删除系统公告
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void deleteNotice(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("ids");
        Notice notice = noticeService.selectByPrimaryKey(Long.parseLong(id));
        notice.setActive(Byte.parseByte("1"));
        JSONObject result = new JSONObject();
        //删除操作
        int index = noticeService.updateNotice(notice);
        if (index > 0) {
            result.put("message", "系统公告删除成功!");
            result.put("flag", true);
        } else {
            result.put("message", "系统公告删除失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    private String checkInfo(String type, String title, String content) {
        if (StringUtil.isNull(type)) {
            return "类型不能为空!";
        }
        if (StringUtil.isNull(title)) {
            return "标题不能为空!";
        }
        if (StringUtil.isNull(content)) {
            return "内容不能为空!";
        }
        return null;
    }
}
