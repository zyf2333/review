package com.example.thread;

/**
 * @Author zyf
 * @Description
 * @ClassName ThreadInterruptDemo
 * @Date 2020/7/28 14:54
 **/
public class ThreadInterruptDemo{
    public static void main(String args[]){

        Thread t = new Thread(()->{
            while (!Thread.interrupted()){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("线程任务。。。");
            }
        },"线程");
        t.start() ; // 启动线程
        try{
            Thread.sleep(100) ;    // 主线程休眠2秒
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        t.interrupt() ; // 中断线程执行
        System.out.println("main 结束");
    }
}
