package com.shoumipay.dao;

import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberExample;
import com.shoumipay.vo.CountOrderStatusVO;
import com.shoumipay.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MemberMapper {
    long countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Long uid);

    Long insert(Member record);

    Long insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    List<MemberVO> selectByTime(@Param("status")Integer status,@Param("phone") String phone, @Param("fullName") String fullName, @Param("startTime") String startTime, @Param("endTime") String endTime,
                                @Param("authenticationStatus") Integer authenticationStatus,@Param("orderStatusPay") Integer orderStatusPay,@Param("ids") String ids);

    List<CountOrderStatusVO> selectByCount();

    Member selectByPrimaryKey(Long uid);

    Member selectByUsername(String username);

    Member selectByPhoneNumber(String phoneNumber);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    int updateByArrayId(@Param("ids")String[] ids,@Param("state")int state);

    List<Member> findAll();
}