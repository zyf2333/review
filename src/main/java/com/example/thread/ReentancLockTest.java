package com.example.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zyf
 * @Description
 * @ClassName ReentancLockTest
 * @Date 2020/8/24 23:53
 **/
public class ReentancLockTest {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Lock lock = new ReentrantLock(true);
        new Thread(new MyThread(lock),"thread-1").start();
        new Thread(new MyThread(lock),"thread-2").start();
        new Thread(new MyThread(lock),"thread-3").start();
        new Thread(new MyThread(lock),"thread-4").start();
        new Thread(new MyThread(lock),"thread-5").start();

    }

    static class MyThread implements Runnable{
        private Lock lock;

        public MyThread(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() );
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}

