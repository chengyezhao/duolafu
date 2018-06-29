package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.service.admin.GoodsRepaymentService;
import com.shoumipay.service.admin.OperLogsService;

/**
 * Created by Tang on 2017/10/26.
 */
public class MaxOverdue extends BasicExamineService {

    private GoodsRepaymentService goodsRepaymentService;

    private Integer days;

    public MaxOverdue(ExamineRule examineRule, GoodsRepaymentService goodsRepaymentService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.goodsRepaymentService = goodsRepaymentService;
        days = Integer.parseInt(examineRule.getParameter());
    }

    @Override
    public int examine(Member member) {
        //TODO: 最大还款逾期天数
//        Long times = goodsRepaymentService.countOverdue(goodsOrder.getId(), days);
//        if (times <= 0) return examineRule.getUnmatch();
//        logger.info("MaxOverdue 不通过 --> " + examineRule + "\n" + goodsOrder);
        operLogsService.addOrderExamineLog("审核不通过", "MaxOverdue 不通过 --> " + examineRule + "\n" , 3, 0L);
        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "逾期次数太多";
    }
}
