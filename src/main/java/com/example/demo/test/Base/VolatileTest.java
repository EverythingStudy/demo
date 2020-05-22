package com.example.demo.test.Base;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * TODO 本例子中是多线程测试count++,保证同步相加。
 * TODO 方法有三种：1.使用Volatile修饰count，在add()加lock 2.使用同步关键字 3.使用AtomicInteger创建原子count
 * @Date 2020/5/20 10:54
 * @Author cly
 **/
public class VolatileTest {
    private static  AtomicInteger count = new AtomicInteger(0);
    private static int COUNT_THREAD = 20;
  //static Lock lock=new ReentrantLock();
    private static void add() {
        count.getAndIncrement();
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT_THREAD);
        for (int i = 0; i < COUNT_THREAD; i++) {
            Thread thread = new Thread(() -> {
                for (int e = 0; e < 10000; e++) {
                   // synchronized (VolatileTest.class) {
                        add();
                    //}
//                    lock.lock();
//
//                    lock.unlock();
                }
                countDownLatch.countDown();
            });
            thread.setPriority(1);
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
