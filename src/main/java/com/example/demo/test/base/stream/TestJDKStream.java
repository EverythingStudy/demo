package com.example.demo.test.base.stream;

import com.example.demo.test.base.bean.Album;
import com.example.demo.test.base.bean.Artist;
import com.example.demo.test.base.bean.Track;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * @Description JDK1.8 Stream流新特性
 * @Date 2019/11/27 13:19
 * @Author cly
 **/
public class TestJDKStream {

    static List<TestJDKStream.Person> personList = new ArrayList<>();

    static {
        personList.add(new TestJDKStream.Person("chen", 10));
        personList.add(new TestJDKStream.Person("lin", 15));
        personList.add(new TestJDKStream.Person("ya", 16));
    }

    @Test
    public void streamTest() {
        List<TestJDKStream.Person> list = new ArrayList<>();
        Stream<TestJDKStream.Person> person = TestJDKStream.personList.stream().filter(s -> s.getAge() == 10);
        //获取流结果
        list = person.collect(Collectors.toList());
        System.out.println(list.size());
    }

    @Test
    public void test1() {
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        //断言--boolean型参数，为flase会出现assertEerro
        assert (Arrays.asList("a", "b", "c").equals(collected));
    }

    @Test
    public void testMap() {
        List<String> collected = Stream.of("a", "b", "c").map(date -> {
            return date.toUpperCase();
        }).collect(Collectors.toList());
        collected.forEach(a -> System.out.println(a));
    }

    @Test
    public void testFilter() {
        List<String> collected = Stream.of("a", "b", "c").filter(string -> string.equals("a")).collect(Collectors.toList());
        collected.forEach(string -> System.out.println(string));
    }

    @Test
    public void testFlatMap() {
        List<Integer> collected = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        collected.forEach(string -> System.out.println(string));
    }

    @Test
    public void testComparing() {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        System.out.println(tracks.stream().max(Comparator.comparing(Track::getLength)).get().getName());
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO 整合使用stream
     * @Date 10:51 2020/5/27
     * @Param []
     **/
    @Test
    public void testIntegration() {
        List<Artist> artists = Arrays.asList(new Artist("theABC", "", "", "中国"), new Artist("theDEF", "", "", "美国"), new Artist("pcf", "", "", "日本"));
        List<Album> albums = Arrays.asList(new Album("test", null, artists));
        albums.stream().forEach(album -> {
            album.getMusicians().stream().filter(artist -> artist.getName().startsWith("the")).map(artist -> artist.getNationallity()).forEach(m -> System.out.println(m));
        });
    }

    @Test
    public void testMake() {
        List<Album> albums = new ArrayList<>();
        Set<String> trackNames = new HashSet<>();
        //albums.stream().forEach(album -> {album.getTracks().stream().filter(track -> track.getLength()>60).forEach(track -> trackNames.add(track.getName()));});
        Set<String> trackNamesSet = albums.stream().flatMap(album -> album.getTracks().stream()).filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(toSet());
    }

    @Test
    public void reduceTest() {
        int count = Arrays.asList(1, 2, 3).stream().reduce(0, (a, b) -> a + b);
        System.out.println(count);
    }

    static class Person {
        private String name;
        private int age;

        Person(String name, Integer age) {
            this.name = name;
            this.age = age;
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
    }

    /**
     * @Author cly
     * @Description //TODO 替换集合中数据
     * @Date 11:06 2020/6/29
     * @Param []
     * @return void
     **/
    @Test
    public void exchangeTest(){
        //personList.stream().map(person -> { person.setName("chenlinya");return getP(person);}).forEach(person -> System.out.println(person.getName()));
        personList.stream().map(person -> getP(person)).forEach(person -> System.out.println(person.getName()));
    }
    public Person getP(Person person){
        person.setName("chenlinya");
        return person;
    }
}
