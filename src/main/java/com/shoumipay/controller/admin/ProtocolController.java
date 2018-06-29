package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.Contract;
import com.shoumipay.service.admin.ContractService;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.tools.ServletUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhw on 2017/11/14.
 */
@Controller
@RequestMapping("/protocol")
public class ProtocolController {
    @Autowired
    ContractService contractService;
    @Autowired
    MemberService memberService;

    @RequestMapping("")
    @RequiresPermissions("protocol:all")
    public String protocol() {
        return "protocol";
    }

    @RequestMapping("/select")
    public String protocolSelect() {
        return "protocolSelect";
    }

    @RequestMapping(value = "protocol/selectList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void selectList(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> param = new HashMap<String, String>();
        JSONObject jo = new JSONObject();
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String idCard = request.getParameter("idCard");
        param.put("page", page);
        param.put("rows", rows);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        List<Contract> contractList = contractService.queryByIdTime(idCard, param);
        PageInfo<Contract> pageInfo = new PageInfo<Contract>(contractList);
        jo.put("rows", contractList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    @RequestMapping(value = "protocol/userProtocol", method = RequestMethod.POST)
    public void prepayment(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Contract contract = contractService.queryById(Long.parseLong(id));
        String content = contract.getContent();
        content = content.replaceAll("\"", "\'");
        content = content.replaceAll("\\n' +", "");
        ServletUtil.createSuccessResponse(200, content, response);
    }
}
