package com.example.demo.test.Spring.entity;

import java.io.Serializable;

/**
 * (Swaggerperson)实体类
 *
 * @author makejava
 * @since 2020-04-03 10:20:15
 */
public class Swaggerperson implements Serializable {
    private static final long serialVersionUID = 133357231528142622L;
    
    private Integer id;
    
    private String name;
    
    private String phoneNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Swaggerperson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}