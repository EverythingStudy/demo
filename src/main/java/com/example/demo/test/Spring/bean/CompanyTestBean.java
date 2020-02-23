package com.example.demo.test.Spring.bean;

/**
 * @Description
 * @Date 2020/2/23 15:37
 * @Author cly
 **/
public class CompanyTestBean {
    private String type;
    private String name;

    public CompanyTestBean(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void initMethod(){
        System.out.println("初始化");
    }
    @Override
    public String toString() {
        return "CompanyTestBean{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
