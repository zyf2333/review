package com.example.design.builder;

/**
 * @Author zyf
 * @Description 具体建造者
 * @ClassName ConcreteBuilder
 * @Date 2020/8/4 23:33
 **/
public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("建造 PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartA("建造 PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartA("建造 PartC");
    }
}
