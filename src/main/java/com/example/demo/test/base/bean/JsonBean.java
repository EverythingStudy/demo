package com.example.demo.test.base.bean;

/**
 * @Description
 * @Date 2020/5/29 9:51
 * @Author cly
 **/
public class JsonBean {
    private String ADB;
    private String test;
    public JsonBean(String test){
        this.ADB=test;
    }

//    public String getAdB() {
//        return AdB;
//    }
//
//    public void setAdB(String adB) {
//        AdB = adB;
//    }
        public String getADB() {
        return ADB;
    }

    public void setADB(String ADB) {
        this.ADB = ADB;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
