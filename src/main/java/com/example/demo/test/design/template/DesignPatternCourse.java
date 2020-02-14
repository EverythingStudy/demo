package com.example.demo.test.design.template;

/**
 * @Description
 * @Date 2020/2/13 17:15
 * @Author cly
 **/
public class DesignPatternCourse extends TemplateMethod {
    @Override
    void packageCourse() {
        System.out.println("提供课程Java源代码");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }

}
