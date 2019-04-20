package com.my.jvm;

/**
 * Created by gavin on 2018/7/8.
 */
public class ThreadDeadLock {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(2,1)).start();

        }
    }
}

class SynAddRunable implements Runnable{

    int a,b;

    public SynAddRunable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)){
            synchronized (Integer.valueOf(b)){
                System.out.println(a + b);
            }
        }
    }
}
