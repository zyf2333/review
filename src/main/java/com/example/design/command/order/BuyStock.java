package com.example.design.command.order;

/**
 * @Author zyf
 * @Description
 * @ClassName BuyStock
 * @Date 2020/8/6 16:28
 **/
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
