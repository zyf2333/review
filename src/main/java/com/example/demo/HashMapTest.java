package com.example.demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zyf
 * @Description
 * @ClassName HashMapTest
 * @Date 2020/7/20 16:48
 **/
public class HashMapTest {
    public static void main(String[] args) {

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put(null,null);
        hashMap.put("a",null);
        hashMap.put(null,123);
        System.out.println(hashMap);



        Map<String, Object> hashTable = new Hashtable<>();
        int hash = "a".hashCode();
        System.out.println(0x7FFFFFFF);
        System.out.println(0X80000000);
        System.out.println(hash & 0x7FFFFFFF);
        int index = (hash & 0x7FFFFFFF) % 16;
        System.out.println(index);
        hashTable.put("a",null);
        System.out.println(hashTable);
    }
}
