package com.shoumipay.v2.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.google.common.base.Splitter;
import com.shoumipay.constants.WeChatConstants;
import com.shoumipay.domain.*;
import com.shoumipay.service.admin.ConfigService;
import com.shoumipay.service.admin.GoodsOrderService;
import com.shoumipay.service.admin.GoodsService;
import com.shoumipay.service.admin.MemberBankcardService;
import com.shoumipay.service.wechat.JdDaiFuService;
import com.shoumipay.service.wechat.WeChatService;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.docs.RiskDocument;
import com.shoumipay.v2.domain.enums.DaifuCodeStatus;
import com.shoumipay.v2.domain.enums.DaifuCodeType;
import com.shoumipay.v2.mapper.DaifuCodeMapper;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.service.impl.IdGenerator;
import com.shoumipay.v2.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.List;

/**
 * Created by yuluo on 2018/3/25.
 */
@Service
public class DaifuCodeServiceImpl implements DaifuCodeService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdDaiFuService jdDaiFuService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private WeChatService weChatService;
    @Autowired
    private MemberBankcardService memberBankcardService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private DaifuCodeService daifuCodeService;
    @Autowired
    private BillService repayService;
    @Autowired
    private BQSRiskService bqsService;
    @Autowired
    private ConfigService configService;
    @Autowired
    private DaifuOrderService orderService;

    @Value("${daifu.minprice}")
    private int minprice;

    private String jdUrl = "https://pay.m.jd.com/newpay/queryOrderStatus.action";

    @Autowired
    private DaifuCodeMapper daifuCodeMapper;

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public DaifuCode selectById(long codeId) {
        return daifuCodeMapper.selectById(codeId);
    }

    @Override
    public DaifuCode selectByDaifuId(String daifuId) {
        return daifuCodeMapper.selectByDaifuId(daifuId);
    }

    @Override
    public List<DaifuCode> queryAll(String platform, String status) {
        return daifuCodeMapper.selectBy(platform, status);
    }

    @Override
    public int update(DaifuCode code) {
        return daifuCodeMapper.updateByPrimaryKey(code);
    }


    @Override
    public DaifuCode create(DaifuCode code) {
        DaifuCode existCode = daifuCodeMapper.selectByDaifuId(code.getDaifuId());
        if(existCode == null){
            daifuCodeMapper.insert(code);
            return  daifuCodeMapper.selectByDaifuId(code.getDaifuId());
        }
        return existCode;
    }


    @Override
    public synchronized String checkDaifuRisk(DaifuCode code, Member member) {
        try {
            String payId = String.valueOf(code.getDaifuId());
            if (StringUtils.isEmpty(payId)) {
                logger.info("代付链接是空的" + code.getDaifuId());
                return configService.selectValueByKey(WeChatConstants.SYSTEM_ERROR);
            }
            if (DaifuCodeStatus.paid.equals(code.getParsingStatus())) {
                logger.info("代付链接是已支付或者等待支付状态" + code.getDaifuId());
                return configService.selectValueByKey(WeChatConstants.SERVICE_FEE_BEEN_PAID_ERROR);
            }

            //TODO: 验证用户姓名是否一致
            //风控，是否有逾期
            if(orderService.queryOrderByUser(member.getUid(), true, true).size() >0){
                logger.info("代付用户已经逾期" + code.getDaifuId());
                return configService.selectValueByKey(WeChatConstants.OVERDUE_ERROR);
            }
            //风控，白骑士
            if(bqsService.isMemberHasLoanRisk(member).equals(BQSRiskService.BQSRisk.Rejected)){
                logger.info("白骑士风控拒绝" + code.getDaifuId());
                return configService.selectValueByKey(WeChatConstants.BQS_ERROR);
            }

            if(!(memberService.checkTaobaoDataGathered(member.getUid()) ||
                    memberService.checkJDDataGathered(member.getUid()))){
                logger.info("电商风控拒绝" + code.getDaifuId());
                return configService.selectValueByKey(WeChatConstants.TB_UNBIND);
            }

            if (false) {
                logger.info("用户和代付人不一致" + code.getDaifuId());
                return configService.selectValueByKey(WeChatConstants.CONSIGNEE_IS_INCONSISTENT);
            }
            RiskDocument riskDocument = (RiskDocument) DocumentUtils.getInstance().getByMemberId(member.getUid(), DocumentUtils.ADF).getDoc();
            if (code.getPrice().doubleValue() < minprice){
                logger.info("目前不支持小于" + minprice + "金额的订单" + code.getDaifuId());
                return "目前不支持小于" + minprice + "金额的订单";
            }
            if(code.getPrice().doubleValue()
                    > riskDocument.getMaxAmountAll().doubleValue()) {
                logger.info("用户信用额度不够" + code.getDaifuId());
                return configService.selectValueByKey(WeChatConstants.LACK_CREDIT);
            }


            //判断商品是否是虚拟的
            String itemList = code.getItems();
            String blackList = configService.selectValueByKey("GOOD_BLACK_LIST");
            if(!StringUtils.isEmpty(blackList)) {
                for(String word : Splitter.on("|").split(blackList)) {
                    if (itemList.contains(word)) {
                        logger.info("商品是虚拟的" + code.getDaifuId());
                        return configService.selectValueByKey(WeChatConstants.CATETORY_ERROR);
                    }
                }
            }

            // TODO: 检查额度是否足够
            return "Success";

        } catch (Exception e) {
            logger.info("failed to process daifu code", e);
        }
        return configService.selectValueByKey(WeChatConstants.SYSTEM_ERROR);
    }


    public DaifuCodeType verifySendedCode(String code, Member member){
        if (code.contains("pay.m.jd.com")) {
            return DaifuCodeType.jdapp;
        } else if (code.contains("wqs.jd.com")) {
            return DaifuCodeType.jdweb;
        }
        try{
            code = URLDecoder.decode(code, "UTF8");
        }catch (Exception e){
            return DaifuCodeType.unsupported;
        }
        if (code.contains("帮我付款")) {
            return DaifuCodeType.zhi;
        }else{
            return DaifuCodeType.unsupported;
        }

    }
}
