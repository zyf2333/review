package com.example.design.decorator.draw;

/**
 * @Author zyf
 * @Description
 * @ClassName Circle
 * @Date 2020/8/5 23:30
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
