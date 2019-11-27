package com.example.demo.test.lock;

import org.junit.Test;

/**
 * @Description
 * @Date 2019/8/15 15:42
 **/
public class TestSyn {
    @Test
    public  void testUnit() {
        while(true){
           // Thread threadone=new Thread(new TestSyn.Writeone());
            //threadone.start();
            Thread threadteo=new Thread(new TestSyn.Writetwo());
            threadteo.start();
        }
    }
    class Writetwo implements Runnable{
        TestSyn testSyn=new TestSyn();
        @Override
        public void run() {
            testSyn.writetwo();
        }
    }
//    class Writeone implements Runnable{
//        TestSyn testSyn=new TestSyn();
//        @Override
//        public void run() {
//            testSyn.writeone();
//        }
//    }

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
