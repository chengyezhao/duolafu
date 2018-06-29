package com.shoumipay.controller.tool;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shoumipay.service.admin.GoodsOrderService;
import com.shoumipay.tools.Message;
import com.shoumipay.vo.PreLoanOrderVO;
import com.shoumipay.vo.PreLoanVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Tang on 2017/11/11.
 */
public class BasicLoanController extends BasicController {
    @Autowired
    protected GoodsOrderService goodsOrderService;

    protected Message get(PreLoanVO vo, Integer page, Integer rows, Integer status) {
        if (null == page) page = 1;
        if (null == rows) rows = 10;
        vo.setStatus(status);
        PageHelper.startPage(page, rows);
        List<PreLoanOrderVO> list = goodsOrderService.queryByPreLoanVO(vo);
        PageInfo<PreLoanOrderVO> info = new PageInfo<>(list);
        return Message.success()
                .add("list", list)
                .add("pages", info.getPages())
                .add("total", info.getTotal())
                ;
    }

    protected Message getOverdue(PreLoanVO vo, Integer page, Integer rows) {
        if (null == page) page = 1;
        if (null == rows) rows = 10;
        PageHelper.startPage(page, rows);
        List<PreLoanOrderVO> list = goodsOrderService.queryByPreLoanVOOverdue(vo);
        PageInfo<PreLoanOrderVO> info = new PageInfo<>(list);
        return Message.success()
                .add("list", list)
                .add("pages", info.getPages())
                .add("total", info.getTotal())
                ;
    }
}
