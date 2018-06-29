package com.shoumipay.service.admin;

import com.shoumipay.domain.VerifyParameter;

import java.util.List;

public interface VerifyParameterService {
    int addVerifyParameter(VerifyParameter verifyParameter);
    int updateVerifyParameter(VerifyParameter verifyParameter);
    List<VerifyParameter> queryVerifyParameterList(VerifyParameter verifyParameter);
}
