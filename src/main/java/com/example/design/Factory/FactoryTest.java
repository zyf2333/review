package com.example.design.Factory;

/**
 * @Author zyf
 * @Description
 * @ClassName FactoryTest
 * @Date 2020/8/4 23:04
 **/
public class FactoryTest {

    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory2();
        Product product = factory.newProduct();
        product.show();
    }
}
