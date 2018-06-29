package com.shoumipay.dao;

import com.shoumipay.domain.AddressBook;
import com.shoumipay.domain.AddressBookExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AddressBookMapper {
    long countByExample(AddressBookExample example);

    int deleteByExample(AddressBookExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AddressBook record);

    int insertSelective(AddressBook record);

    List<AddressBook> selectByExample(AddressBookExample example);

    AddressBook selectByPrimaryKey(Long id);

    List<AddressBook> selectByMemberId(Long memberId);

    int updateByExampleSelective(@Param("record") AddressBook record, @Param("example") AddressBookExample example);

    int updateByExample(@Param("record") AddressBook record, @Param("example") AddressBookExample example);

    int updateByPrimaryKeySelective(AddressBook record);

    int updateByPrimaryKey(AddressBook record);
}