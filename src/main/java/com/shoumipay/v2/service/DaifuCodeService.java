package com.shoumipay.v2.service;

import com.shoumipay.domain.Member;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.domain.enums.DaifuCodeType;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yuluo on 2018/3/25.
 */
public interface DaifuCodeService {

    DaifuCode selectById(long codeId);

    DaifuCode selectByDaifuId(String daifuId);

    List<DaifuCode> queryAll(String platform, String status);

    int update(DaifuCode code);

    DaifuCode create(DaifuCode code);

    //处理吱口令代付链接
    String checkDaifuRisk(DaifuCode code, Member member);

    //检测代付的类型
    DaifuCodeType verifySendedCode(String code, Member member);

}
