package com.shoumipay.service.admin;

import com.shoumipay.v2.domain.DaifuCode;

import java.util.List;

public interface DaifuCodeManageService {

    List<DaifuCode> query(DaifuCode daifuCode, Integer page, Integer rows);


    int update(DaifuCode daifuCode);

}
