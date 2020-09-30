package com.example.demo.test.concurrent.lock;

import java.util.Locale;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * @Description JUC包中的锁定义-读写锁
 * @Date 2020/3/20 16:39
 * @Author cly
 **/
public class TestReadAndWriteLock {
    Lock lock = new ReentrantLock();

    ReadWriteLock reLock = new ReentrantReadWriteLock();

    public void test() {

        Condition condition = lock.newCondition();
        try {
            lock.lockInterruptibly();
            lock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Condition readCondition = reLock.readLock().newCondition();
        Condition writeCondition = reLock.writeLock().newCondition();
        Lock readLock = reLock.readLock();
        readLock.lock();
        LockSupport.park();
        LockSupport.unpark(Thread.currentThread());
    }
    //class MyObject{
        public void get(){

            reLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName()+"进入读数据");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"读数据完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reLock.readLock().unlock();
            }
        }

        public void put(){
            reLock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName()+"进入写数据");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"写数据完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reLock.writeLock().unlock();
            }
        }
    //}
    public static void main(String[] args) {
        ExecutorService threadPoolExecutor=Executors.newCachedThreadPool();
        TestReadAndWriteLock t=new TestReadAndWriteLock();
        for(int i=0;i<10;i++){
            threadPoolExecutor.execute(()->{t.get();});
        }
        for(int i=0;i<10;i++){
            threadPoolExecutor.execute(()->{t.put();});
        }
        threadPoolExecutor.shutdown();
    }
}
