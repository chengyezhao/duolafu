package com.shoumipay.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.shoumipay.constants.GoodsOrderConstants;
import com.shoumipay.tools.CalculateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsOrder {
    private Long id;

    private String orderNumber;

    private Long memberId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")     @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date orderCreateTime;

    private Long goodsId;
    private Long daifuId;

    private String orderCode;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer orderTypes;

    private String orderAuditor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderUpptime;

    private String orderLevel;

    private BigDecimal orderVerifyAmount;

    private String orderChannel;

    private Long orderDiscount;

    private Long orderCardid;
    @NumberFormat(pattern = "#.##")
    private BigDecimal orderAmountRecognized;

    private String oidPaybill;
    private BigDecimal orderRepayment;

    private BigDecimal orderPenalty;


    private String orderFullname;

    private Date orderNextPayTime;

    private Date orderOverduePayTime;

    private Date orderBadPayTime;
    private String orderAuditFailMsg;
	private String orderAnnotate;

    private Integer orderIsShow;
	
	private Integer billsFlag;
    public GoodsOrder(){}
    public GoodsOrder(Long memberId,Goods goods,Long daifuId,BigDecimal amount,BigDecimal verify_amount,Long cardId){
        this.orderNumber= CalculateUtil.generateMixRandomCode(12);
        this.memberId=memberId;
        this.orderCreateTime=new Date();
        if(goods!=null) {
            this.goodsId = goods.getId();
            this.orderCode = goods.getId() + "0" + goods.getTimeLimit() + "0" + goods.getRepaymentType();
            this.orderChannel=GoodsOrderConstants.ORDER_CHANNEL_APP;
        }
        if(daifuId!=null){
            this.daifuId = daifuId;
            this.orderChannel=GoodsOrderConstants.ORDER_CHANNEL_WECHAT;
        }
        this.orderAmount=amount;
        this.orderStatus= GoodsOrderConstants.APPROVAL;
        this.orderTypes=GoodsOrderConstants.NORMAL_ORDER;
        this.orderAuditor=GoodsOrderConstants.SYSTEM_OPERATION;
        this.orderVerifyAmount=verify_amount;
        this.orderCardid=cardId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
}

    public Long getDaifuId() {
        return daifuId;
    }

    public void setDaifuId(Long daifuId) {
        this.daifuId = daifuId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(Integer orderTypes) {
        this.orderTypes = orderTypes;
    }

    public String getOrderAuditor() {
        return orderAuditor;
    }

    public void setOrderAuditor(String orderAuditor) {
        this.orderAuditor = orderAuditor == null ? null : orderAuditor.trim();
    }

    public Date getOrderUpptime() {
        return orderUpptime;
    }

    public void setOrderUpptime(Date orderUpptime) {
        this.orderUpptime = orderUpptime;
    }

    public String getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(String orderLevel) {
        this.orderLevel = orderLevel == null ? null : orderLevel.trim();
    }

    public BigDecimal getOrderVerifyAmount() {
        return orderVerifyAmount;
    }

    public void setOrderVerifyAmount(BigDecimal orderVerifyAmount) {
        this.orderVerifyAmount = orderVerifyAmount;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel == null ? null : orderChannel.trim();
    }

    public Long getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Long orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

 public Long getOrderCardid() {
        return orderCardid;
    }

    public void setOrderCardid(Long orderCardid) {
        this.orderCardid = orderCardid;
    }

    public BigDecimal getOrderAmountRecognized() {
        return orderAmountRecognized;
    }

    public void setOrderAmountRecognized(BigDecimal orderAmountRecognized) {
        this.orderAmountRecognized = orderAmountRecognized;
    }

    public String getOidPaybill() {
        return oidPaybill;
    }

    public void setOidPaybill(String oidPaybill) {
        this.oidPaybill = oidPaybill == null ? null : oidPaybill.trim();
    }
    public BigDecimal getOrderRepayment() {
        return orderRepayment;
    }

    public void setOrderRepayment(BigDecimal orderRepayment) {
        this.orderRepayment = orderRepayment;
    }

    public BigDecimal getOrderPenalty() {
        return orderPenalty;
    }

    public void setOrderPenalty(BigDecimal orderPenalty) {
        this.orderPenalty = orderPenalty;
    }

    public String getOrderFullname() {
        return orderFullname;
    }

    public void setOrderFullname(String orderFullname) {
        this.orderFullname = orderFullname == null ? null : orderFullname.trim();
    }

    public Date getOrderNextPayTime() {
        return orderNextPayTime;
    }

    public void setOrderNextPayTime(Date orderNextPayTime) {
        this.orderNextPayTime = orderNextPayTime;
    }

    public Date getOrderOverduePayTime() {
        return orderOverduePayTime;
    }

    public void setOrderOverduePayTime(Date orderOverduePayTime) {
        this.orderOverduePayTime = orderOverduePayTime;
    }

    public Date getOrderBadPayTime() {
        return orderBadPayTime;
    }

    public void setOrderBadPayTime(Date orderBadPayTime) {
        this.orderBadPayTime = orderBadPayTime;
    }
  public String getOrderAuditFailMsg() {
        return orderAuditFailMsg;
    }

    public void setOrderAuditFailMsg(String orderAuditFailMsg) {
        this.orderAuditFailMsg = orderAuditFailMsg == null ? null : orderAuditFailMsg.trim();
    }

    public String getOrderAnnotate() {
        return orderAnnotate;
    }

    public void setOrderAnnotate(String orderAnnotate) {
        this.orderAnnotate = orderAnnotate == null ? null : orderAnnotate.trim();
    }

    public Integer getOrderIsShow() {
        return orderIsShow;
    }

    public void setOrderIsShow(Integer orderIsShow) {
        this.orderIsShow = orderIsShow;
    }
	public Integer getBillsFlag() {
        return billsFlag;
    }

    public void setBillsFlag(Integer billsFlag) {
        this.billsFlag = billsFlag;
    }
    @Override
    public String toString() {
        return "GoodsOrder{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", memberId=" + memberId +
                ", orderCreateTime=" + orderCreateTime +
                ", goodsId=" + goodsId +
                ", orderCode='" + orderCode + '\'' +
                ", orderAmount=" + orderAmount +
                ", orderStatus=" + orderStatus +
                ", orderTypes=" + orderTypes +
                ", orderAuditor='" + orderAuditor + '\'' +
                ", orderUpptime=" + orderUpptime +
                ", orderLevel='" + orderLevel + '\'' +
                ", orderVerifyAmount=" + orderVerifyAmount +
                ", orderChannel='" + orderChannel + '\'' +
                ", orderDiscount=" + orderDiscount +
                ", orderRepayment=" + orderRepayment +
                ", orderPenalty=" + orderPenalty +
                ", orderCardid='" + orderCardid + '\'' +
                ", orderFullname='" + orderFullname + '\'' +
                ", orderNextPayTime=" + orderNextPayTime +
                ", orderOverduePayTime=" + orderOverduePayTime +
                ", orderBadPayTime=" + orderBadPayTime +
                '}';
    }
}