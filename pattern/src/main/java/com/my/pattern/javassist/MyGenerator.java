package com.my.pattern.javassist;

import com.my.pattern.proxy.MyClassLoader;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class MyGenerator {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //创建Programmer类
        CtClass cc= pool.makeClass("com.samples.Programmer");
        //定义code方法
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        //插入方法代码
        method.insertBefore("System.out.println(\"I'm a Programmer By Javassist generator,Just Coding.....\");");
        cc.addMethod(method);
        //保存生成的字节码
        File file = new File(".");
        String path = file.getCanonicalPath()+"//pattern//temp";
        cc.writeFile(path);
        InputStream input = new FileInputStream(path+"\\com\\samples\\Programmer.class");

        byte[] result = new byte[1024];
        int count = input.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.defineMyClass(cc.getName(), result, 0, count);
        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());

        //实例化一个Programmer对象
        Object o = clazz.newInstance();
        try {
            //调用Programmer的code方法
            clazz.getMethod("code", null).invoke(o, null);
        } catch (IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }
}
