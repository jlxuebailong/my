package com.my.common.thinkinginjava.ch02;

/**
 * Created by gavin on 2019/4/21.
 */
public class Incrementable {
    private static int value = 0;

    public  void increment(){
        value++;
    }
    public  void setValue(int v){
        value = v;
    }

    public  int getValue(){
        return value;
    }
}
