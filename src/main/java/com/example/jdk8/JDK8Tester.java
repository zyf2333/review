package com.example.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyf
 * @Description
 * @ClassName JDK8Tester
 * @Date 2020/7/28 21:24
 **/
public class JDK8Tester {
    public static void main(String[] args) {
        Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car, car);
        System.out.println(cars);
    }

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    static class Car {

        //Supplier是jdk1.8的接口，这里和lamda一起使用了
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
    }
}
