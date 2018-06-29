package com.shoumipay.service.admin;

import com.shoumipay.domain.Feedback;
import com.shoumipay.vo.FeedbackVO;

import java.util.Date;
import java.util.List;

/**
 * Created by Tang on 2017/10/25.
 */
public interface FeedbackService {
    void insertSelective(Feedback feedback);
    List<FeedbackVO> selectVO(String phoneNumber, String key, Date start, Date end);

}
