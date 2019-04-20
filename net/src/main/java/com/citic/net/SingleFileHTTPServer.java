package com.citic.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by gavin on 2018/11/21.
 */
public class SingleFileHTTPServer implements Runnable {

    private byte[] content;
    private byte[] header;
    private int port = 1314;
    public SingleFileHTTPServer(String data, String encoding,String MIMEType, int port) throws UnsupportedEncodingException {
        this(data.getBytes(),encoding,MIMEType,port);
    }
    public SingleFileHTTPServer(byte[] data, String encoding,String MIMEType, int port) throws UnsupportedEncodingException {
        this.content = data;
        this.port = port;
        String header = "HTTP/1.0 200OK\r\n"
                +"Server: OneFile 1.0\r\n"
                +"Content-length: "+this.content.length+"\r\n"
                +"Content-type: "+MIMEType+"\r\n";
        this.header = header.getBytes("ASCII");
    }

    @Override
    public void run() {
        try{
            ServerSocket server = new ServerSocket(this.port);
            System.out.println("Accept connections on port "+server.getLocalPort());
            System.out.println("Data to be sent:");
            System.out.write(this.content);

            while(true){
                Socket connection = null;
                try{
                    connection = server.accept();
                    OutputStream out = new BufferedOutputStream(connection.getOutputStream());
                    InputStream  in  = new BufferedInputStream(connection.getInputStream());
                    StringBuffer request = new StringBuffer("");
                    while(true){
                        int c = in.read();
                        if(c == '\r' || c == '\n' || c == -1){
                            break;
                        }
                        request.append((char)c);
                    }
                    System.out.println("Req : "+request.toString());
                    if(request.toString().indexOf("HTTP/") != -1){
                        out.write(this.header);
                    }
                    out.write(this.content);
                    out.flush();
                }catch (IOException ex){

                }finally {
                    if(connection != null){
                        connection.close();
                    }
                    connection = null;
                }

            }

        }catch (IOException ex){
            System.err.println("Could not start server. Port Occupied");
        }

    }
}
