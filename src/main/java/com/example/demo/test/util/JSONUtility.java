package com.util;

import java.util.ArrayList;
import java.util.List;

//import org.json.JSONArray;
//import org.json.JSONObject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JSONUtility {
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	public static <T> JSONObject objectToJson(T obj) {
		String jsonStr = gson.toJson(obj);
		return JSONObject.parseObject(jsonStr);
	}

	public static <T> JSONArray arrayToJson(List<T> objs) {
		JSONArray objArray = new JSONArray();
		for (T obj : objs) {
			String jsonStr = gson.toJson(obj);

			JSONObject jsonObj = JSONObject.parseObject(jsonStr);
			objArray.add(jsonObj);
		}

		return objArray;
	}

	public static <T> T jsonToObj(JSONObject jsonObj, Class<T> obj) {
		T t = null;
		String jsonStr = jsonObj.toString();

		t = gson.fromJson(jsonStr, obj);
		return t;
	}

	public static <T> List<T> jsonToArray(JSONArray jsonArray, Class<T> obj) {
		List<T> result = new ArrayList<T>();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			T t = gson.fromJson(jsonObj.toString(), obj);
			result.add(t);
		}
		return result;
	}

	public static <T> List<T> StringToList(String objs, Class<T> class1) {
		List<T> listobj = gson.fromJson(objs, new TypeToken<List<T>>() {
		}.getType());
		return listobj;

	}

	public static <T> T stringToObj(String jsonStr, Class<T> obj) {
		T t = null;
		t = gson.fromJson(jsonStr, obj);
		return t;
	}
}
