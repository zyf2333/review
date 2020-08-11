package com.example.design.single;

/**
 * @Author zyf
 * @Description
 * @ClassName Single
 * @Date 2020/8/4 20:13
 **/
public class LazySingleton implements Cloneable{
    private static volatile LazySingleton singleton;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    @Override
    public LazySingleton clone() throws CloneNotSupportedException {
        return (LazySingleton) super.clone();
    }
}
