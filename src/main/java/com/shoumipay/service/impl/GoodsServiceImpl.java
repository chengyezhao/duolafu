package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.*;
import com.shoumipay.domain.*;
import com.shoumipay.service.admin.GoodsService;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.vo.GoodsRepaymentCollectionVO;
import com.shoumipay.vo.OrderVO;
import com.shoumipay.vo.PrepaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhw on 2017/10/24.
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsCostsMapper goodsCostsMapper;
    @Autowired
    private GoodsOrderMapper goodsOrderMapper;
    @Autowired
    private GoodsMakeLoansMapper goodsMakeLoansMapper;
    @Autowired
    private GoodsRepaymentMapper goodsRepaymentMapper;
    @Autowired
    private GoodsRepaymentPlanMapper goodsRepaymentPlanMapper;
    @Autowired
    private GoodsRepaymentCollectionMapper goodsRepaymentCollectionMapper;

    @Override
    public Long applyForLoanCreateOrder(Member member, Goods goods, BigDecimal amount, Long cardId) {
        return createOrder(member, goods, null, amount, cardId);
    }

    @Override
    public Long applyForLoanCreateOrder(Member member, JdDaiFu jdDaiFu, BigDecimal amount, Long cardId) {
        return createOrder(member, null, jdDaiFu.getId(), amount, cardId);
    }


    private Long createOrder(Member member, Goods goods, Long daifuId, BigDecimal amount, Long cardId) {
        BigDecimal verify_amount = verifyAmount(amount, daifuId);
        GoodsOrder goodsOrder = new GoodsOrder(member.getUid(), goods, daifuId, amount, verify_amount, cardId);
        int index = goodsOrderMapper.insertSelective(goodsOrder);
        if (index > 0) {
            return goodsOrder.getId();
        }
        return null;
    }

    @Override
    public BigDecimal verifyAmount(BigDecimal amount, Long goodsId) {
        BigDecimal cost = getGoodsIdCost(goodsId);//费用比例
        return amount.subtract(amount.multiply(cost));//扣除费用的借款
    }

    @Override
    public BigDecimal getGoodsIdCost(Long goodsId) {
        BigDecimal cost = new BigDecimal(0);//费用
        List<GoodsCosts> goodsCosts = getGoodsCostsByGoodsId(goodsId);
        for (GoodsCosts g : goodsCosts) {
            if (g.getCollectingMethods() == 0) {
                cost = cost.add(g.getCost());
            }
        }
        return cost;
    }

    @Override
    public Goods getGoodsById(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Goods> queryGoods(Goods goods, Integer page, Integer rows) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        proSearchParamForGoods(goods, criteria);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public List<GoodsCosts> getGoodsCostsByGoodsId(Long goodsId) {
        GoodsCostsExample example = new GoodsCostsExample();
        GoodsCostsExample.Criteria criteria = example.createCriteria();
        if (goodsId == null) {
            return null;
        }
        criteria.andGoodsidEqualTo(goodsId);
        return goodsCostsMapper.selectByExample(example);
    }
    @Override
    public List<GoodsOrder> queryOrder(GoodsOrder goodsOrder, Date date) {

        GoodsOrderExample example = new GoodsOrderExample();
        GoodsOrderExample.Criteria criteria = example.createCriteria();
        if (goodsOrder != null && null != goodsOrder.getOrderStatus()) {
            criteria.andOrderStatusEqualTo(goodsOrder.getOrderStatus());
            criteria.andOrderCreateTimeLessThanOrEqualTo(date);
        }
        example.setOrderByClause("id desc");
        proSearchParamForOrder(goodsOrder, criteria);
        example.setOrderByClause("order_create_time desc");
        return goodsOrderMapper.selectByExample(example);
    }
    @Override
    public List<GoodsOrder> queryOrder(GoodsOrder goodsOrder, Integer page, Integer rows) {
        if (page != null && rows != null && page > 0 && rows > 0) {
            PageHelper.startPage(page, rows);
        }
        GoodsOrderExample example = new GoodsOrderExample();
        GoodsOrderExample.Criteria criteria = example.createCriteria();
        if (goodsOrder != null && null != goodsOrder.getOrderStatus()) {
            criteria.andOrderStatusEqualTo(goodsOrder.getOrderStatus());
        }
        example.setOrderByClause("id desc");
        proSearchParamForOrder(goodsOrder, criteria);
        example.setOrderByClause("order_create_time desc");
        return goodsOrderMapper.selectByExample(example);
    }

    @Override
    public List<GoodsOrder> queryOrder(GoodsOrder goodsOrder, Date startTime, Date endTime) {
        GoodsOrderExample example = new GoodsOrderExample();
        GoodsOrderExample.Criteria criteria = example.createCriteria();
        if (goodsOrder != null && null != goodsOrder.getOrderStatus()) {
            criteria.andOrderStatusEqualTo(goodsOrder.getOrderStatus());
        }
        if (goodsOrder != null && null != goodsOrder.getBillsFlag()) {
            criteria.andBillsFlagEqualTo(goodsOrder.getBillsFlag());
        }
        example.setOrderByClause("id desc");
        proSearchParamForOrder(goodsOrder, criteria);
        if (startTime != null && endTime != null) {
            criteria.andOrderCreateTimeBetween(startTime, endTime);
        }
        example.setOrderByClause("order_create_time desc");
        return goodsOrderMapper.selectByExample(example);
    }

    @Override
    public GoodsOrder queryOrderByDaifuId(Long daifuId) {
        GoodsOrder goodsOrder = new GoodsOrder();
        goodsOrder.setDaifuId(daifuId);
        List<GoodsOrder> goodsOrders = queryOrder(goodsOrder, 0, 0);
        if (goodsOrders != null && goodsOrders.size() > 0) {
            return goodsOrders.get(0);
        }
        return null;
    }

    @Override
    public List<GoodsOrder> queryOrderByTime(Date startTime, Date endTime) {
        GoodsOrderExample example = new GoodsOrderExample();
        GoodsOrderExample.Criteria criteria = example.createCriteria();
        if (startTime != null && endTime != null) {
            criteria.andOrderCreateTimeBetween(startTime, endTime);
        }
        return goodsOrderMapper.selectByExample(example);
    }

    @Override
    public List<GoodsMakeLoans> queryMakeLoans(GoodsMakeLoans goodsMakeLoans, Integer page, Integer rows) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        GoodsMakeLoansExample example = new GoodsMakeLoansExample();
        GoodsMakeLoansExample.Criteria criteria = example.createCriteria();
        proSearchParamForMakeLoans(goodsMakeLoans, criteria);
        return goodsMakeLoansMapper.selectByExample(example);
    }

    @Override
    public List<GoodsMakeLoans> queryMakeLoansByOrderId(Long orderId) {
        return goodsMakeLoansMapper.selectByOrderId(orderId);
    }

    @Override
    public List<GoodsRepayment> queryRepaymentByOrderId(Long orderId) {
        return goodsRepaymentMapper.selectByOrderId(orderId);
    }

    @Override
    public List<GoodsRepaymentPlan> queryRepaymentPlanByOrderId(Long orderId) {
        return goodsRepaymentPlanMapper.selectByOrderId(orderId);
    }

    @Override
    public List<GoodsRepaymentCollection> queryControllerByOrderId(Long orderId) {
        return goodsRepaymentCollectionMapper.selectByOrderId(orderId);
    }

    @Override
    public List<GoodsRepaymentCollectionVO> queryControllerVO(GoodsRepaymentCollectionVO goodsRepaymentCollectionVO, Integer page, Integer rows) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        return goodsRepaymentCollectionMapper.selectShowList(goodsRepaymentCollectionVO);
    }

    @Override
    public int uppCollection(GoodsRepaymentCollection goodsRepaymentCollection) {
        return goodsRepaymentCollectionMapper.updateByPrimaryKeySelective(goodsRepaymentCollection);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }

    @Override
    public int uppGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public int addGoodsCost(GoodsCosts goodsCosts) {
        return goodsCostsMapper.insertSelective(goodsCosts);
    }

    @Override
    public int uppGoodsCost(GoodsCosts goodsCosts) {
        return goodsCostsMapper.updateByPrimaryKeySelective(goodsCosts);
    }

    @Override
    public List<OrderVO> queryByOrderVO(OrderVO vo, Integer page, Integer rows) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        return goodsOrderMapper.queryByOrderVO(vo);
    }

    @Override
    public List<PrepaymentVO> queryPrepaymentVO(PrepaymentVO prepaymentVO, Integer page, Integer rows) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        return goodsRepaymentMapper.queryByPrepaymentVO(prepaymentVO);
    }


    /**
     * 处理goods表
     */
    private void proSearchParamForGoods(Goods goods, GoodsExample.Criteria criteria) {
        if (goods != null) {
            if (goods.getId() != null) {
                criteria.andIdEqualTo(goods.getId());
            }
            if (goods.getName() != null && goods.getName().trim().length() > 0) {
                criteria.andNameLike("%" + goods.getName() + "%");
            }
            if (goods.getAlias() != null && goods.getAlias().trim().length() > 0) {
                criteria.andAliasLike("%" + goods.getAlias() + "%");
            }
        }
    }

    /**
     * 处理查询条件Order表
     */
    private void proSearchParamForOrder(GoodsOrder goodsOrder, GoodsOrderExample.Criteria criteria) {
        if (goodsOrder != null) {
            if (goodsOrder.getId() != null) {
                criteria.andIdEqualTo(goodsOrder.getId());
            }
            if (goodsOrder.getOrderNumber() != null && goodsOrder.getOrderNumber().trim().length() > 0) {
                criteria.andOrderNumberLike("%" + goodsOrder.getOrderNumber() + "%");
            }
            if (goodsOrder.getMemberId() != null) {
                criteria.andMemberIdEqualTo(goodsOrder.getMemberId());
            }
            if (goodsOrder.getOrderCardid() != null) {
                criteria.andOrderCardidEqualTo(goodsOrder.getOrderCardid());
            }
        }
    }

    /**
     * 处理查询条件MakeLoans表
     */
    private void proSearchParamForMakeLoans(GoodsMakeLoans goodsMakeLoans, GoodsMakeLoansExample.Criteria criteria) {
        if (goodsMakeLoans != null) {
            if (goodsMakeLoans.getId() != null) {
                criteria.andIdEqualTo(goodsMakeLoans.getId());
            }
        }
    }
}
