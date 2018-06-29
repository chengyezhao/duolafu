package com.shoumipay.service.impl;

import com.shoumipay.v2.mapper.RegistrationMapper;
import com.shoumipay.domain.Registration;
import com.shoumipay.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public int save(Registration registration) {
        return registrationMapper.save(registration);
    }

    @Override
    public String selectByKey(String key) {
        return registrationMapper.selectByKey(key);
    }
}
