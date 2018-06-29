package com.shoumipay.v2.mapper;


import com.shoumipay.v2.domain.DaifuOrderLeg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DaifuOrderLegMapper {
    int deleteByPrimaryKey(Long orderlegid);

    int insert(DaifuOrderLeg record);

    int insertSelective(DaifuOrderLeg record);

    DaifuOrderLeg selectByPrimaryKey(Long orderlegid);

    List<DaifuOrderLeg> selectByBillId(Long billId);

    List<DaifuOrderLeg> selectByOrderId(Long orderId);

    List<DaifuOrderLeg> selectByMemberId(Long memberId);

    int updateByPrimaryKeySelective(DaifuOrderLeg record);

    int updateByPrimaryKey(DaifuOrderLeg record);

    List<DaifuOrderLeg> queryList(DaifuOrderLeg daifuOrderLeg);
}