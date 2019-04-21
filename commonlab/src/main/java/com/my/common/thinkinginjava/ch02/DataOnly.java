package com.my.common.thinkinginjava.ch02;

/**
 * Created by gavin on 2019/4/21.
 */
public class DataOnly {

    //未使用public,private,protected声明的属性或方法,可见范围是: 包内可见。
    int i;
    double d;
    boolean b;

    public int storage(String s){
        return s != null ? s.getBytes().length * 2 : -1;
    }

    @Override
    public String toString() {
        return "DataOnly{" +
                "i=" + i +
                ", d=" + d +
                ", b=" + b +
                '}';
    }
}
