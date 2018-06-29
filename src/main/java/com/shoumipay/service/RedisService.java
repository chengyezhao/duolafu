package com.shoumipay.service;

/**
 * Created by Tang on 2017/10/20.
 */

public interface RedisService {
    void set(String key, Object value); //存储一个对象

    Object get(String key);  //获取一个对象

    void set(String key, Object value, long expire); //存储一个对象，设置存活时间

    Object get(String key, long expire); //获取一个对象，如果对象存在就延长存活多长时间

    void expire(String key, long expire); //设置指定对象的存活时间

    void delete(String key); //使指定对象死亡

}
