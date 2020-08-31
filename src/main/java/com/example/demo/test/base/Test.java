package com.example.demo.test.base;

import com.example.demo.test.util.DBConnection;
import com.example.demo.test.util.DateTypeUtility;

import java.util.*;
import java.util.function.BinaryOperator;

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
    static BinaryOperator<Long> addExplicit = (Long x, Long y) -> x - y;
    public static void main(String[] args) {

        System.out.println(addExplicit.apply(1L,2L));
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
