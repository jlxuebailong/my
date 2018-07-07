package com.icitic.es;

/**
 * Created by gavin on 2018/4/23.
 */
public interface EsSearchService {
    void  search();
    void  searchByCondition() throws Exception;
    void  multiSearch();
    void aggsearch();
    void metricsAgg();
}
