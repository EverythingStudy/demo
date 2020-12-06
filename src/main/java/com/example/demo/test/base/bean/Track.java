package com.example.demo.test.base.bean;

/**
 * @Description
 * @Date 2020/5/26 18:22
 * @Author cly
 **/
public class Track {
    private String name;
    private int length;
    public Track(String name, Integer length){
        this.name=name;
        this.length=length;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(length).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.valueOf(length);
    }
}
