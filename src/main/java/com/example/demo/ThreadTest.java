package com.example.demo;

/**
 * @Author zyf
 * @Description
 * @ClassName ThreadTest
 * @Date 2020/5/21 17:19
 **/
public class ThreadTest {
    public static Integer count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                new ThreadTest().add();
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(ThreadTest.count);
    }

    public synchronized void add(){
//        this.count = ++this.count;
        ThreadTest.count = ++ThreadTest.count;
        System.out.println(Thread.currentThread().getName()+":"+ThreadTest.count);
    }

}
