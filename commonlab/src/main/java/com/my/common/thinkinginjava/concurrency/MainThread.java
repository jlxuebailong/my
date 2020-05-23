package com.my.common.thinkinginjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.my.common.thinkinginjava.util.Print.*;
/**
 * Created by gavin on 2020/5/17.
 */
public class MainThread {
    public static void main(String[] args){

        //一般不这样启动线程,因为这样是同步的
        //LiftOff launch = new LiftOff(10);
        //launch.run();

        //异步
        /*Thread thread = new Thread(new LiftOff());
        thread.start();
        println("Waiting for LiftOff");*/

        //more
        /*for (int i = 0; i < 5; i++){
            Thread t = new Thread(new LiftOff());
            t.start();
        }
        println("Waiting for LiftOff");*/

        //newCachedThreadPool
        /*ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
        println("Waiting for LiftOff");*/

        //newSingleThreadExecutor
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
        println("Waiting for LiftOff");

    }
}
