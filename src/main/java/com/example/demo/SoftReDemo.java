package com.example.demo;

/**
 * @Author zyf
 * @Description 软引用
 * @ClassName SoftReDemo
 * @Date 2020/5/21 10:46
 **/
public class SoftReDemo {
    private Integer a;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "SoftReDemo{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) {
//        LinkedList<WeakReference<byte[]>> list = new LinkedList<>();
//        for (int i = 0; i < 15; i++) {
//            WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1024 * 1024]);
//            list.add(weakReference);
//            System.out.println("gc前:" + weakReference.get());
//        }
//        System.gc();
//        for (WeakReference<byte[]> weakReference : list) {
//            System.out.println("gc后:" + weakReference.get());
//        }
//        ReferenceQueue<String> queue = new ReferenceQueue<String>();
//        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
//        System.out.println(pr.get());

//        Integer a = 10;
//        System.out.println(add(a));
//        System.out.println(a);

//        SoftReDemo demo = new SoftReDemo();
//        add(demo);
//        add(demo);
//        System.out.println(demo);
//        Integer n1 = 123;
//        Integer n2 = 123;
//
//        Integer n3 = 128;
//        Integer n4 = 128;
//        System.out.println(n1 == n2);
//        System.out.println(n3 == n4);
//        System.out.println(n3.equals(n4));


        String str1 = "hello world";
        String str2 = new String("hello world");
        String str3 = "hello world";
        String str4 = new String("hello world");

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
        System.out.println(System.identityHashCode(str3));
        System.out.println(System.identityHashCode(str4));
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str2==str4);

        StringBuilder builder = new StringBuilder("a");
        StringBuffer buffer = new StringBuffer("a");
        System.out.println(buffer.toString()==builder.toString());

    }



    public static Integer add(Integer a){
        a = a+10;
        return a;
    }
    public static void add(SoftReDemo a){
        a.setA(a.getA()+10);
    }
    class Father{
        private final Integer age ;

        Father() {
            age = 10;
        }

        public final void speak(){
            System.out.println("f");
        }
        public void speak(String s){
            System.out.println(s);
        }
    }

    class Child extends Father{

        @Override
        public void speak(String s){
            super.speak(s);
        }
    }

}
