package com.my.pattern.decorator;

/**
 * Created by gavin on 2020/2/9.
 */
public class DarkRoast extends Beverage {

    public DarkRoast(){
        this.description = "Dark Roast Coffee";
    }

    @Override
    double cost() {
        return 0.99;
    }

}
