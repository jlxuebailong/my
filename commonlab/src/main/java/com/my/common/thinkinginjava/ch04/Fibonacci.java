package com.my.common.thinkinginjava.ch04;
import com.sun.xml.internal.xsom.impl.scd.Iterators;

import static com.my.common.thinkinginjava.util.Print.*;
/**
 * 斐波那契数列
 */
public class Fibonacci {

    static int[] printFibonacci(int steps){
        int[] array = new int[ steps ];
        array[0] = array[1] = 1;
        for(int i = 2; i < steps; i++){
            array[i] = array[ i - 2 ] + array[ i - 1 ];
        }
        return array;
    }

    static void printArray(int[] array){
        for(int i : array) {
            print(i);
            print(" ");
        }
    }

    public static void main(String[] args){
        printArray(printFibonacci(15));
    }
}
