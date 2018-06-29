package com.shoumipay.controller.wechat.gxb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.controller.wechat.base.BaseController;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.gxb.GxbService;
import com.shoumipay.tools.LongUtil;
import com.shoumipay.tools.wechat.Permission;
import com.shoumipay.v2.DocumentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;

/**
 * Created by Zhw on 2017/12/29.
 */
@Controller
@RequestMapping("gxb")
public class GxbController extends BaseController {
    private Logger log = LoggerFactory.getLogger(getClass());
    private static final String authItem_jd = "jd";
    private static final String authItem_ecommerce = "ecommerce";
    @Value("${domain.name}")
    private String domainName;
    @Autowired
    private GxbService gxbService;
    @Autowired
    private MemberService memberService;

    @PostMapping("callBack")
    @ResponseBody
    public JSONObject callBackJd(@RequestBody String param) {
        return callBack(param, "jd");
    }

    @PostMapping("callBackTb")
    @ResponseBody
    public JSONObject callBackTb(@RequestBody String param) {
        return callBack(param, "tb");
    }

    /**
     * 公信宝回调
     */
    private JSONObject callBack(String param, String flag) {
        JSONObject object = new JSONObject();
//        log.info(param);
        JSONObject jsonObject = JSON.parseObject(param);
        String sequenceNo = jsonObject.getString("sequenceNo");//userId
        Long memberId = LongUtil.parseLong(sequenceNo);
        Member member = memberService.queryByUid(memberId);
        if (member == null) {
            object.put("retCode", 0);
            object.put("retMsg", "失败");
            return object;
        }
        if ("tb".equals(flag)) {
            DocumentUtils.getInstance().update(member.getUid(), DocumentUtils.TAOBAO, param);
        } else {
            DocumentUtils.getInstance().update(member.getUid(), DocumentUtils.JD, param);
        }
        try {
            memberService.calculateQuota(member);
        }catch (Exception e){
            logger.info("failed to calculate quota for member " + member.getUid(), e);
            object.put("retCode", 1);
            object.put("retMsg", "成功");
            return object;
        }

        object.put("retCode", 1);
        object.put("retMsg", "成功");
        return object;
    }

    /**
     * 跳转h5
     */
    @RequestMapping("")
    @Permission
    public String gxbH5(String authItem) throws UnsupportedEncodingException {
        Member member = getLoginMember();
        if (!(memberService.checkIdcardIsCertified(member.getUid())
                && memberService.checkTmobileIsCertified(member.getUid())
                && memberService.checkBankCardIsCertified(member.getUid())) || !(authItem_ecommerce.equals(authItem) || authItem_jd.equals(authItem))) {
            return "redirect:/wx/home?url=authentication.html";
        }
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        String phone = member.getPhoneNumber();
        String name = memberDetail.getFullname();
        String idcard = memberDetail.getIdCard();
        String token = gxbService.getToken(phone, name, idcard, authItem, member.getUid());
        String returnUrl = URLEncoder.encode(domainName + "/wx/oauth2/code", "utf-8");
        String h5_url = gxbService.getH5Url(token, returnUrl);
        return "redirect:" + h5_url;
    }
}
