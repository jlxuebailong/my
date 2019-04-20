package com.my.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM argument: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * Created by gavin on 2018/4/22.
 */
public class HeapOOM {
    static class OOMObject{}
    public static void main(String[] args){
        List<OOMObject> oomObjectList = new ArrayList<OOMObject>();
        while(true)
            oomObjectList.add(new OOMObject());
    }

}
