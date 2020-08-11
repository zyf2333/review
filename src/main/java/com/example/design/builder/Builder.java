package com.example.design.builder;

/**
 * @Author zyf
 * @Description 抽象建造者
 * @ClassName Builder
 * @Date 2020/8/4 23:32
 **/
public abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }
}
