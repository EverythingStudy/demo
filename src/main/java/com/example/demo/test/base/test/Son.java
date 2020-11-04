package com.example.demo.test.base.test;

/**
 * @Description
 * @Date 2020/7/7 17:07
 * @Author cly
 **/
public class Son extends Father {
    public String sonName;
    public int sonAge;
    private String fatherName;
    Son(String sonName,int sonAge,String fatherName){
        super(fatherName,sonAge);
        this.sonName=sonName;
        this.sonAge=sonAge;
        this.fatherName=fatherName;
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

    @Override
    public String getFatherName() {
        return fatherName;
    }

    @Override
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
