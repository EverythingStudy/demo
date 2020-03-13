package com.example.demo.test.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Date 2019/11/13 14:18
 * @Author cly
 **/
public class TestHashMap {
    Map<String,String> hashMap=new HashMap<>();
    /**
     * @Author cly
     * @Description //TODO HashMap迭代器 除了迭代器中的next() 返回的是各种迭代器的值，
     * //TODO hashNext()、nextNode()、remove()等方法都是继承于HashMap实现类的HashIterator内部类
     * //HashIterator内部类中定义了下面几个属性
     *  Node<K,V> next;        // next entry to return
     *  Node<K,V> concurrent;     // concurrent entry
     *                int expectedModCount;  // for fast-fail
     *                int index;当前元素的迭代位置
     * @Date 13:57 2019/11/27
     * @Param []
     * @return void
     **/
    public void mapIterator(){
        //key迭代器
        Iterator<String> iterable=hashMap.keySet().iterator();
        iterable.next();
        //entry迭代器
        hashMap.entrySet().iterator();
        //value迭代器
        hashMap.values().iterator();
    }

    public static void main(String[] args) {
        Map map=new LinkedHashMap();
        Map concurrentHashMap=new ConcurrentHashMap();
        boolean flag=true;
        int a=0;
        for(;a<10;){
            System.out.println(concurrentHashMap.put(1,"11"));
            a++;
        }

    }
}
