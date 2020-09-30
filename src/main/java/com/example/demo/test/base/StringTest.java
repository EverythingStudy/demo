package com.example.demo.test.base;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.*;

/**
 * @Description TODO String不可变类型--intern()方法，如果直接定义"test"则会直接放入String的常量池，如果是队象的引用则使用intern()方法-先去常量池找没有则放入常量池
 * @Date 2020/5/22 18:21
 * @Author cly
 **/
public class StringTest {

    @Test
    public void test(){
        String st=new String();
        st="test";
        System.out.println(st.intern());
        StringBuffer sb=new StringBuffer();
        StringBuilder stringBuilder=new StringBuilder();
        sb.append("a");
        stringBuilder.append("b");
    }
    @Test
    public void testSet(){
        HashSet<String> set=new HashSet<>();
        String hash="test";
        set.add(hash);
        Set unSet=  Collections.unmodifiableSet(set);
        //深度拷贝
        Set imSet=ImmutableSet.copyOf(set);
        set.add("cly");
        System.out.println(unSet);
        System.out.println(imSet);
    }


}
