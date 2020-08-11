package com.example.design.builder;

/**
 * @Author zyf
 * @Description
 * @ClassName BuilderTest
 * @Date 2020/8/4 23:35
 **/
public class BuilderTest {

    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product construct = director.construct();
        System.out.println(construct);
    }
}
