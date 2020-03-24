package com.example.demo.test.Thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Description Executor框架中创建线程池，多个周期任务执行
 * @Date 2020/2/7 14:01
 * @Author cly
 **/
public class TestScheduledThreadPoolExecuor {
/**
 * @Author cly
 * @Description //TODO 测试ScheduledThreadPoolExecutor,定时任务线程池
 * @Date 14:27 2020/2/7
 * @Param []
 * @return void
 **/
    @Test
    public void test(){
        ScheduledThreadPoolExecutor executorService=new ScheduledThreadPoolExecutor(6);
        for(int i=0;i<8;i++){
            executorService.scheduleAtFixedRate(new Runnable(){
                @Override
                public void run() {
                    System.out.println("执行任务");
                }
            },100,10,TimeUnit.SECONDS);
        }
    }
}
