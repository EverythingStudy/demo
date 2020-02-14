package com.example.demo.test.design.factory;

/**
 * @Description
 * @Date 2020/2/13 14:10
 * @Author cly
 **/
public class YellowHuman extends Human{
    String sex;
    String color;

    public String getSex() {
        System.out.println("4343");
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
