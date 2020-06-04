package com.example.demo.test.base.bean;

/**
 * @Description
 * @Date 2020/5/26 18:22
 * @Author cly
 **/
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getNationallity() {
        return nationallity;
    }

    public void setNationallity(String nationallity) {
        this.nationallity = nationallity;
    }
}
