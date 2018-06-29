package com.shoumipay.service.admin;

import com.shoumipay.domain.BankAccount;

import java.util.Date;
import java.util.List;

public interface BankAccountService {
    List<BankAccount> selectAll();
    int insertBankAccount(BankAccount bankAccount);
    List<BankAccount> queryBankAccount(String type, Integer page, Integer rows, Date startTime, Date endTime);

}
