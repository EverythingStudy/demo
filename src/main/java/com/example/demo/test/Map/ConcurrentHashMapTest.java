package com.example.demo.test.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description ConcurrentHashMap相关
 * @Date 2020/3/10 10:53
 * @Author cly
 **/
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map map = new ConcurrentHashMap();

        int n = 8;
        int rs = Integer.numberOfLeadingZeros(n) | (1 << (16 - 1));
        ;
        System.out.println(rs);
//重写User hashCode和equels
        Map<User, String> mapString = new ConcurrentHashMap<>();
        User user1 = new User("陈林亚", "186012");
        User user2 = new User("陈林亚", "1860121");
        mapString.put(user1, "1");
        mapString.put(user2, "1");
        System.out.println(mapString.toString());

    }

    @Test
    public void ite() {
        Map ConcurrentHashMap = new HashMap();
        ConcurrentHashMap.put(1, "a");
        ConcurrentHashMap.put(2, "b");
        ConcurrentHashMap.put(3, "c");
        ConcurrentHashMap.keySet().iterator();
        Iterator iterator = ConcurrentHashMap.keySet().iterator();
        for (; iterator.hasNext(); ) {
            ConcurrentHashMap.remove(2);
            ConcurrentHashMap.put(4, "d");
            System.out.println(iterator.next());
        }

    }

    @Test
    public void whyIsNull() {
        Map map = new ConcurrentHashMap();
        Map hashMap = new HashMap();
        map.put(null, "le");//异常因为null不能做hash
        //异常，因为ConcurrentHashMap源码不允许key和value为null
        //至于为什么不允许，是因为我们在取值的时候会返回null,
        // 分不清他是存的null还是因为key不存在造成的null
        // 假设我们去判断containskey(key)时，多线程中其他线程concurrentHashMap.put(key,null)的操作。
        // 混淆哦我们的判断
        map.put("ConcurrentHashMap", null);
        //正确，hashMap源码允许为null
        hashMap.put("HashMap", null);
    }

    public void exidMap() {
        Map hashMap = new HashMap();
        hashMap.put(1, "a");
        hashMap.put(2, "b");
        hashMap.put(3, "c");
        hashMap.keySet().iterator();
    }
}
