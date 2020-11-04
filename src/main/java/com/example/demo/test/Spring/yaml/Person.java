package com.example.demo.test.Spring.yaml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description yaml配置文件中获取值：具体可以查看ConfigeTest测试
 * 1.@ConfigurationProperties默认加载配置yml中的person值,指定前缀
 * 2.@PropertySource("classpath:application.yml")+@Value() 指定加载的文件路径,默认加载application.yml
 * 3.所有加载出来的配置都可以通过Environment注入获取到：
 *   @Autowired
 *     private Environment environment;
 *    String getProperty(String key);
 * @Date 2020/2/20 10:59
 * @Author cly
 **/
@Component
//@ConfigurationProperties(prefix = "person")
@PropertySource("classpath:application.yml")
public class Person {
    @Value("${person.name}")
    private String name;
    private int age;
    private Map<String,String> map;
    private List<String> list;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", map=" + map +
                ", list=" + list +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
