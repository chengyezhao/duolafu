package com.shoumipay.service.wechat;

import com.alibaba.fastjson.JSONObject;
import com.shoumipay.constants.GoodsOrderConstants;
import com.shoumipay.constants.WeChatConstants;
import com.shoumipay.controller.wechat.base.BaseController;
import com.shoumipay.domain.*;
import com.shoumipay.service.RedisService;
import com.shoumipay.service.admin.GoodsOrderService;
import com.shoumipay.service.admin.GoodsService;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.domain.DaifuOrderLeg;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.domain.enums.DaifuCodeStatus;
import com.shoumipay.v2.domain.enums.OrderStatus;
import com.shoumipay.v2.domain.enums.RepaymentStatus;
import com.shoumipay.v2.service.BillService;
import com.shoumipay.v2.service.DaifuOrderService;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.v2.service.DaifuCodeService;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import com.shoumipay.tools.wechat.ToMapUtil;
import com.shoumipay.tools.wechat.WXPayConstants;
import com.shoumipay.tools.wechat.WXPayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WxPayServiceImpl extends BaseController implements WxPayService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String notify_url = "/wx/notify"; //通知地址
    private final String repay_notify_url = "/wx/renotify";
    private String url = "https://api.mch.weixin.qq.com";
    @Autowired
    private AccessTokenService accessTokenService;
    @Autowired
    private JdDaiFuService jdDaiFuService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private WeChatService weChatService;
    @Autowired
    private DaifuCodeService daifuCodeService;
    @Autowired
    private DaifuOrderService orderService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private BillService billService;

    @Value("${domain.name}")
    private String domainName;
    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String secret;

    @Value("${wechat.mch_id}")
    private String mch_id;

    @Value("${wechat.key}")
    private String key;

    /**
     * 统一下单处理
     */
    private String getPrepayId(String openid, String payId, String title, long money, String ip, String nonce_str, String notify_url) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("appid", appid);
        map.put("mch_id", mch_id);
        map.put("device_info", "WEB");
        map.put("body", title);
        map.put("trade_type", "JSAPI");
        map.put("nonce_str", nonce_str);
        map.put("notify_url", domainName + notify_url);
        map.put("out_trade_no", payId);
        map.put("total_fee", money + "");
        map.put("openid", openid);
        map.put("spbill_create_ip", ip);
        try {
            String xml = WXPayUtil.generateSignedXml(map, key);
            String result = HttpRequestUtils.sendPostXml(url + WXPayConstants.UNIFIEDORDER_URL_SUFFIX, xml);
            Map<String, String> map1 = WXPayUtil.xmlToMap(result);
            if (map1.get("return_msg").equals("System Error")) {
                result = HttpRequestUtils.sendPostXml(url + WXPayConstants.UNIFIEDORDER_URL_SUFFIX, xml);
            }
            String reg = "<prepay_id><!\\[CDATA\\[(\\w+)\\]\\]></prepay_id>";
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(result);
            String prepayId = "";
            while (matcher.find()) {
                prepayId = matcher.group(1);
                logger.debug("预支付ID：" + prepayId);
            }
            return prepayId;
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("订单:" + payId + "微信统一下单失败---" + e.getMessage());
        }
        return null;
    }


    private String getResultJson(String prepayId, String nonce_str) throws Exception {
        Date beijingDate = Calendar.getInstance(Locale.CHINA).getTime();
        String timeStamp = String.valueOf(beijingDate.getTime() / 1000);
        JSONObject json = new JSONObject();
        json.put("appId", appid);
        json.put("timeStamp", timeStamp);
        json.put("nonceStr", nonce_str);
        json.put("package", "prepay_id=" + prepayId);
        json.put("signType", "MD5");
        TreeMap<String, String> map2 = new TreeMap<>();
        map2.put("appId", appid);
        map2.put("timeStamp", timeStamp);
        map2.put("nonceStr", nonce_str);
        map2.put("package", "prepay_id=" + prepayId);
        map2.put("signType", "MD5");
        String paySign = WXPayUtil.generateSignature(map2, key);
        json.put("paySign", paySign);
        return json.toString();
    }

    private Map<String, String> notifyParse(HttpServletRequest request) {
        Map<String, String> map = ToMapUtil.xmlToMap(request);
        logger.info(map.toString());
        //如果微信结果通知为失败
        if ("FAIL".equals(map.get("return_code"))) {
            logger.debug(map.get("return_msg"));
            return null;
        }
        Boolean signTrue = false;
        try {
            signTrue = WXPayUtil.isSignatureValid(map, key);
        } catch (Exception e) {
            logger.error("签名失败" + map.toString());
            return null;
        }
        if (!signTrue) {
            return null;
        }
        return map;
    }

    @Override
    public String weChatPay(BigDecimal money, String openid, String payid, String title, String ip, boolean isRepay) throws Exception {
        String nonce_str = WXPayUtil.generateUUID();
        Long money2 = money.multiply(new BigDecimal(100)).longValue();
        //Long money2 = 1l;
        String notify = notify_url;
        if (isRepay) {
            notify = repay_notify_url;
        }
        String prepayId = getPrepayId(openid, payid, title, money2, ip, nonce_str, notify);
        if (prepayId == null) {
            return null;
        }
        String json = getResultJson(prepayId, nonce_str);
        return json;
    }


    public synchronized String wechatNotify(HttpServletRequest request) {
        Map<String, String> map = notifyParse(request);
        if (map == null) {
            return null;
        }
        String payid = map.get("out_trade_no");
        String total_fee = map.get("total_fee");
        JdDaiFu jdDaiFu = jdDaiFuService.queryJdDaiFuByPayId(payid);
        if (jdDaiFu != null) {
            String amount = jdDaiFu.getPoundagePayMoney().multiply(new BigDecimal(100)).longValue() + "";
            if (jdDaiFu.getPoundagePayFlag() == WeChatConstants.WECHAT_DAIFU_ORDER_STATUS_FALSE) {
                if (total_fee.equals(amount)) {
                    GoodsOrder goodsOrder = goodsService.queryOrderByDaifuId(jdDaiFu.getId());
                    Member member = memberService.queryByUid(goodsOrder.getMemberId());
                    goodsOrder.setOrderStatus(GoodsOrderConstants.WAIT_LEND);
                    goodsOrder.setOrderAmountRecognized(goodsOrder.getOrderAmount().multiply(new BigDecimal(1).add(member.getCost())));
                    goodsOrder.setOrderUpptime(new Date());
                    goodsOrderService.updateByPrimaryKeySelective(goodsOrder);
                    jdDaiFu.setPoundagePayFlag(WeChatConstants.WECHAT_DAIFU_ORDER_STATUS_TRUE);
                    jdDaiFuService.uppJdDaiFu(jdDaiFu);
                    String[] message=new String[3];
                    message[0]="代购服务";
                    message[1]=payid;
                    message[2]= new BigDecimal(amount).divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_CEILING)+"";
                    weChatService.sendMessge(member.getWechatOpenid(),
                            "ZQa5SpNjm2AjlZ21O2E58-PRQqrqLSdLs1DoUUPA5VE",
                            domainName+"/wx/myOrder",
                            "亲，你已成功购买哆啦付一笔代购服务！请耐心等待收货吧！",
                            "如有疑问请联系客服!",
                            message);
                    return "<xml>" +
                            "<return_code><![CDATA[SUCCESS]]></return_code>" +
                            "<return_msg><![CDATA[OK]]></return_msg>" +
                            "</xml>";
                }
                return null;
            }
            return "<xml>" +
                    "<return_code><![CDATA[SUCCESS]]></return_code>" +
                    "<return_msg><![CDATA[OK]]></return_msg>" +
                    "</xml>";
        }else if (payid.startsWith("TRANS")){
            repayWechatNotify(map);
        }
        else{
            //处理新的代付完成消息
            try {
                String daifuId = payid.replace("DAIFU", "");
                DaifuCode code = daifuCodeService.selectById(Long.valueOf(daifuId));
                Member member = memberService.queryByUid(code.getMemberId());
                JSONObject codeInfo = JSONObject.parseObject((String) redisService.get(payid));
                if(code != null && member != null && codeInfo != null){
                    String amount = codeInfo.getInteger("totalAmount") + "";
                    Integer commission = codeInfo.getInteger("commission");
                    Integer downPayment = codeInfo.getInteger("downPayment");
                    Integer term = codeInfo.getInteger("term");

                    DaifuOrder order = orderService.selectOrderByCodeId(code.getCodeId());
                    if(order != null){
                        logger.info("订单已经生成，收到重复的回报" + order.getOrderId());
                        return "<xml>" +
                                "<return_code><![CDATA[SUCCESS]]></return_code>" +
                                "<return_msg><![CDATA[OK]]></return_msg>" +
                                "</xml>";
                    }

                    //如果是待支付状态，防止重复确认
                    if (!DaifuCodeStatus.paid.name().equals(code.getParsingStatus())) {
                        if (total_fee.equals(amount)) {
                            //生成order和子订单，插入子订单到账单中
                            orderService.createDaifuOrder(member, code,
                                    new BigDecimal(downPayment).divide(new BigDecimal(100)),
                                    term,
                                    new BigDecimal(commission).divide(new BigDecimal(100)),
                                    true, false, new Date());

                            //设置code为已支付
                            code.setParsingStatus(DaifuCodeStatus.paid.name());
                            daifuCodeService.update(code);
                            redisService.delete(String.valueOf(code.getDaifuId()));
                            //发送代付成功消息
                            String[] message=new String[3];
                            message[0]="代购服务";
                            message[1]=payid;
                            message[2]= new BigDecimal(amount).divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_CEILING)+"";
                            weChatService.sendMessge(member.getWechatOpenid(),
                                    "ZQa5SpNjm2AjlZ21O2E58-PRQqrqLSdLs1DoUUPA5VE",
                                    domainName + "/wx/index",
                                    "亲，你已成功购买哆啦付一笔代购服务！请耐心等待收货吧！",
                                    "如有疑问请联系客服!",
                                    message);
                            return "<xml>" +
                                    "<return_code><![CDATA[SUCCESS]]></return_code>" +
                                    "<return_msg><![CDATA[OK]]></return_msg>" +
                                    "</xml>";
                        }else{
                            //TODO: 处理支付失败
                            //如果支付返回有问题，则关闭daifuCode
                            logger.error("微信返回的支付金额" + total_fee +"不准确，daifuId=" + code.getCodeId());
                        }
                    }
                    return "<xml>" +
                            "<return_code><![CDATA[SUCCESS]]></return_code>" +
                            "<return_msg><![CDATA[OK]]></return_msg>" +
                            "</xml>";
                }
            }catch (Exception e){
                logger.info("处理收付费支付回报失败",e);
            }
        }
        return null;
    }

    private synchronized String repayWechatNotify(Map<String, String> map) {
        //对接账单付款的消息
        String out_trade_no = map.get("out_trade_no");
        List<Repayment> repayments = billService.getRepaymentByTransId(out_trade_no);
        String total_fee = map.get("total_fee");
        String totalAmountStr = (String) redisService.get(out_trade_no);
        //String amount = 1 + "";
        if (repayments !=null && repayments.size() > 0 && totalAmountStr != null){
            Member member = memberService.queryByUid(repayments.get(0).getMemberId());
            if (total_fee.equals(totalAmountStr)) {
                //更新repayment状态为已支付
                for(Repayment repayment : repayments){
                    billService.finishRepayment(repayment.getRepaymentId(), RepaymentStatus.paid);
                    //尝试更新order和orderLeg状态为已支付
                    orderService.checkAndCloseOrder(repayment.getOrderId(), false, this.getClass().getName(),
                            "repayWechatNotify");
                }
                try {
                    //发送消息
                    String[] message=new String[2];
                    //账单支付金额
                    message[0]= new BigDecimal(totalAmountStr).divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_CEILING)+"";
                    //用户使用的额度
                    List<DaifuOrderLeg> allOpenOrderLegs = orderService
                            .queryAllOrderLegsOfMember(member.getUid(), true, false);
                    //计算总的未还款的子订单总金额
                    BigDecimal totalUsedAmount = new BigDecimal(0.0);
                    for(DaifuOrderLeg l:allOpenOrderLegs){
                        totalUsedAmount = totalUsedAmount.add(l.getAmount());
                    }
                    message[1]= totalUsedAmount.setScale(2,BigDecimal.ROUND_CEILING)+"";
                    redisService.delete(out_trade_no);
                    weChatService.sendMessge(member.getWechatOpenid(),
                            "7n66wtC8q2mPRT3J7k3p3WQQlvI8UOi6WKxXLi9qvGY",
                            domainName+"/wx/home?url=order.html",
                            "亲,还款"+message[0]+"元成功,请查询可用额度确认!",
                            "如有疑问请联系客服!",
                            message);
                } catch (Exception e) {
                    logger.error("微信还款回调,订单:" + out_trade_no + ",message:" + e.getMessage());
                }

                return "<xml>" +
                        "<return_code><![CDATA[SUCCESS]]></return_code>" +
                        "<return_msg><![CDATA[OK]]></return_msg>" +
                        "</xml>";
            }
            return "<xml>" +
                    "<return_code><![CDATA[SUCCESS]]></return_code>" +
                    "<return_msg><![CDATA[OK]]></return_msg>" +
                    "</xml>";
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        String url = "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";
        Map<String, String> datamap = new TreeMap<>();
        datamap.put("mch_id", "1495662972");
        datamap.put("nonce_str", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
        try {
            String xml = WXPayUtil.generateSignedXml(datamap, "3ed6862a77044f30b9a1a3d5cc099f77");
            System.out.println(HttpRequestUtils.sendPostXml(url, xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
