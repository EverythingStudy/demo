package com.example.demo.test.concurrent;

import org.junit.Test;

import java.util.concurrent.Semaphore;


/**
 * @Description 信号量--Semaphore
 * @Date 2019/11/11 18:58
 * @Author cly
 **/
public class TestSemaphore extends Object{
    Semaphore semaphore=new Semaphore(2);

    public void test(){
        for (int i=0;i<10;i++){
            new Thread(()->{
                try {
                    //分配一个信号
                    semaphore.acquire();
                    System.out.println("=1=="+Thread.currentThread().getName());
                    Thread.sleep(1000*2);
                    System.out.println("=2=="+Thread.currentThread().getName());
                    //回收一个信号
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        TestSemaphore testSemaphore=new TestSemaphore();
        testSemaphore.test();
    }
}
