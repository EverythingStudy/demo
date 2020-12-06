package com.example.demo.test.redis.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.redis.jedis
 * @ClassName: RedisLock
 * @Description
 * @Date 2020/11/26 11:14
 * @Author cly
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisLock {
  @Test
  public void test(){
    for(int i=0;i<3;i++){
        String returnData=RedisUtil.lock("q","chen",10000L);
        System.out.println("加锁=="+returnData);
        if("Ok".equals(returnData)){
           //dosomething
           // 解锁
            RedisUtil.unLock("q","chen");
        }else{

        }
    }
  }
}
