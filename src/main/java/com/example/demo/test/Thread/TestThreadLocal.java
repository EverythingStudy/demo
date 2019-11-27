package com.example.demo.test.Thread;

/**
 * @Description
 * @Date 2019/8/21 12:14
 **/
public class TestThreadLocal {
    ThreadLocal<Integer> t=new ThreadLocal<>();
    public void test(){
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                t.set(15);
                System.out.println(Thread.currentThread().getName()+"=="+t.get());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"=="+t.get());
            }
        }.start();
    }

    public static void main(String[] args) {
        TestThreadLocal testThreadLocal=new TestThreadLocal();
        testThreadLocal.test();
    }
}
