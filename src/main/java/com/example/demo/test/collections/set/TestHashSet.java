package com.example.demo.test.collections.set;

import com.example.demo.test.base.TestOverrideSon;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description //TODO set底层结构HashMap map.put(key,Object),添加的对象为key，当hashCode碰撞后equals去重
 * @Date 2019/11/24 16:32
 * @Author cly
 **/
public class TestHashSet {


    public static void main(String[] args) {
        Set set=new HashSet();
        TestOverrideSon testOverrideSon=new TestOverrideSon();
        set.add(testOverrideSon);
        TestOverrideSon testOverrideSon1=new TestOverrideSon();
        set.add(testOverrideSon1);
        String a="clya";
        String d=new String("clya");
        String b=a;
        String c=d;
        set.add(b);
        set.add(c);
        System.out.println(testOverrideSon.equals(testOverrideSon1));
        System.out.println(set);
        System.out.println(b==c);
        System.out.println(b.equals(c));
    }
}
