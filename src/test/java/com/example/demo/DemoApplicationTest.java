package com.example.demo;

import com.example.demo.test.Spring.annotation.configuration.Confige;
import com.example.demo.test.Spring.bean.Company;
import com.example.demo.test.Spring.bean.CompanyTestBean;
import com.example.demo.test.Spring.yaml.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Date 2020/2/21 16:19
 * @Author cly
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest {
    @Autowired
    Confige confige;
    @Autowired
    Person person;
    @Test
    public void test(){
        System.out.println(person);
    }

    @Test
    public void setConfige(){
        System.out.println(confige);
    }

    @Test
    public void getCompany(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(Company.class);
        CompanyTestBean configes= (CompanyTestBean) annotationConfigApplicationContext.getBean("init");
        System.out.println(configes);
    }
}
