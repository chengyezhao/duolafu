package com.shoumipay.service.impl;

import com.shoumipay.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tang on 2017/10/20.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void set(String key, Object value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }

    @Override
    public Object get(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    @Override
    public void set(String key, Object value, long expire) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value, expire, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key, long expire) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        Object value = vo.get(key);
        if (null != value) vo.set(key, value, expire, TimeUnit.SECONDS);
        return value;
    }

    @Override
    public void expire(String key, long expire) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        Object value = vo.get(key);
        if (null != value) vo.set(key, value, expire, TimeUnit.SECONDS);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
