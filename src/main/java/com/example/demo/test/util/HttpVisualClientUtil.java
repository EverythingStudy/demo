package com.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpVisualClientUtil {
	private HttpVisualClientUtil() {
	}

	public static String httpPost(String url, String parametes) {
		String str = "";
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(url);
		if (parametes != null && parametes.trim().equals("") == false) {
			try {
				RequestEntity requestEntity = new StringRequestEntity(
						parametes, "text/plain", "UTF-8");
				postMethod.setRequestEntity(requestEntity);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// postMethod.addRequestHeader("Content-Type", "text/plain");
		}
		postMethod.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");// 请求编码
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());

		try {
			// 执行getMethod
			httpClient.executeMethod(postMethod);
			// int statusCode = httpClient.executeMethod(postMethod);
			/*
			 * if (statusCode != HttpStatus.SC_OK) {
			 * System.err.println("Method failed: "+
			 * psotMethod.getStatusLine()); }
			 */
			// 读取内容
			byte[] responseBody = postMethod.getResponseBody();
			str = new String(responseBody, "utf-8");
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			postMethod.releaseConnection();
		}
		return str;
	}

	/**
	 * 发送POST请求
	 * 
	 * @param url
	 *            目的地址
	 * @param parameters
	 *            请求参数，Map类型。
	 * @return 远程响应结果
	 */
	public static String sendPost(String url, Map<String, String> parameters) {
		String result = "";// 返回的结果
		BufferedReader in = null;// 读取响应输入流
		PrintWriter out = null;
		StringBuffer sb = new StringBuffer();// 处理请求参数
		String params = "";// 编码之后的参数
		try {
			// 编码请求参数
			if (parameters.size() == 1) {
				for (String name : parameters.keySet()) {
					sb.append(name)
							.append("=")
							.append(java.net.URLEncoder.encode(
									parameters.get(name), "UTF-8"));
				}
				params = sb.toString();
			} else {
				for (String name : parameters.keySet()) {
					sb.append(name)
							.append("=")
							.append(java.net.URLEncoder.encode(
									parameters.get(name), "UTF-8")).append("&");
				}
				String temp_params = sb.toString();
				params = temp_params.substring(0, temp_params.length() - 1);
			}
			// 创建URL对象
			URL connURL = new URL(url);
			// 打开URL连接
			HttpURLConnection httpConn = (HttpURLConnection) connURL
					.openConnection();
			// 设置通用属性
			httpConn.setRequestProperty("Accept", "*/*");
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
			// 设置POST方式
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);
			// 获取HttpURLConnection对象对应的输出流
			out = new PrintWriter(httpConn.getOutputStream());
			// 发送请求参数
			out.write(params);
			// flush输出流的缓冲
			out.flush();
			
			Integer code = httpConn.getResponseCode();
            if(!code.equals(200)){
            	return null;
            }
			
			// 定义BufferedReader输入流来读取URL的响应，设置编码方式
			in = new BufferedReader(new InputStreamReader(
					httpConn.getInputStream(), "UTF-8"));
			String line;
			// 读取返回的内容
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static String postFile(String url, InputStream fis, String fileName,String param) {
		String result = "";// 返回的结果
		BufferedReader in = null;// 读取响应输入流
		try {
			String boundary = "Boundary-b1ed-4060-99b9-fca7ff59c113"; // Could be any string
			String Enter = "\r\n";

			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);

			conn.connect();

			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

			String part1 = "--" + boundary + Enter
					+ "Content-Type: application/octet-stream" + Enter
					+ "Content-Disposition: form-data; filename=\"" + fileName
					+ "\"; name=\"file\"" + Enter + Enter;

			String part2 = Enter + "--" + boundary + Enter
					+ "Content-Type: text/plain" + Enter
					+ "Content-Disposition: form-data; name=\"jsonParam\""
					+ Enter + Enter + param + Enter + "--" + boundary + "--";

			byte[] xmlBytes = new byte[fis.available()];
			fis.read(xmlBytes);

			dos.writeBytes(part1);
			dos.write(xmlBytes);
			dos.writeBytes(part2);

			dos.flush();
			dos.close();
			fis.close();

			Integer code = conn.getResponseCode();
            if(!code.equals(200)){
            	return null;
            }
			
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			String line;
			// 读取返回的内容
			while ((line = in.readLine()) != null) {
				result += line;
			}

			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
