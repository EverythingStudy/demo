package com.example.demo;

import lombok.Value;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableTransactionManagement// 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@SpringBootApplication
@MapperScan("com.example.demo.test.Spring.dao")////扫描mapper.xml文件
@EnableCaching
@RestController
public class DemoApplication {

    private static  ConfigurableApplicationContext context;
    private static String[] args;
    public static void main(String[] args) {
        DemoApplication.args = args;
        DemoApplication.context=SpringApplication.run(DemoApplication.class, args);
    }
    @RequestMapping(value = "restart",method = RequestMethod.GET)
    public void restart(){
       Thread thread=new Thread(()->{
           DemoApplication.context.close();
           DemoApplication.context=SpringApplication.run(DemoApplication.class,DemoApplication.args);
       });
       thread.start();
    }
}
