package com.example.demo.test.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description
 * @Date 2020/4/21 16:46
 * @Author cly
 **/
public class CopyOnWriteArraySetTest {
    public void test(){
        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(new Object());
    }
}
