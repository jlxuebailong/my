package com.icitic.pattern.proxy;

public class SubjectConsumer {

    /**
     在这种模式之中：代理Proxy 和RealSubject 应该实现相同的功能，这一点相当重要。
    （我这里说的功能，可以理解为某个类的public方法）
     在面向对象的编程之中，如果我们想要约定Proxy 和RealSubject可以实现相同的功能，有两种方式：
     a.一个比较直观的方式，就是定义一个功能接口，然后让Proxy 和RealSubject来实现这个接口。
     b.还有比较隐晦的方式，就是通过继承。因为如果Proxy 继承自RealSubject，这样Proxy则拥有了RealSubject的功能，Proxy还可以通过重写RealSubject中的方法，来实现多态。
     其中JDK中提供的创建动态代理的机制，是以a 这种思路设计的，而cglib 则是以b思路设计的。
     */
    public static void main(String[] args){
        SubjectProxy proxy = new SubjectProxy();
        proxy.execute();
    }
}
