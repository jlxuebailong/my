package com.my.common.thinkinginjava.ch07;

import static com.my.common.thinkinginjava.util.Print.*;

/**
 *
 */
public class Ex19 {
    private final int i;

    //使用final修饰的变量可以不立即进行初始化,
    // 但必须在构造函数中对未初始化的变量进行初始化。
    private final int[] ints;
    //同时使用static 和 final修饰的变量必须立即初始化。
    private static final int VALUE = 0;

    public Ex19(){
        i = 0;
        ints = new int[]{1,2,3};
    }

    public static void main(String[] args){
        Ex19 ex19 = new Ex19();
        println(ex19.i);
        ex19.ints[2]++;
        for (int i : ex19.ints) {
            println(i);
        }

    }
}


