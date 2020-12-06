package com.example.demo.test.concurrent.Thread;

import java.util.concurrent.Callable;

/**
 * @Description 实现线程的三种方式
 * @Date 2019/11/7 10:49
 * @Author cly
 **/
public class TestThread {
    public static void main(String[] args) {
        Thread thread = new TestThread.MyThread();
        Thread threadRun = new Thread(new MyThread());
        threadRun.start();
        thread.start();
        thread.interrupt();
        System.out.println(thread.getState());
        System.out.println(thread.isInterrupted());
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(2);
            }
            System.out.println(1);
        }
    }

    class MyThreadTwo implements Runnable {
        @Override
        public void run() {
            System.out.println("实现Runnable接口");
        }
    }

    class MyThreadThreed implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "实现Callable接口";
        }
    }
}
