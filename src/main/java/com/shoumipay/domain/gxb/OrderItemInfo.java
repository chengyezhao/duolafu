package com.shoumipay.domain.gxb;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yaojun on 2017/9/27.
 */
public class OrderItemInfo implements Serializable {
    private static final long serialVersionUID = -2522157632184052671L;
    private String title;
    private BigDecimal number;
    private String imageUrl;
    private String itemUrl;
    private String otherSideAccount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getOtherSideAccount() {
        return otherSideAccount;
    }

    public void setOtherSideAccount(String otherSideAccount) {
        this.otherSideAccount = otherSideAccount;
    }
}
