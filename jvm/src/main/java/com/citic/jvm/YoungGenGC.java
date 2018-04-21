package com.citic.jvm;

/**
 * VM argument: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * Created by gavin on 2018/4/22.
 */
public class YoungGenGC {

    public static void main(String[] args){
        System.out.print(0);
    }

}
