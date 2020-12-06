package com.example.demo.test.redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.redis.jedis
 * @ClassName: RedisTool
 * @Description //TODO
 * @Date 2020/11/18 10:21
 * @Author cly
 **/
public class RedisTool {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private static final Long RELEASE_SUCCESS = 1L;
    /**
     * @Author cly
     * @method
     * @Description //TODO 分布式锁-加锁
     * @Date 10:40 2020/11/18
     * @Param
     * @return
     **/
    public static boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime){
        String result=RedisUtil.getJedis().set(lockKey,requestId,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,expireTime);
        //RedisUtil.getJedis().
        System.out.println(result);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
    /**
     * @Author cly
     * @method
     * @Description //TODO 分布式锁-解锁
     * @Date 10:42 2020/11/18
     * @Param
     * @return
     **/
    public static boolean tryGetDistributedUnLock(String lockKey, String requestId){
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = RedisUtil.getJedis().eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
