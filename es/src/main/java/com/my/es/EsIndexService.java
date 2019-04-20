package com.my.es;

/**
 * Created by gavin on 2018/4/23.
 */

public interface EsIndexService {

    void  index(String id);
    void  get();
    void  del(String id);
    void  update(String id) throws  Exception;
    void  multiGet(String ... ids) throws  Exception;
    void  bulk(String ... ids) throws  Exception;
    void  bulkProcesstor(String index,String type,String... ids) throws  Exception;

}