package com.example.thread;

/**
 * @Author zyf
 * @Description
 * @ClassName ThreadSleep
 * @Date 2020/8/8 15:38
 **/
public class ThreadSleep {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a+b;
        String d = "ab";
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        System.out.println(a==b);
        System.out.println(c==d);
        System.out.println(c.intern()==d);
        System.out.println("ab"==d);

        String a1 = new String("aaa");
        String a2 = new String("aaa");
        System.out.println(a1 == a2);
        System.out.println(a1.intern() == a2.intern());


    }
}
