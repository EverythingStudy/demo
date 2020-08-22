package com.example.demo.test.base.test;

/**
 * @Description
 * @Date 2020/7/7 17:07
 * @Author cly
 **/
public class Son extends Father {
    public String sonName;
    public int sonAge;
    Son(String sonName,int sonAge){
        super("陈林亚",sonAge);
        this.sonName=sonName;
        this.sonAge=sonAge;
    }
    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public int getSonAge() {
        return sonAge;
    }

    public void setSonAge(int sonAge) {
        this.sonAge = sonAge;
    }
    @Override
    public void get(){
        System.out.println("son");
    }
}
