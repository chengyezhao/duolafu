package com.shoumipay.controller.wechat.api;

import com.shoumipay.constants.GoodsOrderConstants;
import com.shoumipay.constants.WeChatConstants;
import com.shoumipay.controller.wechat.base.BaseController;
import com.shoumipay.domain.*;
import com.shoumipay.service.admin.GoodsService;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.service.DaifuCodeService;
import com.shoumipay.service.wechat.JdDaiFuService;
import com.shoumipay.service.wechat.WeChatService;
import com.shoumipay.service.wechat.WxPayService;
import com.shoumipay.tools.UserUtil;
import com.shoumipay.tools.wechat.Permission;
import com.shoumipay.tools.wechat.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Zhw on 2018/1/12.
 * 微信支付相关
 */
@Controller
@RequestMapping("wx")
public class DaiFuController extends BaseController {
    @Autowired
    private JdDaiFuService jdDaiFuService;
    @Autowired
    private WxPayService wxPayService;
    @Autowired
    private WeChatService weChatService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private DaifuCodeService daifuCodeService;

    @RequestMapping("pay")
    @Permission
    public String pay(HttpServletRequest request, Model model, String payid) {
        Member member = getLoginMember();
        JdDaiFu jdDaiFu = jdDaiFuService.queryJdDaiFuByPayId(payid);
        GoodsOrder goodsOrder = goodsService.queryOrderByDaifuId(jdDaiFu.getId());
        if (jdDaiFu != null && goodsOrder != null && goodsOrder.getOrderStatus() == GoodsOrderConstants.APPROVAL
                && jdDaiFu.getWeiXinDaiFuStatus() == WeChatConstants.WECHAT_DAIFU_ORDER_STATUS_FALSE
                && jdDaiFu.getPoundagePayFlag() == WeChatConstants.WECHAT_DAIFU_ORDER_STATUS_FALSE) {
            String json = null;
            try {
                json = wxPayService.weChatPay(jdDaiFu.getPoundagePayMoney(), member.getWechatOpenid(), payid, "购物服务", UserUtil.getUserIp(request), false);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("微信手续费支付异常,订单:" + payid);
            }
            model.addAttribute("result", json);
            return "h5/wechat_pay";
        }
        return "redirect:/wx/myOrder";
    }


    @RequestMapping("repay")
    @Permission
    public String repay(HttpServletRequest request, Model model, BigDecimal money) {
        if (money != null) {
            money = money.setScale(2, BigDecimal.ROUND_CEILING);
        }
        Member member = getLoginMember();
        String out_trade_no = WXPayUtil.generateUUID();
        WeChatRepay weChatRepay = new WeChatRepay();
        weChatRepay.setMemberId(member.getUid());
        weChatRepay.setCreateTime(new Date());
        weChatRepay.setOutTradeNo(out_trade_no);
        weChatRepay.setRepayMoney(money);
        int index = weChatService.addWeChatReapy(weChatRepay);
        if (index > 0) {
            String json = null;
            try {
                json = wxPayService.weChatPay(money, member.getWechatOpenid(), out_trade_no, "支付测试", UserUtil.getUserIp(request), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("result", json);
        }
        return "h5/wechat_pay";
    }

    //手续费支付
    @RequestMapping("notify")
    @ResponseBody
    public String notifyH(HttpServletRequest request) {
        String result = wxPayService.wechatNotify(request);
        if (result == null) {
            return "fail";
        }
        return result;
    }

}
