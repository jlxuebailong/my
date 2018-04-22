package com.citic.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xss2M：设置每个线程的堆栈大小
 * VM argument: -verbose:gc -XX:PermSize=10M -XX:+PrintGCDetails
 * Created by gavin on 2018/4/22.
 */
public class RuntimeConstantPoolOOM {

     //JDK1.7以前会报OOM异常,但JDK1.7开始就不会报异常,因为JDK1.7开始常量池已经从方法区移出
    /*public static void main(String[] args){
        List<String> stringList = new ArrayList<String>();
        int i = 0;
        while (true)
            stringList.add(String.valueOf(i++).intern());
    }*/

    //运行结果: JDK1.7之前都是false,JDK1.7开始是true和false
    //JDK1.7之前intern方法会进行复制动作,但JDK1.7开始就不执行复制了
    public static void main(String[] args){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }

}
