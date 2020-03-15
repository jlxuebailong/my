package com.my.pattern.decorator;

import java.util.ArrayList;

/**
 * Created by gavin on 2020/2/9.
 */
public class StarbuzzCoffee {
    public static void main(String[] args){

        ArrayList a;

        Beverage beverage = new DarkRoast();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

    }
}
