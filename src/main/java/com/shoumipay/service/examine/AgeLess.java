package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.service.admin.MemberDetailService;
import com.shoumipay.service.admin.OperLogsService;

/**
 * Created by Tang on 2017/10/26.
 */
public class AgeLess extends BasicExamineService {

    private MemberDetailService memberDetailService;


    private Integer ageLine;

    public AgeLess(ExamineRule examineRule, MemberDetailService memberDetailService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberDetailService = memberDetailService;
        ageLine = Integer.parseInt(examineRule.getParameter());
    }

    @Override
    public int examine(Member member) {
        MemberDetail memberDetail = memberDetailService.selectByMemberId(member.getUid());
        if (null != memberDetail && 0 == memberDetail.getIdType() && null != memberDetail.getIdCard()) {
            Integer age = calcAge(memberDetail.getIdCard());
            if (null != age && age >= ageLine) return examineRule.getUnmatch();
        }
        logger.info("AgeLess 不通过 --> " + examineRule + "\n" + memberDetail);
        operLogsService.addOrderExamineLog("审核不通过", "AgeLess 不通过 --> " + examineRule + "\n" + memberDetail, 3, 0L);
        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "年龄不合法";
    }
}
