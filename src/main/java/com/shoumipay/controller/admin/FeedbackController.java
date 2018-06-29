package com.shoumipay.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shoumipay.service.admin.FeedbackService;
import com.shoumipay.tools.Message;
import com.shoumipay.vo.FeedbackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Tang on 2017/11/9.
 */
@Controller
@RequestMapping("/notice")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/feedback")
    public String feedback() {
        return "notice/feedback";
    }

    @RequestMapping("/feedback/list")
    @ResponseBody
    public Message feedback(String phoneNumber, String key, Date start, Date end, Integer page, Integer rows) {
        if (null == page) page = 1;
        if (null == rows) rows = 10;
        PageHelper.startPage(page, rows);
        List<FeedbackVO> list = feedbackService.selectVO(phoneNumber, key, start, end);
        PageInfo<FeedbackVO> info = new PageInfo<>(list);
        return Message.success().add("list", list)
                .add("pages", info.getPages())
                .add("total", info.getTotal());
    }
}
