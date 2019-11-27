package com.example.demo.test.Thread;

/**
 * @Description
 * @Date 2019/11/7 10:49
 * @Author cly
 **/
public class TestThread {
    public static void main(String[] args) {
        Thread thread=new TestThread.MyThread();
        thread.start();
        thread.interrupt();
//        try {
//            thread.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(thread.getState());
        System.out.println(thread.isInterrupted());
    }
    static class MyThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }
    }
}
