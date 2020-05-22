package com.example.demo.test.collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description set不能重复，treeset保证了数据的数序，linkedHashSet保证了插入顺序，hashset只有去重
 * @Date 2020/4/21 14:57
 * @Author cly
 **/
public class TestSet {

    public void test() {
        Set set = new TreeSet();

        Set linkedSet = new LinkedHashSet();
        linkedSet.add(new Object());
        linkedSet.remove(new Object());
        Set hashSet = new HashSet();
    }

}
