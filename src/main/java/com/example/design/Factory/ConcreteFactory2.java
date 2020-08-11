package com.example.design.Factory;

/**
 * @Author zyf
 * @Description
 * @ClassName ConcreteFactory
 * @Date 2020/8/4 23:04
 **/
public class ConcreteFactory2 implements AbstractFactory{
    @Override
    public Product newProduct() {
        return new ConcreteProduct2();
    }
}
