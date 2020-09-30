package com.example.demo.test.base.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.test.base.bean.JsonBean;
import org.junit.Test;

/**
 * @Description fastJson
 * @Date 2020/5/29 9:48
 * @Author cly
 **/
public class JsonObject {
    @Test
    public void parseJson() {
        String key="AdB";
        System.out.println(Character.isUpperCase(key.charAt(1)));
    }

    public static void main(String[] args) {
        JsonBean jsonBean = new JsonBean("test");
        JSONObject jsonObject= (JSONObject) JSON.toJSON(jsonBean);
        System.out.println(jsonObject);
        JsonBean jsonBeanJson=JSON.parseObject(jsonObject.toJSONString(),JsonBean.class);
    }
}
