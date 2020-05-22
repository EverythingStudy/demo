package com.example.demo.test.Base;

import com.example.demo.test.util.DBConnection;
import com.example.demo.test.util.DateTypeUtility;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * @Description
 * @Date 2019/8/26 15:11
 **/
public class Test {
    DateTypeUtility dateTypeUtility;
    Test(DateTypeUtility dateTypeUtility){
       this.dateTypeUtility=dateTypeUtility;
    }
    DBConnection dbConnection;
    Test(DBConnection dbConnection){
        this.dbConnection=dbConnection;
    }
    @org.junit.Test
    public void contextLoads() {
        String date="20100913000000";
        System.out.println(DateTypeUtility.DateToStr(DateTypeUtility.StrToDate(date,"yyyyMMddhhmmss"),"yyyy-MM-dd "));
        String d="";
    }

    public static void main(String[] args) {
        int k=0;
        System.out.println(k++==1);
        System.out.println(k);
        int j=0;
        System.out.println(++j==1);
        System.out.println(j);

        String[] nameArray={"1","2"};
        Arrays.sort(nameArray,(a,b)->a.compareToIgnoreCase(b));

        List<String> lists=new ArrayList<>();
        //List<String> idList=lists.stream().map()
    }

}
