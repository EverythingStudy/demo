package com.example.demo.test.interfaceTest;

import org.junit.Test;

/**
 * @Description
 * @Date 2019/12/4 18:13
 * @Author cly
 **/
public class TestAbstractSon extends TestAbstract {
    @Override
    public void getNme() {
        System.out.println("cly");
    }
    @Test
    public void test(){
        getPrice();
    }
}
