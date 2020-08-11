package com.example.design.adapter;

/**
 * @Author zyf
 * @Description
 * @ClassName AdapterTest
 * @Date 2020/8/5 19:53
 **/
public class AdapterTest {

    public static void main(String[] args) {
        Target adapter = new Adapter();
        test(adapter);

        Adaptee adaptee = new Adapter();
        ObjectAdapter objectAdapter = new ObjectAdapter(adaptee);
        test(objectAdapter);
    }
    public static void test(Target target){
        target.request();
    }
}
