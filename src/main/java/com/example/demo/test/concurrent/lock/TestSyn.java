package com.example.demo.test.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 同步通知线程
 * @Date 2019/8/15 15:42
 **/
public class TestSyn {
    ExecutorService executorService= Executors.newFixedThreadPool(2);
    @Test
    public  void testUnit() {
        while(true){
            executorService.submit(new TestSyn.Writetwo());
            executorService.submit(new TestSyn.Writeone());
        }
    }
    class Writetwo implements Runnable{
        @Override
        public void run() {
            writetwo();
        }
    }
    class Writeone implements Runnable{
        @Override
        public void run() {
            writeone();
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
        System.out.println(2);
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
