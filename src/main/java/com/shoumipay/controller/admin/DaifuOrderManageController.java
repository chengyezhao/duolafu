package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.service.admin.DaifuCodeManageService;
import com.shoumipay.service.admin.DaifuOrderManageService;
import com.shoumipay.tools.IntegerUtil;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.domain.DaifuOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/daifuOrder")
public class DaifuOrderManageController {

    @Autowired
    private DaifuOrderManageService daifuOrderManageService;

    @RequestMapping("")
    public String test(){
        return "daifuOrderList";
    }

    @PostMapping("/daifuOrderList")
    public void daifuCodeList(DaifuOrder daifuOrder, HttpServletRequest request, HttpServletResponse response) {
        String pageStr = request.getParameter("page");
        String rowsStr = request.getParameter("rows");
        Integer page = IntegerUtil.parseInt(pageStr);
        Integer rows = IntegerUtil.parseInt(rowsStr);
        List<DaifuOrder> list = daifuOrderManageService.query(daifuOrder, page, rows);
        PageInfo<DaifuOrder> pageInfo = new PageInfo<DaifuOrder>(list);
        JSONObject jo = new JSONObject();
        jo.put("rows", list);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }


    @PostMapping("/updateDaifuOrder")
    public void updateDaifuCode(DaifuOrder daifuOrder, HttpServletResponse response) {
        int index = 0;
        String result = "success";
        if (daifuOrder.getOrderId() != 0) {
            index = daifuOrderManageService.update(daifuOrder);
        }
        if (index != 1) {
            result = "fail";
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }



}
