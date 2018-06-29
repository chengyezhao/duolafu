package com.shoumipay.service.admin;

import com.shoumipay.domain.AddressBook;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhw on 2017/11/2.
 */
public interface AddressBookService {
    Map<String, String> getAddressBookByMemberId(Long memberId);
    int addAddressBook(AddressBook addressBook);
    List<AddressBook> queryAddressBookByMemberId(Long memberId);
    AddressBook queryById(Long id);
}
