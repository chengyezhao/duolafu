package com.shoumipay.dao;

import com.shoumipay.domain.WeChatRepay;
import com.shoumipay.domain.WeChatRepayExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface WeChatRepayMapper {
    long countByExample(WeChatRepayExample example);

    int deleteByExample(WeChatRepayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeChatRepay record);

    int insertSelective(WeChatRepay record);

    List<WeChatRepay> selectByExample(WeChatRepayExample example);

    WeChatRepay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeChatRepay record, @Param("example") WeChatRepayExample example);

    int updateByExample(@Param("record") WeChatRepay record, @Param("example") WeChatRepayExample example);

    int updateByPrimaryKeySelective(WeChatRepay record);

    int updateByPrimaryKey(WeChatRepay record);
}