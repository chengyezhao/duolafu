package com.shoumipay.service.examine.deprecated;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.SesameCredit;
import com.shoumipay.service.admin.OperLogsService;
import com.shoumipay.service.SesameCreditService;
import com.shoumipay.service.examine.BasicExamineService;

/**
 * Created by Tang on 2017/10/26.
 */
public class SesameCreditScore extends BasicExamineService {

    private SesameCreditService sesameCreditService;
    private int score;

    public SesameCreditScore(ExamineRule examineRule, SesameCreditService sesameCreditService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.sesameCreditService = sesameCreditService;
        score = Integer.parseInt(examineRule.getParameter());
    }

    @Override
    public int examine(Member member) {
        SesameCredit sesameCredit = sesameCreditService.selectByLatest(member.getUid());
        if (null != sesameCredit && score <= sesameCredit.getSesameScore()) return examineRule.getUnmatch();
        logger.info("SesameCreditScore 不通过 --> " + examineRule + "\n" + sesameCredit);
        operLogsService.addOrderExamineLog("审核不通过", "SesameCreditScore 不通过 --> " + examineRule + "\n" + sesameCredit, 3, 0L);

        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "芝麻信用太低";
    }
}
