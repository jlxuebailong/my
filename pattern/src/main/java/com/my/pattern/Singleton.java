package com.my.pattern;

public class Singleton {

    private static Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void sayHello(){
        System.out.println("Hello World");
    }

    public static void main(String[] args){
        Singleton.getInstance().sayHello();
    }

}
