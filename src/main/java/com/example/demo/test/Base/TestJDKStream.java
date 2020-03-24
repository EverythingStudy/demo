package com.example.demo.test.Base;

import com.example.demo.test.collections.TestArrayList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description JDK1.8 Stream流新特性
 * @Date 2019/11/27 13:19
 * @Author cly
 **/
public class TestJDKStream {
    static List<TestJDKStream.Person> personList=new ArrayList<>();
    static class Person{
        private String name;
        private int age;
        Person(String name,Integer age){
            this.name=name;
            this.age=age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static {
        personList.add(new TestJDKStream.Person("chen",10));
        personList.add(new TestJDKStream.Person("lin",15));
        personList.add(new TestJDKStream.Person("ya",16));
    }

    @Test
    public void streamTest(){
        List<TestJDKStream.Person> list=new ArrayList<>();
        Stream<TestJDKStream.Person> person=TestJDKStream.personList.stream().filter(s->s.getAge()==10);
        //获取流结果
        list=person.collect(Collectors.toList());
        System.out.println(list.size());
    }

}
