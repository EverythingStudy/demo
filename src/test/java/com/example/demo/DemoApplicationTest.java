package com.example.demo;

import com.example.demo.test.Spring.annotation.configuration.Confige;
import com.example.demo.test.Spring.bean.Company;
import com.example.demo.test.Spring.bean.CompanyTestBean;
import com.example.demo.test.Spring.entity.Swaggerperson;
import com.example.demo.test.Spring.service.SwaggerpersonService;
import com.example.demo.test.Spring.yaml.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.example.demo.test.Spring.dao")
@SpringBootTest
public class DemoApplicationTest {
    @Autowired
    Confige confige;
    @Autowired
    Person person;
    @Autowired
    SwaggerpersonService swaggerpersonService;
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

    @Before
    public void start(){
        System.out.println("start==");
    }
    @After
    public void end(){
        System.out.println("end===");
    }
    //自己实现多线程
    @Test
    public void threadPoolBySelf(){
        long begin=System.currentTimeMillis();
        Swaggerperson swaggerperson=new Swaggerperson();
        swaggerperson.setName("王稳娜");
        swaggerperson.setPhoneNum("1353027");
        Swaggerperson swaggerpersonS=swaggerpersonService.insert(swaggerperson);
        System.out.println("一共用了"+(System.currentTimeMillis()-begin)+"秒");
        System.out.println(swaggerpersonS.toString());
    }


}
