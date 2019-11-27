package com.example.demo.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author cly
 * @Description //TODO 时间工具类
 * @Date 13:25 2019/11/27
 * @Param 
 * @return 
 **/

public class DateTypeUtility {
	private static Pattern pattern = Pattern.compile("[0-9]*");
	public static boolean isNumeric(String str) {
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static Date StrToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HHmmss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date StrToDate(String str, String type) {

		SimpleDateFormat format = new SimpleDateFormat(type);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String DateToStr(Date time, String type) {
		SimpleDateFormat f = new SimpleDateFormat(type);
		String timeString = f.format(time);
		return timeString;
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/*
	 * 将时间转换为时间戳
	 */
	public static String dateToStamp(String s) throws ParseException {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		res = String.valueOf(ts);
		return res;
	}

	// 获得年龄
	public static String getAge(String nl) {
		String patientAge = "";
		Date dateAge = DateTypeUtility.StrToDate(nl, "yyyy-MM-dd");
		Date date = new Date();
		long time = date.getTime() - dateAge.getTime();
		time = time / 1000 / 60 / 60 / 24;
		if (time <= 30) {
			patientAge = time + "D";
		} else if (30 < time && time < 365) {
			patientAge = time / 30 + "M";
		} else {
			patientAge = time / 365 + "Y";
		}
		return patientAge;
	}

	// 获得10位时间戳
	public static String getTimeStampten() {
		Long timeMillis = System.currentTimeMillis();
		return Long.toString(timeMillis).substring(0, 10);
	}

	public static String getTimeStamp() {
		Long timeMillis = System.currentTimeMillis();
		return Long.toString(timeMillis);
	}

	public static String getStringTime(String time, String type) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type);
		try {
			Date dateAge = simpleDateFormat.parse(time);
			SimpleDateFormat simpleDateFormats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return simpleDateFormats.format(dateAge);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 多天前
	public static String getBeforeDate(Integer day) {
		Calendar c = Calendar.getInstance();
		// 过去七天
		c.setTime(new Date());
		c.add(Calendar.DATE, -day);
		Date d = c.getTime();
		String time = DateToStr(d, "yyyy-MM-dd HH:mm:ss");
		return time;
	}
	public static String getBeforeHours(Integer hours) {
		Calendar c = Calendar.getInstance();
		// 过去七天
		c.setTime(new Date());
		c.add(Calendar.HOUR, -hours);
		Date d = c.getTime();
		String time = DateToStr(d, "yyyy-MM-dd HH:mm:ss");
		return time;
	}
	public static void main(String[] args) {

	}
}
