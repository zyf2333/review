package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zyf
 * @Description
 * @ClassName MapTest
 * @Date 2020/5/20 18:32
 **/
public class MapTest {
//    static final HashMap<String, Object> map = new HashMap<>(1000);
    static Map<String,Object> map = new ConcurrentHashMap();
    public static void main(String[] args) {
        for (int i = 0; i < 3000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    map.put(UUID.randomUUID().toString(), j);
                    System.out.println(Thread.currentThread().getName()+":"+ j);
                }
            }).start();
        }
        System.out.println(map);
    }
}
