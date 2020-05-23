package com.my.common.thinkinginjava.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gavin on 2020/5/23.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEventValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public /*synchronized*/ int next() {
        lock.lock();
        try {
            ++currentEventValue; //Danger point here!
            ++currentEventValue;
            return currentEventValue;
        }finally {
            lock.unlock();
        }
    }




    public static void main(String[] args){
        EvenChecker.test(new EvenGenerator());
    }
}
