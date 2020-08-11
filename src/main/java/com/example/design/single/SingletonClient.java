package com.example.design.single;

/**
 * @Author zyf
 * @Description
 * @ClassName SingletonClient
 * @Date 2020/8/4 22:05
 **/
public class SingletonClient {
    public static void main(String[] args) {
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        System.out.println(lazySingleton1);
        System.out.println(lazySingleton2);
        System.out.println(hungrySingleton1);
        System.out.println(hungrySingleton2);
        LazySingleton c = null;
        try {
            c = lazySingleton1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(c);


    }
}
