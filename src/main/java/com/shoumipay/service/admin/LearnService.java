package com.shoumipay.service.admin;

import com.shoumipay.domain.LearnResouce;

import java.util.List;
import java.util.Map;

/**
 * Created by zhw on 2017/8/1.
 */

public interface LearnService {
    int add(LearnResouce learnResouce);

    int update(LearnResouce learnResouce);

    int deleteByIds(String[] ids);

    LearnResouce queryLearnResouceById(Long learnResouce);

    List<LearnResouce> queryLearnResouceList(Map<String, Object> params);
}
