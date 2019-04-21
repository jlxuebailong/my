package com.my.common.thinkinginjava.util;

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

    private static void print(String str, boolean isLn){
        if(isLn){
            System.out.println(str);
        }else{
            System.out.print(str);
        }
    }

}
