package com.shoumipay.v2.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.*;
import com.shoumipay.domain.*;
import com.shoumipay.domain.MemberExample.Criteria;
import com.shoumipay.domain.gxb.JDData;
import com.shoumipay.domain.gxb.OrderInfo;
import com.shoumipay.service.ThirdVerifyService;
import com.shoumipay.service.admin.*;
import com.shoumipay.service.examine.*;
import com.shoumipay.service.wechat.WeChatService;
import com.shoumipay.tools.*;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.docs.MemberDocument;
import com.shoumipay.v2.domain.docs.RiskDocument;
import com.shoumipay.v2.service.BQSRiskService;
import com.shoumipay.v2.service.DianShangRiskService;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.v2.service.MobilePhoneRiskService;
import com.shoumipay.vo.CountOrderStatusVO;
import com.shoumipay.vo.MemberVO;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.StrictMath.min;

/**
 * Created by Zhw on 2017/10/16.
 */
@Service
public class MemberServiceImpl implements MemberService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberDetailMapper memberDetailMapper;
    @Autowired
    private MemberLinkmanMapper memberLinkmanMapper;
    @Autowired
    private MemberJobsMapper memberJobsMapper;
    @Autowired
    private MemberDevicesMapper memberDevicesMapper;
    @Autowired
    private MemberBankcardMapper memberBankcardMapper;
    @Autowired
    private ExamineRuleService examineRuleService;
    @Autowired
    private OperLogsService operLogsService;
    @Autowired
    private MemberDetailService memberDetailService;
    @Autowired
    private ThirdVerifyService thirdVerifyService;
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private BQSRiskService bqsService;
    @Autowired
    private MobilePhoneRiskService mobilePhoneRiskService;
    @Autowired
    private DianShangRiskService dianShangRiskService;
    @Autowired
    private WeChatService weChatService;

    //所有审核规则放在这里
    private List<ExamineService> examineServiceList;

    @Override
    public List<Member> getAllMember() {
        return memberMapper.findAll();
    }

    @Override
    public Member login(String username, String password) {
        if (StringUtil.isNull(username) || StringUtil.isNull(password)) {
            return null;
        }
        Member member = memberMapper.selectByUsername(username);
        if (member == null) {
            return null;
        }
        password = UserUtil.getMD5Password(password, member);
        if (!password.equals(member.getPassword())) {
            return null;
        }
        return member;
    }


    //TODO 存放于redis 设置过期时间
    /**
     * 存放“用户名：token”键值对
     */
    public static Map<String, String> tokenMap = new HashMap<String, String>();
    /**
     * 存放“token:User”键值对
     */
    public static Map<String, Member> loginUserMap = new HashMap<String, Member>();

    public String getToken(Member member) {
        String token = tokenMap.get(member.getUsername());
        if (token != null) {
            loginUserMap.remove(token);
            System.out.println("更新用户登录token");
        }
        token = Md5Util.getMD5(member.getUsername() + member.getPassword() + new Date().getTime());
        loginUserMap.put(token, member);
        tokenMap.put(member.getUsername(), token);
        System.out.println("目前有" + tokenMap.size() + "个用户");
        for (Member u : loginUserMap.values()) {
            System.out.println(u.getName() + ":" + u.getPassword());
        }
        return token;
    }

    @Override
    public List<Member> queryMember(Member member, Integer page, Integer rows) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        MemberExample example = new MemberExample();
        Criteria criteria = example.createCriteria();
        proSearchParam(member, criteria);
        return memberMapper.selectByExample(example);
    }

    @Override
    public List<CountOrderStatusVO> selectByCount() {
        return memberMapper.selectByCount();
    }

    @Override
    public List<MemberVO> queryMemberVO(Integer status, String phone, String fullName, Integer page, Integer rows, String startTime, String endTime,
                                        Integer authenticationStatus, Integer orderStatusPay, String ids) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        return memberMapper.selectByTime(status, phone, fullName, startTime, endTime, authenticationStatus, orderStatusPay, ids);
    }

    @Override
    public Long addMember(Member member) {
        return memberMapper.insertSelective(member);
    }

    @Override
    public boolean checkUserName(String userName) {
        if (!StringUtil.isNull(userName)) {
            Member member = memberMapper.selectByUsername(userName);
            if (member != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Member queryByUserName(String userName) {
        if (!StringUtil.isNull(userName)) {
            Member member = memberMapper.selectByUsername(userName);
            if (member != null) {
                return member;
            }
        }
        return null;
    }

    @Override
    public Member queryByPhoneNumber(String phoneNumber) {
        if (!StringUtil.isNull(phoneNumber)) {
            Member member = memberMapper.selectByPhoneNumber(phoneNumber);
            if (null != member) {
                return member;
            }
        }
        return null;
    }


    @Override
    public Member queryByUid(Long uid) {
        if (uid != null) {
            return this.memberMapper.selectByPrimaryKey(uid);
        } else {
            return null;
        }
    }

    @Override
    public Member getMemberByOpenid(String openid) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        criteria.andWechatOpenidEqualTo(openid);
        List<Member> members = memberMapper.selectByExample(example);
        if (members != null && members.size() > 0) {
            return members.get(0);
        }
        return null;
    }

    @Override
    public Member getMemberByUid(Long memberId) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(memberId);
        List<Member> members = memberMapper.selectByExample(example);
        if (members != null && members.size() > 0) {
            return members.get(0);
        }
        return null;
    }

    @Override
    public List<Member> queryMemberList(Date startTime, Date endTime) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        if (startTime != null && endTime != null) {
            criteria.andAddtimeBetween(startTime, endTime);
        }
        return memberMapper.selectByExample(example);
    }

    @Override
    public int updateMember(Member member) {
        return this.memberMapper.updateByPrimaryKey(member);
    }

    @Override
    public int uppMemberState(String[] ids, int state) {
        return memberMapper.updateByArrayId(ids, state);
    }

    @Override
    public MemberDetail queryMemberDetailByMemberId(Long memberId) {
        if (memberId != null) {
            return memberDetailMapper.selectByMemberId(memberId);
        }
        return null;
    }

    @Override
    public List<MemberDetail> queryMemberDetailByIdCard(String idcard) {
        if (idcard != null) {
            MemberDetailExample ex = new MemberDetailExample();
            ex.or().andIdCardEqualTo(idcard);
            return memberDetailMapper.selectByExample(ex);
        }
        return null;
    }

    @Override
    public int addMemberDetail(MemberDetail memberDetail) {
        return memberDetailMapper.insertSelective(memberDetail);
    }

    @Override
    public int uppMemberDetail(MemberDetail memberDetail) {
        return memberDetailMapper.updateByPrimaryKeySelective(memberDetail);
    }

    @Override
    public List<MemberDetail> queryMemberBirthday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DATE);
        return memberDetailMapper.selectByBirthday(day);
    }

    @Override
    public List<MemberDetail> selectMemberDetail(MemberDetail memberDetail) {
        MemberDetailExample example = new MemberDetailExample();
        example.setOrderByClause(" id ");
        //example.createCriteria();
        return memberDetailMapper.selectByExample(example);
    }

    @Override
    public MemberLinkman queryLinkmanByMemberId(Long memberId) {
        if (memberId != null) {
            return memberLinkmanMapper.selectByMemberId(memberId);
        }
        return null;
    }

    @Override
    public int addMemberLinkman(MemberLinkman memberLinkman) {
        return memberLinkmanMapper.insertSelective(memberLinkman);
    }

    @Override
    public int uppMemberLinkman(MemberLinkman memberLinkman) {
        return memberLinkmanMapper.updateByPrimaryKeySelective(memberLinkman);
    }

    @Override
    public MemberJobs queryJobByMemberId(Long memberId) {
        if (memberId != null) {
            return memberJobsMapper.selectByMemberId(memberId);
        }
        return null;
    }

    @Override
    public int addMemberJob(MemberJobs memberJobs) {
        return memberJobsMapper.insertSelective(memberJobs);
    }

    @Override
    public int uppMemberJob(MemberJobs memberJobs) {
        return memberJobsMapper.updateByPrimaryKeySelective(memberJobs);
    }

    @Override
    public MemberDevices queryDevicesByMemberId(Long memberId) {
        if (memberId != null) {
            return memberDevicesMapper.selectByMemberId(memberId);
        }
        return null;
    }

    @Override
    public int addMemberDevices(MemberDevices memberDevices) {
        return memberDevicesMapper.insertSelective(memberDevices);
    }

    @Override
    public int uppMemberDevices(MemberDevices memberDevices) {
        return memberDevicesMapper.updateByPrimaryKeySelective(memberDevices);
    }

    @Override
    public List<MemberBankcard> queryBankcardByMemberId(Long memberId) {
        if (memberId != null) {
            return memberBankcardMapper.selectByMemberId(memberId);
        }
        return null;
    }

    @Override
    public MemberBankcard queryDefaultBankcardByMemberId(Long memberId) {
        List<MemberBankcard> memberBankcards = queryBankcardByMemberId(memberId);
        if (memberBankcards != null) {
            MemberBankcard first = null;
            for (MemberBankcard card : memberBankcards) {
                if (card.getCardState() == 1) {
                    if (card.getCardBindType() == 2) {
                        return card;
                    }
                    if (first == null) {
                        first = card;
                    }
                }
            }
            return first;
        }
        return null;
    }

    @Override
    public MemberBankcard queryBankcardByBankcardId(Long id) {
        return memberBankcardMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addMemberBankcard(MemberBankcard memberBankcard) {
        return memberBankcardMapper.insertSelective(memberBankcard);
    }

    @Override
    public int uppMemberBankcard(MemberBankcard memberBankcard) {
        return memberBankcardMapper.updateByPrimaryKeySelective(memberBankcard);
    }

    @Override
    public int delMemberBankcard(Long id) {
        return memberBankcardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public BigDecimal getMemeberBalance(Long memberId) {
        Member member = queryByUid(memberId);
        if (member != null) {
            return member.getMaxAmount().subtract(member.getBillsFalseAmount().subtract(member.getBillsTrueAmount().add(member.getPrepaymentAmount())));
        }
        return null;
    }


    @Override
    public String checkMemberInfo(MemberDetail memberDetail, MemberJobs memberJobs, MemberLinkman memberLinkman) {
        if (memberDetail == null || memberJobs == null || memberLinkman == null) {
            return "系统异常,请重试";
        }
        if (memberDetail.getRecordOfFormalSchooling() == null) {
            return "请选择学历信息";
        }
        if (memberDetail.getIsmarry() == null) {
            return "请选择婚姻状况";
        }
        if (StringUtil.isNull(memberDetail.getNowLivingInCity())) {
            return "请选择居住城市";
        }
        if (StringUtil.isNull(memberDetail.getResidence())) {
            return "请输入详细地址";
        }
        if (StringUtil.isNull(memberJobs.getCorporateName())) {
            return "请输入单位名称";
        }
        if (StringUtil.isNull(memberJobs.getCompanyAddress())) {
            return "请输入单位地址";
        }
        if (memberLinkman.getLinkmanRelation() == null) {
            return "请选择联系人关系";
        }
        if (StringUtil.isNull(memberLinkman.getLinkmanName())) {
            return "请输入联系人姓名";
        }
        if (StringUtil.isNull(memberLinkman.getLinkmanPhone())) {
            return "请输入联系人电话";
        }
        if (!ValidatorUtil.isMobile(memberLinkman.getLinkmanPhone())) {
            return "联系人电话有误";
        }
        return null;
    }

    @Override
    public String checkMemberDetail(MemberDetail memberDetail) {
        if (memberDetail == null) {
            return "系统异常,请重试";
        }
        if (StringUtil.isNull(memberDetail.getFullname())) {
            return "身份证姓名有误";
        }
        if (memberDetail.getIdCard() == null /*|| !IDValidator.isValid(memberDetail.getIdCard())*/) {
            return "身份证号有误";
        }
        if (memberDetail.getSex() == null) {
            return "身份证性别有误";
        }
        if (StringUtil.isNull(memberDetail.getEthnicity())) {
            return "身份证民族有误";
        }
        if (StringUtil.isNull(memberDetail.getDateOfBirth())) {
            return "身份证出生年月有误";
        }
        if (StringUtil.isNull(memberDetail.getPermanentAddress())) {
            return "身份证地址有误";
        }
        if (StringUtil.isNull(memberDetail.getIssuingAuthority())) {
            return "身份证签发机构有误";
        }
        if (StringUtil.isNull(memberDetail.getPeriodOfValidity())) {
            return "身份证有效期有误";
        }
        return null;
    }

    @Override
    public boolean checkIdcardIsCertified(Long memberId) {
        MemberDetail memberDetail = memberDetailMapper.selectByMemberId(memberId);
        if (memberDetail != null && !StringUtil.isNull(memberDetail.getIdCard())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkTaobaoDataGathered(Long memberId) {
        return DocumentUtils.getInstance().hasDocument(memberId, DocumentUtils.TAOBAO);
    }

    @Override
    public boolean checkJDDataGathered(Long memberId) {
        return DocumentUtils.getInstance().hasDocument(memberId, DocumentUtils.JD);
    }

    @Override
    public boolean checkTmobileIsCertified(Long memberId) {
        return DocumentUtils.getInstance().hasDocument(memberId,DocumentUtils.JXL);
    }

    @Override
    public boolean checkBankCardIsCertified(Long memberId) {
        List<MemberBankcard> memberBankcardList = memberBankcardMapper.selectByMemberId(memberId);
        if (memberBankcardList != null && memberBankcardList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkMemberIsActive(Long memberId, String operId) {
        if (operId != null && memberId == null) {
            memberId = getMemberByOpenid(operId).getUid();
        }
        if (checkIdcardIsCertified(memberId)
                && (checkTaobaoDataGathered(memberId) || checkJDDataGathered(memberId))
                && checkTmobileIsCertified(memberId)
                && checkBankCardIsCertified(memberId)) {
            return true;
        }
        return false;
    }

    @Override
    public String getJdPhone(long memberId) {
        Member member = queryByUid(memberId);
        if (member != null) {
            MemberDocument doc = DocumentUtils.getInstance().getByMemberId(memberId, DocumentUtils.JD);
            if(doc == null || doc.getDoc() == null){
                return null;
            }
            JSONObject jsonObject = JSON.parseObject((String) doc.getDoc());
            return jsonObject.getString("phone");
        }
        return null;
    }

    @Override
    public BigDecimal getJdTotalConsumption(long memberId) {
        Member member = queryByUid(memberId);
        BigDecimal money = new BigDecimal(0);
        if (member != null ) {
            MemberDocument doc = DocumentUtils.getInstance().getByMemberId(memberId, DocumentUtils.JD);
            if(doc == null || doc.getDoc() == null){
                return new BigDecimal(0.0);
            }
            JSONObject jsonObject = JSON.parseObject((String) doc.getDoc());
            String authJson = jsonObject.getString("authJson");//数据
            JDData jdData = JSON.parseObject(authJson, new TypeReference<JDData>() {
            });
            List<OrderInfo> orderInfos = jdData.getOrderList();

            for (OrderInfo o : orderInfos) {
                if (o.getOrderStatus().contains("已完成")) {
                    Date date = new Date();//获取当前时间
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(Calendar.MONTH, -6);
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTime(o.getTradeTime());
                    int result = calendar.compareTo(calendar2);
                    if (result > 0) {
                        money = money.add(o.getAmount());
                    }
                }
            }
        }
        return money;
    }


    /**
     * 处理查询条件
     */
    private void proSearchParam(Member member, Criteria criteria) {
        if (member != null) {
            if (member.getUid() != null) {
                criteria.andUidEqualTo(member.getUid());
            }
            if (member.getUsername() != null && member.getUsername().trim().length() > 0) {
                criteria.andUsernameLike("%" + member.getUsername() + "%");
            }
            if (member.getName() != null && member.getName().trim().length() > 0) {
                criteria.andNameLike("%" + member.getName() + "%");
            }
            if (member.getState() != null) {
                criteria.andStateEqualTo(member.getState());
            }
            if (member.getAuthenticationStatus() != null) {
                criteria.andAuthenticationStatusEqualTo(member.getAuthenticationStatus());
            }
        }
    }

    @Override
    public boolean userLevelRiskCalc(Member member) {
        ExamineScore examineScore = new ExamineScore(member, examineServiceList, 100, 80);
        ExamineService pass = examineScore.pass();
        if (pass == null) {
            logger.info("审核通过 --> " + member.getUid() + "," + member.getPhoneNumber());
            operLogsService.addOrderLog("审核通过", "审核通过", "1", 0L);
            return true;
        } else {
            logger.info("审核不通过 --> " + + member.getUid() + "," + member.getPhoneNumber());
            operLogsService.addOrderLog("审核不通过", "审核不通过", "2", 0L);
            return false;
        }
    }

    @Override
    public int getBillDay(long memberId) {
        MemberDetail memberDetail = this.queryMemberDetailByMemberId(memberId);
        String birthDay = memberDetail.getDateOfBirth().substring(memberDetail.getDateOfBirth().length() - 2, memberDetail.getDateOfBirth().length());
        int billDay = ObjectUtils.min(Integer.parseInt(birthDay), 28);//账单日期
        return billDay;
    }

    @Override
    public int endBillDay(int startBillDay) {
        int nextBillDay = startBillDay + 10;
        if (nextBillDay / 10 == 3) {
            nextBillDay -= 30;
            if (nextBillDay == 0) {
                nextBillDay = 30;
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int i = calendar.getActualMaximum(Calendar.DATE);
        if (nextBillDay > i) {
            nextBillDay = i;
        }
        return nextBillDay;
    }


    /**
     * 装载审核规则
     */
    @Override
    public void loadExamineService() {
        if (null == examineServiceList) {
            examineServiceList = new ArrayList<>();
            List<ExamineRule> list = examineRuleService.selectByUsing(true);
            for (ExamineRule examineRule : list) {
                ExamineService examineService = factory(examineRule);
                if (examineService!=null){
                    if (null != examineRule) examineServiceList.add(examineService);
                }
            }
        }
    }


    private ExamineService factory(ExamineRule examineRule) {
        String type = examineRule.getType();
        if ("身份证号起始包含".equals(type)) return new IDNumberStart(examineRule, memberDetailService, operLogsService);
        if ("居住地址包含".equals(type)) return new ResidenceInclude(examineRule, memberDetailService, operLogsService);
        if ("年龄大于".equals(type)) return new AgeGreater(examineRule, memberDetailService, operLogsService);
        if ("年龄小于".equals(type)) return new AgeLess(examineRule, memberDetailService, operLogsService);
        if ("未实名认证".equals(type)) return new Identify(examineRule, this, operLogsService);
        if ("手机黑名单".equals(type)) return new PhoneBlackList(examineRule, this, operLogsService);
        if ("身份证黑名单".equals(type)) return new IdCardBlackList(examineRule, this, operLogsService);
        if ("实名手机非本人".equals(type)) return null;
        if ("历史情况".equals(type)) return null;
        // if ("实名手机非本人".equals(type)) return new IdentifyPhoneNot(examineRule, memberService, operLogsService);
        if ("风险等级".equals(type)) return new RiskRating(examineRule, this, operLogsService);
        if ("手机状态不正常(运营商数据)".equals(type))
            return new PhoneNumber(examineRule, this, operLogsService, thirdVerifyService);
        if ("黑名单".equals(type)) return new IdCardBlackList(examineRule, this, operLogsService);
        if ("白骑士黑名单".equals(type)) return new BQSBlackList(examineRule, operLogsService, bqsService);
        logger.info("无法构建审核规则 --> " + examineRule);
        return null;
    }

    @Override
    public void calculateQuota(Member member)  {
        //最终的风险报告
        RiskDocument document = new RiskDocument();
        //计算运营商风险等级
        int risk = mobilePhoneRiskService.riskRating(member);
        logger.info(member.getPhoneNumber() + "运营商数据以及风险等级更新");
        document.setMobilePhoneRiskLevel(risk);
        //预先保存
        DocumentUtils.getInstance().update(member.getUid(), DocumentUtils.ADF, document);

        //计算额度
        document.setRiskLayer("F");
        this.loadExamineService();
        boolean userLevelRisk = this.userLevelRiskCalc(member);
        //如果没有过用户级别的风控，则风险分层是F
        if(userLevelRisk == false){
            document.setRiskLayer("F");
        }else if(risk == 6){
            //运营商风险大于6直接F
            document.setRiskLayer("F");
        }else if(checkTaobaoDataGathered(member.getUid())){
            //根据花呗的额度来计算风险封层
            String hubeiRiskLayer = "F";
            int huabei = dianShangRiskService.getHuabeiQuota(member);
            if(huabei > 0) {
                if (risk == 1) {
                    if (huabei > 500){
                        hubeiRiskLayer = "A";
                    }else if (huabei > 0){
                        hubeiRiskLayer = "B";
                    }else if (huabei == 0){
                        hubeiRiskLayer = "C";
                    }
                } else if (risk == 2) {
                    if (huabei > 500){
                        hubeiRiskLayer = "A";
                    }else if (huabei > 0){
                        hubeiRiskLayer = "B";
                    }else if (huabei == 0){
                        hubeiRiskLayer = "F";
                    }
                } else if (risk == 3) {
                    if (huabei > 500){
                        hubeiRiskLayer = "B";
                    }else if (huabei > 0){
                        hubeiRiskLayer = "C";
                    }else if (huabei == 0){
                        hubeiRiskLayer = "F";
                    }
                } else if (risk == 4) {
                    if (huabei > 500){
                        hubeiRiskLayer = "C";
                    }else if (huabei > 0){
                        hubeiRiskLayer = "D";
                    }else if (huabei == 0){
                        hubeiRiskLayer = "F";
                    }
                } else if (risk == 5) {
                    if (huabei > 500){
                        hubeiRiskLayer = "E";
                    }else if (huabei > 0){
                        hubeiRiskLayer = "F";
                    }else if (huabei == 0){
                        hubeiRiskLayer = "F";
                    }
                }
            }
            document.setRiskLayer(hubeiRiskLayer);

        }else if(checkJDDataGathered(member.getUid())){

            //根据京东认证来计算风险分层
            String jdRiskLayer = "F";
            if (risk == 1) {
                jdRiskLayer = "B";
            } else if (risk == 2) {
                jdRiskLayer = "C";
            } else if (risk == 3) {
                jdRiskLayer = "D";
            } else if (risk == 4) {
                jdRiskLayer = "E";
            } else if (risk == 5) {
                jdRiskLayer = "F";
            }
            document.setRiskLayer(jdRiskLayer);
        }
        setQuotaBasedOnRiskLayer(document, member);
        //保存风险
        if(document.getMaxAmountAll().compareTo(BigDecimal.ZERO) > 0){
            //如果额度大于0，则发送消息
            weChatService.sendCcTextMessge(member.getWechatOpenid(), "感谢您参与认证，您的个人最大代付额度为" + document.getMaxAmountAll().intValue());
        }
        logger.info("计算用户风险文档：" + document);
        DocumentUtils.getInstance().update(member.getUid(), DocumentUtils.ADF, document);
    }

    private void setQuotaBasedOnRiskLayer(RiskDocument riskDocument, Member member){

        //计算基础额度
        BigDecimal baseQuota = new BigDecimal(0.0);
        if(checkJDDataGathered(member.getUid())){
//            BigDecimal totalConsumption = new BigDecimal(0);
            try {
                baseQuota = this.getJdTotalConsumption(member.getUid())
                        .divide(new BigDecimal(6), 6, BigDecimal.ROUND_HALF_UP);
            } catch (Exception e) {
                logger.info("无法获取京东的消费额:" + member.getUid());
            }
        }
        if(checkTaobaoDataGathered(member.getUid())){
            int huabei = dianShangRiskService.getHuabeiQuota(member);
            if(baseQuota.compareTo(new BigDecimal(huabei)) < 0){
                baseQuota = new BigDecimal(huabei);
            }
        }

        BigDecimal riskParam = new BigDecimal(0.0);
        BigDecimal bottom = new BigDecimal(0.0);
        BigDecimal termParamP1 = new BigDecimal(1.0);
        BigDecimal termParamP3 = new BigDecimal(1.0);
        BigDecimal termParamP6 = new BigDecimal(1.0);
        BigDecimal capP1 = new BigDecimal(0.0);
        BigDecimal capP3 = new BigDecimal(0.0);
        BigDecimal capP6 = new BigDecimal(0.0);
        if(riskDocument.getRiskLayer().equals("A")){
            riskParam = new BigDecimal(1.5);
            bottom = new BigDecimal(1500);
            termParamP1 = new BigDecimal(1);
            termParamP3 = new BigDecimal(1.8);
            termParamP6 = new BigDecimal(2.5);
            capP1 = new BigDecimal(3000);
            capP3 = new BigDecimal(4500);
            capP6 = new BigDecimal(6000);
        }else if(riskDocument.getRiskLayer().equals("B")){
            riskParam = new BigDecimal(1.2);
            bottom = new BigDecimal(1200);
            termParamP1 = new BigDecimal(1);
            termParamP3 = new BigDecimal(1.6);
            termParamP6 = new BigDecimal(2.2);
            capP1 = new BigDecimal(2500);
            capP3 = new BigDecimal(4000);
            capP6 = new BigDecimal(5500);
        }else if(riskDocument.getRiskLayer().equals("C")){
            riskParam = new BigDecimal(1.0);
            bottom = new BigDecimal(1000);
            termParamP1 = new BigDecimal(1);
            termParamP3 = new BigDecimal(1.5);
            termParamP6 = new BigDecimal(2.0);
            capP1 = new BigDecimal(2000);
            capP3 = new BigDecimal(3500);
            capP6 = new BigDecimal(5000);
        }else if(riskDocument.getRiskLayer().equals("D")){
            riskParam = new BigDecimal(0.8);
            bottom = new BigDecimal(800);
            termParamP1 = new BigDecimal(1);
            termParamP3 = new BigDecimal(1.4);
            termParamP6 = new BigDecimal(1.7);
            capP1 = new BigDecimal(0);
            capP3 = new BigDecimal(3000);
            capP6 = new BigDecimal(4000);
        }else if(riskDocument.getRiskLayer().equals("E")){
            riskParam = new BigDecimal(0.6);
            bottom = new BigDecimal(500);
            termParamP1 = new BigDecimal(1);
            termParamP3 = new BigDecimal(1.2);
            termParamP6 = new BigDecimal(1.0);
            capP1 = new BigDecimal(0);
            capP3 = new BigDecimal(2500);
            capP6 = new BigDecimal(0);
        }

        BigDecimal quotaP1 = baseQuota.multiply(termParamP1).multiply(riskParam);
        BigDecimal quotaP3 = baseQuota.multiply(termParamP3).multiply(riskParam);
        BigDecimal quotaP6 = baseQuota.multiply(termParamP6).multiply(riskParam);

        if(quotaP1.compareTo(bottom) < 0){
            quotaP1 = bottom;
        }
        if(quotaP1.compareTo(capP1) > 0){
            quotaP1 = capP1;
        }
        if(quotaP3.compareTo(bottom) < 0){
            quotaP3 = bottom;
        }
        if(quotaP3.compareTo(capP3) > 0){
            quotaP3 = capP3;
        }
        if(quotaP6.compareTo(bottom) < 0){
            quotaP6 = bottom;
        }
        if(quotaP6.compareTo(capP6) > 0){
            quotaP6 = capP6;
        }
        riskDocument.setMaxAmountP1(quotaP1);
        riskDocument.setMaxAmountP3(quotaP3);
        riskDocument.setMaxAmountP6(quotaP6);
    }


    /**
     * @param v1    除数
     * @param v2    被除数
     * @param scale 精度
     * @return
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public List<ExamineService> getExamineServiceList() {
        return examineServiceList;
    }

    @Override
    public void setExamineServiceList(List<ExamineService> examineServiceList) {
        this.examineServiceList = examineServiceList;
    }
}
