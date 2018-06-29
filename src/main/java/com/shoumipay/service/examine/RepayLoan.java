package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.service.admin.GoodsRepaymentPlanService;
import com.shoumipay.service.admin.OperLogsService;

/**
 * Created by Tang on 2017/10/26.
 */
public class RepayLoan extends BasicExamineService {

    private GoodsRepaymentPlanService goodsRepaymentPlanService;

    public RepayLoan(ExamineRule examineRule, GoodsRepaymentPlanService goodsRepaymentPlanService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.goodsRepaymentPlanService = goodsRepaymentPlanService;
    }

    @Override
    public int examine(Member member) {
        Long times = goodsRepaymentPlanService.countUnRepay(member.getUid());
        if (times < 1) return examineRule.getUnmatch();
        logger.info("RepayLoan 不通过 --> " + examineRule + "\n" + member.getUid());
        operLogsService.addOrderExamineLog("审核不通过", "RepayLoan 不通过 --> " + examineRule + "\n", 3, 0L);

        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "尚有未结清订单";
    }
}
