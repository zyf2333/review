//package com.example.oop;
//
///**
// * @Author zyf
// * @Description
// * @ClassName Man
// * @Date 2020/8/8 21:39
// **/
//public class Man extends People{
//    private static final String name = "男人";
//    protected static String CLASS_NAME;
//    protected static String CLASS_LOADER_NAME;
//
//    static {
//        System.out.println("Man static"+name+"。");
//        CLASS_NAME = Man.class.getName();
//        CLASS_LOADER_NAME = Man.class.getClassLoader().toString();
//        System.out.println("Man Step a: " + CLASS_NAME + " is loaded by " + CLASS_LOADER_NAME);
//    }
//
//    {
//        System.out.println("Man "+name+"。");
//    }
//
//    public Man() {
//        System.out.println("Man()");
//    }
//}
