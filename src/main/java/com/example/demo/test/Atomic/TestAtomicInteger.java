package com.example.demo.test.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Date 2019/8/28 10:54
 * @Author cly
 **/
public class TestAtomicInteger {
    AtomicInteger atomicInteger=new AtomicInteger();
    private int n;
    private final AtomicInteger lock;
    public TestAtomicInteger(int n) {
        this.n = n;
        this.lock = new AtomicInteger(n * 2);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while(this.lock.get() % 2 == 1){
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            this.lock.getAndDecrement();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(this.lock.get() % 2 == 0){
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            this.lock.getAndDecrement();

        }
    }
}
