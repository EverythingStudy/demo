package com.example.demo.test.concurrent.Atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description
 * @Date 2019/9/24 16:26
 * @Author cly
 **/
public class TestAtomicBoolean {


    public static void main(String[] args) {
        AtomicBoolean atomicBoolean=new AtomicBoolean();
        atomicBoolean.compareAndSet(false,true);
    }
}
