/**
 * 
 */
package com.example.demo.test.util;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 验证
 * 
 * @author chenly
 * 
 */
public class VerifyKeyUtil {
	/**
	 * 签名排序
	 *
	 * @author chenly
	 * @param map
	 * @return
	 * @time 2017-6-16 下午5:32:02
	 * @version
	 */
	public static String componentsParameters(Map<String, Object> map) {
		// 获取所有的key
		Set<String> keys = map.keySet();
		// 取出sign
		keys.remove("sign");
		Object[] strs = keys.toArray();
		// 排序
		Arrays.sort(strs);
		StringBuffer md5sourse = new StringBuffer();
		md5sourse=getSortBuffer(md5sourse,strs,map);
		return md5sourse.toString();
	}

	/**
	 * 时间戳比较
	 *
	 * @author chenly
	 * @param param
	 * @return
	 * @time 2017-7-18 下午5:36:13
	 * @version
	 */
	public static Long verificationTime(String param) {
		Long timestamp = Long.valueOf(param);
		Long times = System.currentTimeMillis();
		Long time = (times - timestamp) / 60000;
		return time;
	}

	/**
	 * 签名校验
	 *
	 * @author chenly
	 * @param map
	 * @return
	 * @time 2017-7-18 下午5:41:09
	 * @version
	 */
	public static boolean verificationSign(Map<String, Object> map) {
		try {
			String sign = map.get("sign").toString();
			String signMethod = MD5.getMD5((componentsParameters(map) + "wly_adapter").getBytes());
			if (sign.equals(signMethod)) {
				return true;
			}
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

		return false;
	}

	public static boolean verificationSign(Map<String, Object> map, String key) {
		try {
			String sign = map.get("token").toString();
			String signMethod = MD5.getMD5((componentsParameters(map) + key).getBytes());
			if (sign.equals(signMethod)) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}


	/**
	 * 签名字符串
	 *
	 * @author chenly
	 * @param map
	 * @return
	 * @time 2018-3-8 下午2:16:24
	 * @version
	 */
	public static String signInfo(Map<String, Object> map) {
		// 获取所有的key
		Set<String> keys = map.keySet();
		// 取出sign
		Object[] strs = keys.toArray();
		// 排序
		Arrays.sort(strs);
		StringBuffer md5sourse = new StringBuffer();
		md5sourse=getSortBuffer(md5sourse,strs,map);
		md5sourse.append("wly_adapter");
		return MD5.getMD5(md5sourse.toString().getBytes());
	}

	public static StringBuffer getSortBuffer(StringBuffer md5sourse,Object[] strs,Map<String, Object> map){
		for (int i = 0; i < strs.length; i++) {
			String key = String.valueOf(strs[i]);
			String value = String.valueOf(map.get(key));
			// 去除值为""的
			if (value != null && !"".equals(value)) {
				md5sourse.append(key + "=" + value + "&");
			}
		}
		return md5sourse;
	}

}
