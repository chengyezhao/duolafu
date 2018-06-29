package com.shoumipay.vo.WeChat;

import java.util.List;

/**
 * Created by Zhw on 2017/12/28.
 */
public class NewsMessage extends BaseWechatMessage {
    /**
     * 图文消息
     * <p>
     * <xml>
     * <ToUserName>< ![CDATA[toUser] ]></ToUserName>
     * <FromUserName>< ![CDATA[fromUser] ]></FromUserName>
     * <CreateTime>12345678</CreateTime>
     * <MsgType>< ![CDATA[news] ]></MsgType>
     * <ArticleCount>2</ArticleCount>
     * <Articles>
     * <item>
     * <Title>< ![CDATA[title1] ]></Title>
     * <Description>< ![CDATA[description1] ]></Description>
     * <PicUrl>< ![CDATA[picurl] ]></PicUrl>
     * <Url>< ![CDATA[url] ]></Url>
     * </item>
     * <item>
     * <Title>< ![CDATA[title] ]></Title>
     * <Description>< ![CDATA[description] ]></Description>
     * <PicUrl>< ![CDATA[picurl] ]></PicUrl>
     * <Url>< ![CDATA[url] ]></Url>
     * </item>
     * </Articles>
     * </xml>
     */
    private int ArticleCount; //	图文消息个数，限制为8条以内
    private List<Articles> Articles; //多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应


    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<com.shoumipay.vo.WeChat.Articles> getArticles() {
        return Articles;
    }

    public void setArticles(List<com.shoumipay.vo.WeChat.Articles> articles) {
        Articles = articles;
    }
}
