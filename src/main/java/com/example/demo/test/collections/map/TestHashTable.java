package com.example.demo.test.collections.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.test.collections.map
 * @ClassName: TestHashTable
 * @Description
 * @Date 2020/10/26 9:50
 * @Author cly
 **/
public class TestHashTable {
    public void testHashTable(){
        //4.线程安全所有的方法都同步
        Map map=new Hashtable();
        map.put(1,new Object());
    }
}
