package com.my.common.thinkinginjava.ch04;
import static com.my.common.thinkinginjava.util.Print.*;
/**
 * 斐波那契数列
 */
public class Fibonacci {

    static void printFibonacci(int steps){
        int[] array = new int[ steps ];
        array[0] = array[1] = 1;

        for(int i = 2; i < steps; i++){
            array[i] = array[ i - 2 ] + array[ i - 1 ];
        }

        for(int i : array) {
            print(i);
            print(" ");
        }
    }

    public static void main(String[] args){
        printFibonacci(15);
    }
}
