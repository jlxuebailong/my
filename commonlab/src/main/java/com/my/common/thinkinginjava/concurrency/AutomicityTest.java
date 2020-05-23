package com.my.common.thinkinginjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.my.common.thinkinginjava.util.Print.println;

/**
 * Created by gavin on 2020/5/23.
 */
public class AutomicityTest implements Runnable{
    private volatile int i = 0;
    public synchronized int getValue(){
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        AutomicityTest at = new AutomicityTest();
        exec.execute(at);
        while (true){
            int val = at.getValue();
            if(val % 2 != 0){
                println(val);
                System.exit(0);
            }
        }
    }
}
