package com.example.demo.test.concurrent.Thread;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO java自身线程池，自定义拒绝策略
 * TODO 1.提交线程submit方式返回FutureTask对象可以取消线程。
 * TODO 2.定义Runnable线程可以使用1.8中的lambda表达式创建
 * @Date 2019/8/28 10:53
 * @Author cly
 **/
public class TestThreadPoolExecutor {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1), new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("自定义拒绝策略");
            throw new RejectedExecutionException("自定义拒绝策略");
        }
    });
    AtomicInteger integer=new AtomicInteger();
    @Test
    public void testCallable() {

        for (int i = 0; i < 7; i++) {
            FutureTask<String> futureTask = (FutureTask<String>) threadPoolExecutor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    if(!Thread.currentThread().isInterrupted()){
                         //待处理业务逻辑
                        System.out.println("待处理业务逻辑");
                        //Thread.sleep(1000);
                        //throw new Exception();
                    }
                    return "返回值"+integer.getAndIncrement();
                }
            });
            try {
                // futureTask.cancel(true);
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
   public void testRunnable(){
        for (int i = 0; i < 7; i++) {

            FutureTask<String> futureTask = (FutureTask<String>) threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    //待处理业务逻辑
                    System.out.println("待处理业务逻辑");
                    try {
                        Thread.sleep(1000*10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Thread.currentThread().isInterrupted();
                    //Thread.sleep(1000);
                    //throw new Exception();
                    //return "返回值"+integer.getAndIncrement();
                }
            });
            threadPoolExecutor.execute(()->{
                System.out.println("lambad表达式");
            });
            futureTask.cancel(true);
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * @return void
     * @Author cly
     * @Description //TODO 创建固定个数线程池
     * @Date 13:45 2020/2/7
     * @Param []
     **/
    @Test
    public void testNewFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("==");
            }
        });

    }

    public static void main(String[] args) {
        System.out.println(false&&true);
    }

}
