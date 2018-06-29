package com.shoumipay.service.examine;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.OperLogsService;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.docs.MemberDocument;

public class IdCardBlackList extends BasicExamineService {

    private MemberService memberService;

    public IdCardBlackList(ExamineRule examineRule, MemberService memberService, OperLogsService operLogsService) {
        super(examineRule, operLogsService);
        this.memberService = memberService;
    }

    @Override
    public int examine(Member member) {
        if (member != null) {
            MemberDocument doc = DocumentUtils.getInstance().getByMemberId(member.getUid(), DocumentUtils.JXL);
            if(doc == null || doc.getDoc() == null){
                return examineRule.getUnmatch();
            }
            JSONArray application_check = JSON.parseObject((String)doc.getDoc()).getJSONObject("report_data").getJSONArray("application_check");
            for (int i = 0; i < application_check.size(); i++) {
                String app_point = application_check.getJSONObject(i).getString("app_point");
                if (app_point.equals("id_card")) {
                    boolean id_fin_blk = (boolean) application_check.getJSONObject(i).getJSONObject("check_points").getJSONObject("financial_blacklist").get("arised");
                    boolean id_court_blk = (boolean) application_check.getJSONObject(i).getJSONObject("check_points").getJSONObject("court_blacklist").get("arised");
                    int id_fin_blk_a;
                    int id_court_blk_b;
                    if (id_fin_blk) {
                        id_fin_blk_a = 1;
                    } else {
                        id_fin_blk_a = 0;
                    }
                    if (id_court_blk) {
                        id_court_blk_b = 1;
                    } else {
                        id_court_blk_b = 0;
                    }
                    if (id_fin_blk_a > 0 || id_court_blk_b > 0) {
                        logger.info("IdCardBlackList 不通过 --> " + examineRule + "\n" + member);
                        operLogsService.addOrderExamineLog("审核不通过", "IdCardBlackList 不通过 --> " + examineRule + "\n" + member, 3, 0L);
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
