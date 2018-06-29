package com.shoumipay.v2.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.shoumipay.constants.QuotaEnum;
import com.shoumipay.constants.RiskEnum;
import com.shoumipay.constants.SmsEnum;
import com.shoumipay.constants.WeChatConstants;
import com.shoumipay.controller.wechat.base.BaseController;
import com.shoumipay.domain.*;
import com.shoumipay.service.*;
import com.shoumipay.service.admin.ConfigService;
import com.shoumipay.service.admin.GoodsService;
import com.shoumipay.service.admin.MemberBankcardService;
import com.shoumipay.service.admin.MessageSendService;
import com.shoumipay.service.cache.SMSCacheService;
import com.shoumipay.service.impl.IdGenerator;
import com.shoumipay.service.wechat.*;
import com.shoumipay.tools.*;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import com.shoumipay.tools.wechat.Permission;
import com.shoumipay.tools.wechat.ToMapUtil;
import com.shoumipay.tools.wechat.WxSignUtil;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.*;
import com.shoumipay.v2.domain.docs.MemberDocument;
import com.shoumipay.v2.domain.docs.RiskDocument;
import com.shoumipay.v2.domain.enums.*;
import com.shoumipay.v2.service.*;
import com.shoumipay.v2.vo.*;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

import static com.shoumipay.constants.SMSConstants.*;
import static com.shoumipay.constants.SMSConstants.FLAG_MODIFY_PHONE_NUMBER;
import static com.shoumipay.constants.SMSConstants.FLAG_MODIFY_PHONE_NUMBER_TWO;
import static com.shoumipay.tools.CalculateUtil.generateDigitRandomCode;
import static com.shoumipay.tools.Message.*;
import static com.shoumipay.tools.Message.FLAG_NORMAL_ERROR;
import static com.shoumipay.tools.Message.FLAG_PARAMETER_IS_INCORRECT;
import static com.shoumipay.tools.ValidatorUtil.isMobile;
import static org.apache.commons.lang3.StringUtils.isBlank;


@Controller
@RequestMapping("/api/v1")
public class DaifuApiController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
    private MessageSendService messageSendService;
    @Autowired
    private AccessTokenService accessTokenService;
    //获取公众号相关参数
    @Value("${wechat.appid}")
    private String appid;
    //获取到域名
    @Value("${domain.name}")
    private String domainName;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private JdDaiFuService jdDaiFuService;

    // 这个方法会进行一些简单的判断：需保证身份证认证，运营商认证。
    @Autowired
    private ThirdVerifyService thirdVerifyService;
    @Autowired
    private MemberBankcardService memberBankcardService;
    @Autowired
    private DaifuOrderService orderService;
    @Autowired
    private DaifuCodeService codeService;
    @Autowired
    private ConfigService configService;
    @Autowired
    private BillService billService;
    @Autowired
    private WxPayService wxPayService;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private InfoService infoService;

    /**
     *个人信息填写
     */
    @RequestMapping(value = "/writeInfo", method=RequestMethod.POST)
    @ResponseBody
    @Permission
    public String writeInfo(InfoVO infoVO){
        logger.info("writeInfo" + infoVO.getEducation()+"|"+infoVO.getPhonenum()+"|"+infoVO.getZhimaCredit());
        JSONObject json = new JSONObject();
        json.put("status", 1);
        return json.toJSONString();
    }

    private String jdUrl = "https://pay.m.jd.com/newpay/queryOrderStatus.action";

    /**
     * 统一发送短信验证码的接口
     *
     * @param phoneNumber
     * @param flag
     * @return
     */
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    @ResponseBody
    public Message code(@RequestParam  String phoneNumber, @RequestParam Integer flag) {
        Member member;
        String code;
        String log = null;
        SmsEnum sms = null;
        if (!isBlank(phoneNumber) && isMobile(phoneNumber) && null != flag) {
            member = memberService.queryByPhoneNumber(phoneNumber);
            code = generateDigitRandomCode(4); //生成随机验证码
//            code = "123456"; //生成随机验证码
            switch (flag) {
                case FLAG_REGISTER:
                    if (null != member) return new Message(FLAG_PHONE_NUMBER_ALREADY_EXIST);
                    log = "手机号：" + phoneNumber + "，注册验证码 --> " + code;
                    sms = SmsEnum.CODE;
                    break;
                case FLAG_LOGIN:
                    if (null == member) return new Message(FLAG_PHONE_NUMBER_NOT_REGISTER);
                    log = "手机号：" + phoneNumber + "，登录验证码 --> " + code;
                    sms = SmsEnum.LOGIN;
                    break;
                case FLAG_FORGET_PASSWORD:
                    if (null == member) return new Message(FLAG_PHONE_NUMBER_NOT_REGISTER);
                    log = "手机号：" + phoneNumber + "，忘记密码验证码 --> " + code;
                    sms = SmsEnum.CODE;
                    break;
                case FLAG_MODIFY_PASSWORD:
                    if (null == member) return new Message(FLAG_PHONE_NUMBER_NOT_REGISTER);
                    log = "手机号：" + phoneNumber + "，修改密码验证码 --> " + code;
                    sms = SmsEnum.RESET_PASSWORD;
                    break;
                case FLAG_MODIFY_PHONE_NUMBER:
                    if (null == member) return new Message(FLAG_PHONE_NUMBER_NOT_REGISTER);
                    log = "手机号：" + phoneNumber + "，修改手机号验证码 --> " + code;
                    sms = SmsEnum.CODE;
                    break;
                case FLAG_MODIFY_PHONE_NUMBER_TWO:
                    if (null == member) {
                        log = "手机号：" + phoneNumber + "，修改获取新手机号验证码 --> " + code;
                        sms = SmsEnum.CODE;
                        break;
                    }
                    return new Message(FLAG_PHONE_NUMBER_ALREADY_EXIST);
            }
            if (null != log && null != sms) {
                if (smsCacheService.get(flag, phoneNumber)) return new Message(FLAG_IDENTIFYING_CODE_ALREADY_SEND);
                logger.info(log);
                int index = messageSendService.messSend(Arrays.asList(phoneNumber), sms, null, code);
                if (index == 0) {
                    logger.info("绑定银行卡验证码发送失败,失败原因：插入短信数据库异常");
                    return new Message(FLAG_NORMAL_ERROR);
                }
                if (index == -100) {
                    logger.info("绑定银行卡验证码发送失败,失败原因：该短信模版已失效");
                    return new Message(FLAG_NORMAL_ERROR);
                }
                smsCacheService.save(flag, phoneNumber, code);
                return Message.success("注册验证码发送成功");
            }
        }
        return new Message(FLAG_PARAMETER_IS_INCORRECT);
    }




    /**
     * 剩余额度
     * @return
     */
    @RequestMapping(value="/scredits",method= RequestMethod.GET)
    @ResponseBody
    @Permission
    public CreditsVO scredits(){
        Member member = getLoginMember();
        if(member == null){
            return new CreditsVO();
        }
        MemberDocument doc = DocumentUtils.getInstance().getByMemberId(member.getUid(),
                DocumentUtils.ADF);
        if(doc == null || doc.getDoc() == null){
            return new CreditsVO();
        }
        RiskDocument riskDoc = (RiskDocument) doc.getDoc();
        CreditsVO credits = new CreditsVO();
        credits.setZcredits(riskDoc.getMaxAmountAll());
        credits.setZcreditsP1(riskDoc.getMaxAmountP1());
        credits.setZcreditsP3(riskDoc.getMaxAmountP3());
        credits.setZcreditsP6(riskDoc.getMaxAmountP6());

        //用户所有代付款的子订单
        List<DaifuOrderLeg> allOpenOrderLegs =
                orderService.queryAllOrderLegsOfMember(member.getUid(), true, false);
        //计算总的未还款的子订单总金额
        BigDecimal totalUsedAmount = new BigDecimal(0.0);
        for(DaifuOrderLeg l:allOpenOrderLegs){
            totalUsedAmount = totalUsedAmount.add(l.getAmount());
        }
        BigDecimal totalLeftAmount = riskDoc.getMaxAmountAll().subtract(totalUsedAmount);
        if(totalLeftAmount.compareTo(BigDecimal.ZERO) < 0){
            totalLeftAmount = BigDecimal.ZERO;
        }
        BigDecimal totalLeftAmountP1 = riskDoc.getMaxAmountP1().subtract(totalUsedAmount);
        if(totalLeftAmountP1.compareTo(BigDecimal.ZERO) < 0){
            totalLeftAmountP1 = BigDecimal.ZERO;
        }
        BigDecimal totalLeftAmountP3 = riskDoc.getMaxAmountP3().subtract(totalUsedAmount);
        if(totalLeftAmountP3.compareTo(BigDecimal.ZERO) < 0){
            totalLeftAmountP3 = BigDecimal.ZERO;
        }
        BigDecimal totalLeftAmountP6 = riskDoc.getMaxAmountP6().subtract(totalUsedAmount);
        if(totalLeftAmountP6.compareTo(BigDecimal.ZERO) < 0){
            totalLeftAmountP6 = BigDecimal.ZERO;
        }

        credits.setScredits(totalLeftAmount);
        credits.setScreditsP1(totalLeftAmountP1);
        credits.setScreditsP3(totalLeftAmountP3);
        credits.setScreditsP6(totalLeftAmountP6);
        return credits;
    }

    /**
     * 是否认证
     */
    @RequestMapping(value="/identification",method=RequestMethod.GET)
    @ResponseBody
    public String identification(){
        JSONObject json = new JSONObject();
        Member member = getLoginMember();//获取session中的用户
        if(member == null){
            json.put("msg","请完成认证");
            json.put("status",0);
            return json.toJSONString();
        }
        if (!memberService.checkMemberIsActive(member.getUid(), null)) {
            json.put("msg","请完成认证");
            json.put("status",0);
            return json.toJSONString();
        }else{
            json.put("status",1);
            json.put("msg","认证成功");
            return json.toJSONString();
        }
    }


    /**
     * 代付一笔
     * @param code
     * @return
     */
    @RequestMapping(value="/sendCode",method= RequestMethod.POST)
    @ResponseBody
    @Permission
    public CodeVo sendCode(@RequestBody String code){
        logger.info("收到代付链接 "+ code);
        Member member = getLoginMember();//获取session中的用户
        if(member == null){
            logger.info("用户不存在");
            return new CodeVo("closed", "用户不存在");
        }
        if(StringUtils.isEmpty(code)){
            logger.info("代付链接是空的");
            return new CodeVo("closed", "代付链接是空的");
        }
        logger.info("用户" + member.getUid() + "发送代付链接 " + code);
        if (!memberService.checkMemberIsActive(member.getUid(), null)) {
            logger.info("用户" +member.getUid() + "没有通过认证");
            return new CodeVo("closed", "用户" +member.getUid() + "没有通过认证");
        }

        //用户没有额度
        RiskDocument riskDocument = (RiskDocument) DocumentUtils.getInstance()
                .getByMemberId(member.getUid(), DocumentUtils.ADF).getDoc();
        if (riskDocument.getMaxAmountAll().compareTo(BigDecimal.ZERO) <= 0){
            logger.info("你的信用额度不够，暂时不能处理你的代付请求" );
            return new CodeVo("closed", "你的信用额度不够，暂时不能处理你的代付请求");
        }


        CodeVo codeVo = new CodeVo();
        DaifuCodeType codeType = codeService.verifySendedCode(code, member);
        if(codeType == DaifuCodeType.unsupported){
            //返回错误
            logger.info("代付链接的类型不支持");
            codeVo.setError(configService.selectValueByKey(WeChatConstants.UNSUPPORT_PLATFORM));
            codeVo.setStatus("closed");
            return codeVo;
        }else{

            //JD代付直接处理
            if(codeType.equals(DaifuCodeType.jdapp)){

                Map<String, Object> map = ToMapUtil.urlToMap(code);
                String url = code;
                try {
                    if (code.contains("redirect_uri")) {
                        url = (String) map.get("redirect_uri");
                        url = URLDecoder.decode(url, "utf-8");
                    }
                    url = URLDecoder.decode(url, "UTF8");
                    map = ToMapUtil.urlToMap(url);
                    String appId = (String) map.get("appId");
                    String payId = (String) map.get("payId");
                    if (StringUtil.isNull(appId) || StringUtil.isNull(payId)) {
                        codeVo.setError(configService.selectValueByKey(WeChatConstants.SYSTEM_ERROR));
                        codeVo.setStatus("closed");
                        return codeVo;
                    }

                    String jdDaiFUJson = HttpRequestUtils.sendPost(jdUrl,
                            "weiXinDaiFuCode=undefined&payId=" + payId + "&appId=" + appId + "&_format_=JSON", false);
                    if (StringUtil.isNull(jdDaiFUJson)) {
                        codeVo.setError(configService.selectValueByKey(WeChatConstants.SYSTEM_ERROR));
                        codeVo.setStatus("closed");
                        return codeVo;
                    }
                    JdDaiFu jdDaiFu = JSON.parseObject(jdDaiFUJson, new TypeReference<JdDaiFu>() {});
                    if(jdDaiFu != null && jdDaiFu.getWeiXinDaiFuStatus() == 0) {
                        //保存DaifuCode
                        logger.info("链接解析成功");
                        DaifuCode daifuCode = new DaifuCode();
                        daifuCode.setDaifuId(payId);
                        daifuCode.setPlatform(codeType.name());
                        daifuCode.setShareUrl(URLDecoder.decode(url, "UTF8"));
                        daifuCode.setMemberId(member.getUid());
                        daifuCode.setItems(jdDaiFu.getItemList().get(0).getWareName());
                        daifuCode.setPrice(jdDaiFu.getOrderPrice());
                        daifuCode.setParsingStatus(DaifuCodeStatus.parsed.name());
                        daifuCode.setOrderStatus("doing");
                        daifuCode.setPrice(jdDaiFu.getOrderPrice());
                        daifuCode.setImageUrl(jdDaiFu.getItemList().get(0).getImageUrl());
                        daifuCode = codeService.create(daifuCode);

                        codeVo.setDaifuId(String.valueOf(daifuCode.getCodeId()));
                        codeVo.setStatus(daifuCode.getParsingStatus());
                        codeVo.setImageUrl(jdDaiFu.getItemList().get(0).getImageUrl());
                        codeVo.setMemerId(member.getUid());
                        codeVo.setCreatedDate(daifuCode.getCreatedDate());
                        return codeVo;
                    }else{
                        logger.info("代付链接已经失效");
                        codeVo.setError("代付链接已经失效");
                        codeVo.setStatus("closed");
                        return codeVo;
                    }

                }catch (Exception e){
                    logger.info("代付链接处理出错", e);
                    codeVo.setError(configService.selectValueByKey(WeChatConstants.SYSTEM_ERROR));
                    codeVo.setStatus("closed");
                    return codeVo;
                }
            }else if(codeType.equals(DaifuCodeType.zhi)){
                try{
                    code = URLDecoder.decode(code, "UTF8");
                    int index = code.indexOf("帮我付款");
                    if(index + 4 < code.length()) {
                        String zhicode = code.substring(index + 4, code.length());
                        zhicode = zhicode.replace("=", "");
                        //保存DaifuCode
                        DaifuCode daifuCode = new DaifuCode();
                        daifuCode.setPlatform(codeType.name());
                        daifuCode.setShareUrl(code.replace("=", ""));
                        daifuCode.setMemberId(member.getUid());
                        daifuCode.setDaifuId(zhicode);
                        daifuCode.setParsingStatus(DaifuCodeStatus.init.name());
                        daifuCode = codeService.create(daifuCode);
                        if(daifuCode.getParsingStatus().equals(DaifuCodeStatus.closed.name())){
                            codeVo.setError("该笔代付请求之前已经被关闭，无法再次提交");
                        }
                        codeVo.setStatus(daifuCode.getParsingStatus());
                        codeVo.setDaifuId(String.valueOf(daifuCode.getCodeId()));
                        codeVo.setMemerId(member.getUid());
                        codeVo.setCreatedDate(daifuCode.getCreatedDate());
                    }else{
                        return new CodeVo("closed", "爱代付暂时无法处理你的代付链接，请你检查你的请求");
                    }
                }catch (Exception e){
                    logger.info("爱代付暂时无法处理你的代付链接，请你检查你的请求", e);
                    return new CodeVo("closed", "爱代付暂时无法处理你的代付链接，请你检查你的请求");
                }
            }else{
                //jd web
                Map<String, Object> result = ToMapUtil.urlToMap(code);
                try {
                    if (!result.containsKey("dfid")) {
                        result = ToMapUtil.urlToMap(URLDecoder.decode(code, "UTF8"));
                    }

                    if(result.containsKey("dfid")) {
                        //保存DaifuCode
                        String dfid = (String) result.get("dfid");
                        DaifuCode daifuCode = new DaifuCode();
                        daifuCode.setPlatform(codeType.name());
                        daifuCode.setShareUrl(URLDecoder.decode(code, "UTF8"));
                        daifuCode.setMemberId(member.getUid());
                        daifuCode.setDaifuId(dfid);
                        daifuCode.setParsingStatus(DaifuCodeStatus.init.name());
                        daifuCode = codeService.create(daifuCode);
                        codeVo.setStatus(daifuCode.getParsingStatus());
                        codeVo.setDaifuId(String.valueOf(daifuCode.getCodeId()));
                        codeVo.setMemerId(member.getUid());
                        codeVo.setCreatedDate(daifuCode.getCreatedDate());
                    }else{
                        return new CodeVo("closed", "爱代付暂时无法处理你的代付链接，请你检查你的请求");
                    }
                }catch (Exception e){
                    logger.info("爱代付暂时无法处理你的代付链接，请你检查你的请求", e);
                    return new CodeVo("closed", "爱代付暂时无法处理你的代付链接，请你检查你的请求");
                }
            }
        }

        return codeVo;
    }



    //取消代付
    @RequestMapping(value = "/cancelCode",method=RequestMethod.POST)
    @ResponseBody
    @Permission
    public String cancelCode(@RequestParam Long daifuId){
        logger.info("用户取消代付" + daifuId);
        JSONObject json = new JSONObject();
        Member member = getLoginMember();//获取session中的用户
        if(member == null){
            json.put("status", 0);
            logger.info("用户没有登录");
            json.put("error", "用户没有登录");
            return json.toJSONString();
        }
        DaifuCode daifuCode = codeService.selectById(daifuId);
        if(daifuCode == null){
            json.put("status", 1);
            logger.info("找不到代付链接");
            json.put("error", "找不到代付链接");
            return json.toJSONString();
        }
        if(!member.getUid().equals(daifuCode.getMemberId())){
            json.put("status", 0);
            logger.info("用户没有权限取消");
            json.put("error", "用户没有权限取消");
            return json.toJSONString();
        }
        if(daifuCode.getParsingStatus().equals(DaifuCodeStatus.paid.name())){
            json.put("status", 0);
            logger.info("代付已经生成了支付订单或者完成了支付，无法直接取消, 请联系客服处理");
            json.put("error", "代付已经生成了支付订单或者完成了支付，无法直接取消, 请联系客服处理");
            return json.toJSONString();
        }
        //查看是否已经生成了zhi
        json.put("status", 1);//1成功
        return json.toJSONString();
    }

    //查询代付
    @ResponseBody
    @Permission
    @RequestMapping(value = "/getCode",method= RequestMethod.GET)
    public CodeVo getCode(@RequestParam Long daifuId){
        Member member = getLoginMember();//获取session中的用户
        if(member == null){
            return new CodeVo();
        }
        DaifuCode daifuCode = codeService.selectById(daifuId);
        if(daifuCode == null){
            return new CodeVo();
        }
        if(!member.getUid().equals(daifuCode.getMemberId())){
            return new CodeVo();
        }
        CodeVo codeVo = new CodeVo();
        codeVo.setDaifuId(String.valueOf(daifuId));
        codeVo.setMemerId(member.getUid());
        codeVo.setImageUrl(daifuCode.getImageUrl());
        codeVo.setCreatedDate(daifuCode.getCreatedDate());
        codeVo.setPrice(daifuCode.getPrice());
        codeVo.setItems(daifuCode.getItems());
        codeVo.setStatus(daifuCode.getParsingStatus());
        return codeVo;
    }

    //轮播
    @RequestMapping(value="/news",method=RequestMethod.GET)
    @ResponseBody
    @Permission
    public String history(){
        JSONObject json = new JSONObject();
        //TODO：宇博
        List<String> list = new ArrayList<String>();
        list.add("李* 完成一笔小米新品***** 代付订单");
        list.add("邓** 完成一笔vivo X21 ***** 代付订单");
        list.add("宗** 完成一笔荣耀 荣耀9***** 代付订单");
        list.add("谭* 完成一笔小米 ***** 代付订单");
        list.add("舒** 完成一笔荣耀 荣耀9***** 代付订单");
        list.add("陈** 完成一笔欧莱雅(LOREAL)***** 代付订单");
        list.add("黄* 完成一笔Swarovski***** 代付订单");
        list.add("刘* 完成一笔GIVENCHY***** 代付订单");
        list.add("田* 完成一笔韩国深度补水***** 代付订单");
        list.add("李** 完成一笔OppoR11***** 代付订单");
        list.add("叶* 完成一笔TS（淘森)***** 代付订单");
        list.add("徐** 完成一笔PaulFank烫金***** 代付订单");
        list.add("郭** 完成一笔荣耀 荣耀9***** 代付订单");
        list.add("张* 完成一笔Bose Mini ***** 代付订单");
        list.add("刘* 完成一笔荣耀 V10 ***** 代付订单");
        list.add("陈* 完成一笔尼康D5600***** 代付订单");
        list.add("何** 完成一笔ELAND学院风***** 代付订单");
        list.add("廖** 完成一笔尼康D3400***** 代付订单");
        list.add("邹** 完成一笔HomeFacialPro ***** 代付订单");
        list.add("曹* 完成一笔YSL***** 代付订单");
        list.add("原** 完成一笔耐克/Nike ***** 代付订单");
        list.add("王* 完成一笔华为 NOVA 3e ***** 代付订单");
        list.add("庄** 完成一笔cpb肌肤之钥***** 代付订单");
        list.add("洛** 完成一笔苹果 iphone8 ***** 代付订单");
        list.add("赵** 完成一笔实木折叠***** 代付订单");
        list.add("李** 完成一笔进口保税***** 代付订单");
        list.add("杨** 完成一笔TS（淘森)***** 代付订单");
        list.add("张** 完成一笔vivo X21 ***** 代付订单");
        list.add("孙* 完成一笔荣耀 V10 ***** 代付订单");
        list.add("刘* 完成一笔DW经典***** 代付订单");
        list.add("聂** 完成一笔兰蔻小黑瓶***** 代付订单");
        list.add("杨* 完成一笔KissKitty***** 代付订单");
        list.add("潘* 完成一笔亿健***** 代付订单");
        list.add("陈* 完成一笔兰蔻小黑瓶***** 代付订单");
        list.add("王** 完成一笔小米新品***** 代付订单");
        list.add("杜** 完成一笔Converse***** 代付订单");
        list.add("王** 完成一笔HLA/海澜之家***** 代付订单");
        list.add("芦** 完成一笔尼康D3400***** 代付订单");
        list.add("张** 完成一笔亿健***** 代付订单");
        list.add("田** 完成一笔小米 MIX 2s***** 代付订单");
        list.add("李* 完成一笔德国进口大功率***** 代付订单");
        list.add("罗* 完成一笔HomeFacialPro ***** 代付订单");
        list.add("周** 完成一笔Swarovski***** 代付订单");
        list.add("马** 完成一笔小米 红米***** 代付订单");
        list.add("高** 完成一笔DW经典***** 代付订单");
        list.add("徐* 完成一笔Jo Malone***** 代付订单");
        list.add("李** 完成一笔韩国代购正品***** 代付订单");
        list.add("黄** 完成一笔法国炫酷铆钉时尚***** 代付订单");
        list.add("郝** 完成一笔Coach ***** 代付订单");
        list.add("朱* 完成一笔BURBERRY***** 代付订单");
        list.add("练** 完成一笔YSL***** 代付订单");
        list.add("叶** 完成一笔兰蔻奇迹***** 代付订单");
        list.add("李* 完成一笔Jo Malone***** 代付订单");
        list.add("林** 完成一笔三星ON7***** 代付订单");
        list.add("王** 完成一笔KissKitty***** 代付订单");
        list.add("覃** 完成一笔小米 红米***** 代付订单");
        list.add("孟** 完成一笔佳能750D***** 代付订单");
        list.add("罗** 完成一笔Bose Mini ***** 代付订单");
        list.add("张** 完成一笔进口保税***** 代付订单");
        list.add("司* 完成一笔韩国深度补水***** 代付订单");
        list.add("王** 完成一笔小米 MIX 2s***** 代付订单");
        list.add("王* 完成一笔Coach ***** 代付订单");
        list.add("金* 完成一笔OppoR11 代付订单");
        list.add("郑** 完成一笔耐克/Nike ***** 代付订单");
        list.add("郭** 完成一笔华为荣耀***** 代付订单");
        list.add("曹** 完成一笔CK卡尔文***** 代付订单");
        list.add("童** 完成一笔屏风折叠***** 代付订单");
        list.add("徐* 完成一笔苹果 iphone8 ***** 代付订单");
        list.add("苏** 完成一笔HLA/海澜之家***** 代付订单");
        list.add("詹** 完成一笔黑头BLACK HEAD***** 代付订单");
        list.add("邱* 完成一笔荣耀 V10 ***** 代付订单");
        list.add("吴** 完成一笔OppoR11 代付订单");
        list.add("杨** 完成一笔黑头BLACK HEAD***** 代付订单");
        list.add("洪** 完成一笔韩国酷girl***** 代付订单");
        list.add("刘** 完成一笔韩国高颜值网红***** 代付订单");
        list.add("黎* 完成一笔韩国直邮专柜代购whoo***** 代付订单");
        list.add("金** 完成一笔佳能750D***** 代付订单");
        list.add("雷** 完成一笔美的***** 代付订单");
        list.add("郭** 完成一笔华为 NOVA 3e ***** 代付订单");
        list.add("周** 完成一笔vivo X21 ***** 代付订单");
        list.add("周** 完成一笔PANDORA潘多拉***** 代付订单");
        list.add("刘* 完成一笔荣耀 荣耀9***** 代付订单");
        list.add("郑** 完成一笔Kiehl's ***** 代付订单");
        list.add("邵** 完成一笔华为 NOVA 3e ***** 代付订单");
        list.add("车** 完成一笔锤子 坚果 ***** 代付订单");
        list.add("谢** 完成一笔PANDORA潘多拉***** 代付订单");
        list.add("江** 完成一笔PaulFank烫金***** 代付订单");
        list.add("郭* 完成一笔韩国酷girl***** 代付订单");
        list.add("唐* 完成一笔DANIEL WELLI ***** 代付订单");
        list.add("孙** 完成一笔尼康D5600***** 代付订单");
        list.add("陈** 完成一笔GIVENCHY***** 代付订单");
        json.put("list1",list);
        return json.toJSONString();
    }

    //提交支付订单
    @ResponseBody
    @Permission
    @RequestMapping(value = "/calculateCommission",method=RequestMethod.POST)
    public CommissionVO calculateCommission(@RequestParam Long daifuId, @RequestParam BigDecimal downPayment,
                              HttpServletRequest request){
        DaifuCode daifuCode = codeService.selectById(daifuId);
        CommissionVO commissionVO = new CommissionVO();
        if (daifuId != null && daifuCode != null) {
            if(daifuCode.getPrice() == null || daifuCode.getPrice().compareTo(downPayment) < 0 ||
                   downPayment == null || downPayment.compareTo(BigDecimal.ZERO) < 0){
                return commissionVO;
            }else{
                BigDecimal commission1 = orderService.calculateCommission(1, daifuCode.getPrice(), downPayment);
                BigDecimal commission3 = orderService.calculateCommission(3, daifuCode.getPrice(), downPayment);
                BigDecimal commission6= orderService.calculateCommission(6, daifuCode.getPrice(), downPayment);
                commissionVO.setTerm1(commission1);
                commissionVO.setTerm3(commission3);
                commissionVO.setTerm6(commission6);
            }
        }
        return commissionVO;
    }


    //提交支付订单
    @ResponseBody
    @Permission
    @RequestMapping(value = "/submitOrder",method=RequestMethod.POST)
    public String submitOrder(@RequestParam Long daifuId, @RequestParam Integer termNumber,  @RequestParam BigDecimal downPayment,
                              HttpServletRequest request){
        logger.info("收到用户的代付提交:" + daifuId + "|" +termNumber +"|" +downPayment);
        JSONObject json = new JSONObject();
        Member member = getLoginMember();
        DaifuCode daifuCode = codeService.selectById(daifuId);
        if (daifuId != null && daifuCode != null
                && daifuCode.getParsingStatus().equals(DaifuCodeStatus.parsed.name())) {
            try {
                //判断downpayment
                if(daifuCode.getPrice().compareTo(downPayment) < 0 ||
                        downPayment.compareTo(BigDecimal.ZERO) < 0 || !(termNumber == 1 || termNumber == 3 || termNumber == 6)){
                    json.put("status", 0);
                    json.put("error", "用户提交的输入有误");
                    logger.info("用户提交的信息有误");
                    return json.toJSONString();
                }

                //if the same daifu code has a order
                if(orderService.selectOrderByCodeId(daifuId) != null){
                    json.put("status", 0);
                    json.put("error", "亲你的代付已经在处理中，请勿重复提交代付订单");
                    logger.info("请勿重复提交代付订单");
                    return json.toJSONString();
                }

                String checkRisk = codeService.checkDaifuRisk(daifuCode, member);
                if(!checkRisk.equals("Success")){
                    json.put("status", 0);
                    json.put("error", "订单没有通过我们的检查！");
                    logger.info("订单没有通过我们的检查");
                    return json.toJSONString();
                }

                //计算额度是否足够
                MemberDocument doc = DocumentUtils.getInstance().getByMemberId(member.getUid(),
                        DocumentUtils.ADF);
                if(doc == null || doc.getDoc() == null){
                    json.put("status", 0);
                    json.put("error", "你没有足够的额度，如有疑问请联系客服");
                    return json.toJSONString();
                }
                RiskDocument riskDoc = (RiskDocument) doc.getDoc();
                BigDecimal maxAmount = riskDoc.getMaxAmountP1();
                if(termNumber == 3){
                    maxAmount = riskDoc.getMaxAmountP3();
                }else if(termNumber == 6){
                    maxAmount = riskDoc.getMaxAmountP6();
                }
                List<DaifuOrderLeg> allOpenOrderLegs = orderService.queryAllOrderLegsOfMember(member.getUid(),
                        true, false);
                //计算总的未还款的子订单总金额
                BigDecimal totalUsedAmount = new BigDecimal(0.0);
                for(DaifuOrderLeg l:allOpenOrderLegs){
                    totalUsedAmount = totalUsedAmount.add(l.getAmount());
                }
                BigDecimal left = maxAmount.subtract(totalUsedAmount)
                        .add(downPayment).subtract(daifuCode.getPrice());
                if(left.compareTo(BigDecimal.ZERO) < 0){
                    json.put("status", 0);
                    json.put("error", "你没有足够的额度，如有疑问请联系客服");
                    return json.toJSONString();
                }
                //计算首付加手续费
                BigDecimal commission = orderService.calculateCommission(termNumber, daifuCode.getPrice(), downPayment);
                BigDecimal totalAmount = commission.add(downPayment).setScale(2,BigDecimal.ROUND_HALF_DOWN);
                //保存下上下文
                JSONObject codeInfo = new JSONObject();
                codeInfo.put("downPayment", downPayment.multiply(new BigDecimal(100)).intValue());
                codeInfo.put("commission", commission.multiply(new BigDecimal(100)).intValue());
                codeInfo.put("totalAmount",  totalAmount.multiply(new BigDecimal(100)).intValue());
                codeInfo.put("term", termNumber);
                String payId = "DAIFU" + daifuId;
                redisService.set(payId, codeInfo.toJSONString());

                //发起微信付款请求
                String result =  wxPayService.weChatPay(totalAmount, member.getWechatOpenid(),
                        payId, "购物服务", UserUtil.getUserIp(request), false);
                logger.info(result);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("微信手续费支付异常,代付订单:" + daifuId);
            }
        }
        json.put("status", 0);
        json.put("error", "请重新提交代付订单");
        return json.toJSONString();
    }

    //提交支付订单
    @ResponseBody
    @Permission
    @RequestMapping(value = "/payBill",method=RequestMethod.POST)
    public synchronized String payBill(@RequestBody PayBillVo payBillVo, HttpServletRequest request){
        JSONObject json = new JSONObject();
        Member member = getLoginMember();
        BillCollection billCollection = billService.getBillCollection(payBillVo.getBillId());
        if(billCollection == null || billCollection.getStatus().equals(BillStatus.waiting.name())){
            json.put("status", 0);
            json.put("error", "本期账单还没有发出，无法付款");
            return json.toJSONString();
        }
        //所有等待付款的leg
        List<DaifuOrderLeg> legs = orderService.queryAllOrderLegsInBill(billCollection.getBillId(),
                true, false);

        //TODO：目前的设计，用户可以重复多次提交还款请求，如果中间部分请求没有支付完成，则通过超时检查关闭
//        List<Repayment> pendingRepayments = billService.getRepaymentInBill(payBillVo.getBillId(),
//                false).stream().filter(r -> r.getStatus().equals(RepaymentStatus.pending.name()))
//                .collect(Collectors.toList());
        //若果有正在支付的还款，则直接返回
//        if(pendingRepayments.size() > 0){
//            json.put("status", 0);
//            json.put("error", "请先完成之前的一笔付款，不要重复提交");
//            return json.toJSONString();
//        }

        BigDecimal totalUsedAmount = new BigDecimal(0.0);
        String transId = "TRANS" + idGenerator.nextId();
        for(DaifuOrderLeg leg : legs){
            OrderLegStatus status = orderService.checkAndCloseOrderLeg(leg.getOrderlegId(), false);
            //如果已经完成了支付，则跳过
            if(status.equals(OrderLegStatus.paid)){
                continue;
            }
            //TODO: 支持部分付款
            //增加还款属性
            billService.createRepaymentForOrderLeg(leg.getOrderlegId(), transId, member);
            //计算还款总额
            totalUsedAmount = totalUsedAmount.add(leg.getAmount());
            totalUsedAmount = totalUsedAmount.add(leg.getFee());
            totalUsedAmount = totalUsedAmount.add(leg.getInterest());
        }
        if(totalUsedAmount.compareTo(BigDecimal.ZERO) > 0){
            //如果需要还款
            try {
                redisService.set(transId, String.valueOf(totalUsedAmount.multiply(new BigDecimal(100)).intValue()));
                return wxPayService.weChatPay(totalUsedAmount, member.getWechatOpenid(),
                        transId, "购物服务", UserUtil.getUserIp(request), false);
            }catch (Exception e){
                logger.error("账单付异常,代付订单:" + transId, e);
            }

        }
        json.put("status", 0);
        json.put("error", "订单提交错误");
        return json.toJSONString();
    }


    /**
     * 账单总额
     */
    @RequestMapping(value="/billInfo", method=RequestMethod.GET)
    @ResponseBody
    @Permission
    public TotalBillVO currentBills(){
        Member member = getLoginMember();
        if(member == null){
            return new TotalBillVO();
        }
        BillCollection currentBill = billService.getCurrentBillCollection(member.getUid(), new Date());
        if(currentBill == null){
            List<BillCollection> bills = billService.getBillCollections(member.getUid(), BillStatus.published);
            for(BillCollection bill: bills) {
                if (bill.getDueDate().compareTo(new Date()) < 0) {
                    BigDecimal total = billService.getTotalAmountPlusInterestInBill(bill.getBillId());
                    BigDecimal paid = billService.getPaidAmountPlusInterestInBill(bill.getBillId());
                    if (paid.compareTo(total) < 0) {
                        currentBill = bill;
                    }
                }
            }
            if(currentBill == null) {
                return new TotalBillVO();
            }
        }
        BillCollection nextBill = billService.getNextBill(member.getUid(), currentBill.getBillId());
        TotalBillVO totalBill = new TotalBillVO();
        totalBill.setCurrentBillId(currentBill.getBillId());
        //已出账单
        BigDecimal totalAmount = billService.getTotalAmountPlusInterestInBill(currentBill.getBillId());
        BigDecimal paidAmount = billService.getPaidAmountPlusInterestInBill(currentBill.getBillId());
        totalBill.setBillsTrueAmount(totalAmount);
        //未出账单
        if(nextBill == null) {
            totalBill.setBillsFalseAmount(new BigDecimal(0));
        }else{
            totalBill.setBillsFalseAmount(billService.getTotalAmountPlusInterestInBill(nextBill.getBillId()));
        }
        //本期待还款金额 = 所有金额 - 已还的金额
        totalBill.setLeftBillAmount(totalAmount.subtract(paidAmount));
        //还款日期
        totalBill.setPayDay(currentBill.getDueDate().getTime());
        return totalBill;
    }


    /**
     * 当期账单明细
     */
    @RequestMapping(value="/billList", method=RequestMethod.GET)
    @ResponseBody
    @Permission
    public List<BillVo> currentBilList(){
        Member member = getLoginMember();
        if(member == null){
            return ImmutableList.of();
        }
        BillCollection billCollection = billService.getCurrentBillCollection(member.getUid(), new Date());
        if(billCollection == null){
            List<BillCollection> bills = billService.getBillCollections(member.getUid(), BillStatus.published);
            for(BillCollection bill: bills) {
                if (bill.getDueDate().compareTo(new Date()) < 0) {
                    BigDecimal total = billService.getTotalAmountPlusInterestInBill(bill.getBillId());
                    BigDecimal paid = billService.getPaidAmountPlusInterestInBill(bill.getBillId());
                    if (paid.compareTo(total) < 0) {
                        billCollection = bill;
                    }
                }
            }
            if(billCollection == null) {
                return ImmutableList.of();
            }
        }
        List<DaifuOrderLeg> daifuOrderLegs = orderService.queryAllOrderLegsInBill(billCollection.getBillId(), false, false);
        List<Repayment> repayments = billService.getRepaymentInBill(billCollection.getBillId(), true);
        Map<Long, Repayment> repaymentMap = new HashMap<>();
        for(Repayment r : repayments){
            if(!repaymentMap.containsKey(r.getOrderLegId())){
                repaymentMap.put(r.getOrderLegId(), r);
            }else{
                Repayment old = repaymentMap.get(r.getOrderLegId());
                //累加还款金额
                old.setPrice(old.getPrice().add(r.getPrice()));
                old.setFee(old.getPrice().add(r.getFee()));
                old.setInterest(old.getPrice().add(r.getInterest()));
            }
        }

        List<BillVo> list = new ArrayList<>();
        for(DaifuOrderLeg leg : daifuOrderLegs){
            DaifuOrder order = orderService.selectOne(leg.getOrderId());
            if(order != null) {
                BillVo billVo = new BillVo();
                billVo.setCreatedDate(leg.getCreatedDate().getTime());
                billVo.setPrice(leg.getAmount());
                billVo.setTitle(order.getTitle());
                billVo.setFee(leg.getFee());
                billVo.setInterest(leg.getInterest());
                billVo.setOverdueStatus(leg.getOverdueStatus());
                billVo.setStatus(leg.getStatus());
                Repayment r = repaymentMap.get(leg.getOrderlegId());
                if(r != null) {
                    billVo.setPaidFee(r.getFee());
                    billVo.setPrice(r.getPrice());
                    billVo.setPaidInterest(r.getInterest());
                }
                list.add(billVo);
            }
        }
        return list;
    }


    //计算还款计划表
    @ResponseBody
    @Permission
    @RequestMapping(value = "/calcPayPlan",method=RequestMethod.POST)
    public List<RepaymentPlanVo> calcPayPlan(@RequestBody PayPlanRequestVo vo){
        Member member = getLoginMember();
        if(member == null){
            return ImmutableList.of();
        }
        if(vo.getTerm() == null || vo.getTerm() <= 0){
            return ImmutableList.of();
        }
        //计算利息，收付费等设置
        Double monthlyPay = (vo.getPrice().subtract(vo.getDownPayment())).doubleValue() / vo.getTerm();
        BigDecimal monthFee = orderService.calculateMonthlyFee(vo.getTerm(), vo.getPrice(), vo.getDownPayment());
        //计算如果当前付款的话，用户的还款计划
        List<Pair<Date, Date>> billDates = billService.calcBillAndPayDate(member, new Date(), vo.getTerm());
        List<RepaymentPlanVo> plans = new ArrayList<>();
        for(Pair<Date,Date> datePair : billDates){
            RepaymentPlanVo plan = new RepaymentPlanVo();
            plan.setAmount(new BigDecimal(monthlyPay).add(monthFee).setScale(2, RoundingMode.HALF_DOWN));
            plan.setDate(datePair.getSecond().getTime());
            plan.setFee(monthFee);
            plan.setInterest(new BigDecimal(0.0));
            plan.setStatus(OrderLegStatus.open.name());
            plan.setTotalAmount(monthFee.add(new BigDecimal(monthlyPay)));
            plans.add(plan);
        }
        return plans;
    }


    //已有订单的还款计划表
    @ResponseBody
    @Permission
    @RequestMapping(value = "/payPlan",method=RequestMethod.GET)
    public List<RepaymentPlanVo> payPlan(Long orderId){
        Member member = getLoginMember();
        if(member == null){
            return ImmutableList.of();
        }
        if(orderId == null){
            return ImmutableList.of();
        }
        DaifuOrder order = orderService.selectOne(orderId);
        if(order == null){
            return ImmutableList.of();
        }
        List<RepaymentPlanVo> list = new ArrayList<>();
        //计算利息，收付费等设置
        double reverse_term = 1.0 / order.getTotalTerm();
        BigDecimal monthlyPay = (order.getPrice().subtract(order.getDownPayment()))
                .multiply(new BigDecimal(reverse_term));
        BigDecimal monthFee = order.getMonthlyFee();
        List<Pair<Date, Date>> billDates = billService.calcBillAndPayDate(member, new Date(), order.getTotalTerm());
        List<DaifuOrderLeg> orderLegs = orderService.queryAllOrderLegsInOrder(orderId, false, false);
        if(orderLegs.size() != billDates.size()){
            return ImmutableList.of();
        }
        int i = 0;
        for(DaifuOrderLeg leg : orderLegs){
            RepaymentPlanVo plan = new RepaymentPlanVo();
            plan.setAmount(leg.getAmount());
            //如果子订单还没有付款，则设置付款日期为预计账单付款日
            //否则设置为实际付款日
            if(plan.getStatus().equals(OrderLegStatus.open.name())) {
                plan.setDate(billDates.get(i).getSecond().getTime());
            }else{
                plan.setDate(leg.getLastUpdatedDate().getTime());
            }
            plan.setFee(leg.getFee());
            plan.setInterest(leg.getInterest());
            plan.setStatus(leg.getStatus());
            plan.setTotalAmount(monthFee.add(monthlyPay));
            list.add(plan);
            i++;
        }
        return list;
    }




    /**
     * 个人中心
     * 也就是老版
     * 首页进入 -->我的
     */
    @RequestMapping(value = "/myself",method=RequestMethod.GET)
    @ResponseBody
    @Permission
    public String myself() {
        JSONObject json = new JSONObject();
        Member member = getLoginMember();
        if(member == null){
            return "";
        }
        json.put("phone", member.getPhoneNumber());
        json.put("figure", member.getWechatHeadimgurl());
        json.put("name", member.getWechatNickname());
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        if(memberDetail != null) {
            json.put("name", memberDetail.getFullname());
            json.put("education", memberDetail.getGraduationTime());
            json.put("vocation", memberDetail.getVocation());
        }

        return json.toString();
    }


    /**
     * 查询用户每项验证状态
     */
    @RequestMapping(value = "/verification", method=RequestMethod.GET)
    @ResponseBody
    @Permission
    public String getVerificationStatus() {
        JSONObject json = new JSONObject();
        Member member = getLoginMember();
        if(member == null){
            json.put("idCard",false);
            json.put("bankCard",false);
            json.put("TMobile",false);
            json.put("Taobao",false);
            json.put("JD",false);
            json.put("PhoneBinded",false);
            return json.toJSONString();
        }
        json.put("idCard", memberService.checkIdcardIsCertified(member.getUid()));
        json.put("bankCard", memberService.checkBankCardIsCertified(member.getUid()));
        json.put("TMobile",memberService.checkTmobileIsCertified(member.getUid()));
        json.put("Taobao",memberService.checkTaobaoDataGathered(member.getUid()));
        json.put("JD",memberService.checkJDDataGathered(member.getUid()));
        Member newMember = memberService.queryByUid(member.getUid());
        json.put("PhoneBinded", !StringUtils.isEmpty(newMember.getPhoneNumber()));
        return json.toJSONString();
    }


    //获取微信API的signature等信息
    @RequestMapping(value = "/getWxToken", method=RequestMethod.POST)
    @ResponseBody
    @Permission
    public String getWxToken(String url) {
        JSONObject json = new JSONObject();
        String access_token = accessTokenService.getAccessToken();
        String jsapi_ticket = accessTokenService.getJsapiTicket(access_token);
        String noncestr = WxSignUtil.generateNonceStr(6);
        String timestamp = WxSignUtil.getTimestamp();
        SortedMap<Object, Object> params = new TreeMap<Object, Object>();
        params.put("noncestr", noncestr);
        params.put("jsapi_ticket", jsapi_ticket);
        params.put("timestamp", timestamp);
        params.put("url", domainName + url);
        String sign = WxSignUtil.createSignBySha1(params);
        json.put("appId",appid);
        json.put("noncestr",noncestr);
        json.put("timestamp",timestamp);
        json.put("signature",sign);
        return json.toJSONString();
    }

    //提交银行卡认证
    @RequestMapping(value = "/idcard", method=RequestMethod.POST)
    @Permission
    @ResponseBody
    public String idCard(@RequestParam String pictureFront, @RequestParam String pictureBack) {
        try {
            JSONObject json = new JSONObject();
            if (StringUtil.isNull(pictureFront) || StringUtil.isNull(pictureBack)) {
                json.put("msg", "图片上传失败,请再次尝试");
                json.put("flag", 0);
                return json.toJSONString();
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
                    json.put("frontJSON", frontJSON.getJSONObject("data"));
                    json.put("backJSON", backJSON.getJSONObject("data"));
                    json.put("flag", 1);
                    return json.toJSONString();
                } else {
                    json.put("msg", "您上传的图片不是有效的身份证图片，请重新上传");
                    json.put("flag", 0);
                    return json.toJSONString();
                }
            }
        }catch (Exception e){
            logger.info("上传身份证失败", e);
            JSONObject json = new JSONObject();
            json.put("msg", "失败");
            json.put("flag", 0);
            return json.toJSONString();
        }
    }

    //提交jxl认证
    @RequestMapping(value = "/jxl", method = RequestMethod.POST)
    @ResponseBody
    @Permission
    public String jxl(@RequestParam  String phone, @RequestParam String password, @RequestParam String code, HttpServletResponse response) {
        JSONObject resultJson = new JSONObject();
        Member member = getLoginMember();

        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            resultJson.put("msg", "手机号，服务密码，随机码不能为空");
            resultJson.put("flag", 0);
            resultJson.put("phone", phone);
            resultJson.put("password", password);
            ServletUtil.createSuccessResponse(200, resultJson, response);
            return resultJson.toJSONString();
        }

        JSONObject jsonObject = null;
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());

        if(StringUtils.isEmpty(code)) {
            //1分钟内防止重复认证
            if (redisService.get("StartCode" + phone) != null) {//从redis中根据手机号获取这个对象
                resultJson.put("phone", phone);
                resultJson.put("flag", 0);
                resultJson.put("msg", "请一分钟内不要重复提交");
                return resultJson.toJSONString();
            }
            redisService.set("StartCode" + phone, 1, 60);//存储一个对象，设置存活时间，意思就是设置这个手机号的在缓存里面存活60秒
            jsonObject = jxlDataService.JXLReturnMsg(memberDetail.getFullname(), phone, memberDetail.getIdCard());
            redisService.set("JXLtoken" + phone, jsonObject, 600);

        }else{
            if (redisService.get("bindJXL" + code + member.getUid()) != null) {
                resultJson.put("msg", "两分钟内请不要重复提交相同随机码");
                resultJson.put("flag", 0);
                resultJson.put("phone", phone);
                resultJson.put("password", password);
                return resultJson.toJSONString();
            }
            if (redisService.get("JXLtoken" + phone) == null) {
                resultJson.put("msg", "JXLtoken已失效,请重新获取短信随机码");
                resultJson.put("flag", 0);
                resultJson.put("phone", phone);
                resultJson.put("password", password);
                return resultJson.toJSONString();
            }
            jsonObject = JSON.parseObject(redisService.get("JXLtoken" + phone).toString());
        }

        String token = jsonObject.getString("token");
        String website = jsonObject.getString("website");

        JSONObject flagJSON = jxlDataService.JXLCollectReq(token, phone, password, website, code);
        if (!(boolean) flagJSON.get("success")) {
            resultJson.put("msg", flagJSON.getString("message"));
            resultJson.put("phone", phone);
            resultJson.put("flag", 0);
            logger.info(flagJSON.getString("message"));
            redisService.delete("StartCode" + phone);
            return resultJson.toJSONString();
        }
        String type = jxlDataService.returnData(new Date(), new Date(), token, phone, password, website, "");
        if (type.equals("输入验证码")) {
            sendJXLSmsCode(phone, password);
            resultJson.put("phone", phone);
            resultJson.put("msg", "验证码发送成功");
            resultJson.put("password", password);
            resultJson.put("flag", 1);
            logger.info(type);
            redisService.delete("StartCode" + phone);
            return resultJson.toJSONString();
        }
        if (type.equals("采集结束")) {
            String type3 = jxlDataService.returnStatusData(new Date(), new Date(), memberDetail.getFullname(), phone, memberDetail.getIdCard());
            if (!type3.equals("获取报告状态成功")) {
                resultJson.put("phone", phone);
                resultJson.put("msg", type3);
                resultJson.put("flag", 0);
                redisService.delete("StartCode" + phone);
                logger.info("获取报告状态失败,失败原因:" + type3);
                return resultJson.toJSONString();
            }
            memberService.calculateQuota(member);
            resultJson.put("msg", "验证成功");
            resultJson.put("flag", 2);
            redisService.delete("StartCode" + phone);
            return resultJson.toJSONString();
        }
        resultJson.put("phone", phone);
        resultJson.put("flag", 0);
        resultJson.put("msg", type);
        redisService.delete("StartCode" + phone);
        return resultJson.toJSONString();
    }

    //点击进行发短信的
    private JSONObject sendJXLSmsCode(String phone, String password) {
        Member member = getLoginMember();
        JSONObject jo = new JSONObject();

        if (redisService.get("JXLCode" + member.getUid()) != null) {
            jo.put("msg", "验证码请求太频繁");
            return jo;
        }
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        if (StringUtil.isNull(password)) {
            jo.put("msg", "服务密码不能为空");
            return jo;
        }
        JSONObject object = jxlDataService.JXLReturnMsg(memberDetail.getFullname(), phone, memberDetail.getIdCard());
        String token = object.getString("token");
        String website = object.getString("website");
        redisService.set("JXLtoken" + phone, object, 600);
        JSONObject flag = jxlDataService.JXLCollectReq(token, phone, password, website, "");
        if ((boolean) flag.get("success")) {
            redisService.set("JXLCode" + member.getUid(), "1", 60);
            jo.put("msg", "短信随机码发送成功");
            return jo;
        } else {
            jo.put("msg", "短信随机码发送失败");
            return jo;
        }
    }

//    绑定银行卡
    @RequestMapping(value="/bindBankCard",method = RequestMethod.POST)
    @ResponseBody
    @Permission
    public String bindBankCard(@RequestParam String bankcardNumber) {
        JSONObject json = new JSONObject();
        Member member = getLoginMember();
        if (!memberService.checkIdcardIsCertified(member.getUid())) {//如果数据库中存在这个身份证（字段），则代表已经认证过了
            json.put("msg","请完成身份证绑定!");
            json.put("flag", 0);
            return json.toJSONString();
        }
        if (!memberService.checkTmobileIsCertified(member.getUid())) {//如果数据库中存在这个手机号（字段），则代表已经认证过了
            json.put("msg","请完成运营商验证!");
            json.put("flag", 0);
            return json.toJSONString();
        }
        logger.info("四要素认证手机号:" + member.getPhoneNumber() + "银行卡:" + bankcardNumber);
        MemberBankcard memberBankcard = new MemberBankcard();//这个是用户银行卡对象
        memberBankcard.setBankcardNumber(bankcardNumber);//把银行卡信息存入银行卡对象中
        List<MemberBankcard> memberBankcardList = memberBankcardService.queryBankcard(memberBankcard);
        if (memberBankcardList != null && memberBankcardList.size() > 0) {
            json.put("msg","不能重复绑卡!");
            json.put("flag", 0);
            return json.toJSONString();
        }
        memberBankcard.setPhonenumber(member.getPhoneNumber());//把用户手机号存入银行卡对象中
        String error = memberBankcardService.checkBankcard(memberBankcard);//这个就是经过service进行一些简单的判断，如银行卡号的位数，手机号的正确性
        if (error != null) {
            json.put("msg",error);
            json.put("flag", 0);
            return json.toJSONString();
        }
        String channelOrderId = member.getUid() + CalculateUtil.generateMixRandomCode(12);//用户id加上一个随机的12位的数字
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());//查出这个用户的cl_member_detail表中的信息
        JSONObject jsonObject = thirdVerifyService.cardVerify(memberDetail.getFullname(),
                memberDetail.getIdCard(),
                member.getPhoneNumber(),
                bankcardNumber, new Date(), channelOrderId);//这个会在这个方法cardVerify中进行银行卡的认证（具体认证在cardVerify方法中的这个IdentityCheckService的这个方法cardXmlMap进行认证，验证过后存入到VerifyParameter对象中，最后存入数据库中，或者更新到数据库中），
        if (jsonObject != null) {
            if ("银行卡账户认证获取数据成功".equals(jsonObject.get("msg"))) {
                memberBankcard.setMemberid(member.getUid());
                memberBankcard.setCardAddtime(new Date());
                memberBankcard.setCardState(1);
                memberBankcardService.addBankcard(memberBankcard);
                json.put("msg","绑定成功");
                json.put("flag", 1);
                return json.toJSONString();
            }
            json.put("flag", 0);
            json.put("msg",jsonObject.get("msg"));
            return json.toJSONString();
        }
        json.put("msg","绑卡失败,请输入匹配的信息!");
        json.put("flag", 0);
        return json.toJSONString();
    }

    @RequestMapping(value = "/order", method=RequestMethod.GET)
    @ResponseBody
    @Permission
    public GoodVO order(@RequestParam Long orderId){
        Member member = getLoginMember();
        if(member == null){
            return new GoodVO();
        }
        DaifuOrder order = orderService.selectOne(orderId);
        if(order == null || order.getMemberId() != member.getUid()){
            return new GoodVO();
        }
        GoodVO vo = new GoodVO();
        vo.setGoogName(order.getTitle());
        // TODO: 商品图片
        vo.setImage("");
        DaifuCode code = codeService.selectById(order.getCodeId());
        if(code != null && code.getPlatform().equals(DaifuCodeType.zhi.name())) {
            vo.setList(ImmutableList.of("淘宝"));
        }
        if(code != null && (
                code.getPlatform().equals(DaifuCodeType.jdweb.name()) ||
                        code.getPlatform().equals(DaifuCodeType.jdapp.name()))) {
            vo.setList(ImmutableList.of("京东"));
        }
        vo.setOrdernum(order.getOrderId());
        vo.setPrice(order.getPrice());
        vo.setCommission(order.getCommission());
        vo.setMonthlyFee(order.getMonthlyFee());
        vo.setTime(order.getCreatedDate().getTime());
        return vo;
    }

    @RequestMapping(value = "/getOrder", method=RequestMethod.GET)
    @ResponseBody
    @Permission
    public GoodVO getOrder(@RequestParam Long orderId){
        Member member = getLoginMember();
        if(member == null){
            return new GoodVO();
        }
        List<GoodVO> result = new ArrayList<>();
        DaifuOrder order = orderService.selectOne(orderId);
        GoodVO vo = new GoodVO();
        vo.setGoogName(order.getTitle());
        DaifuCode code = codeService.selectById(order.getCodeId());
        if(code != null) {
            vo.setImage(code.getImageUrl());
        }
        if(code != null && code.getPlatform().equals(DaifuCodeType.zhi.name())) {
            vo.setList(ImmutableList.of("淘宝"));
        }
        if(code != null && (
                code.getPlatform().equals(DaifuCodeType.jdweb.name()) ||
                        code.getPlatform().equals(DaifuCodeType.jdapp.name()))) {
            vo.setList(ImmutableList.of("京东"));
        }
        vo.setOrdernum(order.getOrderId());
        vo.setPrice(order.getPrice());
        vo.setStatus(order.getStatus());
        vo.setCommission(order.getCommission());
        vo.setMonthlyFee(order.getMonthlyFee());
        vo.setTime(order.getCreatedDate().getTime());

        return vo;
    }



    //  订单列表
    //  在原来的程序中没有标签这个东西list
    //  订单状态,0-未提交,1-已提交待审批,2-审批通过,3-审批拒绝,4-订单关闭,5待放款，6放款中,7已放款,8放款失败,9订单中止(一直没有放款结果的单子),10订单结清
    @RequestMapping(value = "/orderList", method=RequestMethod.GET)
    @ResponseBody
    @Permission
    public List<GoodVO> orderList(){
        Member member = getLoginMember();
        if(member == null){
            return ImmutableList.of();
        }
        List<GoodVO> result = new ArrayList<>();
        List<DaifuOrder> orders = orderService.queryOrderByUser(member.getUid(), false, false);
        for(DaifuOrder order: orders){
            GoodVO vo = new GoodVO();
            vo.setGoogName(order.getTitle());
            DaifuCode code = codeService.selectById(order.getCodeId());
            if(code != null) {
                vo.setImage(code.getImageUrl());
            }
            if(code != null && code.getPlatform().equals(DaifuCodeType.zhi.name())) {
                vo.setList(ImmutableList.of("淘宝"));
            }
            if(code != null && (
                    code.getPlatform().equals(DaifuCodeType.jdweb.name()) ||
                            code.getPlatform().equals(DaifuCodeType.jdapp.name()))) {
                vo.setList(ImmutableList.of("京东"));
            }
            vo.setOrdernum(order.getOrderId());
            vo.setPrice(order.getPrice());
            vo.setStatus(order.getStatus());
            vo.setCommission(order.getCommission());
            vo.setMonthlyFee(order.getMonthlyFee());
            vo.setTime(order.getCreatedDate().getTime());
            result.add(vo);
        }

        return result;
    }

    @RequestMapping(value="/getZhiCodeJson",method= RequestMethod.GET)
    @Permission(loginReqired=false)
    @ResponseBody
    public String queryZhiJson(Model model, @RequestParam("secret") String secret){
        Config trueSecret = configService.selectByKey("SECRET");
        JSONObject json = new JSONObject();
        if(trueSecret == null || StringUtils.equals(trueSecret.getValue(), secret)) {
            List<DaifuCode> codes = codeService.queryAll("zhi", "init").stream().filter(c ->{
                Date rangeStart = DateUtils.addMinutes(new Date(), -60);
                if(c.getCreatedDate().compareTo(rangeStart) > 0){
                    return true;
                }
                return false;
            }).sorted(Comparator.comparing(DaifuCode::getCreatedDate)).collect(Collectors.toList());

            if(codes != null && codes.size() >0){
                json.put("codeId", codes.get(0).getCodeId());
                json.put("shareUrl", codes.get(0).getShareUrl());
            }
        }
        return json.toJSONString();
    }


    @RequestMapping(value="/getZhiCode",method= RequestMethod.GET)
    @Permission(loginReqired=false)
    public String queryZhi(Model model, @RequestParam("secret") String secret){
        Config trueSecret = configService.selectByKey("SECRET");
        if(trueSecret == null || StringUtils.equals(trueSecret.getValue(), secret)) {
            List<DaifuCode> codes = codeService.queryAll("zhi", "init").stream().filter(c ->{
                Date rangeStart = DateUtils.addMinutes(new Date(), -60);
                if(c.getCreatedDate().compareTo(rangeStart) > 0){
                    return true;
                }
                return false;
            }).sorted(Comparator.comparing(DaifuCode::getCreatedDate)).collect(Collectors.toList());

            if(codes != null && codes.size() >0){
                model.addAttribute("shareUrl", codes.get(0).getShareUrl());
            }
        }
        return "h5/shareUrl";
    }

    @RequestMapping(value="/updateZhiCode",method= RequestMethod.POST)
    @ResponseBody
    @Permission(loginReqired=false)
    public String updateZhi(@RequestBody DaifuCodeResultVo resultVo, @RequestParam("secret") String secret){
        logger.info("收到上位机返回的口令解析信息" + resultVo.toString());
        Config trueSecret = configService.selectByKey("SECRET");
        //检查权限
        if(trueSecret == null || StringUtils.equals(trueSecret.getValue(), secret)){
            if(resultVo.getCodeId() == null){
                return "NO_CODE_FOUND";
            }
            DaifuCode code = codeService.selectById(resultVo.getCodeId());
            if(code == null){
                return "NO_CODE_FOUND";
            }
            code.setOrderStatus(resultVo.getOrderStatus());
            code.setPrice(resultVo.getAmount());
            code.setItems(resultVo.getGoods());
            code.setUsername(resultVo.getUsername());
            code.setPhonenum(resultVo.getPhonenum());
            code.setParsingStatus(resultVo.getParsingStatus());
            codeService.update(code);
            return "SUCCESS";
        }
        return "NO_PERMISSION";
    }

}
