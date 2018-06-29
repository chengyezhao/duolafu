package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.GoodsOrderExample;
import com.shoumipay.domain.Member;
import com.shoumipay.service.admin.GoodsOrderService;
import com.shoumipay.service.admin.OperLogsService;

import java.util.Date;
import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
public class ApplyTimesGreater extends BasicExamineService {

    private GoodsOrderService goodsOrderService;

    private Integer times;

    public ApplyTimesGreater(ExamineRule examineRule, GoodsOrderService goodsOrderService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.goodsOrderService = goodsOrderService;
        times = Integer.parseInt(examineRule.getParameter());
    }

    @Override
    public int examine(Member member) {
        GoodsOrderExample example = new GoodsOrderExample();
        GoodsOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderCreateTimeGreaterThan(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 15));
        criteria.andMemberIdEqualTo(member.getUid());
        List<GoodsOrder> list = goodsOrderService.selectByExample(example);
        if (null != list && list.size() < times) {
            return examineRule.getUnmatch();
        }
        logger.info("ApplyTimesGreater 不通过 --> " + examineRule + "\n" + list);
        operLogsService.addOrderExamineLog("审核不通过", "ApplyTimesGreater 不通过 --> " + examineRule + "\n" + list, 3, 0L);

        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "申请次数太多";
    }
}
