package com.shoumipay.service;

import com.shoumipay.domain.Registration;


public interface RegistrationService {

    int save(Registration registration);

    String selectByKey(String key);
}
