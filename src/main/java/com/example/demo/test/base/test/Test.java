package com.example.demo.test.base.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2020/7/7 17:10
 * @Author cly
 **/
public class Test {

    public static void main(String[] args) {
        Father father=new Son("胡鹏磊",12);
        Son son=new Son("胡鹏磊",12);
        System.out.println(son.getFatherName());
        System.out.println(((Son) father).getSonName());
        father.get();
    }
    @org.junit.Test
    public void MapToJson(){
      Map<String,String> map=new HashMap<>();
      map.put("a","b");
      JSONObject jsonObject=new JSONObject();
      System.out.println(JSON.toJSONString(map));
      System.out.println(new org.json.JSONObject(JSON.toJSONString(map)));
    }
}
