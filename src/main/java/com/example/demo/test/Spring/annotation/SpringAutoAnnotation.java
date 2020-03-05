package com.example.demo.test.Spring.annotation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2020/2/14 13:05
 * @Author cly
 **/
@RestController
@AnnotationType(value = "pepole")
public class SpringAutoAnnotation {

    @PostMapping(value ="postController")
    public void postController(){}
}
