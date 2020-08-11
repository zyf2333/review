package com.example.design.single;

/**
 * @Author zyf
 * @Description
 * @ClassName HungrySingleton
 * @Date 2020/8/4 22:08
 **/
public class HungrySingleton {

    private static final HungrySingleton INSTANCE = new HungrySingleton();
    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return INSTANCE;
    }
}
