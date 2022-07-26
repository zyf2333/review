package com.example.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author zyf
 * @Description
 * @ClassName LambdaTester2
 * @Date 2020/9/6 20:56
 **/
public class LambdaTester2 {

    public static void main(String[] args) {
//        Integer age = 10;
//        String a = "a";
//
//        a = "c";
//        Person person = (msg) -> "Str:" + msg+",age:"+age;
//        System.out.println(person.say("a"));

        List<Integer> list = Arrays.asList(1, 33, 22, 22, 4, 6, 44);
        list.stream().map(item -> item+=1).forEach(i-> System.out.println(i));

    }


}

@FunctionalInterface
interface Person {
   String say(String msg);
}
