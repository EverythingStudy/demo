package com.example.demo.test.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Date 2019/8/15 15:42
 **/
public class TestSyn {
    ExecutorService executorService= Executors.newFixedThreadPool(2);
    @Test
    public  void testUnit() {
        while(true){
            executorService.submit(new TestSyn.Writetwo());
        }
    }
    class Writetwo implements Runnable{
        TestSyn testSyn=new TestSyn();
        @Override
        public void run() {
            testSyn.writetwo();
        }
    }

    public synchronized void writeone(){
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
