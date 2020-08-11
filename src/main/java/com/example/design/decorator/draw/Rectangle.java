package com.example.design.decorator.draw;

/**
 * @Author zyf
 * @Description
 * @ClassName Rectangle
 * @Date 2020/8/5 23:30
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
