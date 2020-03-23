package com.example.demo.test.Spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Author cly
 * @Description //TODO 自定义注解固定格式
 * @Date 11:05 2020/2/12
 * @Param 
 * @return 
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnnotationTest {
    String value();
    boolean flag() default true;
}
