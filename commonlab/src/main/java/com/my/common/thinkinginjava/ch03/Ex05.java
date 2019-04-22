package com.my.common.thinkinginjava.ch03;

import java.util.Random;

import static com.my.common.thinkinginjava.util.Print.*;

/**
 * @since on 2019/4/22.
 */
public class Ex05 {
    public static void main(String[] args){
        Dog spot = new Dog();
        Dog scruffy = new Dog();
        spot.name = "spot";
        spot.says = "Ruff! ";
        scruffy.name = "scruffy";
        scruffy.says = "Wurf! ";
        println(spot);
        println(scruffy);

        Dog likeSpot = new Dog();
        likeSpot = spot;
        println(likeSpot == spot);
        println(likeSpot.equals(spot));


        int x = 5;
        int y = 5;
        println(x == y);

        Coin coin = new Coin();
        println(coin.throwOut());
        println(coin.throwOut());
        println(coin.throwOut());
        println(coin.throwOut());
        println(coin.throwOut());

        long a = 0x123;//十六进制表示
        println(a);
        a = 291L;//十进制表示
        println(a);
        println(Long.toBinaryString(a));
        a = 037; //八进制表示
        println(a);
        println(Long.toBinaryString(a));
        println(Math.E);
        println(Integer.MAX_VALUE);
        println(1e2d);
    }
}

class Dog{
    String name;
    String says;
    public String toString(){
        return "name: "+name + ", says: " + says;
    }
}

class Coin{
    String front = "主席";
    String back = "长城";
    String currentFace = front;
    Random random = new Random(47);

    public String throwOut(){
        if(random.nextBoolean()){
            currentFace = front;
        }else{
            currentFace = back;
        }
        return currentFace;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "currentFace='" + currentFace + '\'' +
                '}';
    }
}