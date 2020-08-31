package com.example.demo.test.Spring.annotation.configuration;

import java.io.Serializable;

/**
 * @Description
 * @Date 2020/2/23 11:59
 * @Author cly
 **/

public class Confige implements Serializable {
    private String type;
    private String name;

    public Confige() {
    }

    public Confige(String type, String name) {
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

    @Override
    public String toString() {
        return "Confige{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
