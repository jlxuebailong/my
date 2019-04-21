package com.my.common.thinkinginjava.ch02;

import com.my.common.thinkinginjava.ch02.DataOnly;

/**
 * Created by gavin on 2019/4/21.
 */
public class DataOnlyTest {
    public static void main(String[] args){
        DataOnly data = new DataOnly();
        data.i = 1;
        data.d = 0.3d;
        data.b = Boolean.TRUE;
        System.out.println(data);
        System.out.println(data.storage(""));
        System.out.println(data.storage(null));
        System.out.println(data.storage("abc"));
        System.out.println(data.storage("梁山伯"));
        System.out.println("梁".getBytes().length);
        System.out.println("a".getBytes().length);
    }
}
