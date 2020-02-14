package com.example.demo.test.design.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Description
 * @Date 2020/2/13 16:58
 * @Author cly
 **/
public class FECourse extends TemplateMethod {
    Logger logger = LoggerFactory.getLogger(FECourse.class.getName());
    boolean needWriteArticle = false;

    FECourse(boolean needWriteArticle) {
        this.needWriteArticle = needWriteArticle;
    }

    @Override
    protected boolean needWriteArticle() {
        return this.needWriteArticle;
    }

    @Override
    void packageCourse() {
        System.out.println("提供课程的前端代码");
        System.out.println("提供课程的图片等多媒体素材");
    }

}
