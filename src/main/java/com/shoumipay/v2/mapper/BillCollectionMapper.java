package com.shoumipay.v2.mapper;


import com.shoumipay.v2.domain.BillCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BillCollectionMapper {

    //删除
    int deleteByPrimaryKey(Long billId);

    //增加全部字段
    int insert(BillCollection record);

    //增加部分字段
    int insertSelective(BillCollection record);

    BillCollection selectByPrimaryKey(Long billId);

    List<BillCollection> selectByMemberId(Long memberId);

    BillCollection selectByBillNumber(@Param("memberId") Long memberId, @Param("billNumber")  String billNumber);

    //更新部分字段
    int updateByPrimaryKeySelective(BillCollection record);

    //更新全部字段
    int updateByPrimaryKey(BillCollection record);

    List<BillCollection> queryList(BillCollection billCollection);
}