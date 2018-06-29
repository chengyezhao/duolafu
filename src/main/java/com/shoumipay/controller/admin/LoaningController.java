package com.shoumipay.controller.admin;

import com.shoumipay.controller.tool.BasicLoanController;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.JdGoods;
import com.shoumipay.domain.Member;
import com.shoumipay.service.admin.*;
import com.shoumipay.service.cache.SystemCacheService;
import com.shoumipay.service.wechat.JdDaiFuService;
import com.shoumipay.service.wechat.WeChatService;
import com.shoumipay.tools.Message;
import com.shoumipay.tools.UserUtil;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.vo.PreLoanVO;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.shoumipay.constants.GoodsOrderConstants.*;
import static com.shoumipay.tools.Message.*;

/**
 * Created by Tang on 2017/10/28.
 */
@Controller
@RequestMapping("/loaning")
public class LoaningController extends BasicLoanController {

    @Autowired
    private MemberBankcardService memberBankcardService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    protected GoodsCostsService goodsCostsService;

    @Autowired
    private GoodsMakeLoansService goodsMakeLoansService;
    @Autowired
    private OperLogsService operLogsService;
//    @Autowired
//    private PayService payService;
    @Autowired
    private JdDaiFuService jdDaiFuService;
    @Autowired
    private WeChatService weChatService;
    @Autowired
    private MemberDetailService memberDetailService;
    @Autowired
    private SystemCacheService systemCacheService;
    @Autowired
    private MemberService memberService;
    @Value("${domain.name}")
    private String domainName;

    @RequestMapping("/pre")
    public String loanList() {
        return "loaning/pre";
    }

    @InitBinder("vo")
    public void initPreLoanVO(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("vo.");
    }

    @RequestMapping("/preLoan")
    @ResponseBody
    public Message preLoan(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return get(vo, page, rows, WAIT_LEND);
    }

    @PostMapping
    public void doLoanbBatch(String orderIs) {

    }

    @RequestMapping("/doLoan")
    @ResponseBody
    public Message doLoan(String orderId) {
        if (!systemCacheService.doLoan()) {
            return new Message(FLAG_NO_MAKELOAN);
        }
        //获取当日放款次数
        int loanNowTimes = goodsMakeLoansService.countLoanTimes();
        //获取当如放款次数上限
        int loanTimes = systemCacheService.getLoanTimes();
        if (loanNowTimes > loanTimes) {
            return new Message(FLAG_MORE_LOAN_TIMES);
        }
        //获取当日放款金额
        Double loanNowMoney = goodsMakeLoansService.sumLoanAmount();
        //获取当日放款金额上限
        Double loanMoney = systemCacheService.getLoanMoney();
        if (loanNowMoney != null && loanNowMoney > loanMoney) {
            return new Message(FLAG_MORE_LOAN_MONEY);
        }
        String username = UserUtil.getLoginUserName();
        // List<Long> orderIds = Arrays.asList(orderId);
        String orderIdStr[] = orderId.split(",");
        long orderIds[] = (long[]) ConvertUtils.convert(orderIdStr, long.class);
        List<Message> list = new ArrayList<>(orderIds.length);
        for (Long id : orderIds) {
            Message result = doLoan(id, username);
            if (!result.isSuccess()) {
                list.add(result);
            }
        }
        if (list.size() > 0) {
            String fail_list = String.format("\n共放款%d笔，失败%d笔", orderIds.length, list.size());
            for (Message fail : list) {
                fail_list += "\n" + fail.getMessage();// ???
            }
            return Message.fail(fail_list);
        }
        return Message.success(String.format("共放款%d笔", orderIds.length));
    }

    private Message doLoan(Long orderId, String username) {
        GoodsOrder order = goodsOrderService.selectByPrimaryKey(orderId);
        Member member = memberService.queryByUid(order.getMemberId());//TODO 未对orde进行非空检查
        if (null == order || 5 != order.getOrderStatus()) return new Message(ORDER_ID_ERROR);
        /*MemberBankcard bankcard = memberBankcardService.selectByPrimaryKey(order.getOrderCardid());
        if (null == bankcard) return new Message(CARD_INFO_ERROR);*/

        /*Goods goods = goodsService.getGoodsById(order.getGoodsId());
        GoodsCosts costs1 = goodsCostsService.selectByGoodsIdName(goods.getId(), 0);
        GoodsCosts costs2 = goodsCostsService.selectByGoodsIdName(goods.getId(), 1);
        BigDecimal amount = order.getOrderAmountRecognized().multiply(
                new BigDecimal(1).subtract(costs1.getCost()).subtract(costs2.getCost()));
        amount.setScale(2, BigDecimal.ROUND_DOWN);*/

        // BigDecimal amount = order.getOrderVerifyAmount();
        //MemberDetail detail = memberDetailService.selectByMemberId(order.getMemberId());

        //创建还款订单
       /* GoodsMakeLoans makeLoans = new GoodsMakeLoans(
                order.getId(),
                order.getMemberId(),
                new Date(),
                amount,
                null,
                null,
                1,
                2,
                0,
                "",
                "",
                order.getOrderCardid(),
                order.getGoodsId(),
                order.getOrderCode(),
                goods.getProductRate(),
                costs1.getCost(),
                costs2.getCost(),
                new BigDecimal(0),
                goods.getOverdueInterest(),
                false
        );*/
        /*GoodsMakeLoans makeLoans = new GoodsMakeLoans(
                order.getId(),
                order.getMemberId(),
                new Date(),
                amount,
                null,
                null,
                1,
                2,
                0,
                "",
                "",
                0L,
                0L,
                "",
                new BigDecimal(0),
                new BigDecimal(0),
                new BigDecimal(0),
                new BigDecimal(0),
                new BigDecimal(0),
                false
        );
        int ret = goodsMakeLoansService.insert(makeLoans);
        if (ret <= 0) {
            return new Message(Message.FLAG_NORMAL_ERROR);
        }*/
        //Long id = makeLoans.getId();

        //调用接口放款
        /*String[] institutionCode = {""};
        String[] errMsg = {""};
        String oidPayBill = payService.makeLoan(detail, order, bankcard, id, institutionCode, errMsg);
        if (null == oidPayBill) {
            return Message.fail(errMsg[0]);
        }*/

        //更新状态
       /* GoodsMakeLoans loan = new GoodsMakeLoans();
        loan.setId(id);
        loan.setMakeLoansSerialNumber(oidPayBill);
        loan.setMakeLoansInstitutionCode(institutionCode[0]);
        goodsMakeLoansService.updateByPrimaryKeySelective(loan);*/

        //更新订单
        synchronized (member) {
            try {
                member.setBillsFalseAmount(member.getBillsFalseAmount().add(order.getOrderAmountRecognized()));
                memberService.updateMember(member);
            } catch (Exception e) {
                logger.error("订单:" + order.getOrderNumber() + "金额加入未出账失败:" + order.getOrderAmountRecognized());
            }
        }
        GoodsOrder go = new GoodsOrder();
        go.setId(order.getId());
        go.setOrderStatus(LOAN_SUCCESS);
        go.setOrderAuditor(username);
        go.setOrderUpptime(new Date());
        goodsOrderService.updateByPrimaryKeySelective(go);
        String[] message = new String[4];
        message[0] = "哆啦付";
        message[1] = order.getOrderNumber();
        List<JdGoods> jdGoods = jdDaiFuService.queryJdGoodsByDaiFuId(order.getDaifuId());
        if (jdGoods != null && jdGoods.size() > 0) {
            message[2] = jdGoods.get(0).getWareName() + "等";
        }
        message[3] = order.getOrderAmountRecognized().setScale(2, BigDecimal.ROUND_CEILING) + "";
        weChatService.sendMessge(member.getWechatOpenid(),
                "8kREvqS7Gf7a6hs74XNmW6szA02a4QxbubaYYCFiC-8",
                domainName + "/wx/myOrder",
                "亲，你购买的代购服务已经完成！详情请登录京东账户查看。",
                "如有疑问请联系客服!",
                message);
        logger.info("放款中 --> " + orderId);
        return Message.success();
    }

    @RequestMapping("/loaning")
    public String loaning() {
        return "loaning/loaning";
    }


    @RequestMapping("/loaning/list")
    @ResponseBody
    public Message loaning(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return get(vo, page, rows, LENDING);
    }

    @RequestMapping("/loaned")
    public String loaned() {
        return "loaning/loaned";
    }


    @RequestMapping("/loaned/list")
    @ResponseBody
    public Message loaned(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return get(vo, page, rows, LOAN_SUCCESS);
    }

    @RequestMapping("/fail")
    public String fail() {
        return "loaning/fail";
    }


    @RequestMapping("/fail/list")
    @ResponseBody
    public Message fail(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return get(vo, page, rows, LOAN_FAILURE);
    }

    @RequestMapping("/discontinue")
    public String discontinue() {
        return "loaning/discontinue";
    }


    @RequestMapping("/discontinue/list")
    @ResponseBody
    public Message discontinue(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return get(vo, page, rows, LOAN_DISCONTINUE);
    }

    @RequestMapping("/finish")
    public String finish() {
        return "loaning/finish";
    }


    @RequestMapping("/finish/list")
    @ResponseBody
    public Message finish(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return get(vo, page, rows, LOAN_COMPLETE);
    }

}
