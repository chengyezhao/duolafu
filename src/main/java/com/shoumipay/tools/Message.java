package com.shoumipay.tools;

import java.util.HashMap;

/**
 * Created by Tang on 2017/9/4.
 * 信息传递类，用于json传递信息
 */
public class Message extends HashMap<String, Object> {
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;

    //region 错误代码
    public static final int FLAG_PARAMETER_IS_INCORRECT = 100; //参数有误
    public static final int FLAG_PHONE_NUMBER_ALREADY_EXIST = 101; //手机号已注册，请直接登录。
    public static final int FLAG_IDENTIFYING_CODE_ALREADY_SEND = 102; //验证码已发送，请不要频繁请求。
    public static final int FLAG_IDENTIFYING_CODE_ERROR = 103; //验证码错误或已失效，请重新获取。
    public static final int FLAG_ERROR_LOGIN_INFO = 104; //手机号或密码错误，请核对重试。
    public static final int FLAG_PHONE_NUMBER_NOT_REGISTER = 105; //手机号未注册
    public static final int FLAG_PHONE_NUMBER_PASSWORD = 106; //旧密码不匹配，请核对重试。
    public static final int FLAG_TOKEN_ERROR = 107; //请重新登录
    public static final int FLAG_UPLOAD_ERROR = 108; //上传失败
    public static final int FLAG_VERSION_ERROR = 109; //获取版本信息失败
    public static final int FLAG_ID_CARD_NUMBER_ERROR = 110; //证件号码不匹配
    public static final int FLAG_NO_NUMBER_DETAIL = 111; //无详细身份信息
    public static final int FLAG_NO_MEMBER_AUTH = 112; //身份认证未完成
    public static final int FLAG_NO_MEMBER_THIRDVERIFY = 113; //手机号码与身份证不匹配
    public static final int MAKELOANS_CARD_ID_ERROR = 114; //放款银行卡id错误
    public static final int FLAG_ID_CARD_BANDED = 115; //身份证已经绑定
    public static final int FLAG_NO_APPLY = 116; //暂未开放申请
    public static final int FLAG_NO_MAKELOAN = 117; //暂未开放放款
    public static final int FLAG_MORE_APPLY_TIMES = 160; //申请次数超过当日上限
    public static final int FLAG_MORE_LOAN_TIMES = 161; //放款次数超过当日上限
    public static final int FLAG_MORE_LOAN_MONEY = 162; //放款金额超过当日上限
    //银行卡绑定信息
    public static final int CARD_INFO_ERROR = 120;//银行卡获取异常
    public static final int CARD_ALREADY_BIND = 121;//银行卡已绑定
    public static final int CARD_CURRENT_CANT_REMOVE = 122;//
    public static final int CARD_ON_LOAN_CANT_REMOVE = 123;//

    //支付错误
    public static final int ORDER_ID_ERROR = 130;//订单id错误
    public static final int FLAG_LOAN_AMOUNT_ERROR = 131;//确认金额错误
    public static final int FLAG_EXIST_LOANING_ORDER = 132;//存在正在结算的订单，请稍后再试。
    //标准错误
    public static final int ERROR_INVALID_CHAR = 140; //
    public static final int REPAYMENT_ORDER_NOT_VALID = 141; //
    public static final int GOODS_NOT_EXIST = 142; //
    //未知错误
    public static final int FLAG_NORMAL_ERROR = 199;//操作失败，请稍后重试。
    //endregion

    public Message() {
    }

    public Message(Integer flag) {
        if (null != flag) {
            put("flag", flag);
            String msg = null;
            switch (flag) {
                case FLAG_PARAMETER_IS_INCORRECT:
                    msg = "参数错误";
                    break;
                case FLAG_PHONE_NUMBER_ALREADY_EXIST:
                    msg = "手机号已注册，请使用对应账号登录。";
                    break;
                case FLAG_IDENTIFYING_CODE_ALREADY_SEND:
                    msg = "验证码已发送，请不要频繁请求。";
                    break;
                case FLAG_IDENTIFYING_CODE_ERROR:
                    msg = "验证码错误或已失效，请重新获取。";
                    break;
                case FLAG_ERROR_LOGIN_INFO:
                    msg = "手机号或密码错误，请核对重试。";
                    break;
                case FLAG_PHONE_NUMBER_NOT_REGISTER:
                    msg = "手机号未注册";
                    break;
                case FLAG_PHONE_NUMBER_PASSWORD:
                    msg = "旧密码不匹配，请核对重试。";
                    break;
                case FLAG_TOKEN_ERROR:
                    msg = "请重新登录";
                    break;
                case FLAG_UPLOAD_ERROR:
                    msg = "上传失败";
                    break;
                case FLAG_VERSION_ERROR:
                    msg = "获取版本信息失败";
                    break;
                case FLAG_ID_CARD_NUMBER_ERROR:
                    msg = "证件号码不匹配";
                    break;
                case FLAG_ID_CARD_BANDED:
                    msg = "身份证已经被其他用户绑定，请使用账号找回功能，或联系客服。";
                    break;
                case FLAG_NO_NUMBER_DETAIL:
                    msg = "无详细身份信息";
                    break;
                case FLAG_NO_MEMBER_AUTH:
                    msg = "身份认证未完成";
                    break;
                case FLAG_NO_MEMBER_THIRDVERIFY:
                    msg = "手机号码与身份证不匹配";
                    break;
                case CARD_INFO_ERROR:
                    msg = "银行卡获取异常";
                    break;//银行卡获取异常
                case CARD_ALREADY_BIND:
                    msg = "已经绑定的银行卡，请勿重复绑定";
                    break;
                case CARD_CURRENT_CANT_REMOVE:
                    msg = "当前卡不能删除";
                    break;
                case CARD_ON_LOAN_CANT_REMOVE:
                    msg = "借款订单未结清前，不能切换还款卡";
                    break;
                case ORDER_ID_ERROR:
                    msg = "订单id错误";
                    break;//订单id错误
                case FLAG_LOAN_AMOUNT_ERROR:
                    msg = "确认金额错误";
                    break;//确认金额错误
                case FLAG_EXIST_LOANING_ORDER:
                    msg = "存在正在结算的订单，请稍后再试。";
                    break;//存在正在结算的订单，请稍后再试。
                case FLAG_NORMAL_ERROR:
                    msg = "操作失败，请稍后重试。";
                    break;//操作失败，请稍后重试。
                case MAKELOANS_CARD_ID_ERROR:
                    msg = "放款银行卡id错误。";
                    break;//放款银行卡id错误。
                case ERROR_INVALID_CHAR:
                    msg = "提交内容中含有非法字符";
                    break;
                case REPAYMENT_ORDER_NOT_VALID:
                    msg = "借款订单异常，稍后重试";
                    break;
                case GOODS_NOT_EXIST:
                    msg = "借款类型异常";
                    break;
                case FLAG_NO_APPLY:
                    msg = "暂未开放申请";
                    break;
                case FLAG_NO_MAKELOAN:
                    msg = "暂未开放放款";
                    break;
                case FLAG_MORE_APPLY_TIMES:
                    msg = "申请次数超过当日上限";
                    break;
                case FLAG_MORE_LOAN_TIMES:
                    msg = "放款次数超过当日上限";
                    break;
                case FLAG_MORE_LOAN_MONEY:
                    msg = "放款金额超过当日上限";
                    break;
            }
            if (null != msg) put("msg", msg);
        }
    }

    public Message(Integer flag, Object msg) {
        if (null != flag) put("flag", flag);
        if (null != msg) put("msg", msg);
    }

    public static Message success() {
        return new Message(SUCCESS, "success");
    }

    public static Message success(Object message) {
        return new Message(SUCCESS, message);
    }

    public static Message fail() {
        return new Message(FAIL, "fail");
    }

    public static Message fail(Object message) {
        return new Message(FAIL, message);
    }

    /**
     * 增加额外信息
     *
     * @param key    键
     * @param object 值
     * @return 返回自身，可连续调用
     */
    public Message add(String key, Object object) {
        this.put(key, object);
        return this;
    }

    ///
    public boolean isSuccess() {
        return get("flag").toString().equals("1");
    }

    public String getMessage() {
        Object msg = get("msg");
        if (msg == null) {
            return "";
        }
        return msg.toString();
    }
}
