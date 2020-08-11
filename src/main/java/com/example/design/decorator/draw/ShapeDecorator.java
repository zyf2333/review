package com.example.design.decorator.draw;

/**
 * @Author zyf
 * @Description
 * @ClassName ShapeDecorator
 * @Date 2020/8/5 23:30
 **/
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
