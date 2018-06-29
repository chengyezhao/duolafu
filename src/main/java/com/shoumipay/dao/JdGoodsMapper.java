package com.shoumipay.dao;

import com.shoumipay.domain.JdGoods;
import com.shoumipay.domain.JdGoodsExample;
import com.shoumipay.vo.WeChat.JdOrdeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface JdGoodsMapper {
    long countByExample(JdGoodsExample example);

    int deleteByExample(JdGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JdGoods record);

    int insertSelective(JdGoods record);

    long insertJdGoodsList(@Param("list") List<JdGoods> jdGoods,@Param("memberId")long memberId,@Param("daifuId")long daifuId);

    List<JdGoods> selectByExample(JdGoodsExample example);
    List<JdOrdeVO> selectByMemberId(@Param("memberId")Long memberId);
    JdGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JdGoods record, @Param("example") JdGoodsExample example);

    int updateByExample(@Param("record") JdGoods record, @Param("example") JdGoodsExample example);

    int updateByPrimaryKeySelective(JdGoods record);

    int updateByPrimaryKey(JdGoods record);
}