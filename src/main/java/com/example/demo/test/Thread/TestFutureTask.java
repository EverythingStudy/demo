package com.example.demo.test.Thread;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Date 2019/9/26 15:46
 * @Author cly
 **/
public class TestFutureTask {
    public static void main(String[] args) {
        TestFutureTask testFutureTask=new TestFutureTask();
        testFutureTask.test();
    }
    public void test(){
        ExecutorService executorService=new ThreadPoolExecutor(2,10,0L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
        AtomicInteger k=new AtomicInteger(0);
        for(;;){
           Thread thread= new Thread(new Runnable() {
                @Override
                public void run() {
                    CallTest<String> callTest=new CallTest<>(k.get());
                    FutureTask<String> future= (FutureTask<String>) executorService.submit(callTest);
                    try {
                        System.out.println("获取get");
                        System.out.println(future.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }
            },"dd");
            thread.start();
            k.addAndGet(1);
            if(k.get()==10){
                executorService.isShutdown();
                break;
            }
        }

    }
   class CallTest<String> implements Callable<String>{
        private int s=0;
        CallTest(int k){
            this.s=k;
        }
       @Override
       public String call() throws Exception {
            Thread.sleep(1000);
           return (String) Integer.toString(s);
       }
   }
}
