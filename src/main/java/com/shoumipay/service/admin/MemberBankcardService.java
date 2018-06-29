package com.shoumipay.service.admin;

import com.shoumipay.domain.MemberBankcard;

import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
public interface MemberBankcardService {
    /**
     * 根据MemberId来获取用户银行卡List信息集
     * @param memberId
     * */
    List<MemberBankcard> selectByMemberId(Long memberId);
    /**
     * 检测银行卡信息是否正确
     * */
    String checkBankcard(MemberBankcard memberBankcard);
    /**
     * 添加新的银行卡
     * */
    int addBankcard(MemberBankcard memberBankcard);

    /**
     * 清除绑定卡 设置还款卡或放款卡
     * */
    int bindBankCard(Long memberId,Long cardId,Long bindType);
    /**
     * 检查账户是否拥有到账卡 返回卡id
     * */
    Long checkMemberBankcard(Long memberId);
    int updateBankCard(MemberBankcard memberBankcard);

    List<MemberBankcard> queryBankcard(MemberBankcard memberBankcard);

    Boolean valid(Long memberId);

    MemberBankcard selectByPrimaryKey(Long id);

    MemberBankcard selectByMemberIdAndBindType(Long memberId,Long bindType);

    MemberBankcard selectWithhold(Long memberId);

    MemberBankcard selectByUidBankNumber(Long memberId,String bankcardNumber);

}

