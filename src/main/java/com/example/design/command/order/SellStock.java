package com.example.design.command.order;

/**
 * @Author zyf
 * @Description
 * @ClassName SellStock
 * @Date 2020/8/6 16:30
 **/
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
