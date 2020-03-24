package com.example.demo.test.reflect;

/**
 * @Description
 * @Date 2020/2/25 16:44
 * @Author cly
 **/
public class SpringContext {
    String name;
    String age;
    String bean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBean() {
        return "springContext";
    }

    public void setBean(String bean) {
        this.bean = bean;
    }
}
