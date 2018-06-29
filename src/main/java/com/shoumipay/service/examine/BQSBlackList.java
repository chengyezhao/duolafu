package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.service.admin.OperLogsService;
import com.shoumipay.v2.service.BQSRiskService;

public class BQSBlackList extends BasicExamineService {

    private BQSRiskService bqsService;

    public BQSBlackList(ExamineRule examineRule, OperLogsService operLogsService, BQSRiskService bqsService) {
        super(examineRule, operLogsService);
        this.bqsService = bqsService;
    }

    @Override
    public int examine(Member member) {
        BQSRiskService.BQSRisk risk = bqsService.isMemberInBlackList(member);
        if (risk.equals(BQSRiskService.BQSRisk.Accepted) ||
                risk.equals(BQSRiskService.BQSRisk.Unknown)) {
            return examineRule.getUnmatch();
        }
        logger.info("BQSBlackList 不通过 --> " + examineRule + "\n" );
        operLogsService.addOrderExamineLog("审核不通过", "BQSBlackList 不通过 --> " + examineRule + "\n" , 3, member.getUid());
        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "白骑士黑名单审核不通过";
    }
}
