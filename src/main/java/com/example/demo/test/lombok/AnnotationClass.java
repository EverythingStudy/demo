package com.example.demo.test.lombok;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * @Description
 * @Date 2020/1/30 11:54
 * @Author cly
 **/
@EqualsAndHashCode
public class AnnotationClass {
    private String name;

    public String annoNoNull(@NonNull String data){
        return data;
    }
}
