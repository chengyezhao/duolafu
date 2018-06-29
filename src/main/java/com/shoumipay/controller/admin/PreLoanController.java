package com.shoumipay.controller.admin;

import com.shoumipay.controller.tool.BasicLoanController;
import com.shoumipay.tools.Message;
import com.shoumipay.vo.PreLoanVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.shoumipay.constants.GoodsOrderConstants.*;

/**
 * Created by Tang on 2017/11/10.
 */
@Controller
@RequestMapping("/preLoan")
public class PreLoanController extends BasicLoanController {

    @InitBinder("vo")
    public void initPreLoanVO(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("vo.");
    }

    @RequestMapping("/pass")
    public String pass() {
        return "preLoan/pass";
    }

    @RequestMapping("/pass/list")
    @ResponseBody
    public Message pass(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return get(vo, page, rows, APPROVAL);
    }

    @RequestMapping("/reject")
    public String reject() {
        return "preLoan/reject";
    }

    @RequestMapping("/reject/list")
    @ResponseBody
    public Message reject(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return get(vo, page, rows, APPROVAL_REFUSED);
    }

    @RequestMapping("/closed")
    public String closed() {
        return "preLoan/closed";
    }

    @RequestMapping("/closed/list")
    @ResponseBody
    public Message closed(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return get(vo, page, rows, APPROVAL_CLOSED);
    }

}
