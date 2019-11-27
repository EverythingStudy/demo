package com.example.demo.test.util;

import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String getMD5(byte[] source) {
		String s = null;
		// 用来将字节转换成16进制表示的字符
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source);
			// MD5 的计算结果是一个 128 位的长整数，
			byte tmp[] = md.digest();
			// // 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
			char str[] = new char[16 * 2];
			// 进制需要 32 个字符 // 表示转换结果中对应的字符位置
			int k = 0;
			// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
			for (int i = 0; i < 16; i++) {
				// 进制字符的转换// 取第 i 个字节
				byte byte0 = tmp[i];
				// 取字节中高 4 位的数字转换,// >>>为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				// 取字节中低 4 位的数字转换
				str[k++] = hexDigits[byte0 & 0xf];
			}
			// 换后的结果转换为字符串
			s = new String(str);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String[] args) {
		String signKey = "wanliyun";
		String waitMd5 = "recortId=6088a7b6-0d67-405f-a3ed-44765bd291e9&type=1&sign=" + signKey;
		String sign = getMD5(waitMd5.getBytes()).toLowerCase();
		System.out.println(sign);
		String k="http://cfm.wlycloud.com/patient_cfmReportPhoneView.do?did=1&fid=6046&isViewReport=1&recortId=20190731000104_6046&type=1&sign=b03a7b88f5b39a4accdd6e6daef36212";
	}
}
