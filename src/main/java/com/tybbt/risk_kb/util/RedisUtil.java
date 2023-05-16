package com.tybbt.risk_kb.util;

import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    private static final Logger LOG = LoggerFactory.getLogger(RedisUtil.class);

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    public static RedisTemplate<Object, Object> redis;

    @PostConstruct
    public void getRedisTemplate() {
        redis = this.redisTemplate;
    }

    public boolean writeUser(String token, Object userInfo) {
        redisTemplate.opsForValue().set(token.toString(), JSONObject.toJSONString(userInfo), 3600*24, TimeUnit.SECONDS);
        Object object = redis.keys("*");
        LOG.info("GET Redis All keys: {}", object);
        return true;
    }

    public Object showAllRedis(){
        Object object = redisTemplate.keys("*");
        LOG.info("GET Redis All keys: {}", object);
        return object;
    }

    public boolean deleteToken(String token) {
        if (redisTemplate.hasKey(token)) {
            LOG.info("key已存在：{}", token);
            redisTemplate.delete(token);
            return true;
        } else {
            LOG.info("key不存在");
            return false;
        }
    }

    public boolean validateRepeat(String key, long second) {
        if (redisTemplate.hasKey(key)) {
            LOG.info("key已存在：{}", key);
            return false;
        } else {
            LOG.info("key不存在：{}", key);
            redisTemplate.opsForValue().set(key, key, second, TimeUnit.SECONDS);
            return true;
        }
    }

}
