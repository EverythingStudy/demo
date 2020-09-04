package com.example.demo.test.base;

import org.junit.Test;

/**
 * @Description TODO String类型--intern()方法，如果直接定义"test"则会直接放入String的常量池，如果是队象的引用则使用intern()方法-先去常量池找没有则放入常量池
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

}
