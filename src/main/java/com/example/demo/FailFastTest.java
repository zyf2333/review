package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author zyf
 * @Description
 * @ClassName FailFastTest
 * @Date 2020/7/20 20:34
 **/
public class FailFastTest {

    public static final Map<String, Object> MAP = new HashMap<>();

    public static void main(String[] args) {
        ExecutorService cachedThreadPool =
                new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                        60L, TimeUnit.SECONDS,
                        new SynchronousQueue<>());
        for (int j = 0; j < 100; j++) {

            cachedThreadPool.execute(() -> {
                for (int i = 0; i < 10000; i++) {
                    MAP.put(Thread.currentThread().getName(), i);
                }
                System.out.println(MAP);
            });
        }

    }


}
