package com.example.demo.test.collections.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Description  //TODO fast_fail和safe_fail 的区别，在多线程下的修改集合会出现异常。
 * @Date 2020/2/28 18:05
 * @Author cly
 **/
public class TestList {
    private List<Map<String, Object>> list;

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }


    private static List<Integer> listForFail = new ArrayList<>();

    private static void printAll() {
        Iterator iterator = listForFail.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    //@Test
    public static   void main(String[] args) {
        Thread one = new Thread(new One());
        Thread two = new Thread(new Two());
        one.start();
        two.start();
    }

    private static class One implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i < 16) {
                listForFail.add(i);
                printAll();
                i++;
            }
            //printAll();
        }
    }

    static class Two implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i < 16) {
                listForFail.add(i);
                printAll();
                i++;
            }

        }
    }
}
