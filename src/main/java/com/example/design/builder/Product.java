package com.example.design.builder;

/**
 * @Author zyf
 * @Description
 * @ClassName Product
 * @Date 2020/8/4 23:31
 **/
public class Product {
    private String partA;
    private String partB;
    private String partC;
    public void setPartA(String partA)
    {
        this.partA=partA;
    }
    public void setPartB(String partB)
    {
        this.partB=partB;
    }
    public void setPartC(String partC)
    {
        this.partC=partC;
    }
    public void show(){
        System.out.println(partA+partB+partC);
        //显示产品的特性
    }
}
