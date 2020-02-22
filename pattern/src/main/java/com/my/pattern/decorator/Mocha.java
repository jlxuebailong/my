package com.my.pattern.decorator;

/**
 * Created by gavin on 2020/2/9.
 */
public class Mocha extends CondimentDecorator{
    private Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;

    }

    @Override
    protected String getDescription() {
        return  this.beverage.getDescription() + ",Mocha";
    }

    @Override
    double cost() {
        return 0.2 + this.beverage.cost();
    }
}
