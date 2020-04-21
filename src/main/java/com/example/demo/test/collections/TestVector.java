package com.example.demo.test.collections;

import java.util.Vector;

/**
 * vector同list数据结构相同，唯一不同是方法都是同步的synchronized修饰
 *
 */
public class TestVector {

    public void test(){
        Vector vector=new Vector();
        vector.add(new Object());
        vector.remove(new Object());
    }
}
