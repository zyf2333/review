package com.example.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author zyf
 * @Description
 * @ClassName ConcurrentModifi
 * @Date 2020/8/27 20:18
 **/
public class ConcurrentModifi {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.add("d");
        strs.add("e");
        strs.add("f");

//        for (int i = 0; i < strs.size(); i++) {
//            if(strs.get(i).equals("a")||strs.get(i).equals("c")){
//                strs.remove(i);
//            }
//        }

        //每次size会变，结果是b,d,f
//        for (int i = 0; i < strs.size(); i++) {
//            strs.remove(i);
//        }

        //会抛出并发修改异常
//        for (String str : strs) {
//            if (str.equals("a")) {
////                strs.remove(1);
//                strs.remove(str);
//            }
//        }
//        Iterator<String> iterator = strs.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            iterator.remove();
//        }
        new Thread(() -> {
//            synchronized (ConcurrentModifi.class){
                Iterator<String> iterator = strs.iterator();
                while (iterator.hasNext()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    iterator.next();
                    iterator.remove();
                }
//            }
        }, "Thread-1").start();
        new Thread(() -> {
//            synchronized (ConcurrentModifi.class){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Iterator<String> iterator = strs.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
//            }
        }, "Thread-2").start();

        System.out.println(strs);
    }
}
