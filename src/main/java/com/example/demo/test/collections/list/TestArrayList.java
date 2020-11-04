package com.example.demo.test.collections.list;


import org.junit.Test;

import java.util.*;

/**
 * @Description ArrayList测试
 * //TODO 1.底层数据结构为数组 2.默认长度为10，可以指定长度。如果长度不够扩容默认为1.5倍int newCapacity = oldCapacity + (oldCapacity >> 1);
 * //TODO 3.线程不安全
 * //todo
 * @Date 2019/11/24 16:45
 * @Author cly
 **/
public class TestArrayList {

    class Person {
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
            System.out.println();
        }
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO 对象排序 自定义实现
     * @Date 9:39 2019/11/27
     * @Param []
     **/

    @Test
    public void testSort() {
        List<TestArrayList.Person> listSort = new ArrayList();
        listSort.add(new TestArrayList.Person("chen", 16));
        listSort.add(new TestArrayList.Person("li", 10));
        listSort.add(new TestArrayList.Person("chen", 15));
        //按照年龄排序
        listSort.sort(new Comparator<TestArrayList.Person>() {
            @Override
            public int compare(TestArrayList.Person o1, TestArrayList.Person o2) {
                return o1.age - o2.age;
            }
        });
        //自定义数组排序规则
        Person[] psersons = {new TestArrayList.Person("chen", 16), new TestArrayList.Person("li", 10), new TestArrayList.Person("chen", 15)};
        Arrays.sort(psersons, new TestArrayList.Com());
        //lambada表达式
        Person[] arrs = {new TestArrayList.Person("chen", 16), new TestArrayList.Person("chen", 10), new TestArrayList.Person("chen", 15)};
        Arrays.sort(arrs, (Person o1, Person o2) -> o1.age - o2.age);
        //删除集合中元素
        // 1.不会发生异常，但是删除元素后 索引的顺序会变化，导致遍历数据不准确
        for (int k = 0; k < listSort.size(); k++) {
            if (listSort.get(k).age == 10) {
                listSort.remove(k);
                //continue;
            }
            System.out.println(k);
        }
        //2.增强for循环删除，当删除一个元素后再遍历会报出ConcurrentModificationException，可有再删除一个元素后跳出，删除多个就没办法了，所以不用删除
        for (TestArrayList.Person person : listSort) {
            if (person.age == 10) {
                listSort.remove(person);
                // continue;
            }
            System.out.println(listSort.indexOf(person));
        }
        //3.迭代器遍历删除才是正确的方式，理解一下迭代器源码
        Iterator<TestArrayList.Person> iterator = listSort.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAge() == 10) {
                iterator.remove();
            }
        }
    }

    //自定义排序方式
    class Com implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            TestArrayList.Person person1 = (Person) o1;
            TestArrayList.Person person2 = (Person) o2;
            return person1.getAge() - person2.getAge();
        }
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO list迭代器
     * @Date 14:34 2019/11/27
     * @Param []
     **/
    @Test
    public void listIterator() {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        //普通迭代器，只能向下迭代
        Iterator<String> iterator = list.iterator();

        /*双向迭代器
        * @Description //TODOLIstIterator是一个更加强大的Iterator的子类型,它只能用于各种List类的访问
        *  ListIterator可以双向移动,它还可以产生相对于迭代器在列表指向的当前位置的前一个和后一个元素的索引,
        *  并且可以使用set()方法替换它访问过的最后一个元素.
        *  你可以通过ListIterator()方法产生一个指向List开始处的ListIteraor,
        *  并且还可以通过调用ListIterator(n)方法创建一个一开始就指向索引列表n的元素处的ListIterator
        *   boolean hasNext();     //检查是否有下一个元素
            E next();              //返回下一个元素
            boolean hasPrevious(); //check是否有previous(前一个)element(元素)
            E previous();          //返回previous element
            int nextIndex();       //返回下一element的Index
            int previousIndex();   //返回当前元素的Index
            void remove();         //移除一个elment
            void set(E e);         //set()方法替换访问过的最后一个元素 注意用set设置的是List列表的原始值
            void add(E e);         //添加一个element
        **/
        ListIterator<String> listIterator = list.listIterator();

        ListIterator<String> listIteratorSize = list.listIterator(1);
        if (listIteratorSize.hasNext()) {
            System.out.println(listIteratorSize.previous());
            // System.out.println();
        }
    }

    @Test
    public void listMethod() {
        System.out.println(4 >> 1);
    }

    /**
     * @return void
     * @Author cly
     * @Description //TODO 去重listen
     * @Date 18:15 2020/4/23
     * @Param [list]
     **/
    public static void removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        System.out.println(" remove duplicate " + list);
    }

    public static void main(String[] args) {
        //数组转化为集合
        String[] String0 = {"1", "2"};
        List list1 = Arrays.asList(String0);
        System.out.println(list1);
        //两个数组合并
        String[] a = {"1", "2", "3"};
        String[] b = {"1", "4", "5"};
        String[] c = new String[a.length + b.length];
        //Arrays.c
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        for (String s : c) {
            System.out.println(s);
        }
        //两个list集合合并
        List<Integer> e = new ArrayList<Integer>();
        List<Integer> f = new ArrayList<Integer>();
        e.add(1);
        e.add(2);
        e.add(3);
        e.add(3);
        f.add(4);
        f.add(5);
        f.add(6);
        //e.addAll(f);
        System.out.println("e:" + e);
        //两个list集合合并为有序
        List list = sort(e, f);
        System.out.println("list:" + list);
    }

    public static List sort(List<Integer> e, List<Integer> f) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < e.size() && j < f.size()) {
            if (e.get(i) < f.get(j)) {
                list.add(e.get(i++));
            } else {
                list.add(f.get(j++));
            }
        }
        while (i < e.size()) {
            list.add(e.get(i++));
        }
        while (j < f.size()) {
            list.add(f.get(j++));
        }
        return list;
    }
}
