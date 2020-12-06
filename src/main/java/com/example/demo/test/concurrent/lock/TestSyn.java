package com.example.demo.test.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 同步通知线程
 * @Date 2019/8/15 15:42
 **/
public class TestSyn {
    ExecutorService executorService= Executors.newFixedThreadPool(2);
    @Test
    public  void testUnit() {
        while(true){
            executorService.submit(new Thread(new TestSyn.Writeone(),"one") );
            executorService.submit(new Thread(new TestSyn.Writetwo(),"two"));

        }
    }
    class Writetwo implements Runnable{
        @Override
        public void run() {
            readTwo();
        }
    }
    class Writeone implements Runnable{
        @Override
        public void run() {
            readOne();
        }
    }
    public  synchronized void writeone(){
        System.out.println(1);
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void writetwo(){
        Thread thread=new Thread();
        System.out.println(2);
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private volatile boolean flag=true;
    private ReentrantLock reentrantLock=new ReentrantLock();
    private Condition condition=reentrantLock.newCondition();
    public void readOne(){
        while(true){
            reentrantLock.lock();
            try {
            if(flag){
                System.out.println("read one");
                condition.await();
            }
            flag=false;
            condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }
    public void readTwo(){
        while(true){
            reentrantLock.lock();
            try {
                if(!flag){
                    System.out.println("read two");
                    condition.await();
                }
                flag=true;
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }
}
