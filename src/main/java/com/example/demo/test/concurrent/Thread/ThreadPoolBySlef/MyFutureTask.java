package com.example.demo.test.concurrent.Thread.ThreadPoolBySlef;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description 返回值线程执行类
 * @Date 2020/4/3 12:27
 * @Author cly
 * @see com.example.demo DemoApplicationTest--测试类中的threadPoolBySelf方法
 * @see com.example.demo.test.Spring.service.impl.SwaggerpersonServiceImpl insert()
 **/
public class MyFutureTask<T> implements Runnable {
    BlockingQueue<Thread> blockingQueue=new ArrayBlockingQueue(50);
    T result;
    Callable callable;
    volatile boolean flag=false;
    public MyFutureTask(Callable callable){
        this.callable=callable;
    }

    @Override
    public void run() {
        Callable<T> c = callable;
        try {
            result=c.call();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            flag=true;
        }
        Thread thread= null;
        try {
            thread = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (thread!=null){
            System.out.println("线程名=="+thread.getName());
            LockSupport.unpark(thread);
            break;
        }

    }

    public T get() throws InterruptedException, ExecutionException {
        if(flag){
            return result;
        }
        while (!flag){
            //阻塞调用的主线程
            blockingQueue.offer(Thread.currentThread());
            System.out.println(Thread.currentThread().getName());
            LockSupport.park();
        }
        return result;
    }

}
