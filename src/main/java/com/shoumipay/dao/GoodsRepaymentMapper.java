package com.shoumipay.dao;

import com.shoumipay.domain.GoodsRepayment;
import com.shoumipay.domain.GoodsRepaymentExample;
import com.shoumipay.vo.PrepaymentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper @Component
public interface GoodsRepaymentMapper {
    long countByExample(GoodsRepaymentExample example);

    long countOverdue(@Param("orderId") Long orderId, @Param("days") Integer days);

    long countOverdue7(@Param("orderId") Long orderId);

    int deleteByExample(GoodsRepaymentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsRepayment record);

    int insertSelective(GoodsRepayment record);

    List<GoodsRepayment> selectByExample(GoodsRepaymentExample example);

    GoodsRepayment selectByPrimaryKey(Long id);

    GoodsRepayment selectUnRepayByOrderIdTimes(@Param("orderId") Long orderId, @Param("times") Integer times);

    List<PrepaymentVO> queryByPrepaymentVO(@Param("vo") PrepaymentVO vo);

    List<GoodsRepayment> selectByOrderId(Long orderId);

    List<GoodsRepayment> selectRepayByOrderIdTimes(@Param("orderId") Long orderId);

    List<GoodsRepayment> selectByOrderIdTimes(@Param("orderId") Long orderId, @Param("times") Integer times);

    int updateByExampleSelective(@Param("record") GoodsRepayment record, @Param("example") GoodsRepaymentExample example);

    int updateByExample(@Param("record") GoodsRepayment record, @Param("example") GoodsRepaymentExample example);

    int updateByPrimaryKeySelective(GoodsRepayment record);

    int updateByPrimaryKey(GoodsRepayment record);
}