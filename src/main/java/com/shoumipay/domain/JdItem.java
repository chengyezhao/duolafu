package com.shoumipay.domain;

//price":"418.00","count":"1","wareName":"Palladium帕拉丁男鞋 帆布鞋Pampa Hi Cuff 黑色068 42",
// "imageUrl":"http://m.360buyimg.com/mobilecms/jfs/t6556/294/2502403424/201920/e103b261/59635539Na31d0ea5.jpg","skuId":"13831431894"
public class JdItem {
    private Double price;
    private Integer count;
    private String wareName;
    private String imageUrl;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
