package com.example.demo.test.base.thread;

import org.junit.Test;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.base.thread
 * @ClassName: ThreadTest
 * @Description //todo 两个线程顺序打印1-100
 * @Date 2020/12/2 21:10
 * @Author cly
 **/
public class ThreadTest {

    volatile boolean flag = true;
    Object obj = new Object();
    public void test() {
        Thread threadTwo = new Thread(new ThreadTwo());
        threadTwo.start();
        Thread threadOne = new Thread(new ThreadOne());
        threadOne.start();
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.test();
    }

    public class ThreadOne implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 1; i <= 100; i += 2) {
                    while (flag) {
                        System.out.println(i);
                        flag=false;
                        obj.notify();
                    }
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class ThreadTwo implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i <= 100; i += 2) {
                    while (!flag) {
                        System.out.println(i);
                        flag = true;
                        obj.notify();
                    }
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
