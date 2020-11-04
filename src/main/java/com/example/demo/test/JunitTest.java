package com.example.demo.test;

import com.example.demo.test.Spring.yaml.Person;
import org.apache.catalina.mbeans.ContextEnvironmentMBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description //TODO 单元测试用例
 * @Date 2020/8/25 18:21
 * @Author cly
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {
    @Autowired
    Person person;
    @Autowired
    private Environment environment;
    @Test
    public void intToString(){

        System.out.println(environment.getProperty("person.name"));
        String test="155";
        System.out.println(Integer.valueOf(test));
    }
}
