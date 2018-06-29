package com.shoumipay.domain;

import java.math.BigDecimal;

public class GoodsCosts {
    private Long id;

    private Long goodsid;

    private Integer name;

    private Integer billingMethods;

    private BigDecimal cost;

    private Integer collectingMethods;

    private Integer settlementModel;

    private Integer b2bModel;

    private Integer p2pDirectModel;

    private Integer p2pIndirectModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getBillingMethods() {
        return billingMethods;
    }

    public void setBillingMethods(Integer billingMethods) {
        this.billingMethods = billingMethods;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getCollectingMethods() {
        return collectingMethods;
    }

    public void setCollectingMethods(Integer collectingMethods) {
        this.collectingMethods = collectingMethods;
    }

    public Integer getSettlementModel() {
        return settlementModel;
    }

    public void setSettlementModel(Integer settlementModel) {
        this.settlementModel = settlementModel;
    }

    public Integer getB2bModel() {
        return b2bModel;
    }

    public void setB2bModel(Integer b2bModel) {
        this.b2bModel = b2bModel;
    }

    public Integer getP2pDirectModel() {
        return p2pDirectModel;
    }

    public void setP2pDirectModel(Integer p2pDirectModel) {
        this.p2pDirectModel = p2pDirectModel;
    }

    public Integer getP2pIndirectModel() {
        return p2pIndirectModel;
    }

    public void setP2pIndirectModel(Integer p2pIndirectModel) {
        this.p2pIndirectModel = p2pIndirectModel;
    }
}