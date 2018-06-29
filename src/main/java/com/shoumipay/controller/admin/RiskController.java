package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.ExamineRule;
import com.shoumipay.service.admin.ExamineRuleService;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.tools.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tang on 2017/10/27.
 */
@Controller
@RequestMapping("/risk/userLevelRiskCalc")
public class RiskController {
    @Autowired
    ExamineRuleService examineRuleService;

    @RequestMapping("")
    public String examine() {
        return "risk/userLevelRiskCalc";
    }

    @PostMapping("/queryExamineRuleList")
    public void queryExamineRuleList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jo = new JSONObject();
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("page", page);
        params.put("rows", rows);
        List<ExamineRule> examineRuleList = examineRuleService.selectAllExamineRule(params);
        PageInfo<ExamineRule> pageInfo = new PageInfo<ExamineRule>(examineRuleList);
        jo.put("rows", examineRuleList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }


    /**
     * 修改风控参数
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    //@RequiresPermissions("learn:updateByPrimaryKey")//权限管理;
    public void updateLearn(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        Boolean usings = null;
        String id = request.getParameter("id");
        ExamineRule examineRule = examineRuleService.selectById(Long.parseLong(id));
        String using = request.getParameter("using");
        String parameter = request.getParameter("parameter");
        String match = request.getParameter("match");
        String unmatch = request.getParameter("unmatch");
        Long processor = UserUtil.getLoginUserId();
        if (using.equals("启用")) {
            usings = true;
        } else {
            usings = false;
        }
        examineRule.setUsing(usings);
        examineRule.setProcessor(processor);
        examineRule.setParameter(parameter);
        examineRule.setMatch(Integer.parseInt(match));
        examineRule.setUnmatch(Integer.parseInt(unmatch));
        int index = examineRuleService.updateExamineRule(examineRule);
        if (index > 0) {
            result.put("message", "风控参数修改成功!");
            result.put("flag", true);
//            examineTask.setExamineServiceList(null);
        } else {
            result.put("message", "风控参数修改失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }
}
