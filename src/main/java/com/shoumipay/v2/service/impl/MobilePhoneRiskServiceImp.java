package com.shoumipay.v2.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.v2.service.MemberService;
import com.shoumipay.service.wechat.JXLDataService;
import com.shoumipay.tools.StringUtil;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.docs.MemberDocument;
import com.shoumipay.v2.service.MobilePhoneRiskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Service
public class MobilePhoneRiskServiceImp implements MobilePhoneRiskService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JXLDataService jxlDataService;
    @Autowired
    private MemberService memberService;

    private double getRegTime(JSONObject report_data) {
        try {
            JSONArray application_check = report_data.getJSONArray("application_check");
            for (int i = 0; i < application_check.size(); i++) {
                String app_point = application_check.getJSONObject(i).getString("app_point");
                if (app_point.equals("cell_phone")) {
                    Date reg_time = application_check.getJSONObject(i).getJSONObject("check_points").getDate("reg_time");
                    return diff_month(reg_time);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 52.26;
    }
    private int getGender(JSONObject report_data) {
        try {
            JSONArray application_check = report_data.getJSONArray("application_check");
            for (int i=0; i<application_check.size(); i++) {
                JSONObject jsonObject = application_check.getJSONObject(i);
                if ("id_card".equals(jsonObject.getString("app_point"))) {
                    String gender = jsonObject.getJSONObject("check_points").getString("gender");
                    if (!("女").equals(gender)) {
                        return 2;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    private int getSearched_org_cnt(JSONObject report_data) {
        try {
            Integer UC_SEARCHED_ORG_CNT = report_data.getJSONObject("user_info_check")
                    .getJSONObject("check_search_info").getInteger("searched_org_cnt");
            if (UC_SEARCHED_ORG_CNT >= 18) {
                return 18;
            } else {
                return UC_SEARCHED_ORG_CNT;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -99;
    }

    private int getContacts_class1_blacklist_cnt(JSONObject report_data) {
        try {
            Integer contacts_class1_blacklist_cnt = report_data.getJSONObject("user_info_check")
                    .getJSONObject("check_black_info").getInteger("contacts_class1_blacklist_cnt");
            return contacts_class1_blacklist_cnt;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    private String getBehavior_check(JSONObject report_data, String key) {
        try {
            JSONArray array = report_data.getJSONArray("behavior_check");
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                if (key.equals(jsonObject.getString("check_point"))) {
                    return jsonObject.getString("result");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    private float getPhone_silent(JSONObject report_data) {
        String phone_silent = getBehavior_check(report_data, "phone_silent");
        if (!StringUtil.isNull(phone_silent)) {
            String[] split = phone_silent.split("天|有");
            if (split.length >= 3 && StringUtil.isNumber(split[0]) && StringUtil.isNumber(split[2])) {
                float v1 = Float.parseFloat(split[2]);
                float v2 = Float.parseFloat(split[0]);
                if (v2 == 0) {
                    return 1;
                }
                return v1/v2;
            }
        }
        return 1;
    }

    private double getRG_T_AVG_CALL_IN_TIME(JSONObject report_data) {
        try {
            JSONArray contact_region = report_data.getJSONArray("contact_region");
            double region_avg_call_in_time_all = 0;
            for (int i = 0; i < contact_region.size(); i++) {
                Double region_avg_call_in_time = contact_region.getJSONObject(i).getDouble("region_avg_call_in_time");
                region_avg_call_in_time_all += region_avg_call_in_time;
            }
            if (contact_region.size() != 0) {
                return region_avg_call_in_time_all / contact_region.size();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -99;
    }

    private long getTripinfo(JSONObject report_data) {
        try {
            long trip = 0;
            JSONArray trip_info = report_data.getJSONArray("trip_info");
            for (int i = 0; i < trip_info.size(); i++) {
                JSONObject jobj = trip_info.getJSONObject(i);
                String trip_type = jobj.getString("trip_type");
                if ("工作日".equals(trip_type)) {
                    Date end = jobj.getDate("trip_end_time");
                    Date start = jobj.getDate("trip_start_time");
                    if (start != null && end!=null) {
                        int m = diff_month(start);
                        if (m >= 1 && m <=6) {
                            trip += diff_day(end, start);
                        }
                    }
                }
            }
            return trip;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private static int getApphh1() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        String mm = "M" + dateFormat.format(new Date());
        if ("M02M03M04M05".contains(mm)) {
            return 1;
        } else if ("M07M08M09M10".contains(mm)) {
            return 3;
        } else if ("M19M20M21M22".contains(mm)) {
            return 3;
        }
        return 2;
    }
    // ilist: ph_cnt,call_cut_int,SERV_EARLY_MORNING,fam_contact_1w
    private static boolean parseCallData(JSONObject report_data, Integer[] ilist, Double[] dlist) {
        try {
            Integer ph_cnt = 0;
            Integer call_cut_int = 0;
            Integer contact_early_morning = 0;
            Integer contact_1w = 0;
            Double call_out_len = 0.0;
            boolean far_exist = false;
            JSONArray contact_list = report_data.getJSONArray("contact_list");
            for (int i = 0; i < contact_list.size(); i++) {
                JSONObject jobj = contact_list.getJSONObject(i);
                if (jobj == null || jobj.getString("needs_type") == null) {
                    continue;
                }
                String need_type = jobj.getString("needs_type");
                if (need_type.equals("租车") || need_type.equals("114电话导航") || need_type.equals("信用卡") || need_type.equals("运营商")
                        || need_type.equals("汽车")) {
                    contact_early_morning +=  jobj.getInteger("contact_early_morning");
                    call_out_len += jobj.getDouble("call_out_len");
                } else if (need_type.equals("家庭短号") || need_type.equals("旅游出行") || need_type.equals("亲情号码")) {
                    contact_1w += jobj.getInteger("contact_1w");
                    far_exist = true;
                }
                String phone_num = jobj.getString("phone_num");
                if ( (phone_num.length() == 11 && phone_num.charAt(0) == '1')
                        || (phone_num.length() == 14 && phone_num.substring(0,3).equals("086") && phone_num.charAt(3) == '1')) {
                    ph_cnt += 1;
                }
                call_cut_int += 1;
            }
            ilist[0] = ph_cnt;
            ilist[1] = call_cut_int;
            ilist[2] = contact_early_morning;
            if (far_exist) {
                ilist[3] = contact_1w;
            } else {
                ilist[3] = -99;
            }
            dlist[0] = call_out_len;
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    private int diff_month(String date, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            Date date1 = dateFormat.parse(date);
            return diff_month(date1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    private int diff_month(Date date1) {
        try {
            Date date2 = new Date();
            return (date2.getYear() - date1.getYear()) * 12 + date2.getMonth() - date1.getMonth();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    private long diff_day(Date end, Date start) {
        try {
            long beginTime = start.getTime();
            long endTime = end.getTime();
            return (long)Math.floor((endTime - beginTime) / (1000 * 60 * 60 *24) + 0.5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private double getCv3_call_out_time(JSONObject report_data) {
        try {
            JSONArray behavior = report_data.getJSONArray("cell_behavior").getJSONObject(0).getJSONArray("behavior");
            ArrayList<Double> list = new ArrayList<>();
            for (int i = 0; i < behavior.size(); i++) {
                JSONObject jobj = behavior.getJSONObject(i);
                if (jobj != null && !StringUtil.isNull(jobj.getString("cell_mth"))) {
                    int dm = diff_month(jobj.getString("cell_mth"), "yyyy-MM");
                    if (dm == 1 || dm == 2 || dm ==3 ) {
                        list.add(jobj.getDouble("call_out_time"));
                    }
                }
            }
            if (list.size() > 1) {
                double sum = 0;
                for (Double d : list) sum += d;
                double avg = sum / list.size();
                double std2 = 0;
                for (Double d : list) std2 += (d - avg) * (d - avg);
                double std = Math.sqrt(std2/(list.size()-1));
                if (avg != 0) {
                    return std/avg * 100;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private int getUp10s6(JSONObject report_data) {
        try {
            JSONArray behavior = report_data.getJSONArray("cell_behavior").getJSONObject(0).getJSONArray("behavior");
            HashMap<Integer, Integer> list = new HashMap<>();
            for (int i = 0; i < behavior.size(); i++) {
                JSONObject jobj = behavior.getJSONObject(i);
                if (jobj != null && !StringUtil.isNull(jobj.getString("cell_mth"))) {
                    int dm = diff_month(jobj.getString("cell_mth"), "yyyy-MM");
                    if (dm>0 && dm <=6) {
                        list.put(dm, jobj.getIntValue("call_in_cnt"));
                    }
                }
            }
            for (Integer i = 1; i<= 6 ; i++) {
                if (list.get(i)==null) list.put(i, 0);
            }
            int up10s6 = 0;
            for (Integer i = 1; i< 6 ; i++) {
                Integer v = list.get(i);
                Integer n = list.get(i + 1);
                if (n != 0 && v.doubleValue()/n.doubleValue() > 1.1) {
                    up10s6 ++;
                }
                if (n == 0 && v > 0) {
                    up10s6 ++;
                }
            }
            return up10s6;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    private int getDn50s3(JSONObject report_data) {
        try {
            JSONArray behavior = report_data.getJSONArray("cell_behavior").getJSONObject(0).getJSONArray("behavior");
            HashMap<Integer, Integer> list = new HashMap<>();
            for (int i = 0; i < behavior.size(); i++) {
                JSONObject jobj = behavior.getJSONObject(i);
                if (jobj != null && !StringUtil.isNull(jobj.getString("cell_mth"))) {
                    int dm = diff_month(jobj.getString("cell_mth"), "yyyy-MM");
                    if (dm>0 && dm <=3) {
                        list.put(dm, jobj.getIntValue("call_cnt"));
                    }
                }
            }
            for (Integer i = 1; i<= 3 ; i++) {
                if (list.get(i)==null) list.put(i, 0);
            }
            int dn50s3 = 0;
            for (Integer i = 1; i< 3 ; i++) {
                Integer v = list.get(i);
                Integer n = list.get(i + 1);
                if (n != 0 && v.doubleValue()/n.doubleValue() < 1.5) {
                    dn50s3 ++;
                }
            }
            return dn50s3;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static String readToString(String fileName) {
        String encoding = "UTF8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (Exception e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    //风控等级判断
    @Override
    public int riskRating(Member member) {
        MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
        MemberDocument doc = DocumentUtils.getInstance().getByMemberId(member.getUid(), DocumentUtils.JXL);
        if(memberDetail == null){
            logger.info("user not exist");
            return 6;
        }
        //是否报告已经存在
        JSONObject resultJson = null;
        if(doc == null || StringUtils.isEmpty((String) doc.getDoc()) ){
            resultJson = jxlDataService.JXLReportData(memberDetail.getFullname(), member.getPhoneNumber(),
                    memberDetail.getIdCard());
            if (resultJson != null && resultJson.get("success").equals("true")) {
                DocumentUtils.getInstance().update(member.getUid(), DocumentUtils.JXL, resultJson.toString());
            }else{
                logger.info("查询聚信立结果数据错误: " + member.getUid());
                return 6;
            }
        }else{
            try {
                resultJson = JSON.parseObject((String) doc.getDoc());
            }catch (Exception e){
                logger.info("查询聚信立结果数据解析: " + member.getUid());
                return 6;
            }
        }
        JSONObject report_data = resultJson.getJSONObject("report_data");
        if (report_data == null) {
            return 0;
        }
        //1. ph_mth2 手机在网时长
        double ph_mth = getRegTime(report_data);
        int ph_mth2 = getPh_mth2(ph_mth);
        //4. GENDER    性别
        int GENDER = getGender(report_data);
        //5. UC_SEARCHED_ORG_CNT1 查询机构数量
        int UC_SEARCHED_ORG_CNT1 = getSearched_org_cnt(report_data);
        //6.BCH_PH_nACT 手机活跃度
        double BCH_PH_ACT = getPhone_silent(report_data);
        int BCH_PH_nACT = getBCH_PH_nACT(BCH_PH_ACT);
        //7. RG_T_AVG_CALL_IN_TIME1 总平均
        double RG_T_AVG_CALL_IN_TIME = getRG_T_AVG_CALL_IN_TIME(report_data);
        double RG_T_AVG_CALL_IN_TIME1 = getRG_T_AVG_CALL_IN_TIME1(RG_T_AVG_CALL_IN_TIME);
        //8. UC_CONS_C1_BLK_CNT1 关联人在黑名单个数
        int UC_CONS_C1_BLK_CNT1 = getContacts_class1_blacklist_cnt(report_data);

        //11. TRIP_TM6_DUR_WD2 最近6个月周末出行次数
        long TRIP_TM6_DUR_WD = getTripinfo(report_data);
        int TRIP_TM6_DUR_WD2 = TRIP_TM6_DUR_WD > 7 ? 1 : 0;
        //12. 最近6个月呼入比例上升10%次数
        int up10s6_CALL_IN_CNT_RT = getUp10s6(report_data);
        //13. dn50s3_CALL_CNT1 最近3个月通话次数下降50%次数
        int dn50s3_CALL_CNT = getDn50s3(report_data);
        int dn50s3_CALL_CNT1 = dn50s3_CALL_CNT >= 2 ? 1 : 0;
        //14. apphh1 申请时间
        int apphh1 = getApphh1();
        //15. cv3_CALL_OUT_TIME1 最近3关于呼出时间波动系数
        double cv3_CALL_OUT_TIME = getCv3_call_out_time(report_data);
        int cv3_CALL_OUT_TIME1 = (cv3_CALL_OUT_TIME > 0 && cv3_CALL_OUT_TIME <= 42) ? 0 : 1;

        Integer ph_cnt = 0;
        Integer call_cut_int = 0;
        Integer SERV_EARLY_MORNING = 0;
        Integer fam_contact_1w = -99;
        Double SERV_CALL_OUT_LEN = 16.75;
        Integer[] ilist = new Integer[4];//ph_cnt,call_cut_int,SERV_EARLY_MORNING,fam_contact_1w
        Double[] dlist = new Double[1];
        if (parseCallData(report_data, ilist, dlist)){
            ph_cnt = ilist[0];
            call_cut_int = ilist[1];
            SERV_EARLY_MORNING = ilist[2];
            fam_contact_1w = ilist[3];
            SERV_CALL_OUT_LEN = dlist[0];
        }
        //2. SERV_CALL_OUT_LEN2 高危电话呼出时长
        int SERV_CALL_OUT_LEN2 = getSERV_CALL_OUT_LEN2(SERV_CALL_OUT_LEN);
        //3. rt_PH_CALL_CNT2 手机  v.s.非手机比例
        double rt_PH_CALL_CNT = -99;
        if ((call_cut_int - ph_cnt) != 0) {
            rt_PH_CALL_CNT = ph_cnt.doubleValue() / (call_cut_int.doubleValue() - ph_cnt.doubleValue());
        }
        double rt_PH_CALL_CNT2 = getrt_PH_CALL_CNT2(rt_PH_CALL_CNT);
        //9. SERV_EARLY_MORNING1 凌晨高危电话个数
        int SERV_EARLY_MORNING1 = getSERV_EARLY_MORNING1(SERV_EARLY_MORNING);
        //10. FAM_CONTACT_1W 最近一周家庭电话拨打次数
        Integer FAM_CONTACT_1W = fam_contact_1w;

        double prob = getProb( ph_mth2,  SERV_CALL_OUT_LEN2,  rt_PH_CALL_CNT2,  GENDER,  UC_SEARCHED_ORG_CNT1,
                BCH_PH_nACT,  RG_T_AVG_CALL_IN_TIME1,  UC_CONS_C1_BLK_CNT1,  SERV_EARLY_MORNING1, FAM_CONTACT_1W,
                TRIP_TM6_DUR_WD2,  up10s6_CALL_IN_CNT_RT,  dn50s3_CALL_CNT1, apphh1,  cv3_CALL_OUT_TIME1);
        int Risk_seg = getRisk_seg(prob);
        return Risk_seg;
    }

    public int getPh_mth2(double ph_mth) {
        int ph_mth2;
        if (ph_mth <= 24) {
            ph_mth2 = 1;
        } else if (ph_mth <= 30) {
            ph_mth2 = 2;
        } else if (ph_mth <= 36) {
            ph_mth2 = 3;
        } else if (ph_mth <= 64) {
            ph_mth2 = 4;
        } else if (ph_mth <= 75) {
            ph_mth2 = 5;
        } else if (ph_mth <= 90) {
            ph_mth2 = 6;
        } else {
            ph_mth2 = 7;
        }
        return ph_mth2;
    }

    public int getSERV_CALL_OUT_LEN2(double SERV_CALL_OUT_LEN) {
        int SERV_CALL_OUT_LEN2;
        if (SERV_CALL_OUT_LEN <= 5.5) {
            SERV_CALL_OUT_LEN2 = 1;
        } else if (SERV_CALL_OUT_LEN <= 65.5) {
            SERV_CALL_OUT_LEN2 = 2;
        } else {
            SERV_CALL_OUT_LEN2 = 3;
        }
        return SERV_CALL_OUT_LEN2;
    }

    public double getrt_PH_CALL_CNT2(double rt_PH_CALL_CNT) {
        double rt_PH_CALL_CNT2;
        if (rt_PH_CALL_CNT >= 17) {
            rt_PH_CALL_CNT2 = 17;
        } else {
            rt_PH_CALL_CNT2 = rt_PH_CALL_CNT;
        }
        return rt_PH_CALL_CNT2;
    }

    public int getBCH_PH_nACT(double BCH_PH_ACT) {
        int BCH_PH_nACT;
        if (BCH_PH_ACT == 1) {
            BCH_PH_nACT = 0;
        } else if (BCH_PH_ACT < 0.02) {
            BCH_PH_nACT = 1;
        } else if (BCH_PH_ACT < 0.035) {
            BCH_PH_nACT = 2;
        } else if (BCH_PH_ACT < 0.1) {
            BCH_PH_nACT = 3;
        } else if (BCH_PH_ACT < 0.3) {
            BCH_PH_nACT = 4;
        } else {
            BCH_PH_nACT = 5;
        }
        return BCH_PH_nACT;
    }

    public double getRG_T_AVG_CALL_IN_TIME1(double RG_T_AVG_CALL_IN_TIME) {
        double RG_T_AVG_CALL_IN_TIME1;
        if (RG_T_AVG_CALL_IN_TIME <= 0.65) {
            RG_T_AVG_CALL_IN_TIME1 = 0.65;
        } else if (RG_T_AVG_CALL_IN_TIME >= 4) {
            RG_T_AVG_CALL_IN_TIME1 = 4;
        } else {
            RG_T_AVG_CALL_IN_TIME1 = RG_T_AVG_CALL_IN_TIME;
        }
        return RG_T_AVG_CALL_IN_TIME1;
    }

    public int getSERV_EARLY_MORNING1(int SERV_EARLY_MORNING) {
        int SERV_EARLY_MORNING1;
        if (SERV_EARLY_MORNING == 0) {
            SERV_EARLY_MORNING1 = 0;
        } else if (SERV_EARLY_MORNING >= 36) {
            SERV_EARLY_MORNING1 = 36;
        } else {
            SERV_EARLY_MORNING1 = SERV_EARLY_MORNING;
        }
        return SERV_EARLY_MORNING1;
    }

    public double getProb(int ph_mth2, int SERV_CALL_OUT_LEN2, double rt_PH_CALL_CNT2, int GENDER, int UC_SEARCHED_ORG_CNT1,
                          int BCH_PH_nACT, double RG_T_AVG_CALL_IN_TIME1, int UC_CONS_C1_BLK_CNT1, int SERV_EARLY_MORNING1,
                          int FAM_CONTACT_1W, int TRIP_TM6_DUR_WD2, int up10s6_CALL_IN_CNT_RT, int dn50s3_CALL_CNT1,
                          int apphh1, int cv3_CALL_OUT_TIME1) {
        double pred = (ph_mth2*(-0.1249))+(GENDER*0.4538)+(UC_SEARCHED_ORG_CNT1*0.0557)+(BCH_PH_nACT*0.0981)+
                (SERV_CALL_OUT_LEN2*0.307)+(RG_T_AVG_CALL_IN_TIME1*0.1602)+(apphh1*(-0.1656))+(rt_PH_CALL_CNT2*0.00893)+
                (cv3_CALL_OUT_TIME1*0.1618)+(UC_CONS_C1_BLK_CNT1*0.0442)+(SERV_EARLY_MORNING1*0.0334)+(FAM_CONTACT_1W*(-0.0018))+
                (TRIP_TM6_DUR_WD2*0.148)+(up10s6_CALL_IN_CNT_RT*0.0625)+(dn50s3_CALL_CNT1*(-0.1213))+(-3.9877);
        return 1/(Math.exp(-pred)+1);
    }

    public int getRisk_seg(double prob) {
        int Risk_seg;
        if (prob<=0.0416){
            Risk_seg = 1;
        } else if (prob<=0.0525){
            Risk_seg = 2;
        } else if (prob<=0.0619){
            Risk_seg = 3;
        } else if (prob<=0.0762){
            Risk_seg = 4;
        } else if (prob<=0.099){
            Risk_seg = 5;
        } else{
            Risk_seg = 6;
        }
        return Risk_seg;
    }
}
