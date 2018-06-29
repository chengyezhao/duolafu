package com.shoumipay.service.admin;

import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.vo.RepaymentVo;

import java.util.List;

public interface RepaymentManageService {

    List<RepaymentVo> query(RepaymentVo repaymentVo, Integer page, Integer rows);

}
