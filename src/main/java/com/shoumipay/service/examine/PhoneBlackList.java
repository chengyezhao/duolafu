package com.shoumipay.service.examine;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.OperLogsService;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.docs.MemberDocument;

public class PhoneBlackList extends BasicExamineService {
    private MemberService memberService;

    public PhoneBlackList(ExamineRule examineRule, MemberService memberService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberService = memberService;
    }


    @Override
    public int examine(Member member) {
        if (member != null && DocumentUtils.getInstance().hasDocument(member.getUid(),DocumentUtils.JXL)) {
            MemberDocument doc = DocumentUtils.getInstance().getByMemberId(member.getUid(), DocumentUtils.JXL);
            if(doc == null || doc.getDoc() == null){
                return examineRule.getUnmatch();
            }
            JSONArray application_check = JSON.parseObject((String)doc.getDoc()).getJSONObject("report_data").getJSONArray("application_check");
            for (int i = 0; i < application_check.size(); i++) {
                String app_point = application_check.getJSONObject(i).getString("app_point");
                if (app_point.equals("cell_phone")) {
                    boolean ph_fin_blk = (boolean) application_check.getJSONObject(i).getJSONObject("check_points").getJSONObject("financial_blacklist").get("arised");
                    int phoneBlackList;
                    if (ph_fin_blk) {
                        phoneBlackList = 1;
                    } else {
                        phoneBlackList = 0;
                    }
                    if (phoneBlackList > 0) {
                        logger.info("PhoneBlackList 不通过 --> " + examineRule + "\n" + member);
                        operLogsService.addOrderExamineLog("审核不通过", "PhoneBlackList 不通过 --> " + examineRule + "\n" + member, 3, 0L);
                        return examineRule.getMatch();
                    } else {
                        return examineRule.getUnmatch();
                    }
                }
            }
        }
        logger.info("PhoneBlackList 不通过 --> " + examineRule + "\n" + member);
        operLogsService.addOrderExamineLog("审核不通过", "PhoneBlackList 不通过 --> " + examineRule + "\n" + member, 3, 0L);
        return examineRule.getMatch();
    }
}
