package com.example.demo.test.Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Date 2019/11/12 13:42
 * @Author cly
 **/
public class TestCountLatch {
    private volatile static AtomicInteger a=new AtomicInteger(0);
    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(6,() -> {
        System.out.println("裁判员发号施令啦！！！");
    });
    //用来表示裁判员需要维护的是6个运动员
    private static CountDownLatch endSignal = new CountDownLatch(6);
    private static CountDownLatch endSignal1 = new CountDownLatch(6);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            ThreadTask threadTask=new ThreadTask();
            service.execute(threadTask);
        }
        endSignal.await();
        endSignal1.await();
        if(a.get()==6){
            System.out.println("所有运动员到达终点，比赛结束！");
        }
        service.shutdown();
    }
    static class ThreadTask implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 运动员等待裁判员响哨！！！");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "正在全力冲刺");
                endSignal.countDown();
                System.out.println(Thread.currentThread().getName() + "  到达终点");
                a.getAndIncrement();
                endSignal1.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
