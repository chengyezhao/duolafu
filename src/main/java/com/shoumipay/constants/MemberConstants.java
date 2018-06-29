package com.shoumipay.constants;

/**
 * Created by Zhw on 2017/11/21.
 */
public interface MemberConstants {
    //member表
    int AUTHENTICATION_STATUS_VERIFIED = 2;//member 表字段AUTHENTICATION_STATUS 已认证状态
    int AUTHENTICATION_STATUS_UNVERIFIED = 0;//未认证 绑定手机后的状态
    //memberBankcard
    int CARD_STATE_NORMAL = 1;//字段Card_State正常状态
    int CARD_STATE_UNBIND = 2;//字段Card_State解绑状态
    int CARD_BIND_TYPE_ACCOUNT = 0;//字段card_bind_type到账卡 0
    int CARD_BIND_TYPE_DEFAULT = 2;//字段card_bind_type 默认值 2
}
