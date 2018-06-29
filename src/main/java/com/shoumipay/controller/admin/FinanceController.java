package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.*;
import com.shoumipay.service.admin.BankAccountService;
import com.shoumipay.service.admin.FinanceService;
import com.shoumipay.service.admin.GoodsService;
import com.shoumipay.tools.DateUtil;
import com.shoumipay.tools.ServletUtil;
import com.shoumipay.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhw on 2017/11/20.
 * 财务中心
 */
@Controller
@RequestMapping("/finance")
public class FinanceController {
    @Autowired
    private FinanceService financeService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private BankAccountService bankAccountService;

    //流量监控
    @RequestMapping("/netraffic")
    public String netraffic(Model model) {
        List<Goods> goodsList = goodsService.queryGoods(null, null, null);
        model.addAttribute("goodsList", goodsList);
        return "netraffic";
    }

    //流量监控
    @PostMapping("/netraffic/list")
    public void netrafficList(Integer page, Integer rows, Long goodsId, String channel, String startTime, String endTime, HttpServletResponse response) {
        Netraffic netraffic = new Netraffic();
        netraffic.setGoodsId(goodsId);
        netraffic.setChannel(channel);
        Date startTimeD = null;
        Date endTimeD = null;
        if (!StringUtil.isNull(startTime) && !StringUtil.isNull(endTime)) {
            startTimeD = DateUtil.parse(startTime, DateUtil.DEFAULT_DATE_TIME2);
            endTimeD = DateUtil.parse(endTime, DateUtil.DEFAULT_DATE_TIME2);
        }
        List<Netraffic> netrafficList = new ArrayList<>();
        if (page == 1) {
            Netraffic netraffic1 = new Netraffic(financeService.queryNetByTime
                    (DateUtil.format(DateUtil.getStartTime(), DateUtil.DEFAULT_DATE_TIME2)
                            , DateUtil.format(DateUtil.getEndTime(), DateUtil.DEFAULT_DATE_TIME2)));
            netrafficList.add(netraffic1);
        }
        netrafficList.addAll(financeService.queryNetraffic(netraffic, page, rows, startTimeD, endTimeD));
        PageInfo<Netraffic> pageInfo = new PageInfo<>(netrafficList);
        JSONObject jo = new JSONObject();
        jo.put("rows", netrafficList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    //财务监控
    @RequestMapping("/financialmac")
    public String financialMac(Model model) {
        List<Goods> goodsList = goodsService.queryGoods(null, null, null);
        model.addAttribute("goodsList", goodsList);
        return "financial-mac";
    }

    @PostMapping("/financialmac/list")
    public void financialmacList(Integer page, Integer rows, Long goodsId, String channel, String startTime, String endTime, HttpServletResponse response) {
        FinancialMAC financialmac = new FinancialMAC();
        financialmac.setGoodsId(goodsId);
        financialmac.setChannel(channel);
        Date startTimeD = null;
        Date endTimeD = null;
        if (!StringUtil.isNull(startTime) && !StringUtil.isNull(endTime)) {
            startTimeD = DateUtil.parse(startTime, DateUtil.DEFAULT_DATE_TIME2);
            endTimeD = DateUtil.parse(endTime, DateUtil.DEFAULT_DATE_TIME2);
        }
        List<FinancialMAC> financialMACList = new ArrayList<>();
        if (page == 1) {

            FinancialMAC financialMAC = new FinancialMAC(financeService.queryFinanceByTime
                    (DateUtil.format(DateUtil.getStartTime(), DateUtil.DEFAULT_DATE_TIME2)
                            , DateUtil.format(DateUtil.getEndTime(), DateUtil.DEFAULT_DATE_TIME2)));
            financialMACList.add(financialMAC);
        }
        financialMACList.addAll(financeService.queryFinancialMAC(financialmac, page, rows, startTimeD, endTimeD));
        PageInfo<FinancialMAC> pageInfo = new PageInfo<>(financialMACList);
        JSONObject jo = new JSONObject();
        jo.put("rows", financialMACList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    //数据调用
    @RequestMapping("/datamac")
    public String datamac(Model model) {
        List<Goods> goodsList = goodsService.queryGoods(null, null, null);
        model.addAttribute("goodsList", goodsList);
        return "data-mac";
    }

    @PostMapping("/datamac/list")
    public void datamacList(Integer page, Integer rows, Long goodsId, String channel, String startTime, String endTime, HttpServletResponse response) {
        DataMAC datamac = new DataMAC();
        datamac.setGoodsId(goodsId);
        datamac.setChannel(channel);
        Date startTimeD = null;
        Date endTimeD = null;
        if (!StringUtil.isNull(startTime) && !StringUtil.isNull(endTime)) {
            startTimeD = DateUtil.parse(startTime, DateUtil.DEFAULT_DATE_TIME2);
            endTimeD = DateUtil.parse(endTime, DateUtil.DEFAULT_DATE_TIME2);
        }
        List<DataMAC> dataMACList = new ArrayList<>();
        if (page == 1) {
            DataMAC dataMAC = new DataMAC(financeService.queryDataMACByTime
                    (DateUtil.format(DateUtil.getStartTime(), DateUtil.DEFAULT_DATE_TIME2)
                            , DateUtil.format(DateUtil.getEndTime(), DateUtil.DEFAULT_DATE_TIME2)));
            dataMACList.add(dataMAC);
        }
        dataMACList.addAll(financeService.queryDataMAC(datamac, page, rows, startTimeD, endTimeD));
        PageInfo<DataMAC> pageInfo = new PageInfo<>(dataMACList);
        JSONObject jo = new JSONObject();
        jo.put("rows", dataMACList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    //银行流水账
    @RequestMapping("/bankaccount")
    public String bankaccount(Model model) {
        List<BankAccount> bankAccountList = bankAccountService.selectAll();
        model.addAttribute("bankAccountList", bankAccountList);
        return "bank-account";
    }

    @PostMapping("/bankaccount/list")
    public void bankaccountList(Integer page, Integer rows, String type, String startTime, String endTime, HttpServletResponse response) {
        Date startTimeD = null;
        Date endTimeD = null;
        if (!StringUtil.isNull(startTime) && !StringUtil.isNull(endTime)) {
            startTimeD = DateUtil.parse(startTime, DateUtil.DEFAULT_DATE_TIME2);
            endTimeD = DateUtil.parse(endTime, DateUtil.DEFAULT_DATE_TIME2);
        }
        List<BankAccount> bankAccountList = bankAccountService.queryBankAccount(type, page, rows, startTimeD, endTimeD);
        PageInfo<BankAccount> pageInfo = new PageInfo<>(bankAccountList);
        JSONObject jo = new JSONObject();
        jo.put("rows", bankAccountList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    @PostMapping("/bankaccount/editProfile")
    public void bankaccountEditProfile(HttpServletRequest request, HttpServletResponse response) {
        String file = request.getParameter("file");
        String fileName = request.getParameter("filesName");
        try {
            String b2 = new String(file.getBytes("UTF-8"), "UTF-8");
            System.out.println(b2);
            ServletUtil.createSuccessResponse(200, 1, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServletUtil.createSuccessResponse(200, 0, response);
    }
}
