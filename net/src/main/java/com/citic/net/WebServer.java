package com.citic.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * Created by gavin on 2018/11/5.
 */
public class WebServer {
    private static final int PORT = 6789;

    public static void main(String[] args) throws Exception {
        String requestMessageLine;
        String fileName;
        ServerSocket listenSocket = new ServerSocket(PORT);
        Socket connectionSocket = listenSocket.accept();

        BufferedReader inFromClient =
                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient =
                new DataOutputStream(connectionSocket.getOutputStream());
        requestMessageLine = inFromClient.readLine();
        StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);
        if(tokenizedLine.nextToken().equals("GET")){
            fileName =  tokenizedLine.nextToken();
            if(fileName.startsWith("/")){
                fileName = fileName.substring(1);
            }

            fileName = "/Users/gavin/Applications/my/net/src/main/java/com/citic/net/"+fileName;
            System.out.println("FileName : "+fileName);
            File file = new File(fileName);
            int numOfBytes = (int)file.length();

            FileInputStream inFile = new FileInputStream(file);
            byte[] fileInBytes = new byte[numOfBytes];
            inFile.read(fileInBytes);
            outToClient.writeBytes("HTTP/1.0 200 Document Follows\r\n");
            if(fileName.endsWith(".jpg")){
                outToClient.writeBytes("Content-Type:image/jpeg\r\n");
            }
            if(fileName.endsWith(".gif")){
                outToClient.writeBytes("Content-Type:image/gif\r\n");
            }
            outToClient.writeBytes("Content-Length:"+numOfBytes+"\r\n");
            outToClient.writeBytes("\r\n");
            outToClient.write(fileInBytes,0,numOfBytes);
            connectionSocket.close();
        }else{
            outToClient.writeBytes("Bad Request Message.\r\n");
            connectionSocket.close();
        }
    }
}
