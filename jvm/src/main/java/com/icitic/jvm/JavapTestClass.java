package com.icitic.jvm;

import java.util.List;

public class JavapTestClass {
    private int m;
    public int inc(){
        return m + 1;
    }

    public static void main(String[] args){
        /**
         * 自动装箱的陷阱
         */
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;//10以内的常数会复用常量池，所以d==c
        Integer e = 321;//
        Integer f = 321;//当e==f时，不会自动拆箱，所以e==f为假
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(e .equals(f));
        System.out.println(c == (a+b));
        System.out.println(c .equals (a+b));
        System.out.println(g == (a+b));
        System.out.println(g .equals (a+b));
    }
}
