package com.my.net;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.*;
import java.net.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws UnknownHostException, MalformedURLException {
        assertTrue( true );

        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);

        URL u = new URL("ftp://anonymous:anonymous@wuarchive.wustl.edu/");
        System.out.println(u.getHost());
        System.out.println(u.getUserInfo());
        System.out.println(u.getPort());
        System.out.println(u.getFile());
    }

    @Test
    public void testUrlOpenStream() throws IOException {
        String u = "https://www.oreilly.com";//https://www.oreilly.com/
        URL url = new URL(u);
        URLConnection conn = url.openConnection();
        InputStream in =// url.openStream();
                           conn.getInputStream();
        in = new BufferedInputStream(in);
        Reader reader = new InputStreamReader(in);
        int c;
        while((c = reader.read()) != -1){
            //System.out.write(c);
            System.out.print((char)c);
        }

    }
    @Test
    public void testUrlSame() throws IOException {
        URL ibiblio = new URL("http://www.ibiblio.org/");
        URL metalab = new URL("http://metalab.unc.edu/");
        if(ibiblio.equals(metalab)){
            System.out.println(ibiblio + " is the same as " + metalab);
        }else{
            System.out.println(ibiblio + " is not the same as " + metalab);
        }
    }

    @Test
    public void testSocket(){
        String host = "localhost";
        for(int i=1; i<1024; i++) {
            try {
                Socket socket = new Socket(host, i);
                System.out.println("There is a server on port:" + i + " of " + host);
            } catch (UnknownHostException e) {
                System.err.println("UnknownHostException:"+e);
                break;
            } catch (IOException e) {
                System.err.println("IOException:"+e +"on port:" + i );
                continue;
            }
        }
    }
}
