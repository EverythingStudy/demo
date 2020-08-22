package com.example.demo.test.Spring.annotation.configuration;

import com.example.demo.test.Spring.yaml.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @Description
 * @ConfigurationProperties 与@Bean一起使用可以直接给Bean赋值
 *
 * @Date 2020/2/23 11:36
 * @Author cly
 **/
@Configuration
public class ConfigurationPropertiesTest {

    private String configurationType;
    @Bean
    @ConfigurationProperties(prefix = "confige")
    public Confige getConfiger(){
        return new Confige();
    }
}
