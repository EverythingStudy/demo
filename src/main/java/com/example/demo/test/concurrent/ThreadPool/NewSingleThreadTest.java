package com.example.demo.test.concurrent.ThreadPool;

import java.util.concurrent.Executors;

/**
 * @Description
 * @Date 2020/8/25 11:24
 * @Author cly
 **/
public class NewSingleThreadTest {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(2);
    }
}
