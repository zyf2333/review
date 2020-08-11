package com.example.design.adapter;

/**
 * @Author zyf
 * @Description
 * @ClassName Adapter
 * @Date 2020/8/5 19:53
 **/
public class Adapter extends Adaptee implements Target{

    @Override
    public void request() {
        this.specificRequest();
    }
}
