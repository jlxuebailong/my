package com.icitic.es;

import com.google.gson.JsonObject;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ElasticsearchTest1 {

    public final static String HOST = "127.0.0.1";
    //http请求的端口是9200，客户端是9300
    public final static int PORT = 9300;
    private TransportClient client;

    @SuppressWarnings({ "resource", "unchecked" })
    @Before
    public void getConnect() throws UnknownHostException {
         client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(
                          new InetSocketTransportAddress(InetAddress.getByName(HOST),PORT));
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

    /**
     * 创建索引库
     * @Title: addIndex1
     * @author sunt
     * @date 2017年11月23日
     * @return void
     * 需求:创建一个索引库为：msg消息队列,类型为：tweet,id为1
     * 索引库的名称必须为小写
     * @throws IOException
     */
    @Test
    public void testAddIndex() throws IOException {
        IndexResponse response = client.prepareIndex("blog", "article", "1")
                .setSource(
                        XContentFactory.jsonBuilder()
                        .startObject().field("userName", "张三")
                        .field("sendDate", new Date())
                        .field("msg", "你好李四")
                        .endObject()
                ).get();

        System.out.println("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
    }
    @Test
    public void testAddIndexSourceJson() throws IOException {
        String jsonStr = "{" +
                                 "\"userName\":\"李四\"," +
                                 "\"sendDate\":\"2017-11-30\"," +
                                 "\"msg\":\"你好张三\"" +
                             "}";

        IndexResponse response = client.prepareIndex("blog", "article", "2")
                .setSource(
                        jsonStr, XContentType.JSON
                ).get();

        System.out.println("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
    }

    @Test
    public void testAddIndexSourceMap() {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userName", "张路");
        map.put("sendDate", new Date());
        map.put("msg", "巴塞罗那在欧冠1/4淘汰赛第二回合中输给了罗马!");

        IndexResponse response = client.prepareIndex("blog", "article").setSource(map).get();

        System.out.println("map索引名称:" + response.getIndex() + "\n map类型:" + response.getType()
                + "\n map文档ID:" + response.getId() + "\n当前实例map状态:" + response.status());
    }

    @Test
    public void testAddIndexSourceJO() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userName", "吴六");
        jsonObject.addProperty("sendDate", "2017-11-23");
        jsonObject.addProperty("msg","你好吴六");

        IndexResponse response = client.prepareIndex("blog", "article").setSource(jsonObject, XContentType.JSON).get();

        System.out.println("jsonObject索引名称:" + response.getIndex() + "\n jsonObject类型:" + response.getType()
                + "\n jsonObject文档ID:" + response.getId() + "\n当前实例jsonObject状态:" + response.status());
    }

    @Test
    public void testGetData() {
        GetResponse getResponse = client.prepareGet("blog", "article", "1").get();
        System.out.println("索引库的数据:" + getResponse.getSourceAsString());

        QueryBuilder queryBuilder=QueryBuilders.multiMatchQuery("张三","userName","msg");

        SearchRequestBuilder builder = client.prepareSearch("blog");
        builder.setQuery(queryBuilder);
        System.out.println(builder.toString());
        SearchResponse searchResponse = builder.execute().actionGet();
        SearchHits hits = searchResponse.getHits();
        System.out.println("查到记录数："+hits.getTotalHits());
        SearchHit[] searchHists = hits.getHits();
        if(searchHists.length>0){
            for(SearchHit hit:searchHists){
                String userName =  (String) hit.getSource().get("userName");
                String sendDate =  (String) hit.getSource().get("sendDate");
                String msg =  (String) hit.getSource().get("msg");
                System.out.format("%s, %s , %s \n",userName,sendDate,msg);
            }
        }
    }

    @Test
    public void testUpdateData() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("userName", "王五");
        jsonObject.addProperty("sendDate", "2008-08-08");
        jsonObject.addProperty("msg","你好,张三，好久不见");

        UpdateResponse updateResponse = client.prepareUpdate("blog", "article", "1")
                .setDoc(jsonObject.toString(),XContentType.JSON).get();

        System.out.println("updateResponse索引名称:" + updateResponse.getIndex() + "\n updateResponse类型:" + updateResponse.getType()
                + "\n updateResponse文档ID:" + updateResponse.getId() + "\n当前实例updateResponse状态:" + updateResponse.status());
    }

    @Test
    public void testDeleteData() {
        DeleteResponse deleteResponse = client.prepareDelete("blog", "article", "1").get();

        System.out.println("deleteResponse索引名称:" + deleteResponse.getIndex() + "\n deleteResponse类型:" + deleteResponse.getType()
                + "\n deleteResponse文档ID:" + deleteResponse.getId() + "\n当前实例deleteResponse状态:" + deleteResponse.status());
    }


}
