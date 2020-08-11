package com.example.thread;

/**
 * @Author zyf
 * @Description
 * @ClassName SyncDemo
 * @Date 2020/7/28 19:52
 **/
public class SyncDemo {
    public static void main(String[] args) {
//        SyncThread m = new SyncThread();
//        Thread thread1 = new Thread(m,"线程1");
//        Thread thread2 = new Thread(m,"线程2");
//        Thread thread3 = new Thread(m,"线程3");
//        Thread thread4 = new Thread(m,"线程4");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
    }


}

class SyncThread implements Runnable {
    private int ticket = 5;    // 假设一共有5张票

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            synchronized (this) { // 要对当前对象进行同步
                if (ticket > 0) {   // 还有票
                    try {
                        Thread.sleep(300); // 加入延迟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":卖票：ticket = " + ticket--);
                }
//            }
        }
    }
}

