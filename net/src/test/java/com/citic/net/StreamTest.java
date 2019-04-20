package com.citic.net;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by gavin on 2018/11/15.
 */
public class StreamTest {

    private void print(byte[] buf){
        for (byte b : buf) {
            System.out.print((char)b);
        }
        System.out.println();
    }

    @Test
    public void test1(){
        int len = 1024;
        byte[] buf = new byte[len];
        for(int i=0; i<buf.length; i++){
            buf[i] = (byte)i;
        }

        print(buf);
        ByteArrayInputStream in = new ByteArrayInputStream(buf);

        int bytesRead = 0;
        int bytesToRead = len;
        byte[] input = new byte[bytesToRead];
        while(bytesRead < bytesToRead){
            int result = in.read(input, bytesRead, bytesToRead-bytesRead);
            if(result == -1){
                break;
            }
            bytesRead += result;
        }
        print(input);
    }
}
