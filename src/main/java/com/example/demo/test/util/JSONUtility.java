package com.example.demo.test.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JSONUtility {

    public static class FastJson {
        public static <T> JSONObject objectToJson(T obj) {
            String jsonStr = JSON.toJSONString(obj);
            return JSONObject.parseObject(jsonStr);
        }

        public static <T> JSONArray arrayToJson(List<T> objs) {
            String jsonStr = JSONArray.toJSONString(objs);
            return JSONArray.parseArray(jsonStr);
        }

        public static <T> T jsonToObj(JSONObject jsonObj, Class<T> obj) {
            return JSON.toJavaObject(jsonObj, obj);
        }

        public static <T> List<T> jsonToArray(JSONArray jsonArray, Class<T> obj) {
            return JSONArray.parseArray(JSONArray.toJSONString(jsonArray), obj);
        }

        public static <T> List<T> StringToList(String objs, Class<T> class1) {
            return JSONArray.parseArray(objs, class1);

        }

        public static <T> T stringToObj(String jsonStr, Class<T> obj) {

            return JSON.parseObject(jsonStr, obj);
        }
    }

    public static class GsonJson {
        static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        public static <T> List<T> jsonToArry(String reportString) {
            return gson.fromJson(reportString, new TypeToken<List<T>>() {
            }.getType());
        }

        public static <T> T jsonForList(String dateString,T t){
            return gson.fromJson(dateString, new TypeToken<T>() {
            }.getType());
        }
    }
}
