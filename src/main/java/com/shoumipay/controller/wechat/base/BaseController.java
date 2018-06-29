package com.shoumipay.controller.wechat.base;

import com.shoumipay.domain.Member;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.admin.OperLogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Zhw on 2018/1/3.
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpSession session;
    @Autowired
    private OperLogsService operLogsService;

    @Autowired
    private MemberService memberService;

    @Value("${spring.profiles}")//配置文件中属性信息
    private String env;

    /**
     * 获取session中的当前登录用户
     *
     * @return
     */
    public Member getLoginMember() {
       if(!env.equals("prod") && !env.equals("test")){
           return memberService.queryByPhoneNumber(env);
       }

        if (session.getAttribute("memberOpenIdLogin") != null) {
            return (Member) session.getAttribute("memberOpenIdLogin");
        }
        return null;
    }

    public void setLoginMember(Member member) {
        session.setAttribute("memberOpenIdLogin", member);
    }

    public HttpSession getHttpSession() {
        return session;
    }

    public HttpServletRequest getHttpRequest() {
        return request;
    }

    public HttpServletResponse getHttpResponse() {
        return response;
    }

}
