package com.shoumipay.controller.wechat.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.constants.GoodsOrderConstants;
import com.shoumipay.constants.RiskEnum;
import com.shoumipay.controller.wechat.base.BaseController;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberBankcard;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.service.RedisService;
import com.shoumipay.service.ThirdVerifyService;
import com.shoumipay.service.admin.GoodsService;
import com.shoumipay.service.admin.MemberBankcardService;
import com.shoumipay.service.wechat.*;
import com.shoumipay.v2.service.BQSRiskService;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.cache.SMSCacheService;
import com.shoumipay.tools.*;
import com.shoumipay.tools.wechat.Permission;
import com.shoumipay.v2.service.MobilePhoneRiskService;
import com.shoumipay.tools.wechat.WxSignUtil;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.vo.WeChat.JdOrdeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

import static com.shoumipay.constants.SMSConstants.FLAG_REGISTER;
import static com.shoumipay.tools.Message.*;
import static com.shoumipay.tools.ValidatorUtil.isMobile;
import static java.lang.Math.max;
import static java.lang.StrictMath.min;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Zhw on 2018/1/6.
 */
@Controller
@RequestMapping("wx")
public class MemberWeChatController extends BaseController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private SMSCacheService smsCacheService;
    @Autowired
    private FaceCheckService faceCheckService;
    @Autowired
    private JXLDataService jxlDataService;
    @Autowired
    private RedisService redisService;

    @Autowired
    private AccessTokenService accessTokenService;
    @Value("${wechat.appid}")
    private String appid;
    @Value("${domain.name}")
    private String domainName;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private JdDaiFuService jdDaiFuService;
    @Autowired
    private MobilePhoneRiskService mobilePhoneRiskService;
    @Autowired
    private BQSRiskService bqsRiskService;
    @Autowired
    private WeChatService weChatService;

    //所有静态页面的访问过一道认证
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @Permission
    public String home(@RequestParam String url){
        return "redirect:/public/" + url;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Message register(String phoneNumber, String code) {
        if (!isBlank(phoneNumber) && isMobile(phoneNumber) && !isBlank(code)) {
            //检查该手机号是否已经注册
            Member member = memberService.queryByPhoneNumber(phoneNumber);
            if (null != member) {
                return new Message(FLAG_PHONE_NUMBER_ALREADY_EXIST);
            }
            if (smsCacheService.check(FLAG_REGISTER, phoneNumber, code)) {
                member = getLoginMember();
                member.setName(phoneNumber);
                member.setUsername(phoneNumber);
                member.setPhoneNumber(phoneNumber);
                int index = memberService.updateMember(member);
                if (index > 0) {
                    logger.info("用户手机验证：" + member);
                    weChatService.sendCcTextMessge(member.getWechatOpenid(), "恭喜您的手机号码" + phoneNumber + "绑定成功！");
                    setLoginMember(member);
                    return Message.success();
                }
                return new Message(FLAG_NORMAL_ERROR);
            } else {
                return new Message(FLAG_IDENTIFYING_CODE_ERROR);
            }
        }
        return new Message(FLAG_PARAMETER_IS_INCORRECT);
    }

    /**
     * h5首页进入
     */
    @RequestMapping("index")
    @Permission
    public String index(Model model) {
//        Member member = getLoginMember();
//        model.addAttribute("verify", memberService.checkMemberIsActive(member.getUid(), null));
//        model.addAttribute("money", memberService.getMemeberBalance(member.getUid()));
//        return "h5/index";
        return "redirect:/public/index.html";
    }

    /**
     * 首页进入 -->我的
     */
    @RequestMapping("myself")
    @Permission
    public String myself(Model model) {
        Member member = getLoginMember();
        String regex = "(\\w{3})(\\w+)(\\w{4})";
        model.addAttribute("img", member.getWechatHeadimgurl());
        model.addAttribute("nickname", member.getWechatNickname());
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        String phone = member.getPhoneNumber().replaceAll(regex, "$1****$3");
        model.addAttribute("phone", phone);
        if (memberDetail == null || StringUtil.isNull(memberDetail.getIdCard())) {
            model.addAttribute("idcard", false);
        } else {
            model.addAttribute("idcard", memberDetail.getIdCard().replaceAll(regex, "$1$2****"));
        }
        if (memberDetail == null || StringUtil.isNull(memberDetail.getFullname())) {
            model.addAttribute("name", false);
        } else {
            model.addAttribute("name", memberDetail.getFullname());
        }
        if (memberDetail == null || StringUtil.isNull(memberDetail.getPermanentAddress())) {
            model.addAttribute("address", false);
        } else {
            model.addAttribute("address", memberDetail.getPermanentAddress());
        }
        return "h5/myself";
    }

    /**
     * 首页进入 -->激活流程
     */
    @RequestMapping("material")
    @Permission
    public String material(Model model) {
        Member member = getLoginMember();
        if (memberService.checkMemberIsActive(member.getUid(), null)) {
            return "redirect:/wx/index";
        }
        model.addAttribute("idCard", memberService.checkIdcardIsCertified(member.getUid()));
        model.addAttribute("bankCard", memberService.checkBankCardIsCertified(member.getUid()));
        model.addAttribute("TMobile", memberService.checkTmobileIsCertified(member.getUid()));
        model.addAttribute("dianshang", memberService.checkTaobaoDataGathered(member.getUid())
                || memberService.checkJDDataGathered(member.getUid()));
        return "h5/material";
    }

    /**
     * 银行卡绑定
     */
    @RequestMapping("bindBankCard")
    @Permission
    public String bindBankCard(Model model) {
        Member member = getLoginMember();
        model.addAttribute("phone", member.getPhoneNumber());
        if (!memberService.checkIdcardIsCertified(member.getUid())) {
            model.addAttribute("msg", "请完成身份证绑定!");
            return "h5/bank";
        }
        if (!memberService.checkTmobileIsCertified(member.getUid())) {
            model.addAttribute("msg", "请完成运营商验证!");
            return "h5/bank";
        }
        return "h5/bank";
    }

    /**
     * 运营商绑定
     */
    @RequestMapping("bindOperator")
    @Permission
    public String bindOperator(Model model) {
        Member member = getLoginMember();
        model.addAttribute("phone", member.getPhoneNumber());
        if (!memberService.checkIdcardIsCertified(member.getUid())) {
            model.addAttribute("msgs", "请完成身份证绑定!");
            return "h5/operator";
        }
        return "h5/operator";
    }

    /**
     * 运营商绑定Code
     */
    @RequestMapping("CodeOperator")
    @Permission
    public String CodeOperator(String msg, String phone, String password, Model model) {
        model.addAttribute("phone", phone);
        model.addAttribute("password", password);
        model.addAttribute("msg", msg);
        return "h5/operatorCode";
    }

    @RequestMapping("JXLStratCode")
    @Permission
    public void JXLStratCode(String phone, String password, HttpServletResponse response) {
        JSONObject resultJson = new JSONObject();
        Member member = getLoginMember();
        if (redisService.get("StartCode" + phone) != null) {
            resultJson.put("phone", phone);
            resultJson.put("flag", 0);
            resultJson.put("msg", "请一分钟内不要重复提交");
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return;
        }
        redisService.set("StartCode" + phone, 1, 60);
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        JSONObject object = jxlDataService.JXLReturnMsg(memberDetail.getFullname(), phone, memberDetail.getIdCard());
        String token = object.getString("token");
        String website = object.getString("website");
        redisService.set("JXLtoken" + phone, object, 600);
        JSONObject flagJSON = jxlDataService.JXLCollectReq(token, phone, password, website, "");
        if (!(boolean) flagJSON.get("success")) {
            resultJson.put("msg", flagJSON.getString("message"));
            resultJson.put("phone", phone);
            resultJson.put("flag", 0);
            logger.info(flagJSON.getString("message"));
            redisService.delete("StartCode" + phone);
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return;
        }
        String type = jxlDataService.returnData(new Date(), new Date(), token, phone, password, website, "");
        if (type.equals("输入验证码")) {
            resultJson.put("phone", phone);
            resultJson.put("msg", "验证码发送成功");
            resultJson.put("password", password);
            resultJson.put("flag", 1);
            logger.info(type);
            redisService.delete("StartCode" + phone);
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return;
            //return "h5/operatorCode";
        }
        if (type.equals("采集结束")) {
            String type3 = jxlDataService.returnStatusData(new Date(), new Date(), memberDetail.getFullname(), phone, memberDetail.getIdCard());
            if (!type3.equals("获取报告状态成功")) {
                resultJson.put("phone", phone);
                resultJson.put("msg", type3);
                resultJson.put("flag", 0);
                redisService.delete("StartCode" + phone);
                logger.info("获取报告状态失败,失败原因:" + type3);
                ServletUtil.createSuccessResponse(200, resultJson, response);
                return;
            }
            memberService.calculateQuota(member);
            resultJson.put("msg", "验证成功");
            resultJson.put("flag", 2);
            redisService.delete("StartCode" + phone);
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return;
            //return "redirect:/wx/material";
        }
        resultJson.put("phone", phone);
        resultJson.put("flag", 0);
        resultJson.put("msg", type);
        redisService.delete("StartCode" + phone);
        ServletUtil.createSuccessResponse(200, resultJson, response);
        //      return "h5/operator";
    }

    @RequestMapping("JXLCode")
    public void JXLCode(String phone, String password, HttpServletResponse response) {
        Member member = getLoginMember();
        JSONObject jo = new JSONObject();
        if (redisService.get("JXLCode" + member.getUid()) != null) {
            jo.put("msg", "验证码请求太频繁");
            ServletUtil.createSuccessResponse(200, jo, response);
            return;
        }
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        if (StringUtil.isNull(password)) {
            jo.put("msg", "服务密码不能为空");
            ServletUtil.createSuccessResponse(200, jo, response);
            return;
        }
        JSONObject object = jxlDataService.JXLReturnMsg(memberDetail.getFullname(), phone, memberDetail.getIdCard());
        String token = object.getString("token");
        String website = object.getString("website");
        redisService.set("JXLtoken" + phone, object, 600);
        JSONObject flag = jxlDataService.JXLCollectReq(token, phone, password, website, "");
        if ((boolean) flag.get("success")) {
            redisService.set("JXLCode" + member.getUid(), "1", 60);
            jo.put("msg", "短信随机码发送成功");
            ServletUtil.createSuccessResponse(200, jo, response);
            return;
        } else {
            jo.put("msg", "短信随机码发送失败");
            ServletUtil.createSuccessResponse(200, jo, response);
        }
    }

    @RequestMapping("bindJXL")
    public void bindJXL(String phone, String password, String code, HttpServletResponse response) {
        JSONObject resultJson = new JSONObject();
        if (StringUtil.isNull(phone) || StringUtil.isNull(password) || StringUtil.isNull(code)) {
            resultJson.put("msg", "手机号，服务密码，随机码不能为空");
            resultJson.put("flag", 0);
            resultJson.put("phone", phone);
            resultJson.put("password", password);
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return;
            //   return "h5/operator";
        }
        Member member = getLoginMember();
        if (redisService.get("bindJXL" + code + member.getUid()) != null) {
            resultJson.put("msg", "两分钟内请不要重复提交相同随机码");
            resultJson.put("flag", 0);
            resultJson.put("phone", phone);
            resultJson.put("password", password);
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return;
        }
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        if (redisService.get("JXLtoken" + phone) == null) {
            resultJson.put("msg", "JXLtoken已失效,请重新获取短信随机码");
            resultJson.put("flag", 0);
            resultJson.put("phone", phone);
            resultJson.put("password", password);
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return;
        }
        JSONObject jsonObject = JSON.parseObject(redisService.get("JXLtoken" + phone).toString());
        String token = jsonObject.getString("token");
        String website = jsonObject.getString("website");
      /*  String type = jxlDataService.returnData(new Date(),new Date(),token,phone,password,website,"");
        if (!(type.equals("输入验证码")||type.equals("采集结束"))){
            redisService.set("bindJXL"+code+member.getUid(),"1",2*60);
            model.addAttribute("msg",type);
            return "h5/operator";
        }*/
        JSONObject flag = jxlDataService.JXLCollectReq(token, phone, password, website, code);
        String type2 = jxlDataService.returnData(new Date(), new Date(), token, phone, password, website, "");
        if (!type2.equals("采集结束")) {
            redisService.set("bindJXL" + code + member.getUid(), "1", 2 * 60);
            resultJson.put("msg", type2);
            resultJson.put("flag", 0);
            resultJson.put("phone", phone);
            resultJson.put("password", password);
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return;
        }
        if ((boolean) flag.get("success")) {
            jxlDataService.JXLAccessToken();
            String type3 = jxlDataService.returnStatusData(new Date(), new Date(), memberDetail.getFullname(), phone, memberDetail.getIdCard());
            if (!type3.equals("获取报告状态成功")) {
                redisService.set("bindJXL" + code + member.getUid(), "1", 2 * 60);
                redisService.set("bindJXL" + code + member.getUid(), "1", 2 * 60);
                resultJson.put("msg", type3);
                resultJson.put("flag", 0);
                resultJson.put("phone", phone);
                resultJson.put("password", password);
                ServletUtil.createSuccessResponse(200, resultJson, response);
                return;
            }
            memberService.calculateQuota(member);
            resultJson.put("msg", "验证成功");
            resultJson.put("flag", 2);
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return;
        } else {
            resultJson.put("msg", flag.getString("message"));
            resultJson.put("phone", phone);
            resultJson.put("flag", 0);
            logger.info(flag.getString("message"));
            ServletUtil.createSuccessResponse(200, resultJson, response);
        }
    }

    /**
     * 获取权限配置数据
     */
    @RequestMapping("getConfigInfo")
    @Permission
    public void getConfigInfo(String url, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String access_token = accessTokenService.getAccessToken();
        String jsapi_ticket = accessTokenService.getJsapiTicket(access_token);
        String noncestr = WxSignUtil.generateNonceStr(6);
        String timestamp = WxSignUtil.getTimestamp();
        SortedMap<Object, Object> params = new TreeMap<Object, Object>();
        params.put("noncestr", noncestr);
        params.put("jsapi_ticket", jsapi_ticket);
        params.put("timestamp", timestamp);
        params.put("url", url);
        String sign = WxSignUtil.createSignBySha1(params);
        result.put("appId", appid);
        result.put("timestamp", timestamp);
        result.put("noncestr", noncestr);
        result.put("signature", sign);
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 身份证绑定
     */
    @RequestMapping("bindIdCard")
    @Permission
    public String bindIdCard(Model model) {
        String access_token = accessTokenService.getAccessToken();
        String jsapi_ticket = accessTokenService.getJsapiTicket(access_token);
        String noncestr = WxSignUtil.generateNonceStr(6);
        String timestamp = WxSignUtil.getTimestamp();
        SortedMap<Object, Object> params = new TreeMap<Object, Object>();
        params.put("noncestr", noncestr);
        params.put("jsapi_ticket", jsapi_ticket);
        params.put("timestamp", timestamp);
        params.put("url", domainName + "/wx/bindIdCard");
        String sign = WxSignUtil.createSignBySha1(params);
        model.addAttribute("appId", appid);
        model.addAttribute("noncestr", noncestr);
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("signature", sign);
        return "h5/idcard";
    }

    @RequestMapping("idcard")
    @Permission
    public String idCard(String pictureFront, String pictureBack, Model model) {
        if (StringUtil.isNull(pictureFront) || StringUtil.isNull(pictureBack)) {
            //return new Message(FLAG_UPLOAD_ERROR);
            // msg = "图片上传失败,请再次尝试";
            return "h5/idcard";
        } else {
            String access_token = accessTokenService.getAccessToken();
            String frontPic = WxSignUtil.getBase64Data(pictureFront, access_token);
            String backPic = WxSignUtil.getBase64Data(pictureBack, access_token);
            JSONObject frontJSON = faceCheckService.idCardFrontOCR(frontPic);
            JSONObject backJSON = faceCheckService.idCardBackOCR(backPic);
            if ((Boolean) frontJSON.getJSONObject("result").get("success") && (Boolean) backJSON.getJSONObject("result").get("success")) {
                //身份信息插入数据库
                Member member = getLoginMember();
                MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
                int index = 0;
                if (memberDetail != null) {
                    memberDetail.setFullname(frontJSON.getJSONObject("data").getString("id_name"));
                    memberDetail.setIdCard(frontJSON.getJSONObject("data").getString("id_number"));
                    String periodOfValidity = backJSON.getJSONObject("data").getString("validity_period");
                    memberDetail.setPeriodOfValidity(periodOfValidity.replace(".", "-"));
                    memberDetail.setEthnicity(frontJSON.getJSONObject("data").getString("nation"));
                    memberDetail.setAge(Integer.parseInt(frontJSON.getJSONObject("data").getString("age")));
                    String dateOfBirth = frontJSON.getJSONObject("data").getString("birthday");
                    memberDetail.setDateOfBirth(dateOfBirth.replace(".", "-"));
                    String gender = frontJSON.getJSONObject("data").getString("gender");
                    if (gender.equals("男")) {
                        gender = "0";
                    } else {
                        gender = "1";
                    }
                    memberDetail.setSex(Integer.parseInt(gender));
                    memberDetail.setPermanentAddress(frontJSON.getJSONObject("data").getString("address"));
                    memberDetail.setIssuingAuthority(backJSON.getJSONObject("data").getString("issuing_authority"));
                    index = memberService.uppMemberDetail(memberDetail);
                } else {
                    MemberDetail memberDetail1 = new MemberDetail();
                    memberDetail1.setMemberid(member.getUid());
                    memberDetail1.setFullname(frontJSON.getJSONObject("data").getString("id_name"));
                    memberDetail1.setIdCard(frontJSON.getJSONObject("data").getString("id_number"));
                    String periodOfValidity = backJSON.getJSONObject("data").getString("validity_period");
                    memberDetail1.setPeriodOfValidity(periodOfValidity.replace(".", "-"));
                    memberDetail1.setEthnicity(frontJSON.getJSONObject("data").getString("nation"));
                    memberDetail1.setAge(Integer.parseInt(frontJSON.getJSONObject("data").getString("age")));
                    String dateOfBirth = frontJSON.getJSONObject("data").getString("birthday");
                    memberDetail1.setDateOfBirth(dateOfBirth.replace(".", "-"));
                    String gender = frontJSON.getJSONObject("data").getString("gender");
                    if (gender.equals("男")) {
                        gender = "0";
                    } else {
                        gender = "1";
                    }
                    memberDetail1.setSex(Integer.parseInt(gender));
                    memberDetail1.setPermanentAddress(frontJSON.getJSONObject("data").getString("address"));
                    memberDetail1.setIssuingAuthority(backJSON.getJSONObject("data").getString("issuing_authority"));
                    index = memberService.addMemberDetail(memberDetail1);
                }

                if (index > 0) {
                    logger.info("身份信息数据插入成功");
                } else {
                    logger.info("身份信息数据插入失败");
                }
                model.addAttribute("frontJSON", frontJSON.getJSONObject("data"));
                model.addAttribute("backJSON", backJSON.getJSONObject("data"));
                return "h5/idinfo";
            } else {
                return "h5/idinfo_result";
            }
        }
    }

    @RequestMapping("changeIdify")
    @Permission
    public String changeIdify(Model model) {
        Member member = getLoginMember();
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        JSONObject frontJSON = new JSONObject();
        JSONObject backJSON = new JSONObject();
        frontJSON.put("id_name", memberDetail.getFullname());
        frontJSON.put("id_number", memberDetail.getIdCard());
        frontJSON.put("birthday", memberDetail.getDateOfBirth());
        String gender = memberDetail.getSex().toString();
        if (gender.equals("0")) {
            gender = "男";
        } else {
            gender = "女";
        }
        frontJSON.put("gender", gender);
        frontJSON.put("nation", memberDetail.getEthnicity());
        frontJSON.put("address", memberDetail.getPermanentAddress());
        backJSON.put("issuing_authority", memberDetail.getIssuingAuthority());
        backJSON.put("validity_period", memberDetail.getPeriodOfValidity());
        model.addAttribute("frontJSON", frontJSON);
        model.addAttribute("backJSON", backJSON);
        model.addAttribute("msg", "姓名修改失败,请再次修改");
        return "h5/idinfo";
    }

    @PostMapping("checkIdcardInfo")
    @Permission
    public void checkIdcardInfo(String fullName, HttpServletResponse response) {
        logger.info("---进入修改用户姓名方法---");
        Member member = getLoginMember();
        if (StringUtil.isNull(fullName)) {
            MessageUtil.failMessageFlag("/wx/material", response);
            return;
        }
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        memberDetail.setFullname(fullName);
        try {
            int index = memberService.uppMemberDetail(memberDetail);
            if (index <= 0) {
                logger.info(member.getUid() + "更新失败" + fullName);
                MessageUtil.failMessageFlag("/wx/changeIdify", response);
                return;
            }
            logger.info(member.getUid() + "更新成功" + fullName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MessageUtil.successMessageFlag("/wx/material", response);
    }

    /**
     * 帮助
     */
    @RequestMapping("help")
    @Permission
    public String help() {
        return "h5/help";
    }

    /**
     * 关于我们
     */
    @RequestMapping("about")
    public String about() {
        return "h5/about_us";
    }

    /**
     * 平台关联
     */
    @RequestMapping("platfom")
    @Permission
    public String platfom(Model model) {
        Member member = getLoginMember();
        member = memberService.queryByUid(member.getUid());
        model.addAttribute("phone", member.getPhoneNumber());
        model.addAttribute("jd", DocumentUtils.getInstance().hasDocument(member.getUid(), DocumentUtils.JD));
        model.addAttribute("tb", DocumentUtils.getInstance().hasDocument(member.getUid(), DocumentUtils.TAOBAO));
        return "h5/platform_related";
    }

    /**
     * 账单
     */
    @RequestMapping("bills")
    @Permission
    public String bills(Model model) {
        Member member = getLoginMember();
        if (!memberService.checkMemberIsActive(member.getUid(), null)) {
            model.addAttribute("msg", "请完成认证");
            return "h5/bills";
        }
        member = memberService.queryByUid(member.getUid());
        member.setBillsFalseAmount(member.getBillsFalseAmount().subtract(member.getPrepaymentAmount()));
        model.addAttribute("member", member);
        model.addAttribute("balance", memberService.getMemeberBalance(member.getUid()));
        GoodsOrder goodsOrder = new GoodsOrder();
        goodsOrder.setMemberId(member.getUid());
        goodsOrder.setOrderStatus(GoodsOrderConstants.LOAN_SUCCESS);
        List<GoodsOrder> goodsOrders = goodsService.queryOrder(goodsOrder, 0, 0);
        //最后还款时间 start
        int billDay = memberService.getBillDay(member.getUid());
        int nextBillDay = memberService.endBillDay(billDay);
        for (GoodsOrder g : goodsOrders) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(g.getOrderCreateTime());
            int day = calendar2.get(Calendar.DATE);
            if (nextBillDay < day) {
                calendar2.add(Calendar.MONTH, 1);
            }
            calendar2.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), nextBillDay);
            g.setOrderUpptime(calendar2.getTime());
        }
        //最后还款时间 end
        model.addAttribute("goodsOrders", goodsOrders);

        return "h5/bills";
    }

    /**
     * 还款页面
     */
    @RequestMapping("repayment")
    @Permission
    public String repayment(Model model) {
        Member member = getLoginMember();
        member = memberService.queryByUid(member.getUid());
        member.setBillsFalseAmount(member.getBillsFalseAmount().subtract(member.getPrepaymentAmount()));
        model.addAttribute("member", member);
        if (!memberService.checkMemberIsActive(member.getUid(), null)) {
            model.addAttribute("msg", "请完成认证");
            return "h5/pay_hk";
        }
        if (member.getBillsFalseAmount().doubleValue() <= 0 && member.getBillsTrueAmount().doubleValue() <= 0) {
            model.addAttribute("isNull", false);
            return "h5/pay_hk";
        }
        int billDay = memberService.getBillDay(member.getUid());
        int nextBillDay = memberService.endBillDay(billDay);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int i = calendar.getActualMaximum(Calendar.DATE);
        model.addAttribute("nextBirthDay", nextBillDay);
        model.addAttribute("nextBirthDayRepay", billDay - 1 == 0 ? i : billDay - 1);
        model.addAttribute("birthDay", billDay);
        model.addAttribute("isNull", true);
        return "h5/pay_hk";
    }

    @RequestMapping("question")
    public String question() {
        return "h5/question";
    }

    @RequestMapping("protocol")
    public String xieyi() {
        return "h5/xieyi";
    }

    @RequestMapping("dgprotocol")
    @Permission
    public String dgxieyi(Model model) {
        Member member = getLoginMember();
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        String name = "";
        String idcard = "";
        if (memberDetail != null) {
            name = memberDetail.getFullname();
            idcard = memberDetail.getIdCard();
        }
        model.addAttribute("order", "DLF000000" + member.getUid());
        model.addAttribute("name", name);
        model.addAttribute("idcard", idcard);
        model.addAttribute("time", DateUtil.format(new Date(), "yyyy年MM月dd日"));
        return "h5/gmxiyi";
    }

    /**
     * 订单展示
     */
    @RequestMapping("myOrder")
    @Permission
    public String myOrder(Model model) {
        Member member = getLoginMember();
        List<JdOrdeVO> jdOrdeVOList = jdDaiFuService.queryJdOrder(member.getUid());
        model.addAttribute("jdOrdeVOList", jdOrdeVOList);
        return "h5/my_order";
    }


    /**
     * 四要素
     * 接口
     */
    @Autowired
    private ThirdVerifyService thirdVerifyService;
    @Autowired
    private MemberBankcardService memberBankcardService;

    @RequestMapping("bankCardBind")
    @Permission
    public String bankCardBind(String bankcardNumber, Model model) {
        Member member = getLoginMember();
        model.addAttribute("phone", member.getPhoneNumber());
        if (!memberService.checkIdcardIsCertified(member.getUid())) {
            model.addAttribute("msg", "请完成身份证绑定!");
            return "h5/bank";
        }
        if (!memberService.checkTmobileIsCertified(member.getUid())) {
            model.addAttribute("msg", "请完成运营商验证!");
            return "h5/bank";
        }
        logger.info("四要素认证手机号:" + member.getPhoneNumber() + "银行卡:" + bankcardNumber);
        MemberBankcard memberBankcard = new MemberBankcard();
        memberBankcard.setBankcardNumber(bankcardNumber);
        List<MemberBankcard> memberBankcardList = memberBankcardService.queryBankcard(memberBankcard);
        if (memberBankcardList != null && memberBankcardList.size() > 0) {
            model.addAttribute("msg", "不能重复绑卡");
            return "h5/bank";
        }
        memberBankcard.setPhonenumber(member.getPhoneNumber());
        String error = memberBankcardService.checkBankcard(memberBankcard);
        if (error != null) {
            model.addAttribute("msg", error);
            return "h5/bank";
        }
        String channelOrderId = member.getUid() + CalculateUtil.generateMixRandomCode(12);
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        JSONObject jsonObject = thirdVerifyService.cardVerify(memberDetail.getFullname(),
                memberDetail.getIdCard(),
                member.getPhoneNumber(),
                bankcardNumber, new Date(), channelOrderId);
        if (jsonObject != null) {
            if ("银行卡账户认证获取数据成功".equals(jsonObject.get("msg"))) {
                memberBankcard.setMemberid(member.getUid());
                memberBankcard.setCardAddtime(new Date());
                memberBankcard.setCardState(1);
                memberBankcardService.addBankcard(memberBankcard);
                model.addAttribute("msg", "绑定成功");
                return "h5/bank";
            }
            model.addAttribute("msg", jsonObject.get("msg"));
            return "h5/bank";
        }
        model.addAttribute("msg", "绑卡失败,请输入匹配的信息!");
        return "h5/bank";
    }
}
