package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberAgent;
import com.shoumipay.domain.User;
import com.shoumipay.service.admin.AgentService;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.UserService;
import com.shoumipay.tools.DateUtil;
import com.shoumipay.tools.MessageUtil;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.tools.StringUtil;
import com.shoumipay.vo.AgentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    AgentService agentService;
    @Autowired
    MemberService memberService;
    @Autowired
    UserService userService;

    @RequestMapping("/install")
    public String install() {
        return "agent/install";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String id = request.getParameter("id");
        String agentType = request.getParameter("agentType");
        String commision = request.getParameter("commision");
        String rate = request.getParameter("rate");
        String message = chckinfo(id, agentType, commision, rate);
        if (!StringUtil.isNull(message)) {
            MessageUtil.failMessageFlag(message, response);
            return;
        }
        Long memberId = Long.parseLong(id);
        Member member = memberService.queryByUid(memberId);
        if (member == null) {
            result.put("message", "该用户未注册");
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        MemberAgent memberAgent = new MemberAgent();
        memberAgent.setMemberId(memberId);
        memberAgent.setAgentType(Integer.parseInt(agentType));
        memberAgent.setCreatetime(new Date());
        memberAgent.setCommisionType(commision);
        memberAgent.setCommisionRate(BigDecimal.valueOf(Long.parseLong(rate)));
        try {
            int index = agentService.insertAgent(memberAgent);
            if (index > 0) {
                result.put("message", "设置代理成功");
            } else {
                result.put("message", "设置代理失败");
            }
            ServletUtil.createSuccessResponse(200, result, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/list")
    public String list() {
        return "agent/list";
    }

    @RequestMapping(value = "agent/queryList", method = RequestMethod.POST)
    public void queryList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String phoneNum = request.getParameter("id");
        String agentType = request.getParameter("agentType");
        if (agentType == "") {
            agentType = null;
        }
        Long memberId = null;
        if (!StringUtil.isNull(phoneNum)) {
            Member member = memberService.queryByPhoneNumber(phoneNum);
            if (member == null) {
                List<AgentVO> agentList = null;
                result.put("rows", agentList);
                ServletUtil.createSuccessResponse(200, result, response);
                return;
            }
            memberId = member.getUid();
        }
        if (startTime == null && endTime == null) {
            startTime = DateUtil.formatNormalDateString(DateUtil.addTime(new Date(), -30));
            endTime = DateUtil.formatNormalDateString(new Date());
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("page", page);
        params.put("rows", rows);
        List<AgentVO> agentList = agentService.queryByTimeId(params, memberId, agentType);
        PageInfo<AgentVO> pageInfo = new PageInfo<AgentVO>(agentList);
        result.put("rows", agentList);
        result.put("total", pageInfo.getPages());//总页数
        result.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, result, response);
    }

    @RequestMapping("/branch")
    public String branch() {
        return "agent/branch";
    }

    @RequestMapping(value = "agent/queryAgentVOList", method = RequestMethod.POST)
    public void queryAgentVOList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String phoneNumMember = request.getParameter("memberId");
        String phoneNumAgent = request.getParameter("agentIds");
        Long agentId = null;
        Long memberId = null;
        if (!StringUtil.isNull(phoneNumAgent)) {
            Member member = memberService.queryByPhoneNumber(phoneNumAgent);
            User user = userService.findByUsername(phoneNumAgent);
            if (member == null && user == null) {
                List<AgentVO> agentList = null;
                result.put("rows", agentList);
                ServletUtil.createSuccessResponse(200, result, response);
                return;
            }
            if (member != null) {
                agentId = member.getUid();
            } else {
                agentId = user.getUid();
            }
        }
        if (!StringUtil.isNull(phoneNumMember)) {
            Member member = memberService.queryByPhoneNumber(phoneNumMember);
            if (member == null) {
                List<AgentVO> agentList = null;
                result.put("rows", agentList);
                ServletUtil.createSuccessResponse(200, result, response);
                return;
            }
            memberId = member.getUid();
        }
        if (startTime == null && endTime == null) {
            startTime = DateUtil.formatNormalDateString(DateUtil.addTime(new Date(), -30));
            endTime = DateUtil.formatNormalDateString(new Date());
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("page", page);
        params.put("rows", rows);
        List<AgentVO> agentVOList = agentService.selectVo(params, agentId, memberId);
        if (memberId != null) {
            PageInfo<AgentVO> pageInfo = new PageInfo<AgentVO>(agentVOList);
            result.put("rows", agentVOList);
            result.put("total", pageInfo.getPages());//总页数
            result.put("records", pageInfo.getTotal());//查询出的总记录数
            result.put("message", "查询成功");
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        List<AgentVO> agentVOS = queryAgentVO(agentVOList);
        PageInfo<AgentVO> pageInfo = new PageInfo<AgentVO>(agentVOS);
        result.put("rows", agentVOS);
        result.put("total", pageInfo.getPages());//总页数
        result.put("records", pageInfo.getTotal());//查询出的总记录数
        result.put("message", "查询成功");
        ServletUtil.createSuccessResponse(200, result, response);
    }

    @RequestMapping("/commision")
    public String commision() {
        return "agent/commision";
    }

    @RequestMapping(value = "agent/queryAgentRecordList", method = RequestMethod.POST)
    public void queryAgentRecordList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String phoneNumMember = request.getParameter("memberId");
        String phoneNumAgent = request.getParameter("agentId");
        Long memberId = null;
        Long agentId = null;
        if (!StringUtil.isNull(phoneNumMember)) {
            Member member = memberService.queryByPhoneNumber(phoneNumMember);
            if (member == null) {
                List<AgentVO> agentList = null;
                result.put("rows", agentList);
                ServletUtil.createSuccessResponse(200, result, response);
                return;
            }
            memberId = member.getUid();
        }
        if (!StringUtil.isNull(phoneNumAgent)) {
            Member member = memberService.queryByPhoneNumber(phoneNumAgent);
            User user = userService.findByUsername(phoneNumAgent);
            if (member == null && user == null) {
                List<AgentVO> agentList = null;
                result.put("rows", agentList);
                ServletUtil.createSuccessResponse(200, result, response);
                return;
            }
            if (member != null) {
                agentId = member.getUid();
            } else {
                agentId = user.getUid();
            }
        }
        if (startTime == null && endTime == null) {
            startTime = DateUtil.formatNormalDateString(DateUtil.addTime(new Date(), -30));
            endTime = DateUtil.formatNormalDateString(new Date());
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        params.put("page", page);
        params.put("rows", rows);
        List<AgentVO> agentVOList = agentService.selectAgentRecordVO(params, memberId, agentId);
        PageInfo<AgentVO> pageInfo = new PageInfo<AgentVO>(agentVOList);
        result.put("rows", agentVOList);
        result.put("total", pageInfo.getPages());//总页数
        result.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, result, response);
    }

    private String chckinfo(String id, String agentType, String commision, String rate) {
        if (StringUtil.isNull(id)) {
            return "用户名不能为空";
        }
        if (StringUtil.isNull(agentType)) {
            return "代理等级不能为空";
        }
        if (StringUtil.isNull(commision)) {
            return "佣金比例不能为空";
        }
        if (StringUtil.isNull(agentType)) {
            return "统一比例不能为空";
        }
        return null;
    }

    private List<AgentVO> queryAgentVO(List<AgentVO> agentVOList) {
        List<AgentVO> list = new LinkedList<>();
        Long agentId = null;
        if (agentVOList != null && agentVOList.size() > 0) {
            for (AgentVO agentVO : agentVOList) {
                agentId = agentVO.getMemberId();
                List<AgentVO> agentList1 = agentService.selectVo(null, agentId, null);
                if (agentList1 != null && agentList1.size() > 0) {
                    for (AgentVO agentVO1 : agentList1) {
                        agentId = agentVO.getMemberId();
                        List<AgentVO> agentList2 = agentService.selectVo(null, agentId, null);
                        list.add(agentVO1);
                    }
                }
                list.add(agentVO);
            }
        }
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).getId().equals(list.get(j).getId())) {
                        list.remove(list.get(j));
                    }
                }
            }
        }
        return list;
    }
}
