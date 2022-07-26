package com.example.demo;

/**
 * @Author zyf
 * @Description 子类不继承父类方法的synchronized
 * @ClassName Aoo
 * @Date 2020/7/20 21:17
 **/
public class Aoo {

    public synchronized void eat() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Aoo:"+Thread.currentThread().getName()+":"+i);
        }
    }
    public static void main(String[] args) {
        Aoo aoo = new Boo();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {aoo.eat();
                }
            }).start();
        }
    }
}

class Boo extends Aoo{

    @Override
    public void eat() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Boo:"+Thread.currentThread().getName()+":"+i);
        }
    }
}
