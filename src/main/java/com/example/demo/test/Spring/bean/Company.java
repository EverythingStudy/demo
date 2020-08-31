package com.example.demo.test.Spring.bean;

import com.example.demo.test.Spring.annotation.configuration.Confige;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * javaConfig
 * @Description @Bean的方式实现配置，可以完全替代XML的方式定义。
 * 1.@Configuration等同于<beans></beans>
 * 2.@Bean等同于<bean></bean>
 * 3.通过AnnotationConfigApplicationContext来加载JavaConfig
 * 4.方法名init()就等同于<bean>中的id，默认方法名就是beanName
 *
 * 点击进入@Bean注解可以查看其他属性：initMethod destroyMethod
 * 1.name属性等同于<bean>的name
 * 2.initMethod属性等同于<bean>的init-method,当获取bean的时候init()方法被执行，此方法在构造方法之前执行。
 * 3.destroyMethod属性等同于<bean>的destroy-method,在容器被销毁的时候，执行了destroy()方法
 * 4.scope这个比较奇怪，不属于@Bean的参数，这是一个单独的注解，singleton/prototype
 *
 * @Date 2020/2/23 15:24
 * @Author cly
 **/
@Configuration
public class Company {
    @Bean(initMethod = "initMethod")
    @Scope(value = "singleton")
    public CompanyTestBean init(){
      return new CompanyTestBean("bean","Company");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(Company.class);
        CompanyTestBean configes= (CompanyTestBean) annotationConfigApplicationContext.getBean("init");
        System.out.println(configes);
    }
}
