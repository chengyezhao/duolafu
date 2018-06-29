package com.shoumipay.vo.WeChat;

/**
 * Created by Zhw on 2018/1/19.
 */
public class Articles {
    private String Title;//图文消息标题
    private String Description;//图文消息描述
    private String PicUrl;//图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String Url;//	点击图文消息跳转链接

    public Articles(String title, String description, String picUrl, String url) {
        Title = title;
        Description = description;
        PicUrl = picUrl;
        Url = url;
    }

    public Articles() {

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

}
