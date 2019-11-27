package com.example.demo.test.Base;

import java.io.Serializable;

/**
 * @Description 序列化
 * @Date 2019/10/9 18:34
 * @Author cly
 **/
public class TestSerialVerion implements Serializable {
    public static long SerializableId=123456L;
    public transient String name;//瞬间变量 不被序列化

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
