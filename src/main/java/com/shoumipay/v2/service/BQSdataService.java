package com.shoumipay.v2.service;

import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;

public interface BQSdataService {

    String login(Member member,String userName,String pwd,String reqId,String authCode);

    String getTaobao(Member member);

}
