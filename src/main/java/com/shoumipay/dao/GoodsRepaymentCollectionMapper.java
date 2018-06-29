package com.shoumipay.dao;

import com.shoumipay.domain.GoodsRepaymentCollection;
import com.shoumipay.domain.GoodsRepaymentCollectionExample;
import com.shoumipay.vo.GoodsRepaymentCollectionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface GoodsRepaymentCollectionMapper {
    long countByExample(GoodsRepaymentCollectionExample example);

    int deleteByExample(GoodsRepaymentCollectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsRepaymentCollection record);

    int insertSelective(GoodsRepaymentCollection record);

    List<GoodsRepaymentCollection> selectByExample(GoodsRepaymentCollectionExample example);

    GoodsRepaymentCollection selectByPrimaryKey(Long id);

    List<GoodsRepaymentCollection> selectByOrderId(Long orderId);

    List<GoodsRepaymentCollectionVO> selectShowList(@Param("vo") GoodsRepaymentCollectionVO vo);

    int updateByExampleSelective(@Param("record") GoodsRepaymentCollection record, @Param("example") GoodsRepaymentCollectionExample example);

    int updateByExample(@Param("record") GoodsRepaymentCollection record, @Param("example") GoodsRepaymentCollectionExample example);

    int updateByPrimaryKeySelective(GoodsRepaymentCollection record);

    int updateByPrimaryKey(GoodsRepaymentCollection record);
}