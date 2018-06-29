package com.shoumipay.dao;

import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberBankcard;
import com.shoumipay.domain.MemberBankcardExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface MemberBankcardMapper {
    long countByExample(MemberBankcardExample example);

    int deleteByExample(MemberBankcardExample example);

    int deleteByPrimaryKey(Long cardid);

    int insert(MemberBankcard record);

    int insertSelective(MemberBankcard record);

    List<MemberBankcard> selectByExample(MemberBankcardExample example);

    List<MemberBankcard> selectByMemberId(Long memberId);

    MemberBankcard selectByPrimaryKey(Long cardid);

    MemberBankcard selectByIdAndBindType(@Param("memberId") Long memberId,@Param("bindType") Long bindType);

    MemberBankcard selectWithhold(@Param("memberId") Long memberId);

    MemberBankcard selectByUidBankNumber(@Param("memberId") Long memberId,@Param("bankcardNumber") String bankcardNumber);

    int updateByExampleSelective(@Param("record") MemberBankcard record, @Param("example") MemberBankcardExample example);

    int updateByExample(@Param("record") MemberBankcard record, @Param("example") MemberBankcardExample example);

    int updateByPrimaryKeySelective(MemberBankcard record);

    int updateByPrimaryKey(MemberBankcard record);

    int updateBindCard(@Param("memberId") Long memberId,@Param("cardId") Long cardId,@Param("bindType") Long bindType,@Param("bindTypeF") Long bindTypeF);
}