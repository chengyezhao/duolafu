package com.shoumipay.v2.mapper;


import com.shoumipay.v2.domain.DaifuOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DaifuOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    DaifuOrder selectOrderByCodeId(Long codeId);

    int insert(DaifuOrder record);

    int insertSelective(DaifuOrder record);

    DaifuOrder selectByPrimaryKey(Long orderId);

    List<DaifuOrder> selectByMemberId(Long memberId);

    int updateByPrimaryKeySelective(DaifuOrder record);

    int updateByPrimaryKey(DaifuOrder record);

    List<DaifuOrder> queryList(DaifuOrder daifuOrder);

    int update(DaifuOrder daifuOrder);
}