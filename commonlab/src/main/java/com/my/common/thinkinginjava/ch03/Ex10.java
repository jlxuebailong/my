package com.my.common.thinkinginjava.ch03;

/**
 * 位运算练习
 */
public class Ex10 {

    public static void main(String[] args){
        int x = 0x23;
        int y = 0x2d;

        System.out.println(" x \t\t = \t" + Integer.toBinaryString(x));
        System.out.println(" y \t\t = \t" + Integer.toBinaryString(y));
        System.out.println("-----------------------------------------");
        System.out.println(" x & y " + " = " + Integer.toBinaryString(x & y));
        System.out.println(" x | y " + " = " + Integer.toBinaryString(x | y));
        System.out.println(" x ^ y " + " = " + Integer.toBinaryString(x ^ y));
    }
}
