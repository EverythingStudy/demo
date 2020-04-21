package com.example.demo.test.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description JUC包中的锁定义
 * @Date 2020/3/20 16:39
 * @Author cly
 **/
public class TestReadAndWriteLock {
 Lock lock=new ReentrantLock();
 ReentrantReadWriteLock reLock=new ReentrantReadWriteLock();
 public void test(){
     LockSupport.park();
     LockSupport.unpark(Thread.currentThread());
 }
}
