package com.example.demo.test;

import com.example.demo.test.Spring.bean.Company;
import com.example.demo.test.Spring.entity.Backup;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Date 2020/8/25 18:21
 * @Author cly
 **/
public class Test {
    @org.junit.Test
    public void intToString(){
        String test="155";
        System.out.println(Integer.valueOf(test));

    }
    public void remov(List<Backup> list){
        System.out.println("test");
        list.stream().filter(c->c.getBackupId()>20).collect(Collectors.toList());

    }
}
