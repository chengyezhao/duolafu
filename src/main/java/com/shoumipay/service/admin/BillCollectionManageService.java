package com.shoumipay.service.admin;

import com.shoumipay.v2.domain.BillCollection;
import com.shoumipay.v2.domain.DaifuOrderLeg;

import java.util.List;

public interface BillCollectionManageService {

    List<BillCollection> query(BillCollection billCollection, Integer page, Integer rows);

}
