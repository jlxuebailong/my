package com.my.common.thinkinginjava.ch02;

/**
 * Created by gavin on 2019/4/21.
 */
public class Ex10 {

    public static void main(String[] args){
        if(args == null || args.length < 3){
            System.out.println("Usage: java ../../Ex10 par1 par2 par3 ");
            return;
        }

        System.out.println("par1: " + args[0]);
        System.out.println("par2: " + args[1]);
        System.out.println("par3: " + args[2]);

    }
}
