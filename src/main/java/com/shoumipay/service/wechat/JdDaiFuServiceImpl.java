package com.shoumipay.service.wechat;

import com.shoumipay.dao.JdDaiFuMapper;
import com.shoumipay.dao.JdGoodsMapper;
import com.shoumipay.domain.JdDaiFu;
import com.shoumipay.domain.JdDaiFuExample;
import com.shoumipay.domain.JdGoods;
import com.shoumipay.domain.JdGoodsExample;
import com.shoumipay.vo.WeChat.JdOrdeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhw on 2018/1/9.
 */
@Service
public class JdDaiFuServiceImpl implements JdDaiFuService {
    @Autowired
    private JdDaiFuMapper jdDaiFuMapper;
    @Autowired
    private JdGoodsMapper jdGoodsMapper;

    @Override
    public JdDaiFu queryJdDaiFuByPayId(String payId) {
        if(payId!=null) {
            JdDaiFu jdDaiFu = new JdDaiFu();
            jdDaiFu.setPayid(payId);
            JdDaiFuExample example = new JdDaiFuExample();
            JdDaiFuExample.Criteria criteria = example.createCriteria();
            criteria.andPayidEqualTo(payId);
            List<JdDaiFu> jdDaiFus = jdDaiFuMapper.selectByExample(example);
            if (jdDaiFus != null && jdDaiFus.size() > 0) {
                return jdDaiFus.get(0);
            }
        }
        return null;
    }

    @Override
    public JdDaiFu queryJdDaiFuById(long id) {
        return jdDaiFuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<JdGoods> queryJdGoodsByDaiFuId(Long daifuId) {
        JdGoodsExample example=new JdGoodsExample();
        JdGoodsExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(daifuId);
        return jdGoodsMapper.selectByExample(example);
    }


    @Override
    public long addJdDaiFu(JdDaiFu jdDaiFu) {
        return jdDaiFuMapper.insertSelective(jdDaiFu);
    }

    @Override
    public long uppJdDaiFu(JdDaiFu jdDaiFu) {
        return jdDaiFuMapper.updateByPrimaryKeySelective(jdDaiFu);
    }

    @Override
    public long addJdGoodsList(List<JdGoods> jdGoodsList, long memberId, long jdDaiFuId) {
        return jdGoodsMapper.insertJdGoodsList(jdGoodsList,memberId,jdDaiFuId);
    }

    @Override
    public List<JdOrdeVO> queryJdOrder(Long memberId) {
        return jdGoodsMapper.selectByMemberId(memberId);
    }
}
