package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.OperLogsService;

public class IdentifyPhoneNot extends BasicExamineService {
    private MemberService memberService;

    public IdentifyPhoneNot(ExamineRule examineRule, MemberService memberService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberService = memberService;
    }

    @Override
    public int examine(Member member) {
        if (member != null && member.getPhoneNumber() != null) {
            String identifyPhone = member.getPhoneNumber();
            String myPhone = memberService.getJdPhone(member.getUid());
            if (identifyPhone.equals(myPhone)) {
                return examineRule.getUnmatch();
            } else {
                logger.info("IdentifyPhoneNot 不通过 --> " + examineRule + "\n" + member);
                operLogsService.addOrderExamineLog("审核不通过", "IdentifyPhoneNot 不通过 --> " + examineRule + "\n" + member, 3, 0L);
                return examineRule.getMatch();
            }
        }
        logger.info("IdentifyPhoneNot 不通过 --> " + examineRule + "\n" + member);
        operLogsService.addOrderExamineLog("审核不通过", "IdentifyPhoneNot 不通过 --> " + examineRule + "\n" + member, 3, 0L);
        return examineRule.getMatch();
    }
}
