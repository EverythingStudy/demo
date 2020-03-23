package com.example.demo.test.design.template;

import org.junit.Test;

/**
 * @Description 模板方法模式--预先定义抽象方法，在子类继承父类时重写实现逻辑
 *
 * 定义一个操作中的算法骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 *
 * 模板模式属于行为型模式
 *
 * 在模板模式中，一个抽象类公开定义了执行它的方法的模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。
 *
 * 代码实现：模拟一个场景，在学习平台上传一套学习资源需要经过一个固定的步骤，如，首先上传PPT，然后上传教学视频，手记等资源。但是视频种类不同，具体细节会有不同。可以先在父类中将可以确定的部分实现，将不同的细节部分定义成接口，交由子类实现。
 * @Date 2020/2/13 16:49
 * @Author cly
 **/


public abstract class TemplateMethod {
    public final void makeCourse(){
        this.makePPT();
        this.makeVideo();
        if(needWriteArticle()){
            writerArticle();
        }
        this.packageCourse();
    }

    final void makePPT(){
        System.out.println("制作PPT");
    }
    final void makeVideo(){
        System.out.println("制作视频");
    }
    final void writerArticle(){
        System.out.println("编写手记");
    }
    // 是否上传手记
    protected abstract boolean needWriteArticle();

    abstract void packageCourse();

    public static void main(String[] args) {
            TemplateMethod templateMethod=new FECourse(false);
            templateMethod.makeCourse();
    }
}
