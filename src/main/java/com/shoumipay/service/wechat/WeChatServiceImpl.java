package com.shoumipay.service.wechat;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableList;
import com.shoumipay.constants.WeChatConstants;
import com.shoumipay.dao.WeChatRepayMapper;
import com.shoumipay.domain.*;
import com.shoumipay.service.admin.*;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.service.DaifuOrderService;
import com.shoumipay.v2.service.DaifuCodeService;
import com.shoumipay.tools.DateUtil;
import com.shoumipay.tools.StringUtil;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import com.shoumipay.tools.wechat.ToMapUtil;
import com.shoumipay.tools.wechat.WeChatMessageUtil;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.vo.WeChat.Articles;
import com.shoumipay.vo.WeChat.NewsMessage;
import com.shoumipay.vo.WeChat.TextMessage;
import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhw on 2017/12/29.
 */
@Service
public class WeChatServiceImpl implements WeChatService {
    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String secret;

    @Value("${domain.name}")
    private String domainName;

    @Autowired
    private MemberService memberService;
    @Autowired
    private JdDaiFuService jdDaiFuService;
    @Autowired
    private MemberBankcardService memberBankcardService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private AccessTokenService accessTokenService;
    @Autowired
    private WeChatRepayMapper weChatRepayMapper;
    @Autowired
    private DaifuCodeService daifuCodeService;
    @Autowired
    private DaifuOrderService code2OrderService;
    @Autowired
    private ConfigService configService;

    private Logger log = LoggerFactory.getLogger(getClass());

    private String weChatMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
    private String weChatCSMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";

    /**
     * 模板消息
     *
     * @param openId      微信openid
     * @param template_id 模板id
     * @param url         跳转url
     */
    public String sendMessge(String openId, String template_id, String url, String title, String remarkValue, String[] key) {
        log.info("send weichat message:" + StringUtils.join(ImmutableList.of(openId, template_id, url, title , remarkValue)));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", openId);
        jsonObject.put("template_id", template_id);
        if (!StringUtil.isNull(url)) {
            jsonObject.put("url", url);
        }
        JSONObject data = new JSONObject();

        JSONObject first = new JSONObject();
        first.put("value", title);
        first.put("color", "#5B9BD5");
        data.put("first", first);

        for (int i = 0; key.length > i; i++) {
            JSONObject keyword = new JSONObject();
            keyword.put("value", key[i]);
            keyword.put("color", "#000000");
            data.put("keyword" + (i + 1), keyword);
        }

        JSONObject remark = new JSONObject();
        remark.put("value", remarkValue);
        remark.put("color", "#5B9BD5");
        data.put("remark", remark);

        jsonObject.put("data", data);
        String accessToken = accessTokenService.getAccessToken();
        String result = HttpRequestUtils.sendPost(weChatMessageUrl + accessToken, jsonObject.toString(), true);
        return result;
    }

    @Override
    public String sendCcTextMessge(String openId, String message){
        log.info("send weichat message:" + StringUtils.join(ImmutableList.of(openId, message)));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", openId);
        jsonObject.put("msgtype", "text");
        JSONObject data = new JSONObject();
        data.put("content", message);
        jsonObject.put("text", data);
        String accessToken = accessTokenService.getAccessToken();
        String result = HttpRequestUtils.sendPost(weChatCSMessageUrl + accessToken, jsonObject.toString(), true);
        return result;
    }

    @Override
    public String processRequest(HttpServletRequest request) {
        Map<String, String> map = ToMapUtil.xmlToMap(request);
        log.info(map.toString());
        // 发送方帐号（一个OpenID）
        String fromUserName = map.get("FromUserName");
        // 开发者微信号
        String toUserName = map.get("ToUserName");
        // 消息类型
        String msgType = map.get("MsgType");
        String event = map.get("Event");
        String eventKey = map.get("EventKey");
        // 默认回复一个"success"
        String responseMessage = "success";
        Member member = memberService.getMemberByOpenid(fromUserName);
        // 对消息进行处理
        if (WeChatMessageUtil.MESSAGE_TEXT.equals(msgType)) {
            responseMessage = createMessage("我们已经收到您的消息，将会在稍后给您回复。如果您需要发起代付申请，请点击菜单上的发起代付按钮。 ",
                    WeChatMessageUtil.MESSAGE_TEXT, fromUserName, toUserName);
        } else if (WeChatMessageUtil.MESSAGE_LINK.equals(msgType)) {
            responseMessage = createMessage("我们已经收到您的消息，将会在稍后给您回复。如果您需要发起代付申请，请点击菜单上的发起代付按钮。 ",
                    WeChatMessageUtil.MESSAGE_TEXT, fromUserName, toUserName);

        } else if (WeChatMessageUtil.MESSAGE_EVENT.equals(msgType)) {
            //关注时间与如何代购菜单
            if (WeChatConstants.APPLICATION_METHOD_KEY.equals(eventKey)) {
                List<Articles> articlesList = new ArrayList<>();
                Articles articles = new Articles("爱代付使用方法"
                        , "哪里买都可以用爱代付分期！——爱代付，支持所有电商的购物分期神器"
                        , "https://mmbiz.qpic.cn/mmbiz_jpg/qXqXxeaIlyfOL7yQO6OanfI4r4T79JibmSO4jXVlaPBfbKKJ7Pzzo6VOzIKMlOIV7pFlFnb0IfAibGALQbicicj0lg/0?wx_fmt=jpeg"
                        , "https://mp.weixin.qq.com/s?__biz=MzU2OTM2ODQwMg==&mid=100000007&idx=1&sn=c61410af79563ef6b49ce2e2c929c8a1&chksm=7cfe8b3a4b89022c4e81cea8f38ae4f09de7c5c5485402ea65735ac86d4593bd19844c9747bb#rd");
                articlesList.add(articles);
                responseMessage = createNewsMessage(fromUserName, toUserName, articlesList);
            } else if (WeChatConstants.IN_DEVELOPMENT.equals(eventKey)) {
                responseMessage = createMessage("开发中!", WeChatMessageUtil.MESSAGE_TEXT, fromUserName, toUserName);
            } /*else if (WeChatConstants.SUPPORTING_PLATFORM.equals(eventKey)) {
                responseMessage = createMessage("哆啦付目前仅支持京东APP代付下单，更多平台开放，敬请期待！", WeChatMessageUtil.MESSAGE_TEXT, fromUserName, toUserName);
            } */ else if (WeChatMessageUtil.MESSAGE_EVENT_SUBSCRIBE.equals(event)) {
                String message = "hi~终于等到你！\n欢迎来到年轻人都在用的爱代付[Heart][Heart]\n\n这里，\n有专属于你的一站式购物分期服务，淘宝京东苏宁任你选[Smart]还有一些有趣的分享和超值的活动等你哦[Smirk]\n\n\n" +
                        "<a href=\"" + domainName + "/wx/index\">领取新手礼包 ：新人注册赢最高500元免单>>></a>"
                        + "\n\n你也可以点击底部 “个人账户” ，领取你的专属额度~~";
                responseMessage = createMessage(message, WeChatMessageUtil.MESSAGE_TEXT, fromUserName, toUserName);
            }
        }
        log.info(responseMessage);
        return responseMessage;
    }
    @Override
    public String oauth2Url(String url) {
        return WECHAT_OAUTH2_URL + "?appid=" + appid + "&redirect_uri=" + url + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
    }


    /**
     * 生成微信支付 手续费5%
     * todo
     */
    @Override
    public BigDecimal createWeChatPay(BigDecimal money) {
        return money.multiply(new BigDecimal(0.05)).setScale(2, BigDecimal.ROUND_CEILING);
    }

    @Override
    public String getPayMessage(String nickName, JdDaiFu jdDaiFu, String orderNumber, String wareName) {
        return "尊敬的" + nickName + "，您有1笔代购服务订单，请打开链接支付服务金： " +
                "<a href=\"" + domainName + "/wx/pay?payid=" + jdDaiFu.getPayid() + "\">金额：¥" + createWeChatPay(jdDaiFu.getOrderPrice()) + "元</a>\n" +
                "\n" +
                "订单详情\n" +
                "服务金额：¥" + jdDaiFu.getOrderPrice().setScale(2, BigDecimal.ROUND_CEILING) + "元\n" +
                "服务商品：" + wareName + " 等\n" +
                "订单编号：" + orderNumber + "\n" +
                "服务金额请于两个小时内支付：" + DateUtil.format(DateUtil.addTimeMinute(new Date(), 12), DateUtil.DEFAULT_DATE_TIME2) + "\n" +
                "<a href=\"" + jdDaiFu.getShareUrl() + "\">详情    > （查看详细代付链接内容）</a>";
    }

    @Override
    public String getPayMessage(String nickName, DaifuCode code, String orderNumber, String wareName) {
        return "尊敬的" + nickName + "，您有1笔代购服务订单，请打开链接支付服务金： " +
                domainName + "/wx/payDaifu?daifuId=" + code.getDaifuId() + "  金额：¥" + createWeChatPay(code.getPrice()) + "元\n" +
                "\n" +
                "订单详情\n" +
                "服务金额：¥" + code.getPrice().setScale(2, BigDecimal.ROUND_CEILING) + "元\n" +
                "服务商品：" + wareName + " 等\n" +
                "订单编号：" + orderNumber + "\n" +
                "服务金额请于两个小时内支付：" + DateUtil.format(DateUtil.addTimeMinute(new Date(), 12), DateUtil.DEFAULT_DATE_TIME2) + "\n" ;
    }

    @Override
    public int addWeChatReapy(WeChatRepay weChatRepay) {
        return weChatRepayMapper.insertSelective(weChatRepay);
    }

    @Override
    public int uppWeChatReapy(WeChatRepay weChatRepay) {
        return weChatRepayMapper.updateByPrimaryKeySelective(weChatRepay);
    }

    @Override
    public WeChatRepay getWeChatReapyByOutTradeNo(String outTradeNo) {
        if (StringUtil.isNull(outTradeNo)) {
            return null;
        }
        WeChatRepayExample example = new WeChatRepayExample();
        WeChatRepayExample.Criteria criteria = example.createCriteria();
        criteria.andOutTradeNoEqualTo(outTradeNo);
        List<WeChatRepay> weChatRepays = weChatRepayMapper.selectByExample(example);
        if (weChatRepays != null && weChatRepays.size() > 0) {
            return weChatRepays.get(0);
        }
        return null;
    }

    /**
     * 返回带登录链接信息
     */
    private String createErrorMessage(String errorMessage, boolean isLogin) {
        try {
            String url = "";
            if (isLogin) {
                url = domainName + "/wx/oauth2/code";
            } else {
                url = domainName + "/wx/material";
            }
            errorMessage = "<a href='" + oauth2Url(URLEncoder.encode(url, "utf-8")) + "'>" + errorMessage + "</a>";
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            errorMessage = "系统繁忙";
        }
        return errorMessage;
    }

    private String createErrorMessage(int index) {
        String errorMessage = null;
        try {
            String url = "";
            /*if (isLogin) {
                url = domainName + "/wx/oauth2/code";
            } else {
                url = domainName + "/wx/material";
            }*/
            switch (index) {
                case 1:
                    url = domainName + "/wx/oauth2/code";
                    break;
                case 2:
                    url = domainName + "/wx/material";
                    break;
                case 3:
                    url = domainName + "/wx/platfom";
                    break;
            }
            errorMessage = "您还不是我们的会员，哆啦付无法为您提供服务，请到 “注册申请”提交申请并进行“平台关联”成为哆啦付会员吧。<a href=\"" + oauth2Url(URLEncoder.encode(url, "utf-8")) + "\">点击申请</a>";
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            errorMessage = "系统繁忙";
        }
        return errorMessage;

    }

    /**
     * 微信消息回复
     *
     * @param message      回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     * @param messageType  回复信息的类型
     * @param fromUserName 开发者微信号
     * @param toUserName   接收方帐号（收到的OpenID）
     */
    private String createMessage(String message, String messageType, String fromUserName, String toUserName) {
        TextMessage textMessage = new TextMessage();
        textMessage.setMsgType(messageType);
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setContent(message);
        return WeChatMessageUtil.textMessageToXml(textMessage);
    }

    /**
     * 微信回复图文消息
     */
    private String createNewsMessage(String fromUserName, String toUserName, List<Articles> articlesList) {
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setMsgType(WeChatMessageUtil.MESSAGE_NEWS);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(System.currentTimeMillis());
        newsMessage.setArticleCount(articlesList.size());
        newsMessage.setArticles(articlesList);
        return WeChatMessageUtil.newMessageToXml(newsMessage);
    }

}
