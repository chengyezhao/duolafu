package com.shoumipay;

import com.shoumipay.v2.domain.*;
import com.alibaba.druid.util.StringUtils;
import com.shoumipay.dao.MemberMapper;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.domain.docs.MemberDocument;
import com.shoumipay.v2.domain.enums.OrderLegStatus;
import com.shoumipay.v2.domain.enums.OrderStatus;
import com.shoumipay.v2.domain.enums.OverDueStatus;
import com.shoumipay.v2.mapper.*;
import com.shoumipay.v2.repository.MemberDocumentRepository;
import javafx.scene.control.OverrunStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("chengye")
public class TestMapper {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberDocumentRepository repository;
    @Autowired
    private MongoTemplate template;

    public void select(){
        List<Member> list = new ArrayList<Member>();
        list = memberMapper.findAll();
        logger.info("-------------"+list.size());
        for(int i=0;i<list.size();i++){
            logger.info("----------------------------"+list.get(i).getUid(),DocumentUtils.JD,list.get(i).getJdData());
            if (!StringUtils.isEmpty(list.get(i).getJdData())){
                DocumentUtils.getInstance().update(list.get(i).getUid(),DocumentUtils.JD,list.get(i).getJdData());
            }
            if (!StringUtils.isEmpty(list.get(i).getTbData())){
                DocumentUtils.getInstance().update(list.get(i).getUid(),DocumentUtils.TAOBAO,list.get(i).getTbData());
            }
            if (!StringUtils.isEmpty(list.get(i).getJxlData())){
                DocumentUtils.getInstance().update(list.get(i).getUid(),DocumentUtils.JXL,list.get(i).getJxlData());
            }
        }
    }




    @Autowired
    private BillCollectionMapper billcollectionMapper;

    @Autowired
    private DaifuCodeMapper codeMapper;

    @Test
    public void test00(){
        BillCollection billCollection = new BillCollection();
        billCollection.setBillDate(new Date());
        billCollection.setBillNumber("100");
        billCollection.setMemberId(11l);
        billCollection.setOverdueStatus("XX");
        billCollection.setDueDate(new Date());
        billCollection.setStatus("1");
        int a = billcollectionMapper.insert(billCollection);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test01(){
        BillCollection billCollection = new BillCollection();
        billCollection.setBillDate(new Date());
        billCollection.setBillId(2l);
        billCollection.setBillNumber("100");
        billCollection.setCreatedDate(new Date());
        billCollection.setDueDate(new Date());
        billCollection.setLastUpdatedDate(new Date());
        billCollection.setMemberId(11l);
        billCollection.setOverdueStatus("XX");
        billCollection.setStatus("1");
        int a = billcollectionMapper.insert(billCollection);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test02(){
        BillCollection billCollection = new BillCollection();
        billCollection.setBillDate(new Date());
        billCollection.setBillId(2l);
        billCollection.setBillNumber("100");
        billCollection.setCreatedDate(new Date());
        billCollection.setDueDate(new Date());
        billCollection.setLastUpdatedDate(null);
        billCollection.setMemberId(11l);
        billCollection.setOverdueStatus("XXx");
        billCollection.setStatus("11");
        int a = billcollectionMapper.updateByPrimaryKeySelective(billCollection);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }

    @Test
    public void test03(){
        BillCollection billCollection = new BillCollection();
        billCollection.setBillDate(new Date());
        billCollection.setBillId(1l);
        billCollection.setBillNumber("100");
        billCollection.setCreatedDate(new Date());
        billCollection.setDueDate(new Date());
        billCollection.setLastUpdatedDate(null);
        billCollection.setMemberId(11l);
        billCollection.setOverdueStatus("XXx");
        billCollection.setStatus("11");
        int a = billcollectionMapper.updateByPrimaryKey(billCollection);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test04(){
        BillCollection billCollection = billcollectionMapper.selectByPrimaryKey(1l);
        if (billCollection != null){
            logger.info("成功------"+billCollection.getBillId()+"------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }

    @Test
    public void test05(){
        int a = billcollectionMapper.deleteByPrimaryKey(2l);
        if (a > 0){
            logger.info("成功"+"-----------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Autowired
    private DaifuOrderMapper daifuOrderMapper;

    @Test
    public void test06(){
        DaifuOrder daifuOrder = new DaifuOrder();
        daifuOrder.setBillId(1l);
        daifuOrder.setCodeId(1l);
        daifuOrder.setCommission(new BigDecimal(10));
        daifuOrder.setCreatedDate(new Date());
        daifuOrder.setLastUpdateDate(new Date());
        daifuOrder.setMemberId(1l);
        daifuOrder.setMonthlyFee(new BigDecimal(10));
        daifuOrder.setOrderId(1l);
        daifuOrder.setOverdueStatus("1");
        daifuOrder.setTitle("1");
        daifuOrder.setStatus(OrderStatus.closed.name());
        daifuOrder.setTotalTerm(1);
        int a = daifuOrderMapper.insertSelective(daifuOrder);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test07(){
        DaifuOrder daifuOrder = new DaifuOrder();
        daifuOrder.setBillId(2l);
        daifuOrder.setCodeId(2l);
        daifuOrder.setCommission(new BigDecimal(10));
        daifuOrder.setCreatedDate(new Date());
        daifuOrder.setLastUpdateDate(new Date());
        daifuOrder.setMemberId(2l);
        daifuOrder.setMonthlyFee(new BigDecimal(10));
        daifuOrder.setOverdueStatus("2");
        daifuOrder.setPaidCommision(new BigDecimal(10));
        daifuOrder.setPrice(new BigDecimal(10));
        daifuOrder.setStatus("2");
        daifuOrder.setTitle("2");
        daifuOrder.setTotalTerm(2);
        daifuOrder.setDownPayment(new BigDecimal(10));
        int a = daifuOrderMapper.insertSelective(daifuOrder);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test08(){
        DaifuOrder daifuOrder = new DaifuOrder();
        daifuOrder.setBillId(11l);
        daifuOrder.setCodeId(11l);
        daifuOrder.setCommission(new BigDecimal(101));
        daifuOrder.setCreatedDate(new Date());
        daifuOrder.setOrderId(2l);
        daifuOrder.setLastUpdateDate(new Date());
        daifuOrder.setTotalTerm(11);
        int a = daifuOrderMapper.updateByPrimaryKeySelective(daifuOrder);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }

    @Test
    public void test09(){
        DaifuOrder daifuOrder = new DaifuOrder();
        daifuOrder.setBillId(2l);
        daifuOrder.setCodeId(2l);
        daifuOrder.setCommission(new BigDecimal(10));
        daifuOrder.setCreatedDate(new Date());
        daifuOrder.setLastUpdateDate(new Date());
        daifuOrder.setMemberId(2l);
        daifuOrder.setMonthlyFee(new BigDecimal(10));
        daifuOrder.setOrderId(2l);
        daifuOrder.setOverdueStatus("2");
        daifuOrder.setPaidCommision(new BigDecimal(10));
        daifuOrder.setPrice(new BigDecimal(10));
        daifuOrder.setStatus("2");
        daifuOrder.setTitle("2");
        daifuOrder.setTotalTerm(2);
        daifuOrder.setDownPayment(new BigDecimal(10));
        int a = daifuOrderMapper.updateByPrimaryKey(daifuOrder);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test10(){
        DaifuOrder daifuOrder = daifuOrderMapper.selectByPrimaryKey(2l);
        if (daifuOrder != null){
            logger.info("成功------"+daifuOrder.getStatus()+"------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }

    @Test
    public void test11(){
        int a = daifuOrderMapper.deleteByPrimaryKey(1l);
        if (a > 0){
            logger.info("成功"+"-----------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }



    @Autowired
    private DaifuOrderLegMapper daifuOrderLegMapper;

    @Test
    public void test12(){
        DaifuOrderLeg daifuOrderLeg = new DaifuOrderLeg();
        daifuOrderLeg.setAmount(new BigDecimal(100));
        daifuOrderLeg.setBillId(1l);
        daifuOrderLeg.setCreatedDate(new Date());
        daifuOrderLeg.setFee(new BigDecimal(1));
        daifuOrderLeg.setInterest(new BigDecimal(100));
        daifuOrderLeg.setLastUpdatedDate(new Date());
        daifuOrderLeg.setOrderId(1l);
        daifuOrderLeg.setOverdueStatus("1");
        daifuOrderLeg.setSequence(1);
        daifuOrderLeg.setStatus("1");
        daifuOrderLeg.setMemberId(1L);
        int a = daifuOrderLegMapper.insert(daifuOrderLeg);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test13(){
        DaifuOrderLeg daifuOrderLeg = new DaifuOrderLeg();
        daifuOrderLeg.setAmount(new BigDecimal(100));
        daifuOrderLeg.setBillId(2l);
        daifuOrderLeg.setCreatedDate(new Date());
        daifuOrderLeg.setFee(new BigDecimal(1));
        daifuOrderLeg.setInterest(new BigDecimal(100));
        daifuOrderLeg.setLastUpdatedDate(new Date());
        daifuOrderLeg.setOrderId(2l);
        daifuOrderLeg.setStatus(OrderLegStatus.open.name());
        daifuOrderLeg.setOrderlegId(2l);
        daifuOrderLeg.setOverdueStatus(OverDueStatus.no.name());
        daifuOrderLeg.setSequence(3);
        daifuOrderLeg.setMemberId(12L);
        int a = daifuOrderLegMapper.insert(daifuOrderLeg);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test14(){
        DaifuOrderLeg daifuOrderLeg = new DaifuOrderLeg();
        daifuOrderLeg.setAmount(new BigDecimal(100));
        daifuOrderLeg.setBillId(3l);
        daifuOrderLeg.setCreatedDate(new Date());
        daifuOrderLeg.setFee(new BigDecimal(1));
        daifuOrderLeg.setInterest(new BigDecimal(100));
        daifuOrderLeg.setLastUpdatedDate(new Date());
        daifuOrderLeg.setOrderId(3l);
        daifuOrderLeg.setOrderlegId(2l);
        int a = daifuOrderLegMapper.updateByPrimaryKeySelective(daifuOrderLeg);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }

    @Test
    public void test15(){
        DaifuOrderLeg daifuOrderLeg = new DaifuOrderLeg();
        daifuOrderLeg.setAmount(new BigDecimal(100));
        daifuOrderLeg.setBillId(2l);
        daifuOrderLeg.setCreatedDate(new Date());
        daifuOrderLeg.setFee(new BigDecimal(1));
        daifuOrderLeg.setInterest(new BigDecimal(100));
        daifuOrderLeg.setLastUpdatedDate(new Date());
        daifuOrderLeg.setOrderId(2l);
        daifuOrderLeg.setOrderlegId(1l);
        daifuOrderLeg.setOverdueStatus("2");
        daifuOrderLeg.setSequence(2);
        daifuOrderLeg.setStatus("2");
        int a = daifuOrderLegMapper.updateByPrimaryKey(daifuOrderLeg);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test16(){
        DaifuOrderLeg daifuOrderLeg = daifuOrderLegMapper.selectByPrimaryKey(1l);
        if (daifuOrderLeg != null){
            logger.info("成功------"+daifuOrderLeg.getSequence()+"------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }

    @Test
    public void test17(){
        int a = daifuOrderLegMapper.deleteByPrimaryKey(2l);
        if (a > 0){
            logger.info("成功"+"-----------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }




    @Autowired
    private RepaymentMapper repaymentMapper;

    @Test
    public void test18(){
        Repayment repayment = new Repayment();
        repayment.setCreatedDate(new Date());
        repayment.setFee(new BigDecimal(100));
        repayment.setInterest(new BigDecimal(100));
        repayment.setLastUpdatedDate(new Date());
        repayment.setMemberId(1l);
        repayment.setOperatorId("1");
        repayment.setOrderId(1l);
        repayment.setOrderLegId(1l);
        repayment.setPrice(new BigDecimal(100));
        repayment.setStatus("1");
        repayment.setTransId("1");
        repayment.setType("1");
        int a = repaymentMapper.insert(repayment);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test19(){
        Repayment repayment = new Repayment();
        repayment.setFee(new BigDecimal(100));
        repayment.setInterest(new BigDecimal(100));
        repayment.setMemberId(2l);
        repayment.setOperatorId("2");
        repayment.setOrderId(2l);
        repayment.setOrderLegId(2l);
        repayment.setPrice(new BigDecimal(100));
        repayment.setStatus("2");
        repayment.setTransId("2");
        repayment.setType("2");
        int a = repaymentMapper.insert(repayment);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test20(){
        Repayment repayment = new Repayment();
        repayment.setFee(new BigDecimal(100));
        repayment.setInterest(new BigDecimal(100));
        repayment.setLastUpdatedDate(new Date());
        repayment.setMemberId(2l);
        repayment.setOperatorId("2");
        repayment.setOrderId(2l);
        repayment.setOrderLegId(2l);
        repayment.setPrice(new BigDecimal(100));
        repayment.setRepaymentId(2l);
        repayment.setStatus("2");
        repayment.setTransId("2");
        repayment.setType("2");
        int a = repaymentMapper.updateByPrimaryKeySelective(repayment);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }

    @Test
    public void test21(){
        Repayment repayment = new Repayment();
        repayment.setCreatedDate(new Date());
        repayment.setFee(new BigDecimal(100));
        repayment.setInterest(new BigDecimal(100));
        repayment.setLastUpdatedDate(new Date());
        repayment.setMemberId(2l);
        repayment.setOperatorId("2");
        repayment.setOrderId(2l);
        repayment.setOrderLegId(2l);
        repayment.setPrice(new BigDecimal(100));
        repayment.setRepaymentId(2l);
        repayment.setStatus("2");
        repayment.setTransId("2");
        repayment.setType("2");
        int a = repaymentMapper.updateByPrimaryKeySelective(repayment);
        if (a>0){
            logger.info("成功"+"------------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }


    @Test
    public void test22(){
       Repayment repayment = repaymentMapper.selectByPrimaryKey(2l);
        if (repayment != null){
            logger.info("成功------"+repayment.getInterest()+"------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }

    @Test
    public void test23(){
        int a = repaymentMapper.deleteByPrimaryKey(1l);
        if (a > 0){
            logger.info("成功"+"-----------------");
        }else{
            logger.info("失败"+"------------------");
        }
    }




    @Test
    public void testCodeCreate(){
        DaifuCode code = new DaifuCode();
        code.setOrderStatus("doing");
        code.setPhonenum("1872872211");
        code.setItems("Test ");
        code.setUsername("chenghye ");
        code.setParsingStatus("iphone ");
        code.setPlatform("zhi");
        code.setImageUrl("http:?/");
        code.setParsingStatus("init");
        code.setPrice(new BigDecimal(10));
        code.setDaifuId("TestId");
        code.setMemberId(12L);
        code.setShareUrl("TestURL");
        codeMapper.insert(code);
    }


    @Test
    public void testCodeUpdate(){
        DaifuCode code = codeMapper.selectByDaifuId("TestId");
        code.setParsingStatus("paid");
        code.setImageUrl("http://image.png");
        code.setPrice(new BigDecimal(1000));
        codeMapper.updateByPrimaryKey(code);
    }



}
