package com.shoumipay.constants;

/**
 * Created by Tang on 2017/10/23.
 */
public interface SMSConstants {
    int FLAG_REGISTER = 1;
    int FLAG_LOGIN = 2;
    int FLAG_FORGET_PASSWORD = 3;
    int FLAG_MODIFY_PASSWORD = 4;
    int FLAG_MODIFY_PHONE_NUMBER = 5;
    int FLAG_BING_BANKNUMBER = 6;

    int FLAG_MODIFY_PHONE_NUMBER_TWO = 7;


    //    String REGISTER_CODE = "欢迎注册玖易贷账号，您的验证码是：{code}。";
//    String LOGIN_CODE = "欢迎登录玖易贷账号，您的验证码是：{code}。";
//    String FORGET_PASSWORD_CODE = "欢迎使用玖易贷账号，忘记密码的验证码是：{code}。";
    String REGISTER_CODE = "【玖易贷】{code}(玖易平台注册验证码，验证码在5分钟内有效)，如非本人操作，请忽略该短信。";
    String LOGIN_CODE = "【玖易贷】{code}(玖易平台登录验证码，验证码在5分钟内有效)，如非本人操作，请忽略该短信。";
    String FORGET_PASSWORD_CODE = "【玖易贷】{code}(玖易平台忘记密码验证码，验证码在5分钟内有效)，如非本人操作，请忽略该短信。";
    String MODIFY_PASSWORD_CODE = "【玖易贷】{code}(玖易平台修改密码验证码，验证码在5分钟内有效)，如非本人操作，请忽略该短信。";
    String MODIFY_PHONE_NUMBER_CODE = "【玖易贷】{code}(玖易平台修改手机号验证码，验证码在5分钟内有效)，如非本人操作，请忽略该短信。";
}
