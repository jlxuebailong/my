package com.my.common.thinkinginjava.concurrency;
import static com.my.common.thinkinginjava.util.Print.*;
/**
 * Created by gavin on 2020/5/17.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){
    }
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!")
                +").";
    }
    @Override
    public void run() {
        while (countDown-- > 0){
            println(status());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }

}
