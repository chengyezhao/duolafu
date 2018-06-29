package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.*;
import com.shoumipay.service.admin.GoodsService;
import com.shoumipay.tools.IntegerUtil;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.tools.UserUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhw on 2017/10/23.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("")
    public String goods() {
        return "goods-list";
    }


    @PostMapping("/queryGoodsList")
    public void queryGoodsList(Goods goods, HttpServletResponse response, HttpServletRequest request) {
        String pageStr = request.getParameter("page");
        String rowStr = request.getParameter("rows");
        Integer page = IntegerUtil.parseInt(pageStr);
        Integer rows = IntegerUtil.parseInt(rowStr);
        List<Goods> goodsList = goodsService.queryGoods(goods, page, rows);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodsList);
        JSONObject jo = new JSONObject();
        jo.put("rows", goodsList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    @PostMapping("/addGoods")
    public void addGoods(Goods goods, HttpServletResponse response) {
        int index = 0;
        String result = "success";
        if (goods.getId() != null) {
            index = goodsService.uppGoods(goods);
        } else {
            goods.setAddtime(new Date());
            goods.setUpptime(new Date());
            goods.setUppname(UserUtil.getLoginUserName());
            index = goodsService.addGoods(goods);
        }
        if (index != 1) {
            result = "fail";
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    @PostMapping("/queryGoodsCostsByGoodsId")
    public void queryGoodsCostsByGoodsId(Long goodsId, HttpServletResponse response) {
        List<GoodsCosts> goodsCostsList = goodsService.getGoodsCostsByGoodsId(goodsId);
        ServletUtil.createSuccessResponse(200, goodsCostsList, response);
    }

    @PostMapping("/addGoodsCosts")
    public void addGoodsCosts(GoodsCosts goodsCosts, HttpServletResponse response) {
        if (goodsCosts.getId() != null) {
            goodsService.uppGoodsCost(goodsCosts);
        } else {
            goodsService.addGoodsCost(goodsCosts);
        }
        ServletUtil.createSuccessResponse(200, "success", response);
    }

    @RequestMapping("/order")
    @RequiresPermissions("order:all")//权限管理;
    public String order() {
        return "order-list";
    }

    @PostMapping("/queryOrderList")
    public void queryOrderList(GoodsOrder goodsOrder, HttpServletRequest request, HttpServletResponse response) {
        String pageStr = request.getParameter("page");
        String rowsStr = request.getParameter("rows");
        Integer page = IntegerUtil.parseInt(pageStr);
        Integer rows = IntegerUtil.parseInt(rowsStr);
        List<GoodsOrder> goodsOrderList = goodsService.queryOrder(goodsOrder, page, rows);
        PageInfo<GoodsOrder> pageInfo = new PageInfo<GoodsOrder>(goodsOrderList);
        JSONObject jo = new JSONObject();
        jo.put("rows", goodsOrderList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    @GetMapping("/getOrderIdRepaymentPay")
    public void getOrderIdRepaymentPay(Long orderId, HttpServletResponse response) {
        List<GoodsRepayment> goodsRepaymentList = goodsService.queryRepaymentByOrderId(orderId);
        ServletUtil.createSuccessResponse(200, goodsRepaymentList, response);
    }

    @PostMapping("getRepaymentPlanByOrderId")
    public void getRepaymentPlanByOrderId(Long orderId, HttpServletResponse response) {
        List<GoodsRepaymentPlan> goodsRepaymentPlanList = goodsService.queryRepaymentPlanByOrderId(orderId);
        ServletUtil.createSuccessResponse(200, goodsRepaymentPlanList, response);
    }

    @PostMapping("getCollectionByOrderId")
    public void getCollectionByOrderId(Long orderId, HttpServletResponse response) {
        List<GoodsRepaymentCollection> goodsRepaymentCollectionList = goodsService.queryControllerByOrderId(orderId);
        ServletUtil.createSuccessResponse(200, goodsRepaymentCollectionList, response);
    }

    @PostMapping("getMakeLoansByOrderId")
    public void getMakeLoansByOrderId(Long orderId, HttpServletResponse response) {
        List<GoodsMakeLoans> goodsMakeLoansList = goodsService.queryMakeLoansByOrderId(orderId);
        ServletUtil.createSuccessResponse(200, goodsMakeLoansList, response);
    }
}
