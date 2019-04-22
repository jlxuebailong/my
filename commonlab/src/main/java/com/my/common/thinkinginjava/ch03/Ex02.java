package com.my.common.thinkinginjava.ch03;

import java.util.Random;

import static com.my.common.thinkinginjava.util.Print.*;

/**
 * @author Gavin.Xue
 * @since 2019/4/21.
 */
public class Ex02 {

    static void f(Tank t){
        t.value *= 2;
    }

    public static void main(String[] args){
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.value = 0.5f;
        t2.value = 0.7f;
        println("1. " + t1.value + " , " + t2.value);
        //对象赋值时, 使用的对象的引用进行赋值
        //将t2的引用赋给t1, 现在t1和t2都指向t2的引用; t1原来的引用丢失, 引用内存将在下一次gc时回收;
        t1 = t2;
        println("2. " + t1.value + " , " + t2.value);
        t1.value = 1.9f;
        println("3. " + t1.value + " , " + t2.value);
        //方法中对象的传值也是传址
        //f方法修改了t1的value
        f(t1);
        println("4. " + t1.value + " , " + t2.value);

        //种子数字47, 据说是一个"魔幻数字"
        Random random = new Random(47);
        println(random.nextInt(100) + 1);

        Integer x = new Integer(1);
        Integer y = new Integer(1);
        println(x == y);
        println(x.equals(y));

    }

}


class Tank{
    float value;
}
