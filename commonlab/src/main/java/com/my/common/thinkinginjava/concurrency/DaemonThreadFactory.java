package com.my.common.thinkinginjava.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Created by gavin on 2020/5/23.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
