package com.my.common.thinkinginjava.concurrency;

import java.util.concurrent.TimeUnit;

import static com.my.common.thinkinginjava.util.Print.println;

/**
 * Created by gavin on 2020/5/23.
 */
public class SimpleDaemons implements Runnable {
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
        for (int i = 0; i < 2; i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(300);
    }
}
