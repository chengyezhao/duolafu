package com.shoumipay.service.impl;

import com.shoumipay.constants.MemberConstants;
import com.shoumipay.dao.MemberBankcardMapper;
import com.shoumipay.dao.MemberMapper;
import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberBankcard;
import com.shoumipay.domain.MemberBankcardExample;
import com.shoumipay.domain.MemberBankcardExample.Criteria;
import com.shoumipay.service.admin.MemberBankcardService;
import com.shoumipay.tools.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
@Service
public class MemberBankcardServiceImpl implements MemberBankcardService {
    @Autowired
    private MemberBankcardMapper memberBankcardMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public List<MemberBankcard> selectByMemberId(Long memberId) {
        return memberBankcardMapper.selectByMemberId(memberId);
    }


    @Override
    public String checkBankcard(MemberBankcard memberBankcard) {
        if (memberBankcard == null) {
            return "银行卡获取异常";
        }
        if (!ValidatorUtil.isNumeric(memberBankcard.getBankcardNumber()) ||
                memberBankcard.getBankcardNumber().trim().length() < 13 ||
                memberBankcard.getBankcardNumber().trim().length() > 19) {
            return "银行卡卡号有误";
        }
        if (!ValidatorUtil.isMobile(memberBankcard.getPhonenumber())) {
            //手机号错误
            return "银行预留手机号有误";
        }
        return null;
    }

    @Override
    public int addBankcard(MemberBankcard memberBankcard) {
        Member member=memberMapper.selectByPrimaryKey(memberBankcard.getMemberid());
        member.setAuthenticationStatus(MemberConstants.AUTHENTICATION_STATUS_VERIFIED);//更改用户状态为已认证
        memberMapper.updateByPrimaryKey(member);
        return memberBankcardMapper.insertSelective(memberBankcard);
    }

    @Override
    public int bindBankCard(Long memberId, Long cardId, Long bindType) {
        return memberBankcardMapper.updateBindCard(memberId, cardId, bindType, bindType == 1 ? 0L : 1L);
    }

    @Override
    public Long checkMemberBankcard(Long memberId) {
        MemberBankcard memberBankcard = new MemberBankcard();
        memberBankcard.setMemberid(memberId);
        memberBankcard.setCardBindType(MemberConstants.CARD_BIND_TYPE_ACCOUNT);//绑定类型为到账卡
        List<MemberBankcard> memberBankcardList = queryBankcard(memberBankcard);
        if (memberBankcardList == null || memberBankcardList.size() <= 0) {
            return null;
        }
        return memberBankcardList.get(0).getCardid();
    }

    @Override
    public int updateBankCard(MemberBankcard memberBankcard) {
        return memberBankcardMapper.updateByPrimaryKeySelective(memberBankcard);
    }

    @Override
    public List<MemberBankcard> queryBankcard(MemberBankcard memberBankcard) {
        MemberBankcardExample example = new MemberBankcardExample();
        Criteria criteria = example.createCriteria();
        proSearchParam(memberBankcard, criteria);
        return memberBankcardMapper.selectByExample(example);
    }

    @Override
    public Boolean valid(Long memberId) {
        List<MemberBankcard> list = memberBankcardMapper.selectByMemberId(memberId);
        for (MemberBankcard mb : list) {
            if (mb.getCardType() != null && 0 == mb.getCardType()) return true;
        }
        return false;
    }

    @Override
    public MemberBankcard selectByPrimaryKey(Long id) {
        return memberBankcardMapper.selectByPrimaryKey(id);
    }


    @Override
    public MemberBankcard selectByMemberIdAndBindType(Long memberId, Long bindType) {
        return memberBankcardMapper.selectByIdAndBindType(memberId, bindType);
    }

    @Override
    public MemberBankcard selectWithhold(Long memberId) {
        return memberBankcardMapper.selectWithhold(memberId);
    }

    @Override
    public MemberBankcard selectByUidBankNumber(Long memberId, String bankcardNumber) {
        return memberBankcardMapper.selectByUidBankNumber(memberId,bankcardNumber);
    }

    /**
     * 处理查询条件
     */
    private void proSearchParam(MemberBankcard memberBankcard, Criteria criteria) {
        if (memberBankcard != null) {
            if (memberBankcard.getCardid() != null) {
                criteria.andCardidEqualTo(memberBankcard.getCardid());
            }
            if (memberBankcard.getMemberid() != null) {
                criteria.andMemberidEqualTo(memberBankcard.getMemberid());
            }
            if (memberBankcard.getCardType() != null) {
                criteria.andCardTypeEqualTo(memberBankcard.getCardType());
            }
            if (memberBankcard.getCardState() != null){
                criteria.andCardStateEqualTo(memberBankcard.getCardState());
            }
            if(memberBankcard.getCardBindType()!= null){
                criteria.andCardBindTypeEqualTo(memberBankcard.getCardBindType());
            }
            if (null != memberBankcard.getBankcardNumber()) {
                criteria.andBankcardNumberEqualTo(memberBankcard.getBankcardNumber());
            }
            if (null != memberBankcard.getPhonenumber()) {
                criteria.andPhonenumberEqualTo(memberBankcard.getPhonenumber());
            }
        }
    }
}
