package com.example.demo.test.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @Description 时间工具类
 * 1.8中 时间类：LocalDate为日期处理类、LocalTime为时间处理类、LocalDateTime为日期时间处理类
 * DateTimeFormatter 线程安全的时间转化工具，SimpleDateFormat线程不安全
 * LocalDateTime
 * TimeUtil
 * @Date 2020/2/24 10:39
 * @Author cly
 **/
public class DateTimeFormatterUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static Logger logger = LoggerFactory.getLogger(DateTimeFormatterUtil.class);

    public static String formateDate(LocalDateTime time) {
        return formatter.format(time);
    }

    public static LocalDateTime parse(String dateString) {
        return LocalDateTime.parse(dateString, formatter);
    }

    public String dateNow() {
        LocalDateTime LocalDate = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return dateTimeFormatter.format(LocalDate);
    }

    @Test
    public void testTime() {
        System.out.println(dateNow());
    }

    public static void main(String[] args) {
        DateTimeFormatterUtil.formateDate(LocalDateTime.now());
        logger.info(formatter.format(LocalDateTime.now()));
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(formatter.format(LocalDateTime.now()));
        //LocalDateTime localDateTime=DateTimeFormatterUtil.parse("2020/12/12");
        //System.out.println(DateTimeFormatterUtil.formateDate(localDateTime));
    }
}
