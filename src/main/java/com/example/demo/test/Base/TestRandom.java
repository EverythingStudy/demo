package com.example.demo.test.Base;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * @Description Random函数
 * @Date 2020/3/1 17:06
 * @Author cly
 **/
public class TestRandom {
    Logger logger= LoggerFactory.getLogger(TestRandom.class);
    @Test
    public void  test(){
    Random random=new Random();
    logger.info(String.valueOf(random.nextInt(10)));
    }
}
