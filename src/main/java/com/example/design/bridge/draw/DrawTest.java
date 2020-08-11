package com.example.design.bridge.draw;

/**
 * @Author zyf
 * @Description
 * @ClassName DrawTest
 * @Date 2020/8/5 22:59
 **/
public class DrawTest {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
