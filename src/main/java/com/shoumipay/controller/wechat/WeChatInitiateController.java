package com.shoumipay.controller.wechat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shoumipay.constants.WeChatConstants;
import com.shoumipay.service.wechat.AccessTokenService;
import com.shoumipay.tools.MessageUtil;
import com.shoumipay.tools.wechat.HttpRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Zhw on 2017/12/28.
 */
@Controller
@RequestMapping("wxInitiate")
public class WeChatInitiateController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
    public static final String MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
    public static final String CREATE_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
    @Autowired
    private AccessTokenService accessTokenService;
    @Value("${domain.name}")
    private String domainName;

    @RequestMapping("getMaterial")
    @ResponseBody
    public String getMaterial() {
        JSONObject json = new JSONObject();
        json.put("type", "news");
        json.put("offset", "0");
        json.put("count", "20");
        String access_token = accessTokenService.getAccessToken();
        String result = HttpRequestUtils.sendPost(MATERIAL + access_token, json.toString(), true);
        return result;
    }

    @RequestMapping("createMaterial")
    @ResponseBody
    public String createMaterial() {
        JSONObject json = new JSONObject();
        json.put("media_id", "MlXoFbkL31jNw-r6p7R4MlBW8cFE6u_UCLejIZJsxCw");
        String access_token = accessTokenService.getAccessToken();
        String result = HttpRequestUtils.sendPost(CREATE_MATERIAL + access_token, json.toString(), true);
        return result;
    }

    /**
     * 微信公众号菜单创建
     */
    @RequestMapping("")
    public void createMenu(HttpServletResponse response) {
        String access_token = accessTokenService.getAccessToken();
        JSONObject firstJsonObject = new JSONObject();
        JSONArray arrayButton = new JSONArray();
        arrayButton.add(getJsonUrl("view", "发起代付", domainName + "/wx/home?url=index.html"));
        arrayButton.add(getJsonUrl("view", "个人账户", domainName + "/wx/home?url=ucenter.html"));
        arrayButton.add(getJsonClick("如何使用", WeChatConstants.APPLICATION_METHOD_KEY));
        firstJsonObject.put("button", arrayButton);
        String result = HttpRequestUtils.sendPost(CREATE_MENU + access_token, firstJsonObject.toString(), true);
        logger.info(result);
        MessageUtil.successMessageFlag(result, response);
    }

    private JSONObject getJsonUrl(String type, String name, String url) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", type);
        jsonObject.put("name", name);
        jsonObject.put("url", url);
        return jsonObject;
    }

    private JSONObject getJsonClick(String name, String key) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "click");
        jsonObject.put("name", name);
        jsonObject.put("key", key);
        return jsonObject;
    }
}
