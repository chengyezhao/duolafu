package com.shoumipay.controller.wechat;

import com.shoumipay.constants.MemberConstants;
import com.shoumipay.controller.wechat.base.BaseController;
import com.shoumipay.domain.Member;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.cache.SMSCacheService;
import com.shoumipay.service.wechat.AccessTokenService;
import com.shoumipay.service.wechat.WeChatService;
import com.shoumipay.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by Zhw on 2017/12/27.
 */
@Controller
@RequestMapping("wx")
public class WeChatController extends BaseController {
    @Value("${wechat.token}")
    private static final String token = "zenghaowen";

    @Value("${domain.name}")
    private String domainName;

    @Autowired
    private AccessTokenService accessTokenService;
    @Autowired
    private WeChatService weChatService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private SMSCacheService smsCacheService;

    /**
     * 微信签名判断
     */
    public boolean wxSignatureCheck(String signature, String timestamp, String nonce) {
        boolean result = false;
        // 对token、timestamp和nonce按字典序排序
        String[] array = new String[]{token, timestamp, nonce};
        Arrays.sort(array);
        // 将三个参数字符拼接成一个字符串
        String str = array[0].concat(array[1]).concat(array[2]);
        String sha1Str = null;
        try {
            // 对拼接后的字符串进行sha1加密
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(str.getBytes());
            sha1Str = StringUtil.byte2str(digest);
        } catch (Exception e) {
        }
        if (sha1Str != null && sha1Str.equals(signature)) {
            result = true;
        }
        return result;
    }

    /**
     * 接口配置信息
     */
    @GetMapping("")
    public void wxTokenBind(String signature, String timestamp, String nonce, String echostr, PrintWriter out, HttpServletResponse response) {
        if (wxSignatureCheck(signature, timestamp, nonce)) {
            out.print(echostr);
            out.flush();
        }
    }

    /**
     * 微信用户发送消息处理
     */
    @PostMapping("")
    public void wxMessage(String signature, String timestamp, String nonce, PrintWriter out, HttpServletRequest request, HttpServletResponse response) {
        if (wxSignatureCheck(signature, timestamp, nonce)) {
            String result = weChatService. processRequest(request);
            try {
                result = new String(result.getBytes(), "iso8859-1");
                out.print(result);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } finally {
                out.flush();
            }

        }
    }

    /**
     * 微信授权接口,类似于登录接口
     */
    @RequestMapping("oauth2/code")
    public String oauth2Code(String code, String url) {//String state
        if (url == null) {
            url = "/wx/index";
        }
        HttpSession session = getHttpSession();
        Member member = (Member) session.getAttribute("memberOpenIdLogin");
        if (member == null) {
            if (code == null) {
                try {
                    url = URLEncoder.encode(url, "utf-8");

                    return "redirect:" + weChatService.oauth2Url(URLEncoder.encode(domainName + "/wx/oauth2/code?url=" + url, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    return "404";
                }
            }
            Map<String, String> map = accessTokenService.getWebAccessToken(code);
            if (map != null) {
                map = accessTokenService.getWebUserInfo(map);
            }
            if (map == null) {
                return "404";
            }
            String openid = map.get("openid");
            if (openid == null) {
                return "404";
            }
            String nickname = map.get("nickname");
            String headimgurl = map.get("headimgurl");
            member = memberService.getMemberByOpenid(openid);
            if (member == null) {
                member = new Member();
                member.setWechatOpenid(openid);
                member.setWechatNickname(nickname);
                member.setWechatHeadimgurl(headimgurl);
                member.setAuthenticationStatus(MemberConstants.AUTHENTICATION_STATUS_UNVERIFIED);
                member.setAddtime(new Date());
                long index = memberService.addMember(member);
                if (index <= 0) {
                    return "404";
                }
                member = memberService.getMemberByOpenid(openid);
            }
            session.setAttribute("memberOpenIdLogin", member);
        }
        if (StringUtil.isNull(member.getPhoneNumber())) {
            return "redirect:/public/bindingphone.html";
        }
        return "redirect:" + url;
    }
}
