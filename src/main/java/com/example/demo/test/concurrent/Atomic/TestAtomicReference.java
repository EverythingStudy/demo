package com.example.demo.test.concurrent.Atomic;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description
 * @Date 2019/9/27 18:38
 * @Author cly
 **/
public class TestAtomicReference {
    public static void main(String[] args) {
//        AtomicStampedReference
        AtomicReference<String> te=new AtomicReference<>();
        Integer k=2;
        System.out.println((k>>1));
        Map map=new ConcurrentHashMap();
        Map maps=new HashMap();
        Map mapTable=new Hashtable();
        Map mapLikedHashMap=new LinkedHashMap();

    }
}
