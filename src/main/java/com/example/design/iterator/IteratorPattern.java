package com.example.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyf
 * @Description 迭代器模式
 * @ClassName IteratorPattern
 * @Date 2020/8/7 0:09
 **/
public class IteratorPattern {
    public static void main(String[] args) {
//        Aggregate ag = new ConcreteAggregate();
//        ag.add("中山大学");
//        ag.add("华南理工");
//        ag.add("韶关学院");
//        System.out.print("聚合的内容有：");
//        Iterator it = ag.getIterator();
//        while (it.hasNext()) {
//            Object ob = it.next();
//            System.out.println(ob.toString());
//        }
//        Object ob = it.first();
//        System.out.println("\nFirst：" + ob.toString());
        List<Object> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        java.util.Iterator<Object> iterator = list.iterator();
        if (iterator.hasNext()) {
            Object next = iterator.next();
            list.remove("a");
            System.out.println(next);
        }
        System.out.println(list);
    }
}

//抽象聚合
interface Aggregate {
    public void add(Object obj);

    public void remove(Object obj);

    public Iterator getIterator();
}

//具体聚合
class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<Object>();

    public void add(Object obj) {
        list.add(obj);
    }

    public void remove(Object obj) {
        list.remove(obj);
    }

    public Iterator getIterator() {
        return (new ConcreteIterator(list));
    }
}

//抽象迭代器
interface Iterator {
    Object first();

    Object next();

    boolean hasNext();
}

//具体迭代器
class ConcreteIterator implements Iterator {
    private List<Object> list;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public Object first() {
        index = 0;
        Object obj = list.get(index);
        return obj;
    }

    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }
}
