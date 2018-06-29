package com.shoumipay.service.admin;


import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.Map;

/**
 * Created by Czy on 2017/10/20.
 */
public interface IdentityCheckService {
    //cid 身份证
    /* 学历信息核查 */
     Map<String,String> educationXmlMap(String name,Date sendTime, String cid, String degree,String channelOrderId);
    //自然人被执行人信息查询
     Map<String,String> personXmlMap(String name, String cid,Date sendTime,String channelOrderId);
    //自然人失信人信息查询
     Map<String,String> brokeXmlMap(String name, String cid,Date sendTime,String channelOrderId);
    /**
     *手机姓名身份证认证
     * @param name 姓名
     * @param cid 身份证号码
     * @param phone 手机号码
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单
     * @return
     */
     Map<String,String> phoneNameCidXmlMap(String name, String cid,String phone, Date sendTime, String channelOrderId);
    /** 实名认证
     * @param name 姓名
     * @param cid 身份证号码（身份证号码，必须，18位，最后一位是X需要大写。）
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单Id（用于区分渠道验证的唯一一笔交易）
     * @return
     */
     Map<String,String> nameXmlMap(String name, String cid,Date sendTime, String channelOrderId);
    /**
     *银行卡账户认证
     * @param name 姓名
     * @param cid 身份证号码
     * @param phone 手机号码
     * @param cardNo 银行卡号
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单
     * @return
     */
     Map<String,String> cardXmlMap(String name, String cid, String phone, String cardNo,Date sendTime,String channelOrderId);
    //芝麻分查询(linkedMerchantId 回调地址)
    /**
     * 芝麻分授权
     * @param name 姓名
     * @param cid 身份证号码
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单
     * @return
     */
     JSONObject sesameXmlMap(String name, String cid,Date sendTime, String channelOrderId);

    /**
     * 芝麻分查询
     * @param openId  openid(授权后获得)
     * @param sendTime 发送时间
     * @param channelOrderId 渠道订单
     * @return
     */
     JSONObject querySesameXmlMap(String openId, Date sendTime, String channelOrderId);
}
