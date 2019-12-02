package com.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpRequest {

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			java.net.URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			// Map<String, List<String>> map = connection.getHeaderFields();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static InputStream sendGetInput(String url) {
		InputStream result = null;
		InputStream ino = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			java.net.URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			result = conn.getInputStream();
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			byte[] data = new byte[1024];
			int count = -1;
			while ((count = result.read(data, 0, 1024)) != -1) {
				outStream.write(data, 0, count);
			}
			System.out.println("ss=" + outStream.size());
			result.close();
			ino = new ByteArrayInputStream(outStream.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ino;
	}

	public static String httpGet(String url, Map<String, Object> parametes) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?";
			if (parametes != null && parametes.size() > 0) {
				Set<String> keys = parametes.keySet();
				Object[] strs = keys.toArray();
				for (int i = 0; i < strs.length; i++) {
					String key = String.valueOf(strs[i]);
					String value = String.valueOf(parametes.get(key));
					// 去除值为""的
					if (i == strs.length - 1) {
						urlNameString = urlNameString + key + "=" + value;
					} else {
						urlNameString = urlNameString + key + "=" + value + "&";
					}
				}
			}
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			java.net.URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			// Map<String, List<String>> map = connection.getHeaderFields();

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * post 字符串 连接
	 * 
	 * @param urlString
	 * @param param
	 * @return
	 */
	public static String postStringData(String urlString, String param) {
		String responseData = null;
		try {
			// 创建连接
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("content-type", "application/octet-stream; charset=UTF-8");
			connection.connect();
			// POST请求
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.write(param.getBytes("utf-8"));
			out.flush();
			out.close();
			InputStream inputStream = connection.getInputStream();
			if (inputStream != null) {
				int responseCode = connection.getResponseCode();
				if (responseCode != 200) {
					connection.disconnect();
					return responseData;
				}
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] data = new byte[1024];
				int count = -1;

				while ((count = inputStream.read(data, 0, 1024)) != -1) {
					outStream.write(data, 0, count);
				}
				data = null;
				responseData = new String(outStream.toByteArray(), "utf-8");
			}
			inputStream.close();
			// 断开连接
			connection.disconnect();
			connection=null;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseData;
	}

	public static String httpPost(String url, Map<String, String> parametes) {
		String str = "";
		HttpClient httpClient = new HttpClient();
		PostMethod psotMethod = new PostMethod(url);
		if (parametes != null && parametes.size() > 0) {
			Set<String> keys = parametes.keySet();
			for (String key : keys) {
				psotMethod.setParameter(key, parametes.get(key));// 这里添加参数
			}
		}
		psotMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");// 请求编码
		psotMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		try {
			// 执行getMethod
			int statusCode = httpClient.executeMethod(psotMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + psotMethod.getStatusLine());
			}
			// 读取内容
			byte[] responseBody = psotMethod.getResponseBody();
			str = new String(responseBody, "utf-8");
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 释放连接
			psotMethod.releaseConnection();
		}
		return str;
	}
}
