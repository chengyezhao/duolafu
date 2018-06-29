package com.shoumipay.service.examine;

import com.shoumipay.domain.*;
import com.shoumipay.service.admin.MemberInfoChangeRecordService;
import com.shoumipay.service.admin.OperLogsService;

import java.util.Date;
import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
public class PhoneModifyGreater extends BasicExamineService {

    private MemberInfoChangeRecordService memberInfoChangeRecordService;

    private Integer time;

    public PhoneModifyGreater(ExamineRule examineRule, MemberInfoChangeRecordService memberInfoChangeRecordService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberInfoChangeRecordService = memberInfoChangeRecordService;
        time = Integer.parseInt(examineRule.getParameter());
    }

    @Override
    public int examine(Member member) {
        MemberInfoChangeRecordExample example = new MemberInfoChangeRecordExample();
        MemberInfoChangeRecordExample.Criteria criteria = example.createCriteria();
        criteria.andChangeTimeGreaterThan(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 30));
        criteria.andColumnNameEqualTo("phone_number");
        List<MemberInfoChangeRecord> list = memberInfoChangeRecordService.selectByExample(example);
        if (null != list && list.size() < time) {
            return examineRule.getUnmatch();
        }
        logger.info("ResidenceInclude 不通过 --> " + examineRule + "\n" + list);
        operLogsService.addOrderExamineLog("审核不通过", "ResidenceInclude 不通过 --> " + examineRule + "\n" + list, 3, 0L);

        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "30天内手机号修改次数太多";
    }
}
