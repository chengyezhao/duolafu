package com.shoumipay.service.gxb;

/**
 * Created by Zhw on 2017/12/29.
 */
public interface GxbService {
    /**
     * 公信宝获取 token
     * @param authItem 爬取数据类型 jd->京东
     * */
    String getToken(String phone, String name, String idcard,String authItem,Long userId);

    /**
     * 公信宝 H5地址
     * @param returnUrl 成功跳转地址
     * */
    String getH5Url(String token,String returnUrl);
}
