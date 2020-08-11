package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Author zyf
 * @Description
 * @ClassName AsyncService
 * @Date 2020/7/23 0:35
 **/
@Service
public class AsyncService {
    @Async
    public void longtime() {
        System.out.println("s:我在执行一项耗时任务"+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("s:完成");

    }

    @Async
    public Future<Integer> longtime2() {
        System.out.println("s:我在执行一项耗时任务"+Thread.currentThread().getName());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("s:完成");
        return new AsyncResult<>(123);
    }
}
