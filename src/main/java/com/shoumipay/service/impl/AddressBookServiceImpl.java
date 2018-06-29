package com.shoumipay.service.impl;

import com.shoumipay.dao.AddressBookMapper;
import com.shoumipay.domain.AddressBook;
import com.shoumipay.service.admin.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Zhw on 2017/11/2.
 */
@Service
public class AddressBookServiceImpl implements AddressBookService {
    @Autowired
    private AddressBookMapper addressBookMapper;
    @Override
    public Map<String, String> getAddressBookByMemberId(Long memberId) {
        List<AddressBook> addressBookList=addressBookMapper.selectByMemberId(memberId);
        Map<String,String> map=new LinkedHashMap<>();
        for (AddressBook a:addressBookList){
            map.put(a.getNumber(),a.getName());
        }
        return map;
    }

    @Override
    public int addAddressBook(AddressBook addressBook) {
        addressBook.setUpptime(new Date());
        return addressBookMapper.insertSelective(addressBook);
    }

    @Override
    public List<AddressBook> queryAddressBookByMemberId(Long memberId) {
        return addressBookMapper.selectByMemberId(memberId);
    }

    @Override
    public AddressBook queryById(Long id) {
        return addressBookMapper.selectByPrimaryKey(id);
    }
}
