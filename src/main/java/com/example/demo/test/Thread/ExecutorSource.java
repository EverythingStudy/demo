package com.example.demo.test.Thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @Description 线程池源码分析
 * @Date 2020/3/6 9:14
 * @Author cly
 **/
public class ExecutorSource {
Logger logger= LoggerFactory.getLogger(this.getClass());
    @Test
    public void threadPoolExecutorSubmit(){
        ExecutorService executorService=new ThreadPoolExecutor(1,4,5L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
        executorService.submit(new Runnable(){
            @Override
            public void run() {
                logger.info("Runnable线程");
            }
        });

//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Runnable线程");
//            }
//        });
    }
/**
 * @Author cly
 * @Description //TODO //取消线程 true为中断，设置中断标志位。false为不中断，取消后线程get会出现异常
 * @Date 12:44 2020/3/6
 * @Param []
 * @return void
 **/
    @Test
    public void threadPoolExecutorCancel(){
        ExecutorService executorService=new ThreadPoolExecutor(1,4,5L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
        InnerCallThread innerCallThread=new InnerCallThread();
        Future future= executorService.submit(innerCallThread);
        future.cancel(true);

    }
    /**
     * @Author cly
     * @Description //TODO get获取线程结果，会阻塞当前主线程。get中死循环去获取执行结果
     * @Date 12:46 2020/3/6
     * @Param []
     * @return void
     **/
    @Test
    public void threadPoolExecutorGet(){
        ExecutorService executorService=new ThreadPoolExecutor(1,4,5L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
        InnerCallThread innerCallThread=new InnerCallThread();
        Future<String> future= executorService.submit(innerCallThread);
        try {
            //会阻塞当前线程
            String result=future.get();
            System.out.println("获取了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Author cly
     * @Description //TODO 停止线程的主要逻辑都是将workers队列中的线程interrupt,不再接收新的线程任务
     * //TODO 只不过shutdown()--interruptIdleWorkers()判断一下线程是否中断;shutdownNnow()--interruptWorkers()不判断中断 直接stop
     * @Date 12:59 2020/3/6
     * @Param []
     * @return void
     **/
    @Test
    public void threadPoolExecutorShutDown(){
        ExecutorService executorService=new ThreadPoolExecutor(1,4,5L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
        InnerCallThread innerCallThread=new InnerCallThread();
        Future<String> future= executorService.submit(innerCallThread);
        executorService.shutdown();
        executorService.shutdownNow();
    }
class InnerThread implements Runnable{
    @Override
    public void run() {
        logger.info("Runnable线程");
    }
}
class InnerCallThread implements Callable{

    @Override
    public Object call() throws Exception {
        logger.info("Callable线程");
        Thread.sleep(10000);
        return "Callable线程";
    }
}
}
