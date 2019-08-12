package com.my.common.thinkinginjava.ch07;
import static com.my.common.thinkinginjava.util.Print.*;
/**
 * Created by gavin on 2019/5/15.
 */
public class Ex23 {
    public static void main(String[] args){
        println("Beetle constructor");
        //Beetle beetle = new Beetle();
        Beetle.say();
    }
}

class Insect{
    private int i = printInit("Insect.i initialized"); //(3)
    protected int j;                                   //(4)
    Insect(){                                          //(5)
        println("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInit("static insect.x1 initialized");//(1)
    static int printInit(String s){
        println(s);
        return 47;
    }
}

class Beetle extends Insect{
    private int k = printInit("Beetle.k initialized"); //(6)
    public Beetle(){                                   //(7)
        println("k = " + k);
        println("j = " + j);
    }
    private static int x2 = printInit("static Beetle.x2 initialized");//(2)

    public static void say(){
        println("Hi i am a beetle");
    }
}
/*
类的初始化顺序:
先父类的静态成员, 再子类的静态成员;
当通过调用构造函数来初始化对象时,
    先对父类的成员变量初始化,并执行父类的构造函数;
    再对子类的成变量初始化,并执行子类的构造函数。

 */