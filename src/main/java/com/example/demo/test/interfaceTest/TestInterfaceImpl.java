package com.example.demo.test.interfaceTest;

/**
 * @Description
 * @Date 2019/12/4 17:57
 * @Author cly
 **/
public class TestInterfaceImpl implements TestInterface {
    @Override
    public void getInterface() {
        System.out.println(TestInterface.price);
    }
}
