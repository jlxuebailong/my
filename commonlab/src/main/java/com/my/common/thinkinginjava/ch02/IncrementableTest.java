package com.my.common.thinkinginjava.ch02;

/**
 * Created by gavin on 2019/4/21.
 */
public class IncrementableTest {

    public static void main(String[] args){
        Incrementable incrementable1 = new Incrementable();
        incrementable1.increment();
        System.out.println(incrementable1.getValue());
        incrementable1.increment();
        System.out.println(incrementable1.getValue());

        //虽然创建多个对象,但所有对象引用的表态属性却是同一个
        Incrementable incrementable2 = new Incrementable();
        incrementable2.increment();
        System.out.println(incrementable2.getValue());
        incrementable2.increment();
        System.out.println(incrementable2.getValue());

        int i = 0;
        Integer x = i;
        int y = x;
        System.out.println(y);
    }
}
