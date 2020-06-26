package com.example.demo.test.base.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Date 2020/5/26 18:22
 * @Author cly
 **/
@Setter
@Getter
public class Artist {
    private String name;
    private String members;
    private String origin;
    private String nationallity;
    public Artist(String name,String members,String origin,String nationallity){
        this.name=name;
        this.members=members;
        this.origin=origin;
        this.nationallity=nationallity;
    }
}
