package com.my.pattern.decorator;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by gavin on 2020/2/9.
 */
public abstract class Beverage  {
    protected String description = "Undown";
    protected String getDescription(){
        return this.description;
    }
    abstract double cost();

}
