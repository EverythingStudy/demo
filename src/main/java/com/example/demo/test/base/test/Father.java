package com.example.demo.test.base.test;

/**
 * @Description
 * @Date 2020/7/7 17:08
 * @Author cly
 **/
public class Father {
    Father(String fatherName,int fatherAge){
        this.fatherName=fatherName;
        this.fatherAge=fatherAge;
    }
    public String fatherName;
    public int fatherAge;

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getFatherAge() {
        return fatherAge;
    }

    public void setFatherAge(int fatherAge) {
        this.fatherAge = fatherAge;
    }
    public void get(){
        System.out.println("father");
    }
}
