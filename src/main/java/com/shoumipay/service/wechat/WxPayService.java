package com.shoumipay.service.wechat;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public interface WxPayService {
    String weChatPay(BigDecimal money, String openid, String payid, String title,
                     String ip, boolean isRepay) throws Exception;

    String wechatNotify(HttpServletRequest request);

}
