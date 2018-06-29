package com.shoumipay.service.wechat;

import com.shoumipay.domain.JdDaiFu;
import com.shoumipay.domain.JdGoods;
import com.shoumipay.vo.WeChat.JdOrdeVO;

import java.util.List;

/**
 * Created by Zhw on 2018/1/9.
 */

public interface JdDaiFuService {
    /**
     * 根据Jd代付页面传递的payId
     *
     * @param payId
     */
    JdDaiFu queryJdDaiFuByPayId(String payId);
    JdDaiFu queryJdDaiFuById(long id);
    /**
     * 查询详细订单
     * */
    List<JdGoods> queryJdGoodsByDaiFuId(Long daifuId);
    /**
     * jd代付表新增
     * @param jdDaiFu
     * */
    long addJdDaiFu(JdDaiFu jdDaiFu);
    /**
     * jd 代付更新
     * */
    long uppJdDaiFu(JdDaiFu jdDaiFu);
    /**
     * jd代付商品信息
     * @param jdGoodsList
     * @param memberId  用户id
     * @param jdDaiFuId 代付表Id
     * */
    long addJdGoodsList(List<JdGoods> jdGoodsList,long memberId,long jdDaiFuId);
    /**
     * 查询订单信息
     * */
    List<JdOrdeVO> queryJdOrder(Long memberId);
}
