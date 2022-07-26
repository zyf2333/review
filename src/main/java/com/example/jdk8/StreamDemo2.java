package com.example.jdk8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @Author zyf
 * @Description
 * @ClassName StreamDemo2
 * @Date 2020/9/6 22:22
 **/
public class StreamDemo2 {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person(1, 15, "a"),
                new Person(3, 12, "b"),
                new Person(2, 10, "c"),
                new Person(4, 13, "d")
        );

        List<Person> collect = list.stream()
//                .filter(p -> p.getAge() > 12)
                .map(o->{
                    o.setId(o.getId()+1);
                    return o;
                })
                .sorted(Comparator.comparingInt(Person::getAge))
//                .skip(1)
//                .limit(2)
                .collect(Collectors.toList());
        System.out.println(collect);

        boolean b = list.stream().allMatch(o -> o.getAge() > 1);
        System.out.println(b);


        Optional<Person> first = list.stream().findFirst();
        System.out.println(first.get());

//        ArrayList<Object> collect1 = list.stream().mapToInt(o -> o.getId())
//                .collect(Collectors.toList());


    }

    static  class Person{

        private Integer id;

        private Integer age;

        private String name;

        public Person(Integer id, Integer age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}


