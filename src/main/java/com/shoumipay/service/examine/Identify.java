package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.OperLogsService;

/**
 * Created by Tang on 2017/10/26.
 */
public class Identify extends BasicExamineService {

    private MemberService memberService;

    public Identify(ExamineRule examineRule, MemberService memberService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberService = memberService;
    }

    @Override
    public int examine(Member member) {
        if (null != member && member.hasAuthentication()) {
            return examineRule.getUnmatch();
        }
        logger.info("Identify 不通过 --> " + examineRule + "\n" + member);
        operLogsService.addOrderExamineLog("审核不通过", "Identify 不通过 --> " + examineRule + "\n" + member, 3, 0L);
        return examineRule.getMatch();
    }
}
