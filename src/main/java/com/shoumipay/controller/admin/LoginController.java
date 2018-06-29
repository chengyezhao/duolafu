package com.shoumipay.controller.admin;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录
 * Created by Zhw on 2017/8/3.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) throws Exception {
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = " ";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号或密码错误";//UnknownAccountException 账号不存在
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "账号或密码错误";//IncorrectCredentialsException -- > 密码不正确
            } else {
                msg = exception;
            }
            model.addAttribute("msg", msg);
            return "login";
        } else {
            return "redirect:index";
        }
    }
}
