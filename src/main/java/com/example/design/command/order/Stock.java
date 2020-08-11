package com.example.design.command.order;

/**
 * @Author zyf
 * @Description 真正的业务实现者
 * @ClassName Stock
 * @Date 2020/8/6 16:29
 **/
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+",Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+",Quantity: " + quantity +" ] sold");
    }
}
