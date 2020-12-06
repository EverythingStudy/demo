package com.example.demo.test.redis.jedis;

import org.junit.Test;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.redis.jedis
 * @ClassName: JedisTest
 * @Description
 * @Date 2020/11/18 11:05
 * @Author cly
 **/
public class JedisTest {

    public static void main(String[] args) {
        RedisTool.tryGetDistributedLock("chen","123",100000);
    }
    @Test
    public void unLock(){
        RedisTool.tryGetDistributedUnLock("chen","123");
    }
}
