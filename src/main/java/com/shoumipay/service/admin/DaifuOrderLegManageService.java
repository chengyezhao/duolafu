package com.shoumipay.service.admin;

import com.shoumipay.v2.domain.DaifuOrder;
import com.shoumipay.v2.domain.DaifuOrderLeg;

import java.util.List;

public interface DaifuOrderLegManageService {

    List<DaifuOrderLeg> query(DaifuOrderLeg daifuOrderLeg, Integer page, Integer rows);

}
