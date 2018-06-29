package com.shoumipay.service.admin;

import com.shoumipay.domain.*;
import com.shoumipay.v2.domain.DaifuCode;
import com.shoumipay.vo.GoodsRepaymentCollectionVO;
import com.shoumipay.vo.OrderVO;
import com.shoumipay.vo.PrepaymentVO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhw on 2017/10/24.
 */
public interface GoodsService {

    /**
     * 贷款申请生成订单
     *
     * @param member
     * @param amount
     * @param goods
     * @return
     */
    Long applyForLoanCreateOrder(Member member, Goods goods, BigDecimal amount, Long cardId);

    Long applyForLoanCreateOrder(Member member, JdDaiFu jdDaiFu, BigDecimal amount, Long cardId);

    /**
     * 根据产品和金额获取扣除费用后的金额
     */
    BigDecimal verifyAmount(BigDecimal amount, Long goodsId);

    /**
     * 根据产品获取扣除的管理费比例
     */
    BigDecimal getGoodsIdCost(Long goodsId);

    /**
     * 获取Goods
     *
     * @param id
     * @return
     */
    Goods getGoodsById(Long id);

    /**
     * 分页查询goods
     */
    List<Goods> queryGoods(Goods goods, Integer page, Integer rows);

    /**
     * 根据goodsId获取费用详情
     *
     * @param goodsId
     * @return
     */
    List<GoodsCosts> getGoodsCostsByGoodsId(Long goodsId);

    //查询订单
    List<GoodsOrder> queryOrder(GoodsOrder goodsOrder, Integer page, Integer rows);
     List<GoodsOrder> queryOrder(GoodsOrder goodsOrder, Date date) ;

    List<GoodsOrder> queryOrder(GoodsOrder goodsOrder, Date startTime, Date endTime);

    GoodsOrder queryOrderByDaifuId(Long daifuId);

    List<GoodsOrder> queryOrderByTime(Date startTime, Date endTime);


    //查询放款
    List<GoodsMakeLoans> queryMakeLoans(GoodsMakeLoans goodsMakeLoans, Integer page, Integer rows);

    List<GoodsMakeLoans> queryMakeLoansByOrderId(Long orderId);

    List<GoodsRepayment> queryRepaymentByOrderId(Long orderId);

    List<GoodsRepaymentPlan> queryRepaymentPlanByOrderId(Long orderId);

    List<GoodsRepaymentCollection> queryControllerByOrderId(Long orderId);

    List<GoodsRepaymentCollectionVO> queryControllerVO(GoodsRepaymentCollectionVO goodsRepaymentCollectionVO, Integer page, Integer rows);

    int uppCollection(GoodsRepaymentCollection goodsRepaymentCollection);

    int addGoods(Goods goods);

    int uppGoods(Goods goods);

    int addGoodsCost(GoodsCosts goodsCosts);

    int uppGoodsCost(GoodsCosts goodsCosts);

    /**
     * 查询订单记录
     */
    List<OrderVO> queryByOrderVO(OrderVO vo, Integer page, Integer rows);

    /**
     * 查看还款记录
     */
    List<PrepaymentVO> queryPrepaymentVO(PrepaymentVO prepaymentVO, Integer page, Integer rows);
}
