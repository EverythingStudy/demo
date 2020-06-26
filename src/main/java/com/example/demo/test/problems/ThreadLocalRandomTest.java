package com.example.demo.test.problems;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {
    @Test
    public void test(){
        System.out.println(ThreadLocalRandom.current().nextInt(20));
    }
}
