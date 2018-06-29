package com.shoumipay;

import com.shoumipay.domain.Member;
import com.shoumipay.domain.MemberDetail;
import com.shoumipay.v2.DocumentUtils;
import com.shoumipay.v2.domain.docs.RiskDocument;
import com.shoumipay.v2.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("chengye")
public class ReCalculateRiskDoc {

    @Autowired
    private MongoRepository repository;

    @Autowired
    private MemberService memberService;

    @Test
    public void insertRiskDocument(){
        for(Long ui = 1L; ui < 600; ui++) {
            Member member = memberService.getMemberByUid(ui);
            if(member != null ) {
                MemberDetail memberDetail = memberService.queryMemberDetailByMemberId(member.getUid());
                if(memberDetail != null) {
                    memberService.calculateQuota(member);
                }
            }
        }
    }

}
