package com.my.common.thinkinginjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.my.common.thinkinginjava.util.Print.println;

/**
 * Created by gavin on 2020/5/23.
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                println(Thread.currentThread() + " " +this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++){
            exec.execute(new DaemonFromFactory());
        }
        println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
