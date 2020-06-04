package com.example.demo.test.base.lambda;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description
 * @Date 2020/5/29 18:15
 * @Author cly
 **/
public class ArraysTest {
    String [] strins={"a","b","c"};


    @Test
    public void parallelPrefix(){
        Arrays.parallelPrefix(strins,(s,i)->s+i);
        System.out.println(strins[0]+"=="+strins[1]+"==="+strins[2]);
    }
}
