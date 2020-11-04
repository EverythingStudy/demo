package com.example.demo.test.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.concurrent.lock
 * @ClassName: Test
 * @Description
 * @Date 2020/11/3 16:52
 * @Author cly
 **/
public class Test {
    public static void main(String[] args) {
        LockSupport.park();
        LockSupport.unpark(new Thread());
    }
}
