package com.my.common.thinkinginjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gavin on 2020/5/23.
 */
public class ExceptionThread implements Runnable {



    @Override
    public void run() {
        throw new RuntimeException("Thread Exception");
    }

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ">>>" + e.getMessage());
                System.exit(1);
            }
        });
        ExceptionThread thread = new ExceptionThread();
        exec.execute(thread);

    }
}
