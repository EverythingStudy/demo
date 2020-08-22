package com.example.demo.test.base;

import org.junit.Test;

/**
 * @Description String类型
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
