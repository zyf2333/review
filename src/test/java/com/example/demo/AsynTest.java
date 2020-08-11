package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author zyf
 * @Description Async
 * @ClassName AsynTest
 * @Date 2020/7/23 0:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsynTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        System.out.println("main:main函数开始执行");
        System.out.println("main:"+Thread.currentThread().getName());
        Future<Integer> future = asyncService.longtime2();
        System.out.println("main:"+"main函数执行结束");
//        while (true) {  ///这里使用了循环判断，等待获取结果信息
//            if (future.isDone()) {  //判断是否执行完毕
//                System.out.println("main:"+"Result from asynchronous process - " + future.get());
//                break;
//            }
//            Thread.sleep(1000);
//        }
        System.out.println("main:"+"Result from asynchronous process - " + future.get());
        System.out.println("main:end");
    }



}
