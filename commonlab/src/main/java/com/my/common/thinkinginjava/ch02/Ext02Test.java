package com.my.common.thinkinginjava.ch02;

/**
 * Created by gavin on 2019/4/21.
 */
public class Ext02Test {
    public static void main(String[] args){
        Ex02 ex = new Ex02();
        Ex02.ANumberType aNumberType = ex.buildANumberType(3);
        System.out.println(aNumberType.doubleValue());
    }
}
