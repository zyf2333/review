package com.example.thread;

/**
 * @Author zyf
 * @Description
 * @ClassName ThreadDaemonDemo
 * @Date 2020/7/28 15:01
 **/
public class ThreadDaemonDemo {
    public static void main(String args[]){
        MyThread2 mt = new MyThread2() ;  // 实例化Runnable子类对象
        Thread t = new Thread(mt,"线程");     // 实例化Thread对象
//        t.setDaemon(true) ; // 此线程在后台运行
//        t.start() ; // 启动线程
    }
}
class MyThread2 implements Runnable{ // 实现Runnable接口
    public void run(){  // 覆写run()方法
        while(true){
            System.out.println(Thread.currentThread().getName() + "在运行。") ;
        }
    }
}
