package com.example.demo.test.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JDK8中stream流操作集合
 */
public class TestStream {
class Person{
    public String name;
    public int age;

     Person() {
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
@Test
    public void CollectionStream(){
      List<Person> list=new ArrayList<>();
      TestStream.Person person=new TestStream.Person();
      person.setAge(10);
      list.add(person);
      Stream<Person> StringStream=list.stream().filter(s-> s.age==10);
      List<Person> personList=StringStream.collect(Collectors.toList());
      System.out.println(personList.get(0).getAge());

    }
}
