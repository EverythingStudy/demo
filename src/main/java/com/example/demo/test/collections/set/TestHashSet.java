package com.example.demo.test.collections.set;

import com.example.demo.test.Base.TestOverrideSon;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description
 * @Date 2019/11/24 16:32
 * @Author cly
 **/
public class TestHashSet {


    public static void main(String[] args) {
        Set set=new HashSet();
        TestOverrideSon testOverrideSon=new TestOverrideSon();
        set.add(testOverrideSon);
        Set treeSet=new TreeSet();
        treeSet.add("cly");

    }
}
