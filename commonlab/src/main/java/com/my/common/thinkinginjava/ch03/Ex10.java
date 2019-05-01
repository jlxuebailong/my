package com.my.common.thinkinginjava.ch03;

import java.util.Random;
import static com.my.common.thinkinginjava.util.Print.*;

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

        Random rand = new Random(47);
        int i = rand.nextInt();
        int j = rand.nextInt();
        printBinaryInt("-1", -1);
        printBinaryInt("1", 1);
        printBinaryInt("i", i);
        printBinaryInt("j", j);
    }

    static void printBinaryInt(String s, int i){
        println(s + ", int: " + i + ", binary: \n " +
        Integer.toBinaryString(i));
    }
    static void printBinaryLong(String s, long l){
        println(s + ", long: " + l + ", binary: \n " +
                Long.toBinaryString(l));
    }
}
