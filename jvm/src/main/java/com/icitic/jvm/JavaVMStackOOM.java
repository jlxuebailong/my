package com.icitic.jvm;

/**
 * -Xss2M：设置每个线程的堆栈大小
 * VM argument: -verbose:gc -Xss2M -XX:+PrintGCDetails
 * Created by gavin on 2018/4/22.
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true);
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(()->dontStop());
            thread.start();
        }
    }

    public static void main(String[] args){
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
