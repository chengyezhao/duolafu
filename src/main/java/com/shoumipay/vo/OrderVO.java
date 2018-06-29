package com.shoumipay.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Zhw on 2017/11/22.
 */
public class OrderVO {
    private Long id;
    private Long memberId;
    private Long daifuId;
    private String username;
    private String orderNumber;
    private Date orderCreateTime;
    private BigDecimal orderAmount;
    private BigDecimal useAmount;
    private Long goodsId;
    private String orderCode;
    private Integer orderStatus;
    private Integer orderTypes;
    private String orderAuditor;
    private Date orderUpptime;
    private BigDecimal orderVerifyAmount;
    private String orderAuditFailMsg;
    private String orderAnnotate;
    private Integer orderIsShow;
    //筛选用
    private String maxAuditTime;
    private String minAuditTime;
    private String maxApplyForTime;
    private String minApplyForTime;
    private String maxAuditAmount;
    private String minAuditAmount;
    private String maxApplyForAmount;
    private String minApplyForAmount;

    public Long getDaifuId() {
        return daifuId;
    }

    public void setDaifuId(Long daifuId) {
        this.daifuId = daifuId;
    }

    public BigDecimal getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(BigDecimal useAmount) {
        this.useAmount = useAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderAuditor() {
        return orderAuditor;
    }

    public void setOrderAuditor(String orderAuditor) {
        this.orderAuditor = orderAuditor;
    }

    public Date getOrderUpptime() {
        return orderUpptime;
    }

    public void setOrderUpptime(Date orderUpptime) {
        this.orderUpptime = orderUpptime;
    }

    public BigDecimal getOrderVerifyAmount() {
        return orderVerifyAmount;
    }

    public void setOrderVerifyAmount(BigDecimal orderVerifyAmount) {
        this.orderVerifyAmount = orderVerifyAmount;
    }

    public String getOrderAuditFailMsg() {
        return orderAuditFailMsg;
    }

    public void setOrderAuditFailMsg(String orderAuditFailMsg) {
        this.orderAuditFailMsg = orderAuditFailMsg;
    }

    public String getOrderAnnotate() {
        return orderAnnotate;
    }

    public void setOrderAnnotate(String orderAnnotate) {
        this.orderAnnotate = orderAnnotate;
    }

    public Integer getOrderIsShow() {
        return orderIsShow;
    }

    public void setOrderIsShow(Integer orderIsShow) {
        this.orderIsShow = orderIsShow;
    }

    public String getMaxAuditTime() {
        return maxAuditTime;
    }

    public void setMaxAuditTime(String maxAuditTime) {
        this.maxAuditTime = maxAuditTime;
    }

    public String getMinAuditTime() {
        return minAuditTime;
    }

    public void setMinAuditTime(String minAuditTime) {
        this.minAuditTime = minAuditTime;
    }

    public String getMaxApplyForTime() {
        return maxApplyForTime;
    }

    public void setMaxApplyForTime(String maxApplyForTime) {
        this.maxApplyForTime = maxApplyForTime;
    }

    public String getMinApplyForTime() {
        return minApplyForTime;
    }

    public void setMinApplyForTime(String minApplyForTime) {
        this.minApplyForTime = minApplyForTime;
    }

    public String getMaxAuditAmount() {
        return maxAuditAmount;
    }

    public void setMaxAuditAmount(String maxAuditAmount) {
        this.maxAuditAmount = maxAuditAmount;
    }

    public String getMinAuditAmount() {
        return minAuditAmount;
    }

    public void setMinAuditAmount(String minAuditAmount) {
        this.minAuditAmount = minAuditAmount;
    }

    public String getMaxApplyForAmount() {
        return maxApplyForAmount;
    }

    public void setMaxApplyForAmount(String maxApplyForAmount) {
        this.maxApplyForAmount = maxApplyForAmount;
    }

    public String getMinApplyForAmount() {
        return minApplyForAmount;
    }

    public void setMinApplyForAmount(String minApplyForAmount) {
        this.minApplyForAmount = minApplyForAmount;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(Integer orderTypes) {
        this.orderTypes = orderTypes;
    }
}
