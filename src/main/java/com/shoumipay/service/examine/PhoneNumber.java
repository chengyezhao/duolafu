package com.shoumipay.service.examine;

import com.alibaba.fastjson.JSONObject;
import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.OperLogsService;
import com.shoumipay.service.ThirdVerifyService;
import com.shoumipay.smsmessage.XmlUtils;

import java.util.Date;

/**
 * Created by Tang on 2017/10/26.
 */
public class PhoneNumber extends BasicExamineService {

    private MemberService memberService;
    private ThirdVerifyService thirdVerifyService;

    public PhoneNumber(ExamineRule examineRule, MemberService memberService, OperLogsService operLogsService, ThirdVerifyService thirdVerifyService) {
        super(examineRule, operLogsService);
        this.memberService = memberService;
        this.thirdVerifyService = thirdVerifyService;
    }

    @Override
    public int examine(Member member) {
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        if (null != member && null != memberDetail) {
            String phone = member.getPhoneNumber();
            String name = memberDetail.getFullname();
            String idCard = memberDetail.getIdCard();
            String channelorderId = XmlUtils.getChannelId(member.getUid().toString());
            // TODO 下面调用接口查看手机号是否异常
            JSONObject result = thirdVerifyService.phoneNameCidVerify(name, idCard, phone, new Date(), channelorderId);
            if ("手机姓名身份证认证获取数据成功".equals(result.getString("msg"))) {
                System.out.println("手机姓名身份证认证获取数据成功");
                return examineRule.getUnmatch();
            }
            logger.info("PhoneNumber 不通过 --> " + examineRule);
            operLogsService.addOrderExamineLog("审核不通过", "PhoneNumber 不通过 --> " + examineRule, 3, 0L);
            return examineRule.getMatch();
        }
        logger.info("PhoneNumber 不通过 --> " + examineRule);
        operLogsService.addOrderExamineLog("审核不通过", "PhoneNumber 不通过 --> " + examineRule, 3, 0L);

        return examineRule.getMatch();
    }

    @Override
    public String getDesc() {
        return "手机号实名认证不通过";
    }
}
