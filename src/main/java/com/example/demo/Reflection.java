package com.example.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author zyf
 * @Description
 * @ClassName Reflection
 * @Date 2020/7/27 18:15
 **/
public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
//        Class strClass = String.class;
//        System.out.println(strClass.getPackage());
        Class aClass = Class.forName("com.example.demo.B");
        Class superclass = aClass.getSuperclass();
//        System.out.println(superclass.getModifiers());
//        System.out.println(Modifier.isPublic(superclass.getModifiers()));
//        System.out.println(isDefault(superclass.getModifiers()));
//        System.out.println(Modifier.isProtected(superclass.getModifiers()));
//        System.out.println(superclass.getName());
        Method[] methods = superclass.getMethods();
        System.out.println(Arrays.toString(methods));
        Method method = superclass.getMethod("eat", new Class[]{int.class, int.class, String.class});
        method.invoke(superclass.newInstance(), new Object[]{1, 2, "a"});

        new A().getClass();
    }

}

class A {
    public A() {
    }
    public A(String a){

    }
    public void eat(int a){
        System.out.println(a);
    }
    public void eat(int a,int b){
        System.out.println(a);
    }

    public static void eat(int a,int b,String c){
        System.out.println(""+a+b+c);
    }
}

class B extends A{

}
