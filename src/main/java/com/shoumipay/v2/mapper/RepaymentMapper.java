package com.shoumipay.v2.mapper;


import com.shoumipay.v2.domain.Repayment;
import com.shoumipay.v2.vo.RepaymentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepaymentMapper {
    int deleteByPrimaryKey(Long repaymentId);

    int insert(Repayment record);

    int insertSelective(Repayment record);

    Repayment selectByPrimaryKey(Long repaymentId);

    List<Repayment> selectByOrderLegId(Long selectByOrderLegId);

    List<Repayment> selectByTransId(String transId);

    List<Repayment> selectByOrderId(Long selectByOrderId);

    int updateByPrimaryKeySelective(Repayment record);

    int updateByPrimaryKey(Repayment record);

    List<Repayment> selectPendingRepayment();

    List<RepaymentVo> queryList(RepaymentVo repaymentVo);
}