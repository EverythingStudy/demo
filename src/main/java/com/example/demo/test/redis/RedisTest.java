package com.example.demo.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Date 2020/7/1 10:45
 * @Author cly
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private RedisService redisService;
    @Test
    public void hashSetTest(){
        Map<String,String> map=new HashMap<>();
        map.put("a879","1");
        map.put("2131","23");
        //redis中添加hash
        redisService.setHash("ccc",map);
        //多次获取hash
        Map hash=redisService.getHash("ccc");
        if (hash!=null){
            System.out.println(hash.toString());
        }
    }
    @Test
    public void hashUpTset(){
        Map<String,String> map=new HashMap<>();
        map.put("a879","2");
        redisService.putIfAbsent("ccc","test","2");
        Map hash=redisService.getHash("ccc");
        if (hash!=null){
            System.out.println(hash.toString());
        }
    }
    @Test
    public void putByKey(){
        redisService.set("clyt",6);
    }
    @Test
    public void keyTime(){
        redisService.setKeyTime("ccc",1L, TimeUnit.SECONDS);
    }

    @Test
    public void setKeyByString(){
        String uid= UUID.randomUUID().toString();
        boolean flag=redisService.tryLock("cly",uid,30,100L);
        logger.info("trylock={}",flag);
        //boolean release=redisService.releaseLock("cly",uid);
        //logger.info("releaseLock={}",release);
    }
@Test
    public void test(){
        redisService.decr("clyt",1L);
    }
}
