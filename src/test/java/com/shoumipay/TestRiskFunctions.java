package com.shoumipay;

import com.google.common.io.Files;
import com.shoumipay.domain.Config;
import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.Member;
import com.shoumipay.service.ThirdVerifyService;
import com.shoumipay.service.admin.*;
import com.shoumipay.service.examine.*;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.docs.RiskDocument;
import com.shoumipay.v2.service.*;
import com.shoumipay.v2.service.BillService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("chengye")
public class TestRiskFunctions {

    @Autowired
    private MemberService memberService;
    @Autowired
    private BQSRiskService bqsRiskServiceq;
    @Autowired
    private MobilePhoneRiskService mobilePhoneRiskService;
    @Autowired
    private BillService repayService;
    @Autowired
    private DianShangRiskService dianShangRiskService;
    @Autowired
    private ConfigService configService;
    @Autowired
    private ExamineRuleService examineRuleService;
    @Autowired
    private OperLogsService operLogsService;
    @Autowired
    private MemberDetailService memberDetailService;
    @Autowired
    private ThirdVerifyService thirdVerifyService;
    @Autowired
    private BQSRiskService bqsService;

    private static String jdDoc;
    private static String tbDoc;
    private static String jxlDoc;

    private static Member member;

    private static String loadData(String fileName){
        try {
            BufferedReader reader =  Files.newReader(new File(fileName),
                    Charset.defaultCharset());
            StringBuffer sb = new StringBuffer();
            while(true){
                String line = reader.readLine();
                if(line != null){
                    sb.append(line).append("\n");
                }else {
                    break;
                }
            }
            return sb.toString();

        }catch (Exception e){
            System.out.println("failed to read file");
        }
        return "";
    }

    @BeforeClass
    public static void before() {

        /**
         * -------------------------------
         * 测试时候需要保证存在503用户和用户详情，需要一个经过完整认证的用户
         */
        member = new Member();
        member.setUid(503L);
        member.setPhoneNumber("18616955651");
        member.setAuthenticationStatus(1);


        //加载用户数据
        jdDoc = loadData("C:\\Users\\Administrator\\Desktop\\duolafu\\test\\jd_data_test.txt");
        tbDoc = loadData("C:\\Users\\Administrator\\Desktop\\duolafu\\test\\tb_data_test.txt");
        jxlDoc = loadData("C:\\Users\\Administrator\\Desktop\\duolafu\\test\\jxl_data_test.txt");


    }

    @Before
    public void saveDoc(){
        DocumentUtils.getInstance().update(member.getUid(), DocumentUtils.JD, jdDoc);
        DocumentUtils.getInstance().update(member.getUid(), DocumentUtils.TAOBAO, tbDoc);
        DocumentUtils.getInstance().update(member.getUid(), DocumentUtils.JXL, jxlDoc);

    }

    @AfterClass
    public static void after(){
//        DocumentUtils.getInstance().remove(member.getUid(), DocumentUtils.JD);
//        DocumentUtils.getInstance().remove(member.getUid(), DocumentUtils.JXL);
//        DocumentUtils.getInstance().remove(member.getUid(), DocumentUtils.TAOBAO);
        DocumentUtils.getInstance().remove(member.getUid(), DocumentUtils.ADF);
    }

    @Test
    public void checkDoc(){
        assertTrue(DocumentUtils.getInstance().hasDocument(member.getUid(), DocumentUtils.JD));
        assertTrue(DocumentUtils.getInstance().hasDocument(member.getUid(), DocumentUtils.TAOBAO));
    }

    @Test
    public void testJdDataParsing() {
        BigDecimal num = memberService.getJdTotalConsumption(member.getUid());
        assertTrue(num.compareTo(new BigDecimal(0.0))  > 0);
    }

    @Test
    public void testHuabeiParsing() {
        int num = dianShangRiskService.getHuabeiQuota(member);
        assertTrue(num == 15000);
    }

    @Test
    public void testConfigCache(){
        Config newConfig = new Config();
        newConfig.setKey("test");
        newConfig.setValue("test");
        configService.insert(newConfig);
        Config config = configService.selectByKey("test");
        assertNotNull(config);
        config = configService.selectByKey("test");
        assertNotNull(config);
        Config dConfig = configService.selectByKey("no_key", "home");
        assertNotNull("home".equalsIgnoreCase(dConfig.getValue()));
        configService.remove("test");
    }

    private ExamineService factory(ExamineRule examineRule) {
        String type = examineRule.getType();
        if ("身份证号起始包含".equals(type)) return new IDNumberStart(examineRule, memberDetailService, operLogsService);
        if ("居住地址包含".equals(type)) return new ResidenceInclude(examineRule, memberDetailService, operLogsService);
        if ("年龄大于".equals(type)) return new AgeGreater(examineRule, memberDetailService, operLogsService);
        if ("年龄小于".equals(type)) return new AgeLess(examineRule, memberDetailService, operLogsService);
        if ("未实名认证".equals(type)) return new Identify(examineRule, memberService, operLogsService);
        if ("手机黑名单".equals(type)) return new PhoneBlackList(examineRule, memberService, operLogsService);
        if ("身份证黑名单".equals(type)) return new IdCardBlackList(examineRule, memberService, operLogsService);
        if ("实名手机非本人".equals(type)) return null;
        if ("历史情况".equals(type)) return null;
        // if ("实名手机非本人".equals(type)) return new IdentifyPhoneNot(examineRule, memberService, operLogsService);
        if ("风险等级".equals(type)) return new RiskRating(examineRule, memberService, operLogsService);
        if ("手机状态不正常(运营商数据)".equals(type))
            return new PhoneNumber(examineRule, memberService, operLogsService, thirdVerifyService);
        if ("黑名单".equals(type)) return new IdCardBlackList(examineRule, memberService, operLogsService);
        if ("白骑士黑名单".equals(type)) return new BQSBlackList(examineRule, operLogsService, bqsService);
        return null;
    }

    @Test
    public void testUserLevelRiskCalc(){
        //构建一个特殊的ExampleRule集合
        List<ExamineService> examineServiceList = new ArrayList<>();
        List<ExamineRule> list = examineRuleService.selectByUsing(true);

        //构建risk数据
        RiskDocument document = new RiskDocument();
        document.setMemberId(member.getUid());
        document.setMobilePhoneRiskLevel(2);
        DocumentUtils.getInstance().update(member.getUid(), DocumentUtils.ADF, document);

        for (ExamineRule examineRule : list) {
            //跳过年龄限制
            if(examineRule.getType().equalsIgnoreCase("年龄大于")) {
                examineRule.setParameter("35");
            }
            ExamineService examineService = factory(examineRule);
            if (examineService!=null){
                if (null != examineRule) examineServiceList.add(examineService);
            }
        }
        memberService.setExamineServiceList(examineServiceList);
        int initScore = 80;
        for (ExamineService rule : examineServiceList) {
            initScore += rule.examine(member);
        }
        assertTrue(initScore > 0);
    }

    @Test
    public void calculateQuota(){
        memberService.calculateQuota(member);
        RiskDocument doc = (RiskDocument) DocumentUtils.getInstance().getByMemberId(member.getUid(), DocumentUtils.ADF).getDoc();
        assertTrue(doc.getRiskLayer().equalsIgnoreCase("C"));
        assertTrue(doc.getMaxAmountP1().compareTo(BigDecimal.ZERO) >0);
        assertTrue(doc.getMaxAmountP3().compareTo(BigDecimal.ZERO) >0);
        assertTrue(doc.getMaxAmountP6().compareTo(BigDecimal.ZERO) >0);
    }

}
