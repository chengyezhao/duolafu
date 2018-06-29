package com.shoumipay.service.examine;

import com.shoumipay.domain.ExamineRule;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.service.admin.ExamineService;
import com.shoumipay.service.admin.OperLogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tang on 2017/10/26.
 */
public abstract class BasicExamineService implements ExamineService {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected ExamineRule examineRule;

    protected OperLogsService operLogsService;

    public BasicExamineService(ExamineRule examineRule, OperLogsService operLogsService) {
        this.examineRule = examineRule;
        this.operLogsService = operLogsService;
    }

    public abstract int examine(Member member);

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    protected int calcAge(String number) {
        try {
            Date birthday = sdf.parse(number.substring(6, 13));
            int age;
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间
            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);
            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    protected boolean span(Date start, Date end, int days) {
        if (null == start) return false;
        if (null == end) return false;
        long s = start.getTime();
        long e = end.getTime();
        if (e < s) {
            long t = s;
            s = e;
            e = t;
        }
        if (e < s + 1000L * 60 * 60 * 24 * days) return true; //在时间范围内
        else return false;
    }

    @Override
    public String getDesc() {
        return "基础规则审核不通过";
    }
}
