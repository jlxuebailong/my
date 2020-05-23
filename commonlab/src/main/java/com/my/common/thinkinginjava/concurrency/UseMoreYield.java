package com.my.common.thinkinginjava.concurrency;


import static com.my.common.thinkinginjava.util.Print.*;

/**
 * Created by gavin on 2020/5/17.
 */
public class UseMoreYield implements Runnable {
    public static int taskCount = 0;
    private final int id = taskCount++;
    @Override
    public void run() {
        println("#"+id+": Task start...");
        Thread.yield();//通知处理器可以进行线程切换
        println("#"+id+": Task stop...");
    }

    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            Thread t = new Thread(new UseMoreYield());
            t.start();
        }
    }
}
