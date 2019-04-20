package com.citic.net;

import java.io.*;

/**
 * Created by gavin on 2018/11/21.
 */
public class SingleFileHTTPServerMain {
    public static void  main(String[] args) throws IOException, InterruptedException {
        String  fileName = "/Users/gavin/Applications/my/net/src/main/java/com/citic/net/index.html";
        System.out.println("FileName : "+fileName);
        String contentType = "text/plain";
        if(fileName.endsWith(".html") || fileName.endsWith(".htm")){
            contentType = "text/html";
        }
        InputStream in = new FileInputStream(fileName);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int b;
        while((b = in.read()) != -1){
            out.write(b);
        }
        byte[] data = out.toByteArray();
        System.out.println("Send to be data:");
        System.out.write(data);

        int port = 1314;
        String encoding = "ASCII";
        Thread t = new Thread(new SingleFileHTTPServer(data,encoding,contentType,port));
        t.start();

    }
}
