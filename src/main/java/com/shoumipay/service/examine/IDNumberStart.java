package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.service.admin.MemberDetailService;
import com.shoumipay.service.admin.OperLogsService;

import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Tang on 2017/10/26.
 */
public class IDNumberStart extends BasicExamineService {

    private MemberDetailService memberDetailService;

    private String pattern;

    public IDNumberStart(ExamineRule examineRule, MemberDetailService memberDetailService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberDetailService = memberDetailService;
        pattern = examineRule.getParameter();
    }

    @Override
    public int examine(Member member) {
        MemberDetail memberDetail = memberDetailService.selectByMemberId(member.getUid());
        if (null != memberDetail && 0 == memberDetail.getIdType() && null != memberDetail.getIdCard()) {
            String number = memberDetail.getIdCard();
            if (!isBlank(number) && !Pattern.matches(pattern, number)) return examineRule.getUnmatch();
        }
        logger.info("IDNumberStart 不通过 --> " + examineRule + "\n" + memberDetail);
        operLogsService.addOrderExamineLog("审核不通过", "IDNumberStart 不通过 --> " + examineRule + "\n" + memberDetail, 3, 0L);
        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "身份证区域不禁止";
    }
}
