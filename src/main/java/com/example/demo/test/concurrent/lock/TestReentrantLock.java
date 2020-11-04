package com.example.demo.test.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.concurrent.lock
 * @ClassName: Test
 * @Description //TODO 死锁测试
 * @Date 2020/11/3 16:41
 * @Author cly
 **/
public class TestReentrantLock {
    static Lock lock=new ReentrantLock();
    static Lock getLock=new ReentrantLock();
    public static void lock1(){
        lock.lock();
        try {
            System.out.println("lock1");
            Thread.sleep(10000);
            lock2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void lock2(){
        getLock.lock();
        try {
            System.out.println("lock2");
            Thread.sleep(10000);
            lock1();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            getLock.unlock();
        }
    }
     static class ThreadLock1 implements Runnable{

        @Override
        public void run() {
            lock1();
        }
    }
     static class ThreadLock2 implements Runnable{

        @Override
        public void run() {
            lock2();
        }
    }

    public static void main(String[] args) {
        Thread thread1=new Thread(new ThreadLock1(),"test1");
        Thread thread2=new Thread(new ThreadLock2(),"test2");
        thread1.start();
        thread2.start();
    }
}
