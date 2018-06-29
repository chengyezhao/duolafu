package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.Notice;
import com.shoumipay.domain.User;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.NoticeService;
import com.shoumipay.service.admin.UserService;
import com.shoumipay.tools.*;
import com.shoumipay.vo.MessageVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    MemberService memberService;
    @Autowired
    UserService userService;

    @RequestMapping("")
    @RequiresPermissions("message:all")
    public String message() {
        return "message";
    }

    @RequestMapping(value = "/queryMessageList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void querySmsList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jo = new JSONObject();
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
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
        if ("admin".equals(processor)) {
            notice.setProcessor(9L);
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
            List<MessageVO> messageVOList = new LinkedList<MessageVO>();
            for (Notice notice1 : noticeList) {
                Long id = notice1.getAcceptor();
                Long mid = notice1.getProcessor();
                String name = "";
                String mname = "";
                if (id != null && mid != null) {
                    Member member = memberService.queryByUid(id);
                    User user = userService.findByUid(mid);
                    if (member != null) {
                        name = member.getName();
                    }
                    if (user != null) {
                        mname = user.getName();
                    }
                }
                MessageVO messageVO = new MessageVO(notice1);
                messageVO.setAcceptor(name);
                messageVO.setProcessor(mname);
                messageVOList.add(messageVO);
            }
            PageInfo<Notice> pageInfo = new PageInfo<Notice>(noticeList);
            jo.put("rows", messageVOList);
            jo.put("total", pageInfo.getPages());//总页数
            jo.put("records", pageInfo.getTotal());//查询出的总记录数
            ServletUtil.createSuccessResponse(200, jo, response);
        }
    }

    /**
     * 新添系统消息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addNotice(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String acceptor = request.getParameter("acceptor");
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String message = checkInfo(acceptor, type, title, content);
        String more = "";
        Long processor = UserUtil.getLoginUserId();
        Byte active = 0;
        if (!StringUtil.isNull(message)) {
            MessageUtil.failMessageFlag(message, response);
            return;
        }
        Member member = memberService.queryByUid(Long.parseLong(acceptor));
        if (member == null) {
            result.put("message", "该收件人不存在");
            ServletUtil.createSuccessResponse(200, result, response);
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
        notice.setAcceptor(Long.parseLong(acceptor));
        int index = noticeService.addNotice(notice);
        if (index > 0) {
            result.put("message", "系统消息添加成功!");
            result.put("flag", true);
        } else {
            result.put("message", "系统消息添加失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 修改系统消息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public void updateNotice(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String id = request.getParameter("id");
        Notice notice = noticeService.selectByPrimaryKey(Long.parseLong(id));
        String acceptor = request.getParameter("acceptor");
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String message = checkInfo(acceptor, type, title, content);
        String more = "";
        Long processor = UserUtil.getLoginUserId();
        Byte active = 0;
        if (!StringUtil.isNull(message)) {
            MessageUtil.failMessageFlag(message, response);
            return;
        }
        Member member = memberService.queryByUid(Long.parseLong(acceptor));
        if (member == null) {
            result.put("message", "该收件人不存在");
            ServletUtil.createSuccessResponse(200, result, response);
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
        notice.setAcceptor(Long.parseLong(acceptor));
        int index = noticeService.updateNotice(notice);
        if (index > 0) {
            result.put("message", "系统消息修改成功!");
            result.put("flag", true);
        } else {
            result.put("message", "系统消息修改失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 删除系统消息
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
            result.put("message", "系统消息删除成功!");
            result.put("flag", true);
        } else {
            result.put("message", "系统消息删除失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    private String checkInfo(String acceptor, String type, String title, String content) {
        if (StringUtil.isNull(acceptor)) {
            return "收件人不能为空!";
        }
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
