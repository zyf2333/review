package com.example.design.decorator.draw;

/**
 * @Author zyf
 * @Description
 * @ClassName RedShapeDecorator
 * @Date 2020/8/5 23:32
 **/
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
