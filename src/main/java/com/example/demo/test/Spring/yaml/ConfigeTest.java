package com.example.demo.test.Spring.yaml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Date 2020/9/23 15:02
 * @Author cly
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigeTest {
    @Autowired
    Person person;
    @Autowired
    private Environment environment;
    @Test
    public void intToString(){
        System.out.println(environment.getProperty("person.name"));

    }
}
