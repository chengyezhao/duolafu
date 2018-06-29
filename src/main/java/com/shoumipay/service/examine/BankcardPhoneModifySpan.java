package com.shoumipay.service.examine;

import com.shoumipay.domain.*;
import com.shoumipay.service.admin.MemberBankcardService;
import com.shoumipay.service.admin.MemberInfoChangeRecordService;
import com.shoumipay.service.admin.OperLogsService;

import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
public class BankcardPhoneModifySpan extends BasicExamineService {

    private MemberBankcardService memberBankcardService;
    private MemberInfoChangeRecordService memberInfoChangeRecordService;
    private Integer dayLine;

    public BankcardPhoneModifySpan(ExamineRule examineRule,
                                   MemberBankcardService memberBankcardService,
                                   MemberInfoChangeRecordService memberInfoChangeRecordService,
                                   OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberBankcardService = memberBankcardService;
        this.memberInfoChangeRecordService = memberInfoChangeRecordService;
        dayLine = Integer.parseInt(examineRule.getParameter());
    }

    @Override
    public int examine(Member member) {
        MemberInfoChangeRecord record = memberInfoChangeRecordService.selectByLatestPhoneChange(member.getUid());
        if (null == record) return examineRule.getUnmatch();
        List<MemberBankcard> list = null;
        if (null != record) {
            list = memberBankcardService.selectByMemberId(member.getUid());
            if (null != list) {
                boolean match = false;
                for (MemberBankcard mb : list) {
                    if (span(record.getChangeTime(), mb.getCardUpptime(), dayLine)) {
                        match = true;
                        break;
                    }
                }
                if (!match) return examineRule.getUnmatch();
            }
        }
        logger.info("BankcardPhoneModifySpan 不通过 --> " + examineRule + "\n" + record + "\n" + list);
        operLogsService.addOrderExamineLog("审核不通过", "BankcardPhoneModifySpan 不通过 --> " + examineRule + "\n" + record + "\n" + list, 3, 0L);
        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "银行卡和手机号更改太频繁";
    }
}
