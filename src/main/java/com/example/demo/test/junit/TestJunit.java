package com.example.demo.test.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * @Description Junit
 * @Date 2018/7/14 10:51
 * @Author cly
 **/
public class TestJunit {

    @Before
    public void before(){
        System.out.println("before");
    }

    @After
    public void after(){
        System.out.println("after");
    }
    @Test
    public void test(){
        System.out.println("test");
    }


    public static void main(String[] args) {
        Optional.empty();
    }
}
