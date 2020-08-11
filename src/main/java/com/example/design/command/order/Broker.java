package com.example.design.command.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyf
 * @Description
 * @ClassName Broker
 * @Date 2020/8/6 16:31
 **/
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
