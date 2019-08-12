package com.my.common.thinkinginjava.ch05;
import static com.my.common.thinkinginjava.util.Print.*;

/**
 * 演示变量初始化的顺序
 */
public class House {
    Window w1 = new Window(1);//先自动初始化
    House(){                  //最后执行构造器
        println("House()");
        w3 = new Window(33);

    }
    Window w2 = new Window(2);//先自动初始化
    void f(){println("f()");}
    Window w3 = new Window(3);//先自动初始化
    static Window w4 = new Window(4); //表态变量最先被初始化
    static Window w5;
    static {
        w5 = new Window(5);
    }

}

class Window{
    boolean isOpen ;

    //实例初始化子句
    {
        isOpen = false;
        if(isOpen) {
            println("Window is open");
        }else{
            println("Window is close");
        }
    }
    Window(int marker){
        println("Window(" + marker + ")");
    }
}

class OrderOfInitialization{
    public static void main(String[] args){
        //每一次加载类时, 静态变量会首先被初始化
        House house1 = new House();
        house1.f();

        //以后加载时,静态变量将不再被重复初始化了
        House house2 = new House();
        house2.f();
    }
}
