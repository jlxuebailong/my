package com.icitic.es2;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by gavin on 2018/4/21.
 */
public class TestES {

    public final static String HOST = "127.0.0.1";
    //http请求的端口是9200，客户端是9300
    public final static int PORT = 9300;
    private TransportClient client;

    @SuppressWarnings({ "resource", "unchecked" })
    @Before
    public void getConnect() throws UnknownHostException {

/*
Settings settings = Settings.builder()
        .put("cluster.name", "myClusterName").build();
TransportClient client = new PreBuiltTransportClient(settings);
 */
        Settings settings = Settings.builder()
                             .put("client.transport.sniff", true)
                             .put("cluster.name", "elasticsearch").build();
        client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
                new TransportAddress(InetAddress.getByName(HOST),PORT));
        System.out.println("连接信息:" + client.toString());
    }
    @After
    public void closeConnect() {
        if(null != client) {
            System.out.println("执行关闭连接操作...");
            client.close();
        }
    }

    @Test
    public void testClientAvailable() {
        System.out.println("Elasticsearch connect info:" + client.toString());
        //关闭客户端
        client.close();
    }


    @Test
    public void testQuery1(){
        String qryParam = "欧冠";

        SearchRequestBuilder srb = client.prepareSearch("blog").setTypes("article");
        QueryBuilder query = QueryBuilders.matchQuery("msg", qryParam);

        srb.setQuery(query);
        SearchResponse searchResponse = srb.execute().actionGet();
        System.out.println(searchResponse);
    }
}
