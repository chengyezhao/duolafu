package com.shoumipay.service.impl;

import com.shoumipay.dao.FeedbackMapper;
import com.shoumipay.domain.Feedback;
import com.shoumipay.service.admin.FeedbackService;
import com.shoumipay.vo.FeedbackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Tang on 2017/10/25.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    public void insertSelective(Feedback feedback){
        feedbackMapper.insertSelective(feedback);
    }

    @Override
    public List<FeedbackVO> selectVO(String phoneNumber, String key, Date start, Date end) {
        if (null != key) key = "%" + key + "%";
        return feedbackMapper.selectVO(phoneNumber, key, start, end);
    }
}
