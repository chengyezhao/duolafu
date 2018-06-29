package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.service.admin.DaifuOrderLegManageService;
import com.shoumipay.service.admin.DaifuOrderManageService;
import com.shoumipay.tools.IntegerUtil;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/daifuOrderLeg")
public class DaifuOrderLegManageController {

    @Autowired
    private DaifuOrderLegManageService daifuOrderLegManageService;

    @RequestMapping("")
    public String test(){
        return "daifuOrderLegList";
    }

    @PostMapping("/daifuOrderLegList")
    public void daifuCodeList(DaifuOrderLeg daifuOrderLeg, HttpServletRequest request, HttpServletResponse response) {
        String pageStr = request.getParameter("page");
        String rowsStr = request.getParameter("rows");
        Integer page = IntegerUtil.parseInt(pageStr);
        Integer rows = IntegerUtil.parseInt(rowsStr);
        List<DaifuOrderLeg> list = daifuOrderLegManageService.query(daifuOrderLeg, page, rows);
        PageInfo<DaifuOrderLeg> pageInfo = new PageInfo<DaifuOrderLeg>(list);
        JSONObject jo = new JSONObject();
        jo.put("rows", list);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);


    }



}
