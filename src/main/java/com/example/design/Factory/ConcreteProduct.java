package com.example.design.Factory;

/**
 * @Author zyf
 * @Description
 * @ClassName ConcreteProduct
 * @Date 2020/8/4 23:03
 **/
public class ConcreteProduct implements Product{
    @Override
    public void show() {
        System.out.println("product1");
    }
}
