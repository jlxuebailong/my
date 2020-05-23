package com.my.common.thinkinginjava.concurrency;

/**
 * Created by gavin on 2020/5/23.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
