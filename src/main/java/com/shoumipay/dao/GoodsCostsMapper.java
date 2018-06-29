package com.shoumipay.dao;

import com.shoumipay.domain.GoodsCosts;
import com.shoumipay.domain.GoodsCostsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper @Component
public interface GoodsCostsMapper {
    long countByExample(GoodsCostsExample example);

    int deleteByExample(GoodsCostsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCosts record);

    int insertSelective(GoodsCosts record);

    List<GoodsCosts> selectByExample(GoodsCostsExample example);

    GoodsCosts selectByGoodsIdName(@Param("goodsId") Long goodsId, @Param("name") Integer name);

    GoodsCosts selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCosts record, @Param("example") GoodsCostsExample example);

    int updateByExample(@Param("record") GoodsCosts record, @Param("example") GoodsCostsExample example);

    int updateByPrimaryKeySelective(GoodsCosts record);

    int updateByPrimaryKey(GoodsCosts record);
}