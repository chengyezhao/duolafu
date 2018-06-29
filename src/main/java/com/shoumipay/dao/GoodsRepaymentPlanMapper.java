package com.shoumipay.dao;

import com.shoumipay.domain.GoodsRepaymentPlan;
import com.shoumipay.domain.GoodsRepaymentPlanExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper @Component
public interface GoodsRepaymentPlanMapper {
    long countByExample(GoodsRepaymentPlanExample example);

    long countUnRepay(Long memberId);

    int deleteByExample(GoodsRepaymentPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsRepaymentPlan record);

    int insertSelective(GoodsRepaymentPlan record);

    List<GoodsRepaymentPlan> selectByExample(GoodsRepaymentPlanExample example);

    List<GoodsRepaymentPlan> selectByMemberId(Long memberId);

    List<GoodsRepaymentPlan> selectUnRepayByOrderId(@Param("orderId") Long orderId);

    GoodsRepaymentPlan selectByPrimaryKey(Long id);

    GoodsRepaymentPlan selectByOrderIdTimes(@Param("orderId") Long orderId, @Param("times") Integer times);

    GoodsRepaymentPlan selectLatest(@Param("orderId") Long orderId);

    List<GoodsRepaymentPlan> selectByOrderId(Long orderId);

    List<GoodsRepaymentPlan> selectRepayTip(@Param("start") Date start, @Param("end") Date end);

    int updateByExampleSelective(@Param("record") GoodsRepaymentPlan record, @Param("example") GoodsRepaymentPlanExample example);

    int updateByExample(@Param("record") GoodsRepaymentPlan record, @Param("example") GoodsRepaymentPlanExample example);

    int updateByPrimaryKeySelective(GoodsRepaymentPlan record);

    int updateByPrimaryKey(GoodsRepaymentPlan record);
}