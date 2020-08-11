package com.example.design.bridge.draw;

/**
 * @Author zyf
 * @Description
 * @ClassName Circle
 * @Date 2020/8/5 22:57
 **/
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
