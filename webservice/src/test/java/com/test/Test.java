package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin on 2018/7/7.
 */
public class Test {

    @org.junit.Test
    public void test1() throws InterruptedException {
        List<byte[]> oomList = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            //System.out.println(oomList.size());
            Thread.sleep(100);
            oomList.add(new byte[64 * 1024]);
        }

    }

}
