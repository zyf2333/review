package com.example.thread;

/**
 * @Author zyf
 * @Description
 * @ClassName ThreadYieldDemo
 * @Date 2020/7/28 15:17
 **/
public class ThreadYieldDemo {
    public static void main(String args[]){
        MyThread3 my = new MyThread3() ;  // 实例化MyThread对象
        Thread t1 = new Thread(my,"线程A") ;
        Thread t2 = new Thread(my,"线程B") ;
        t1.start() ;
        t2.start() ;
    }
}
class MyThread3 implements Runnable{ // 实现Runnable接口
    @Override
    public void run(){  // 覆写run()方法
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(500) ;
            }catch(Exception e){
            }
            System.out.println(Thread.currentThread().getName()
                    + "运行，i = " + i) ;  // 取得当前线程的名字
            if(i==2){
                System.out.print(Thread.currentThread().getName()+"线程礼让：") ;
                Thread.currentThread().yield() ;    // 线程礼让
            }
        }
    }
}
