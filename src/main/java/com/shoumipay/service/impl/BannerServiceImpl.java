package com.shoumipay.service.impl;

import com.shoumipay.dao.BannerMapper;
import com.shoumipay.domain.Banner;
import com.shoumipay.service.admin.BannerService;
import com.shoumipay.vo.BannerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tang on 2017/10/31.
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> selectByActive(Integer active) {
        return bannerMapper.selectByActive(active);
    }

    @Override
    public List<BannerVO> selectWithNameByActive() {
        return bannerMapper.selectWithNameByActive();
    }

    @Override
    public int insert(Banner record) {
        return bannerMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Banner selectByPrimaryKey(Long id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }
}
