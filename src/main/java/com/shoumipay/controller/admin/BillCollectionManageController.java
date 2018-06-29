package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.service.admin.BillCollectionManageService;
import com.shoumipay.service.admin.DaifuOrderLegManageService;
import com.shoumipay.tools.IntegerUtil;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/billCollection")
public class BillCollectionManageController {

    @Autowired
    private BillCollectionManageService billCollectionManageService;

    @RequestMapping("")
    public String test(){
        return "billCollectionList";
    }

    @PostMapping("/billCollectionList")
    public void daifuCodeList(BillCollection billCollection, HttpServletRequest request, HttpServletResponse response) {
        String pageStr = request.getParameter("page");
        String rowsStr = request.getParameter("rows");
        Integer page = IntegerUtil.parseInt(pageStr);
        Integer rows = IntegerUtil.parseInt(rowsStr);
        List<BillCollection> list = billCollectionManageService.query(billCollection, page, rows);
        PageInfo<BillCollection> pageInfo = new PageInfo<BillCollection>(list);
        JSONObject jo = new JSONObject();
        jo.put("rows", list);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);


    }



}
