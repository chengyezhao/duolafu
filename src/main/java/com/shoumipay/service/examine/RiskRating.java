package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.domain.docs.MemberDocument;
import com.shoumipay.v2.domain.docs.RiskDocument;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.OperLogsService;
import com.shoumipay.v2.DocumentUtils;

public class RiskRating extends BasicExamineService {
    private MemberService memberService;

    public RiskRating(ExamineRule examineRule, MemberService memberService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberService = memberService;
    }

    @Override
    public int examine(Member member) {
        if (member != null && DocumentUtils.getInstance().hasDocument(member.getUid(),DocumentUtils.ADF)) {
            MemberDocument document = DocumentUtils.getInstance().getByMemberId(member.getUid(), DocumentUtils.ADF);
            RiskDocument riskDocument = (RiskDocument) document.getDoc();
            int riskRating = riskDocument.getMobilePhoneRiskLevel();
            if (riskRating < 5) {
                return examineRule.getUnmatch();
            } else {
                logger.info("RiskRating 不通过 --> " + examineRule + "\n" + member);
                operLogsService.addOrderExamineLog("审核不通过", "RiskRating 不通过 --> " + examineRule + "\n" + member, 3, 0L);
                return examineRule.getMatch();
            }
        }
        logger.info("RiskRating 不通过 --> " + examineRule + "\n" + member);
        operLogsService.addOrderExamineLog("审核不通过", "RiskRating 不通过 --> " + examineRule + "\n" + member, 3, 0L);
        return examineRule.getMatch();
    }

}
