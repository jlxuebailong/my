package com.my.common.thinkinginjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.my.common.thinkinginjava.util.Print.println;

/**
 * Created by gavin on 2020/5/23.
 */
public class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator g, int id){
        this.generator = g;
        this.id = id;
    }


    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if(val % 2 != 0){
                println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator g, int c){
        println("Press Control-c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<c; i++){
            exec.execute(new EvenChecker(g, i));
        }
        exec.shutdown();
    }

    public static  void test(IntGenerator g){
        test(g, 10);
    }
}
