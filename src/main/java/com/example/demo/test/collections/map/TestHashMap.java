package com.example.demo.test.collections.map;

import com.example.demo.test.Spring.yaml.Person;
import org.junit.Test;

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

    @Test
    public void mapHash(){
        Person person=new Person();
        int h=person.hashCode();
        System.out.println(person.hashCode());
        System.out.println(h^ (h >>> 16));
        int k=h^ (h >>> 16);
        System.out.println(k&16);
    }

    public static void main(String[] args) {
        Integer integer="tes".hashCode();
        System.out.println("s1s5".hashCode()%8);
        System.out.println("tes3".hashCode()%8);
    }
}
