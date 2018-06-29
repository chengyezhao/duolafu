package com.shoumipay.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shoumipay.constants.GoodsOrderConstants;
import com.shoumipay.domain.*;
import com.shoumipay.service.admin.*;
import com.shoumipay.service.wechat.JdDaiFuService;
import com.shoumipay.service.wechat.WeChatService;
import com.shoumipay.tools.*;
import com.shoumipay.tools.wechat.WXPayUtil;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.vo.GoodsRepaymentCollectionVO;
import com.shoumipay.vo.OrderVO;
import com.shoumipay.vo.PrepaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhw on 2017/11/22.
 */

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private OperLogsService operLogsService;
    @Autowired
    private JdDaiFuService jdDaiFuService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberBankcardService memberBankcardService;

    @Value("${domain.name}")
    private String domainName;

    @RequestMapping("")
    public String orderShow(Model model, Integer status, Long memberId) {
        String statusStr = "";
        if (status != null) {
            switch (status) {
                case 0:
                    statusStr = "未提交";
                    break;
                case 1:
                    statusStr = "已提交待审批";
                    break;
                case 2:
                    statusStr = "已通过申请";
                    break;
                case 3:
                    statusStr = "已拒绝申请";
                    break;
                case 4:
                    statusStr = "已关闭申请";
                    break;
                case 5:
                    statusStr = "未放款业务";
                    break;
                case 6:
                    statusStr = "放款中业务";
                    break;
                case 7:
                    statusStr = "已放款业务";
                    break;
                case 8:
                    statusStr = "放款失败业务";
                    break;
                case 9:
                    statusStr = "已中止业务";
                    break;
                case 10:
                    statusStr = "已完成业务";
                    break;
                case 11:
                    statusStr = "已逾期业务";
                    break;
                case 12:
                    statusStr = "提前还款查询";
                    break;
            }
        }
        List<Goods> goodsList = goodsService.queryGoods(null, null, null);
        model.addAttribute("goodsList", goodsList);
        model.addAttribute("statusStr", statusStr);
        model.addAttribute("status", status);
        model.addAttribute("memberId", memberId);
        return "order";
    }

    /**
     * 订单展示
     */
    @PostMapping("/list")
    public void orderData(OrderVO orderVO, Integer page, Integer rows, HttpServletResponse response) {
        //逾期订单单独显示
        if (orderVO.getOrderStatus() != null) {
            if (orderVO.getOrderStatus() == 11) {
                orderVO.setOrderTypes(GoodsOrderConstants.ORDERDUE_ORDER);
                orderVO.setOrderStatus(null);
            } else {
                orderVO.setOrderTypes(GoodsOrderConstants.NORMAL_ORDER);
            }
        }
        List<OrderVO> orderVOList = goodsService.queryByOrderVO(orderVO, page, rows);
        if (orderVOList != null && orderVOList.size() > 0) {
            for (OrderVO orderVO1 : orderVOList) {
                orderVO1.setUseAmount(memberService.getMemeberBalance(orderVO1.getMemberId()));
            }
        }
        PageInfo<OrderVO> pageInfo = new PageInfo<>(orderVOList);
        JSONObject jo = new JSONObject();
        jo.put("rows", orderVOList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    /**
     * 根据memberI查询历史订单
     */
    @RequestMapping(value = "queryGoodsOrder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void queryGoodsOrder(Long memberId, Integer page, Integer rows, HttpServletResponse response) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        List<GoodsOrder> goodsOrderList = goodsOrderService.selectByMemberid(memberId);
        PageInfo<GoodsOrder> pageInfo = new PageInfo<>(goodsOrderList);
        JSONObject jo = new JSONObject();
        jo.put("rows", goodsOrderList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数*/
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    /**
     * 更新订单状态  通过或拒绝
     */
    @PostMapping("/upp")
    public void uppOrderStatus(String orderId, Integer status, HttpServletRequest request, HttpServletResponse response) {
        int index = 0;
        int realStatus = (status == GoodsOrderConstants.APPROVAL ? GoodsOrderConstants.APPROVAL_REFUSED : GoodsOrderConstants.APPROVAL);
        if (!orderId.contains(",")) {
            GoodsOrder goodsOrder = goodsOrderService.selectByPrimaryKey(LongUtil.parseLong(orderId));
            //TODO ???
            if (goodsOrder == null && (goodsOrder.getOrderStatus() != status || (goodsOrder.getOrderStatus() == 5 && status == 2))) {
                MessageUtil.failMessageFlag("数据异常,请重试!", response);
                return;
            }
            goodsOrder.setOrderStatus(realStatus);
            if (status == 2) {
                goodsOrder.setOrderAuditFailMsg(goodsOrder.getOrderAuditFailMsg() + " 操作人:" + UserUtil.getLoginUserName());
            }
            index = goodsOrderService.updateByPrimaryKeySelective(goodsOrder);
        } else {
            index = goodsOrderService.updateOrderStatus(orderId.split(","), realStatus);
        }
        if (index > 0) {
            String result = "复审通过";
            String resultStatus = "1";
            if (status == 2) {
                result = "复审不通过";
                resultStatus = "2";
            }
            if (!orderId.contains(",")) {
                operLogsService.addOrderLog(result, result, resultStatus, LongUtil.parseLong(orderId));
            } else {
                operLogsService.addOrderLogByOrderIdArray(result, result, resultStatus, orderId.split(","));
            }
            operLogsService.addLog(UserUtil.getLoginUserName(), (status == 2 ? "拒绝" : "通过") + "订单ID:" + orderId, UserUtil.getUserIp(request));
        }
        MessageUtil.uppOrAddMessage(index, "操作成功!", "操作失败,请重试!", response);
    }

    /**
     * 查看还款计划
     */
    @PostMapping("getRepaymentPlanByOrderId")
    public void getRepaymentPlanByOrderId(Long orderId, HttpServletResponse response) {
        List<GoodsRepaymentPlan> goodsRepaymentPlanList = goodsService.queryRepaymentPlanByOrderId(orderId);
        ServletUtil.createSuccessResponse(200, goodsRepaymentPlanList, response);
    }

    /**
     * 提前还款展示
     */
    @RequestMapping("prepayment")
    public String prepayment(Model model, Long id) {
        model.addAttribute("id", id);
        return "prepayment";
    }

    /**
     * 提前还款数据获取
     */
    @PostMapping("queryPrepayment")
    public void queryPrepayment(PrepaymentVO prepaymentVO, Integer page, Integer rows, HttpServletResponse response) {
        //prepaymentVO.setRepaymentStatus(GoodsOrderConstants.PREPAYMENT_STATUS);//查询提前还款
        List<PrepaymentVO> repaymentVOS = goodsService.queryPrepaymentVO(prepaymentVO, page, rows);
       /* PageInfo<PrepaymentVO> pageInfo = new PageInfo<>(repaymentVOS);
        JSONObject jo = new JSONObject();
        jo.put("rows", repaymentVOS);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数*/
        ServletUtil.createSuccessResponse(200, repaymentVOS, response);
    }

    /**
     * 催收记录展示
     */
    @RequestMapping("collection")
    public String collection() {
        return "collection";
    }

    /**
     * 催收记录获取
     */
    @PostMapping("collection/list")
    public void queryCollectionList(GoodsRepaymentCollectionVO vo, Integer page, Integer rows, HttpServletResponse response) {
        List<GoodsRepaymentCollectionVO> goodsRepaymentCollectionVOS = goodsService.queryControllerVO(vo, page, rows);
        PageInfo<GoodsRepaymentCollectionVO> pageInfo = new PageInfo<>(goodsRepaymentCollectionVOS);
        JSONObject jo = new JSONObject();
        jo.put("rows", goodsRepaymentCollectionVOS);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }

    /**
     * 入催按钮
     */
    @PostMapping("collection/upp")
    public void uppCollection(Long orderId, BigDecimal amount, HttpServletResponse response, HttpServletRequest request) {
        List<GoodsRepaymentCollection> goodsRepaymentCollections = goodsService.queryControllerByOrderId(orderId);
        int index = 0;
        if (amount == null || amount.doubleValue() <= 0) {
            MessageUtil.failMessageFlag("金额有误!", response);
            return;
        }
        if (goodsRepaymentCollections != null && goodsRepaymentCollections.size() > 0) {
            GoodsRepaymentCollection goodsRepaymentCollection = goodsRepaymentCollections.get(0);
            goodsRepaymentCollection.setRepaymentCollectionIncome(amount);
            goodsRepaymentCollection.setRepaymentCollectionStatus(1);//成功
            index = goodsService.uppCollection(goodsRepaymentCollection);
            GoodsOrder goodsOrder = goodsOrderService.selectByPrimaryKey(orderId);
            goodsOrder.setOrderStatus(GoodsOrderConstants.LOAN_COMPLETE);
            goodsOrderService.updateByPrimaryKeySelective(goodsOrder);
            operLogsService.addLog(UserUtil.getLoginUserName(), "orderId:" + orderId + "入催金额:" + amount, UserUtil.getUserIp(request));
        }
        MessageUtil.uppOrAddMessage(index, "操作成功!", "操作失败,请重试!", response);
    }

    /**
     * 复制按钮
     */
    @PostMapping("copyLink")
    public void copyLink(Long orderId, HttpServletResponse response) {
        GoodsOrder goodsOrder = goodsOrderService.selectByPrimaryKey(orderId);
        JdDaiFu jdDaiFu = jdDaiFuService.queryJdDaiFuById(goodsOrder.getDaifuId());
        MessageUtil.successMessageFlag(jdDaiFu.getShareUrl(), response);
    }

    @GetMapping("addOrder")
    public String addOrder(Model model) {
        MemberDetail memberDetail = new MemberDetail();
        List<MemberDetail> memberDetails = memberService.selectMemberDetail(memberDetail);
        model.addAttribute("memberDetails", memberDetails);
        return "order/add-order";
    }

    @Autowired
    private WeChatService weChatService;

    @PostMapping("addOrder")
    public void addOrder(BigDecimal money, long memberid, String name, String link, HttpServletResponse response) {
        Member member = memberService.queryByUid(memberid);
        if (member == null) {
            MessageUtil.failMessageFlag("用户选取失败", response);
            return;
        }
        BigDecimal balance = memberService.getMemeberBalance(member.getUid());
        if (money.doubleValue() > balance.doubleValue()) {
            MessageUtil.failMessageFlag("当前用户可用余额小于商品金额!", response);
            return;
        }
        Long cardId = memberBankcardService.checkMemberBankcard(member.getUid());
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(memberid);
        JdDaiFu jdDaiFu = new JdDaiFu();
        jdDaiFu.setCustomerName(memberDetail.getFullname());
        jdDaiFu.setMemberId(memberid);
        jdDaiFu.setImageUrl("http://m.360buyimg.com/mobilecms/jfs/t9565/330/46747508/145018/f3499643/59c4726cNc6f0ade3.jpg!q20.jpg");
        jdDaiFu.setWeiXinDaiFuStatus(0);
        jdDaiFu.setCode(0);
        jdDaiFu.setDisableWishList(0);
        jdDaiFu.setTitle("帮我付款才是真友谊");
        jdDaiFu.setShareUrl(link);
        jdDaiFu.setOrderPrice(money);
        jdDaiFu.setPoundagePayFlag(0);
        jdDaiFu.setPayid(WXPayUtil.generateUUID());
        jdDaiFu.setPoundagePayMoney(weChatService.createWeChatPay(jdDaiFu.getOrderPrice()));
        jdDaiFuService.addJdDaiFu(jdDaiFu);
        List<JdGoods> jdGoodsList = new ArrayList<>();
        JdGoods jdGoods = new JdGoods();
        jdGoods.setPrice(money);
        jdGoods.setCount(1);
        jdGoods.setWareName(name);
        jdGoods.setImageUrl("http://m.360buyimg.com/mobilecms/jfs/t9565/330/46747508/145018/f3499643/59c4726cNc6f0ade3.jpg!q20.jpg");
        jdGoodsList.add(jdGoods);
        jdDaiFuService.addJdGoodsList(jdGoodsList, member.getUid(), jdDaiFu.getId());
        Long orderId = goodsService.applyForLoanCreateOrder(member, jdDaiFu, jdDaiFu.getOrderPrice(), cardId);
        int index = 0;
        if (orderId != null) {
            String[] message = new String[4];
            message[0] = jdDaiFu.getPayid();
            message[1] = name;
            message[2] = money.setScale(2, BigDecimal.ROUND_CEILING) + "";
            message[3] = DateUtil.format(new Date(), "yyyy-MM-dd");
            weChatService.sendMessge(member.getWechatOpenid(),
                    "7KmdxX2m6r_Y4mY9aLz9poiDDQCi_PXhgdWLD-O4GOQ",
                    domainName + "/wx/pay?payid=" + jdDaiFu.getPayid(),
                    "尊敬的" + memberDetail.getFullname() + "，您有1笔代购服务订单。确认请客官打赏小费：金额：¥" + jdDaiFu.getPoundagePayMoney().setScale(2, BigDecimal.ROUND_CEILING) + "元",
                    "如有疑问请联系客服!",
                    message);
            index = 1;
        }
        MessageUtil.uppOrAddMessage(index, "操作成功!", "操作失败,请重试!", response);
    }
}
