package com.example.demo.test.base.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.json.JSONException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2020/7/7 17:10
 * @Author cly
 **/
public class Test implements Serializable{
    public static long SerializableId=1L;
    public static void main(String[] args) {
        Father father=new Son("胡鹏磊",12,"陈林亚");
        //Son son=new Father("",13);
        Son son=new Son("胡鹏磊",12,"陈林亚");
        System.out.println(son.getFatherName());
        System.out.println(((Son) father).getSonName());
        System.out.println(father.getFatherName());;
    }
    @org.junit.Test
    public void MapToJson(){
      Map<String,String> map=new HashMap<>();
      map.put("a","b");
      JSONObject jsonObject=new JSONObject();
      System.out.println(JSON.toJSONString(map));
        try {
            System.out.println(new org.json.JSONObject(JSON.toJSONString(map)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
