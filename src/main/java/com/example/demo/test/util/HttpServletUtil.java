package com.example.demo.test.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.UUID;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

/**
 * 获取HTTP请求信息
 * 
 * @author chenly
 * 
 */
public class HttpServletUtil {
	final static int BUFFER_SIZE = 1024;

	public static String getInputString(HttpServletRequest request) {

		String inputParameter = null;
		try {
			ServletInputStream inputStream = request.getInputStream();

			if (inputStream != null) {
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] data = new byte[BUFFER_SIZE];
				int count = -1;

				while ((count = inputStream.read(data, 0, BUFFER_SIZE)) != -1) {
					outStream.write(data, 0, count);
				}

				data = null;
				inputParameter = new String(outStream.toByteArray(), "utf-8");
				outStream.close();
				outStream = null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return inputParameter;

	}


	public static JSONObject getInputJson(HttpServletRequest request) {
		JSONObject obj = null;
		try {
			String stringInput = getInputString(request);
			obj = JSONObject.parseObject(stringInput);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("obj===" + obj.toString());
		return obj;
	}
}
