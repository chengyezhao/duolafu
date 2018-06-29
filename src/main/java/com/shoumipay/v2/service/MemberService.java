package com.shoumipay.v2.service;

import com.shoumipay.constants.QuotaEnum;
import com.shoumipay.domain.*;
import com.shoumipay.service.admin.ExamineService;
import com.shoumipay.vo.CountOrderStatusVO;
import com.shoumipay.vo.MemberVO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface MemberService {
    List<Member>  getAllMember();

    Member login(String username, String password);

    String getToken(Member member);

    List<Member> queryMember(Member member, Integer page, Integer rows);

    List<MemberVO> queryMemberVO(Integer status,String phone,String fullName, Integer page, Integer rows, String startTime, String endTime,Integer authenticationStatus,Integer orderStatusPay,String id);

    List<CountOrderStatusVO> selectByCount();

    Long addMember(Member member);

    boolean checkUserName(String userName);

    Member queryByUserName(String userName);

    Member queryByPhoneNumber(String phoneNumber);

    Member queryByUid(Long uid);

    /**
     * 根据openId获取用户
     * */
    Member getMemberByOpenid(String openid);

    Member getMemberByUid(Long uid);

    List<Member> queryMemberList(Date startTime, Date endTime);

    int updateMember(Member member);
    //修改状态
    int uppMemberState(String[] ids,int state);

    //MemberDetail
    MemberDetail queryMemberDetailByMemberId(Long memberId);

    List<MemberDetail> queryMemberDetailByIdCard(String idcard);

    int addMemberDetail(MemberDetail memberDetail);

    int uppMemberDetail(MemberDetail memberDetail);

    List<MemberDetail> queryMemberBirthday();

    List<MemberDetail> selectMemberDetail(MemberDetail memberDetail);

    //MemberLinkman
    MemberLinkman queryLinkmanByMemberId(Long memberId);

    int addMemberLinkman(MemberLinkman memberLinkman);

    int uppMemberLinkman(MemberLinkman memberLinkman);

    //memberJobs
    MemberJobs queryJobByMemberId(Long memberId);

    int addMemberJob(MemberJobs memberJobs);

    int uppMemberJob(MemberJobs memberJobs);

    //MemberDevices
    MemberDevices queryDevicesByMemberId(Long memberId);

    int addMemberDevices(MemberDevices memberDevices);

    int uppMemberDevices(MemberDevices memberDevices);

    //memberBankcard
    List<MemberBankcard> queryBankcardByMemberId(Long memberId);

    MemberBankcard queryDefaultBankcardByMemberId(Long memberId);

    MemberBankcard queryBankcardByBankcardId(Long id);

    int addMemberBankcard(MemberBankcard memberBankcard);

    int uppMemberBankcard(MemberBankcard memberBankcard);

    int delMemberBankcard(Long id);
    /**
     * 获取用户可用余额
     * */
    BigDecimal getMemeberBalance(Long memberId);
    /**
     * app提交个人资料信息完整检测
     * */
    String checkMemberInfo(MemberDetail memberDetail, MemberJobs memberJobs, MemberLinkman memberLinkman);
    /**
     * app提交身份证信息完整检测
     * */
    String checkMemberDetail(MemberDetail memberDetail);

    /**
     * 检查身份证是否认证
     * */
    boolean checkIdcardIsCertified(Long memberId);

    boolean checkTaobaoDataGathered(Long memberId);

    boolean checkJDDataGathered(Long memberId);
    /**
     * 检查运营商是否认证
     * */
    boolean checkTmobileIsCertified(Long memberId);
    /**
     * 检查银行卡是否认证
     * */
    boolean checkBankCardIsCertified(Long memberId);
    /**
     * 检查用户是否被激活
     * 选择性传memberId或者OperId  传null
     * */
    boolean checkMemberIsActive(Long memberId,String operId);
    /**
     * 获取京东手机号
     *
     * */
    String getJdPhone(long memberId);
    /**
     * 获取京东6个月消费总额
     * */
    BigDecimal getJdTotalConsumption(long memberId);

    void loadExamineService();

    /**
     * 客户级别的风控
     * @param member
     * @return
     */
    boolean userLevelRiskCalc(Member member);

    /**
     * 获取账单日 开始
     * */
    int getBillDay(long memberId);
    /**
     * 获取账单日 结束
     * @param startBillDay 出账日
     * */
    int endBillDay(int startBillDay);

    void calculateQuota(Member member);

    void setExamineServiceList(List<ExamineService> examineServiceList);
}