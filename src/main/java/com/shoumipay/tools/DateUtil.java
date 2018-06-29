package com.shoumipay.tools;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 项目名称：账号安全中心(all)
 * 类名称：DateUtil
 * 类描述：   时间操作工具
 * 创建人：linwu
 * 创建时间：2014-12-17 上午10:43:08
 */
public class DateUtil {
    public static final String DEFAULT_DATE_TIME2 = "yyyy-MM-dd HH:mm";
    public static final String DEFAULT_DATE_TIME3 = "yyyyMMdd HH:mm:ss";
    public static final String LOG_DATE_TIME = "yyyyMMddHHmmss";
    public static final String DEFAULT_SHORT_DATE = "yyyy-MM-dd";
    public static final String DEFAULT_HOUR_DATE = "yyyyMMddHH";
    public static final String DEFAULT_DAY_DATE = "yyyyMMdd";
    public static final String DEFAULT_MONTH_DATE = "yyyyMM";

    public static String format(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null) {
            return sdf.format(date);
        }
        return "";
    }

    public static String formatLong(Long date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null) {
            return sdf.format(date);
        }
        return "";
    }

    public static Date parse(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null) {
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 生成ISO-8601 规范的时间格式
     *
     * @param date
     * @return
     */
    public static String formatISO8601DateString(Date date) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        return DateFormatUtils.format(date, pattern);
    }


    /**
     * 获取反时间戳
     *
     * @return
     */
    public static Long getCurrentReverseTime() {
        long longTime = System.currentTimeMillis() * 1000000 + CalculateUtil.getNext(999999);
        return Long.MAX_VALUE - longTime;
    }

    /**
     * 获取原时间戳
     *
     * @param reverseTime
     * @return
     */
    public static Long recoverReverseTime(Long reverseTime) {
        long longTime = Long.MAX_VALUE - reverseTime;
        return longTime / 1000000;
    }

    /**
     * 生成页面普通展示时间
     *
     * @param date
     * @return
     */
    public static String formatNormalDateString(Date date) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 生成页面普通展示时间
     *
     * @param date
     * @return
     */
    public static String formatYMDDateString(Date date) {
        String pattern = "yyyy年MM月dd日";
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 日期加
     *
     * @param date
     * @param time
     * @return
     */
    public static Date addTime(Date date, Integer time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + time);//让日期加1
        return calendar.getTime();
    }

    /**
     * 时间加
     */
    public static Date addTimeHour(Date date, Integer hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }

    /**
     * 时间加
     */
    public static Date addTimeMinute(Date date, Integer hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, hour);
        return calendar.getTime();
    }

    /**
     * 时间加月
     */
    public static Date addTimeMonth(Date date, Integer month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static void main(String[] arg) {
        for (int j = 1; j <= 31; j++) {
            int billDay = ObjectUtils.min(j, 28);//账单日期
            int nextBillDay = billDay + 10;
            if (nextBillDay / 10 == 3) {
                nextBillDay -= 30;
                if (nextBillDay == 0) {
                    nextBillDay = 30;
                }
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int i = calendar.getActualMaximum(Calendar.DATE);
            if (nextBillDay > i) {
                nextBillDay = i;
            }
            ;
            System.out.println(j + "-->" + billDay + "--->" + nextBillDay + "--->" + (billDay - 1 == 0 ? i : billDay - 1));
        }

        //Date date=addTime(new Date(),1);
       /* Date date=addTimeHour(new Date(),1);
        System.out.println(getStartTime(addTime(new Date(),-1)));
        System.out.println(getEndTime(addTime(new Date(),-1)));
        System.out.println(getStartTime());*/
        /*Date date = new Date();//获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        System.out.println(calendar.getTime());*/

        /*Date date=DateUtil.addTime(new Date(),10);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int day=calendar.get(Calendar.MONTH);*/
        /*Date date=DateUtil.addTime(new Date(),10);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int day=calendar.get(Calendar.DATE);


        Date date2=DateUtil.addTimeMonth(new Date(),1);
        date2=DateUtil.addTime(date2,-1);
        Calendar calendar2=Calendar.getInstance();
        calendar2.setTime(date2);
        int day2=calendar2.get(Calendar.DATE);*/
        /*model.addAttribute("nextBirthDay",day);*/
       /* Date date=DateUtil.addTimeMonth(new Date(),1);
        date=DateUtil.addTime(date,-1);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int day=calendar.get(Calendar.DATE);*/
        /*Date date=DateUtil.addTime(new Date(),10);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int day=calendar.get(Calendar.DATE);*/
    }

    //获取当天开始时间
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getStartTime(Date date) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    //获取当天结束时间
    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static Date getEndTime(Date date) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

}
