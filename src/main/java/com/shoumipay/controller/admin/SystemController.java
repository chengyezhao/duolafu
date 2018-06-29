package com.shoumipay.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shoumipay.domain.Banner;
import com.shoumipay.domain.Config;
import com.shoumipay.service.admin.BannerService;
import com.shoumipay.service.cache.SystemCacheService;
import com.shoumipay.tools.Message;
import com.shoumipay.vo.BannerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.shoumipay.service.cache.SystemCacheService.*;

/**
 * Created by Tang on 2017/11/8.
 */
@Controller
@RequestMapping("/system")
public class SystemController {
    private static List<String> configList = Arrays.asList(
            APPLY_ORDER,
            DO_LOAN,
            IDENTIFYING_CODE_TIME
    );
    private static List<String> loanConfigList = Arrays.asList(
            LOAN_TIMES_LIMIT,
            APPLY_TIMES_LIMIT,
            LOAN_MONEY_LIMIT
    );

    @Autowired
    private BannerService bannerService;

    @Autowired
    private SystemCacheService systemCacheService;

    @RequestMapping("/config")
    public String config(Model model) {
        for (String key : configList) {
            Config config = systemCacheService.get(key);
            model.addAttribute(key, config);
            System.out.println(config);
        }
        return "system/config";
    }

    @RequestMapping("/updateConfig")
    @ResponseBody
    public Message updateConfig(String key, String value, String desc) {
        return systemCacheService.update(new Config(key, value, desc));
    }

    @RequestMapping("/loan-config")
    public String loanConfig(Model model) {
        for (String key : loanConfigList) {
            Config config = systemCacheService.get(key);
            model.addAttribute(key, config);
            System.out.println(config);
        }
        return "system/loan-config";
    }

    @RequestMapping("/news")
    public String news() {
        return "system/news";
    }

    @RequestMapping("/news/list")
    @ResponseBody
    public Message newsList(Integer page, Integer rows) {
        if (null == page) page = 1;
        if (null == rows) rows = 10;
        PageHelper.startPage(page, rows);
        List<BannerVO> list = bannerService.selectWithNameByActive();
        PageInfo<BannerVO> info = new PageInfo<>(list);
        return Message.success().add("list", list)
                .add("pages", info.getPages())
                .add("total", info.getTotal());
    }

    @ResponseBody
    @RequestMapping(value = "/news/banner", method = RequestMethod.POST)
    public Message save(Banner banner) {
        if (null == banner.getId()) {
            banner.setCreateTime(new Date());
            bannerService.insert(banner);
        } else {
            bannerService.updateByPrimaryKeySelective(banner);
        }
        return Message.success();
    }

    @ResponseBody
    @RequestMapping(value = "/news/banner/delete", method = RequestMethod.POST)
    public Message save(Long bannerId) {
        Banner banner = bannerService.selectByPrimaryKey(bannerId);
        if (null != banner) {
            bannerService.deleteByPrimaryKey(bannerId);
        }
        return Message.success();
    }

}
