package com.example.demo.test.concurrent.bean;

import java.util.Objects;

/**
 * @Description
 * @Date 2020/3/10 14:15
 * @Author cly
 **/
public class User {
    private String name;
    private String phon;

    public User(String name, String phon) {
        this.name = name;
        this.phon = phon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(phon, user.phon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phon);
    }
}
