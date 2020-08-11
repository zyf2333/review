package com.example.thread;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Author zyf
 * @Description
 * @ClassName ThreadWaitDemo
 * @Date 2020/7/28 15:25
 **/
public class ThreadWaitDemo {
    public static Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        if (i == 5) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "线程A");

        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        if (i == 7) {
                            lock.notifyAll();
                            lock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程B");
        thread1.start();
        thread2.start();
    }
}
