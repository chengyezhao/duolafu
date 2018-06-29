package com.shoumipay.service.admin;

import com.shoumipay.domain.Contract;

import java.util.List;
import java.util.Map;

public interface ContractService {
    int insertContract(Contract contract);
    List<Contract> queryByIdTime(String id,Map<String,String> param);
    Contract queryById(Long id);
}
