package com.example.demo.test.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Date 2019/11/13 14:18
 * @Author cly
 **/
public class TestHashMap {
    //1.最普通基本的Map接口实现
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

    public static void testLinkedHashMap() {
        //2.比较大小，存入数据自动排好序--插入有顺序
        Map map=new LinkedHashMap();
        Map concurrentHashMap=new ConcurrentHashMap();
        boolean flag=true;
        int a=0;
        for(;a<10;){
            System.out.println(concurrentHashMap.put(1,"11"));
            a++;
        }

    }

    public void testTreeMap(){
        //3.实现了sortedMap接口，插入的数据按照大小排序
        Map map=new TreeMap();
        map.put(1,new Object());
    }

    public void testHashTable(){
        //4.线程安全所有的方法都同步
        Map map=new Hashtable();
        map.put(1,new Object());
    }
}
