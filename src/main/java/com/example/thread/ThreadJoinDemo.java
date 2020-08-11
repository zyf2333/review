package com.example.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author zyf
 * @Description
 * @ClassName ThreadTest
 * @Date 2020/7/28 14:49
 **/
public class ThreadJoinDemo{
    public static void main(String args[]){
        MyThread mt = new MyThread() ;  // 实例化Runnable子类对象
        Thread t = new Thread(mt,"线程");     // 实例化Thread对象
        t.start() ; // 启动线程
        for(int i=0;i<50;i++){
            if(i>10){
                try{
                    t.join() ;  // 线程强制运行
                }catch(InterruptedException e){
                }
            }
            System.out.println("Main线程运行 --> " + i) ;
        }
    }
}
class MyThread implements Runnable{ // 实现Runnable接口
    @Override
    public void run(){  // 覆写run()方法
        for(int i=0;i<50;i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + "运行，i = " + i) ;  // 取得当前线程的名字
        }
    }
};

