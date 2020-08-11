package com.example.design.bridge.draw;

/**
 * @Author zyf
 * @Description
 * @ClassName GreenCircle
 * @Date 2020/8/5 22:55
 **/
public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
