package com.shoumipay.dao;

import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.GoodsOrderExample;
import com.shoumipay.vo.OrderVO;
import com.shoumipay.vo.PreLoanOrderVO;
import com.shoumipay.vo.PreLoanVO;
import com.shoumipay.vo.RepaymentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface GoodsOrderMapper {
    long countByExample(GoodsOrderExample example);

    int deleteByExample(GoodsOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsOrder record);

    int insertSelective(GoodsOrder record);

    List<GoodsOrder> selectByExample(GoodsOrderExample example);

    List<GoodsOrder> selectNormal();

    List<PreLoanOrderVO> queryByPreLoanVO(@Param("vo") PreLoanVO vo);

    List<PreLoanOrderVO> queryByPreLoanVOOverdue(@Param("vo") PreLoanVO vo);

    List<OrderVO> queryByOrderVO(@Param("vo") OrderVO vo);

    GoodsOrder selectByPrimaryKey(Long id);

    GoodsOrder selectLatest(@Param("memberId") Long memberId);

    GoodsOrder selectByOrderNumber(@Param("orderNumber") String orderNumber);

    int updateByExampleSelective(@Param("record") GoodsOrder record, @Param("example") GoodsOrderExample example);

    int updateByExample(@Param("record") GoodsOrder record, @Param("example") GoodsOrderExample example);

    int updateByPrimaryKeySelective(GoodsOrder record);

    int updateByPrimaryKey(GoodsOrder record);

    int updateOrderByStatus(@Param("ids") String[] ids,@Param("status") Integer status ,@Param("loginUser")String loginUser);

    List<RepaymentVO> queryRepayList(@Param("memberId") Long memberId, @Param("start") Date start, @Param("end") Date end);

    List<GoodsOrder> selectByMemberid(@Param("memberId") Long memberId);

    int countTimesByTime(@Param("startTime") Date startTime,@Param("endTime") Date endTime);


}