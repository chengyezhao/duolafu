package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.BankAccountMapper;
import com.shoumipay.domain.BankAccount;
import com.shoumipay.domain.BankAccountExample;
import com.shoumipay.service.admin.BankAccountService;
import com.shoumipay.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountMapper bankAccountMapper;
    @Override
    public List<BankAccount> selectAll() {
        BankAccountExample bankAccountExample = new BankAccountExample();
        return bankAccountMapper.selectByExample(bankAccountExample);
    }

    @Override
    public int insertBankAccount(BankAccount bankAccount) {
        return bankAccountMapper.insertSelective(bankAccount);
    }

    @Override
    public List<BankAccount> queryBankAccount(String type, Integer page, Integer rows, Date startTime, Date endTime) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        BankAccountExample example = new BankAccountExample();
        BankAccountExample.Criteria criteria = example.createCriteria();
            if (!StringUtil.isNull(type)){
                criteria.andTypeFlagEqualTo(Integer.parseInt(type));
            }
        if (startTime != null && endTime != null) {
            criteria.andTimeOfOrderCreatedBetween(startTime, endTime);
        }
        return bankAccountMapper.selectByExample(example);
    }
}
