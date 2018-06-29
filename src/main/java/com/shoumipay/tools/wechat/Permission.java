package com.shoumipay.tools.wechat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Zhw on 2018/1/5.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Permission {
    /**
     * 是否需要登录，缺省为需要
     *
     * @return
     */
    boolean loginReqired() default true;

}