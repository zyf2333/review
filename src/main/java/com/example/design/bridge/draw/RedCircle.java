package com.example.design.bridge.draw;

/**
 * @Author zyf
 * @Description
 * @ClassName RedCircle
 * @Date 2020/8/5 22:55
 **/
public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
