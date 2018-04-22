package com.citic.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * VM argument: -verbose:gc -XX:+PrintGCDetails -Xmx20M -XX:MaxDirectMemorySize=10M
 * Created by gavin on 2018/4/22.
 */
public class DirectMemoryOOM {

    private static final int _10MB = 1024 * 1024 * 10;
    public static void main(String[] args) throws IllegalAccessException {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while(true)
            unsafe.allocateMemory(_10MB);
    }

}
