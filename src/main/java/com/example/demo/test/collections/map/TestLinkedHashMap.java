package com.example.demo.test.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.collections.map
 * @ClassName: TestLinkedHashMap
 * @Description
 * @Date 2020/10/26 9:48
 * @Author cly
 **/
public class TestLinkedHashMap {
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
}
