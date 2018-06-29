package com.shoumipay.service;




import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface ThirdVerifyService {
    /**
     *手机姓名身份证认证
     * @param name 姓名
     * @param cid 身份证号码
     * @param phone 手机号码
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单(memberid+当前时间)
     * @return
     */
    JSONObject phoneNameCidVerify(String name, String cid, String phone, Date sendTime, String channelOrderId);
    /** 实名认证
     * @param name 姓名
     * @param cid 身份证号码（身份证号码，必须，18位，最后一位是X需要大写。）
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单Id（用于区分渠道验证的唯一一笔交易）(memberid+当前时间)
     * @return
     */
    JSONObject nameVerify(String name, String cid,Date sendTime, String channelOrderId);
    /**
     *银行卡账户认证
     * @param name 姓名
     * @param cid 身份证号码
     * @param phone 手机号码
     * @param cardNo 银行卡号
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单(memberid+当前时间)
     * @return
     */
    JSONObject cardVerify(String name, String cid, String phone, String cardNo,Date sendTime,String channelOrderId);
    /**
     * 芝麻分授权
     * @param name 姓名
     * @param cid 身份证号码
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单(memberid+当前时间)
     * @return
     */
    JSONObject sesameVerify(String name, String cid,Date sendTime, String channelOrderId);
    /**
     * 芝麻分查询
     * @param openId  openid(授权后获得)
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单(memberid+当前时间)
     * @return
     */
    JSONObject querySesameVerify(String openId, Date sendTime, String channelOrderId);
}
