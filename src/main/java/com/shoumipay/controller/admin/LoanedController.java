package com.shoumipay.controller.admin;

import com.shoumipay.controller.tool.BasicLoanController;
import com.shoumipay.tools.Message;
import com.shoumipay.vo.PreLoanVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tang on 2017/11/20.
 */
@Controller
@RequestMapping("/loaned")
public class LoanedController extends BasicLoanController {

    @RequestMapping("/overdue")
    public String overdue() {
        return "loaned/overdue";
    }

    @RequestMapping("/overdue/list")
    @ResponseBody
    public Message overdue(@ModelAttribute PreLoanVO vo, Integer page, Integer rows) {
        return getOverdue(vo, page, rows);
    }

}
