package com.shoumipay.vo.WeChat;

/**
 * Created by Zhw on 2017/12/28.
 */
public class TextMessage extends BaseWechatMessage {
    /**
     * 文本消息内容
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
