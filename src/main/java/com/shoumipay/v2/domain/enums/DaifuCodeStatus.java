package com.shoumipay.v2.domain.enums;

public enum DaifuCodeStatus {
    init, //待处理
    parsed, //解析完成
    paid,   //支付完成
    closed, //解析错误
}
