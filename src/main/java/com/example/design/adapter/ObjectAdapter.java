package com.example.design.adapter;

/**
 * @Author zyf
 * @Description
 * @ClassName ObjectAdapter
 * @Date 2020/8/5 20:15
 **/
public class ObjectAdapter implements Target{

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
