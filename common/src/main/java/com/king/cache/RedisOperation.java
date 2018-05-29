package com.king.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author wangchangyong
 * @create 2018/05/24 14:39
 */
@Component
public class RedisOperation {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 值操作：如果key存在,将key对应的value+1,key不存在,则设置key,value=defaultValue
     * @param key
     * @param defaultValue 必须是正整数
     * @return
     */
    public Long incrementByValue(String key, long defaultValue){
        return redisTemplate.opsForValue().increment(key,defaultValue);
    }

    /**
     * 设置key的过期时间
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    public Boolean expire(String key, final long timeout, final TimeUnit timeUnit) {
        return redisTemplate.expire(key,timeout,timeUnit);
    }

    /**
     * 值操作：设置key,value
     * @param key
     * @param value
     * @param expireTime 过期时间
     * @param timeUnit
     */
    public void setValue(String key, Object value, long expireTime, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,expireTime,timeUnit);
    }

    /**
     * 值操作：获取key
     * @param key
     * @return
     */
    public Object getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 列表操作：获取size
     * @param key
     * @return
     */
    public Long getSize(String key){
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 列表操作：从列表左边压入key,value,作为简单队列
     * @param key
     * @param value
     * @return
     */
    public Long leftPushByList(String key, Object value){
        return redisTemplate.opsForList().leftPush(key,value);
    }

    /**
     * 列表操作：从列表右边弹出key,value,作为简单队列
     * @param key
     * @param blockTime 当列表没有数据的阻塞等待时间
     * @param timeUnit
     * @return
     */
    public Object rightPopByList(String key, long blockTime, TimeUnit timeUnit){
        return redisTemplate.opsForList().rightPop(key,blockTime,timeUnit);
    }

    /**
     * 根据key删除缓存
     * @param key
     */
    public void remove(String key){
        redisTemplate.delete(key);
    }

}
