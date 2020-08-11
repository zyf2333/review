package com.example.jdk8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author zyf
 * @Description
 * @ClassName StreamDemo
 * @Date 2020/7/29 20:08
 **/
public class StreamDemo {
    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
//
//        long a = System.currentTimeMillis();
//        List<String> collect = list.parallelStream()
//                .map((integer) -> {
//                    //System.out.println(Thread.currentThread().getName());
//                    return Integer.toString(++integer);
//                })
//                .collect(Collectors.toList());
//        System.out.println(collect);
//
//        long b = System.currentTimeMillis();
//        System.out.println(b - a);
//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);
//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//// 获取对应的平方数
//        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
//        System.out.println(squaresList);
        long c = System.currentTimeMillis();
        List<Student> list = new ArrayList<>();
        List<Map<String,Object>> mList = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            list.add(new Student(i + "", i + "", i + ""));
            Map<String, Object> map = new HashMap<>();
            map.put("id", ""+i);
            mList.add(map);
        }
        long d = System.currentTimeMillis();
        System.out.println(d-c);


        long a = System.currentTimeMillis();
        Map<String, Student> collect = list.stream().collect(Collectors.toMap(
                student -> student.getId(),
                student -> student
        ));
        System.out.println(collect.size());
        mList.stream().forEach(x -> {
            String id = (String) x.get("id");
            Student student = collect.get(id);
            x.put("student", student);
        });
//        System.out.println(collect);
        long b = System.currentTimeMillis();
        System.out.println(b - a);

    }
}

class Student {
    private String id;

    private String name;

    private String age;

    public Student(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
