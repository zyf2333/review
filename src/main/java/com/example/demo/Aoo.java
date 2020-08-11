package com.example.demo;

/**
 * @Author zyf
 * @Description
 * @ClassName Aoo
 * @Date 2020/7/20 21:17
 **/
public class Aoo {

    public synchronized void eat() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Aoo"+i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new Boo().eat();
                }
            }).start();
        }
    }
}

class Boo extends Aoo{

    @Override
    public void eat() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Boo"+i);
        }
    }
}
