package com.shoumipay.service.impl;

import com.shoumipay.dao.GoodsOrderMapper;
import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.GoodsOrderExample;
import com.shoumipay.domain.GoodsOrderExample.Criteria;
import com.shoumipay.service.admin.GoodsOrderService;
import com.shoumipay.tools.DateUtil;
import com.shoumipay.tools.UserUtil;
import com.shoumipay.vo.PreLoanOrderVO;
import com.shoumipay.vo.PreLoanVO;
import com.shoumipay.vo.RepaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by Tang on 2017/10/26.
 */
@Service
public class GoodsOrderServiceImpl implements GoodsOrderService {

    @Autowired
    private GoodsOrderMapper goodsOrderMapper;


    @Override
    public List<GoodsOrder> selectByExample(GoodsOrderExample example) {
        return goodsOrderMapper.selectByExample(example);
    }

    @Override
    public List<GoodsOrder> selectNormal() {
        return goodsOrderMapper.selectNormal();
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsOrder record) {
        return goodsOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public GoodsOrder selectByPrimaryKey(Long id) {
        return goodsOrderMapper.selectByPrimaryKey(id);
    }

    public GoodsOrder selectLatest(Long memberId) {
        return goodsOrderMapper.selectLatest(memberId);
    }

    @Override
    public GoodsOrder selectByOrderNumber(String orderNumber) {
        return goodsOrderMapper.selectByOrderNumber(orderNumber);
    }

    @Override
    public GoodsOrder getOrderById(Long orderId) {
        return goodsOrderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public GoodsOrder getOrderByIdAndMemberId(Long orderId, Long memberId) {
        GoodsOrderExample example=new GoodsOrderExample();
        Criteria criteria=example.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        criteria.andIdEqualTo(orderId);
        List<GoodsOrder> goodsOrders=goodsOrderMapper.selectByExample(example);
        if(goodsOrders!=null&&goodsOrders.size()>0){
            return goodsOrders.get(0);
        }
        return null;
    }

    @Override
    public List<RepaymentVO> queryRepayList(Long memberId, Date start, Date end) {
        return goodsOrderMapper.queryRepayList(memberId, start, end);
    }

    @Override
    public List<PreLoanOrderVO> queryByPreLoanVO(PreLoanVO vo) {
        return goodsOrderMapper.queryByPreLoanVO(vo);
    }

    @Override
    public List<PreLoanOrderVO> queryByPreLoanVOOverdue(PreLoanVO vo) {
        return goodsOrderMapper.queryByPreLoanVOOverdue(vo);
    }

    @Override
    public int countTimesByTime() {
        Date startTime = DateUtil.getStartTime();
        Date endTime = DateUtil.getEndTime();
        return goodsOrderMapper.countTimesByTime(startTime,endTime);
    }

    @Override
    public int updateOrderStatus(String[] ids,Integer status) {
        String loginUser="";
        if(status==2){
            loginUser=" 操作人:"+UserUtil.getLoginUserName();
        }
        return goodsOrderMapper.updateOrderByStatus(ids,status, loginUser);
    }

    @Override
    public List<GoodsOrder> selectByMemberid(Long memberId) {
        return goodsOrderMapper.selectByMemberid(memberId);
    }

}
