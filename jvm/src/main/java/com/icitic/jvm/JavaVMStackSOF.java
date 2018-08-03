package com.icitic.jvm;

/**
 * VM argument: -verbose:gc -Xss160k -XX:+PrintGCDetails
 * Created by gavin on 2018/4/22.
 */
public class JavaVMStackSOF {

    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args){
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Exception e){
            System.out.println("Stack length: "+oom.stackLength);
            throw e;
        }
    }

}
