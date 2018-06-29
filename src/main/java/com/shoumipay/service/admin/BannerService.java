package com.shoumipay.service.admin;

import com.shoumipay.domain.Banner;
import com.shoumipay.vo.BannerVO;

import java.util.List;

/**
 * Created by Tang on 2017/10/31.
 */
public interface BannerService {
    List<Banner> selectByActive(Integer active);
    List<BannerVO> selectWithNameByActive();
    int insert(Banner record);
    int updateByPrimaryKeySelective(Banner record);
    Banner selectByPrimaryKey(Long id);
    int deleteByPrimaryKey(Long id);

}
