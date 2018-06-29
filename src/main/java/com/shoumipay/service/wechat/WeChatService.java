package com.shoumipay.service.wechat;

import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.domain.JdDaiFu;
import com.shoumipay.domain.WeChatRepay;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by Zhw on 2017/12/28.
 */
public interface WeChatService {
    String WECHAT_OAUTH2_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";

    /**
     * 模板发送
     */
    String sendMessge(String openId, String template_id, String url, String title, String remarkValue, String[] key);

    /**
     * 发送客服文本消息
     * @return
     */
    String sendCcTextMessge(String openId, String message);

    /**
     * 微信消息处理
     */
    String processRequest(HttpServletRequest request);

    /**
     * 微信oauth2授权
     */
    String oauth2Url(String url);

    /**
     * 手续费已经支付
     */
    BigDecimal createWeChatPay(BigDecimal money);

    /**
     * 微信还款表 添加
     */
    int addWeChatReapy(WeChatRepay weChatRepay);

    /**
     * 微信还款表 更新
     */
    int uppWeChatReapy(WeChatRepay weChatRepay);

    /**
     * 微信还款表查询
     */
    WeChatRepay getWeChatReapyByOutTradeNo(String outTradeNo);

    /**
     * 向用户发送的等待支付消息
     * @param nickName
     * @param jdDaiFu
     * @param orderNumber
     * @param wareName
     * @return
     */
    String getPayMessage(String nickName, JdDaiFu jdDaiFu, String orderNumber, String wareName);

    String getPayMessage(String nickName, DaifuCode jdDaiFu, String orderNumber, String wareName);
}

