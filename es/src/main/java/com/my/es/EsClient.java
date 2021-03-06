package com.my.es;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import java.net.InetAddress;

/**
 * Created by xiaotian on 2017/12/1.
 */
public class EsClient {

    //private  EsClient client = new EsClient();

    TransportClient client = null;

    public  EsClient(){
        try{
            Settings settings = Settings.builder()
                    .put("client.transport.sniff", true)
                    .put("cluster.name", "elasticsearch").build();

            String eshost = "127.0.0.1";
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(eshost), 9300));

        }catch (Exception ex){
            client.close();
        }finally {

        }
    }
    public  TransportClient getConnection(){

        if (client == null){
            synchronized (EsClient.class){
                if (client == null){
                    new EsClient();
                }
            }
        }
        return  client;

    }

}