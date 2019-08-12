package com.my.common.thinkinginjava.util;

import java.io.PrintStream;

/**A Print Util
 * @author Gavin.Xue
 * @since 2019/4/21.
 */
public class Print {

    public static void print(Object str){
        print(String.valueOf(str), false);
    }

    public static void println(Object str){
        print(String.valueOf(str), true);
    }

    public static void println(){
        print("", true);
    }

    public static PrintStream printf(String format, Object ...args){
        return System.out.printf(format, args);
    }

    private static void print(String str, boolean isLn){
        if(isLn){
            System.out.println(str);
        }else{
            System.out.print(str);
        }
    }

    public static void main(String[] args){
        println("a");
        println("");
        println();
        printf("Today is %4d-%02d-%02d", 2019, 5, 4);
    }

}
