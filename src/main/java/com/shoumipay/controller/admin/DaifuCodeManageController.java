package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.Goods;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.service.admin.DaifuCodeManageService;
import com.shoumipay.tools.IntegerUtil;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.tools.StringUtil;
import com.shoumipay.tools.UserUtil;
import com.shoumipay.v2.domain.DaifuCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/daifuCode")
public class DaifuCodeManageController {

    @Autowired
    private DaifuCodeManageService daifuCodeManageService;

    @RequestMapping("")
    public String test(){
        return "daifuCodeList";
    }

    @PostMapping("/daifuCodeList")
    public void daifuCodeList(DaifuCode daifuCode, HttpServletRequest request, HttpServletResponse response) {
        String pageStr = request.getParameter("page");
        String rowsStr = request.getParameter("rows");
        Integer page = IntegerUtil.parseInt(pageStr);
        Integer rows = IntegerUtil.parseInt(rowsStr);
        List<DaifuCode> list = daifuCodeManageService.query(daifuCode,page, rows);
        PageInfo<DaifuCode> pageInfo = new PageInfo<DaifuCode>(list);
        JSONObject jo = new JSONObject();
        jo.put("rows", list);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);


    }


    @PostMapping("/updateDaifuCode")
    public void updateDaifuCode(DaifuCode daifuCode, HttpServletResponse response) {
        int index = 0;
        String result = "success";
        if (daifuCode.getCodeId() != 0) {
            index = daifuCodeManageService.update(daifuCode);
        }
        if (index != 1) {
            result = "fail";
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }


}
