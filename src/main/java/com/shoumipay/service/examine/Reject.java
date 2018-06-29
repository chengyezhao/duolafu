package com.shoumipay.service.examine;

import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.service.admin.ExamineService;
import com.shoumipay.service.admin.OperLogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Tang on 2017/10/27.
 */
public class Reject implements ExamineService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private OperLogsService operLogsService;

    public Reject(OperLogsService operLogsService) {
        this.operLogsService = operLogsService;
    }

    @Override
    public int examine(Member member) {
        logger.info("Reject 不通过 --> " + member);
        operLogsService.addOrderExamineLog("审核不通过", "Reject 不通过 --> ", 3, 0L);

        return Integer.MIN_VALUE;
    }

    @Override
    public String getDesc() {
        return "禁止申请";
    }
}
