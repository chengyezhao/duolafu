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
public class ResidenceInclude extends BasicExamineService {

    private MemberDetailService memberDetailService;

    private String pattern;

    public ResidenceInclude(ExamineRule examineRule, MemberDetailService memberDetailService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberDetailService = memberDetailService;
        pattern = examineRule.getParameter();
    }

    @Override
    public int examine(Member member) {
        MemberDetail memberDetail = memberDetailService.selectByMemberId(member.getUid());
        if (null != memberDetail) {
            String residence = memberDetail.getPermanentAddress();
            if (!isBlank(residence) && !Pattern.matches(pattern, residence)) return examineRule.getUnmatch();
        }
        logger.info("ResidenceInclude 不通过 --> " + examineRule + "\n" + memberDetail);
        operLogsService.addOrderExamineLog("审核不通过", "ResidenceInclude 不通过 --> " + examineRule + "\n" + memberDetail, 3, 0L);

        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "居住地区禁止";
    }
}
