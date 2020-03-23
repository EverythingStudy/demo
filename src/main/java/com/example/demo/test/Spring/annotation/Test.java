package com.example.demo.test.Spring.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 使用自定义的Annotation注解
 * @Date 2020/2/12 11:05
 * @Author cly
 **/
@Controller(value = "test")
@AnnotationType(value = "pepole")
public class Test {
    @AnnotationTest(value="test")
    public String name(){
        return "wangwenna";
    }

    @AnnotationTest(value="test",flag = false)
    public int age(@AnnotationParameter(value = true) boolean flag){
        return 15;
    }
}
