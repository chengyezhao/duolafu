package com.shoumipay.service.admin;

import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.v2.domain.DaifuOrder;

import java.util.List;

public interface DaifuOrderManageService {

    List<DaifuOrder> query(DaifuOrder daifuOrder, Integer page, Integer rows);

    int update(DaifuOrder daifuOrder);

}
