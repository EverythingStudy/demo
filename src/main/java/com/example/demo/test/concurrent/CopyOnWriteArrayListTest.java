package com.example.demo.test.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description 读写并发List,写入时复制集合
 * @Date 2020/4/21 16:45
 * @Author cly
 **/
public class CopyOnWriteArrayListTest {
    List list=new CopyOnWriteArrayList();

    public  void test() {
        list.add("copy");
        list.iterator();
    }

}
