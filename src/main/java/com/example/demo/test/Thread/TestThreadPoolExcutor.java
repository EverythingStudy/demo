package com.example.demo.test.Thread;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * @Description java自身线程池
 * @Date 2019/8/28 10:53
 * @Author cly
 **/
public class TestThreadPoolExcutor {
//默认结束策略
    ExecutorService threadPoolExecutor=new ThreadPoolExecutor(2,10,0L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
   public void test(){

      FutureTask<String> futureTask= (FutureTask<String>) threadPoolExecutor.submit(new Callable<String>(){
          @Override
          public String call() throws Exception {
              return null;
          }
      });
   }

   public void testNewFixedThreadPool(){
       ExecutorService executorService=Executors.newFixedThreadPool(6);
   }
}
