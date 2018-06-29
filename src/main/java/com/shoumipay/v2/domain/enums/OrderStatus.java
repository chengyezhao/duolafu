package com.shoumipay.v2.domain.enums;

public enum OrderStatus {
    pending,    //通过审批，等待放款
    open,       //通过申请，正在还款
    paid,       //全部完成
    refunded,   //退款完成
    closed      //关闭，包括审批拒绝，放款失败等原因
}
