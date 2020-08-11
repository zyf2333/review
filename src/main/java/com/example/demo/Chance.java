package com.example.demo;

import java.util.Random;

/**
 * @Author zyf
 * @Description
 * @ClassName Rundom
 * @Date 2020/6/18 19:24
 **/
public class Chance {

    public static void main(String[] args) {

        int chance = 60;
        for (int i = 0; i < 100; i++) {
            System.out.println(check(chance));
        }
    }

    private static boolean check(int chance) {
        Random random = new Random();
        int nextInt = random.nextInt(100);
        System.out.println(nextInt);
        if (nextInt <= chance) {
            return true;
        } else {
            return false;
        }
    }


}
