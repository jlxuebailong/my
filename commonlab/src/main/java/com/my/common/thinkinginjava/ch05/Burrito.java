package com.my.common.thinkinginjava.ch05;
import static com.my.common.thinkinginjava.util.Print.*;
/**
 *
 */
public class Burrito {
    Spiciness degree;
    Burrito(Spiciness degree){
        this.degree = degree;
    }
    public void describe(){
        println("This burrito is");
        switch (degree){
            case NOT:
                println("not spicy at all.");
                break;
            case MILD:
            case MEDIUM:
                println("a little hot.");
                break;
            case HOT:
            case FLAMING:
            default:
                println("maybe too hot.");

        }
    }


    public static void main(String[] args){

        for(Spiciness s : Spiciness.values()){
            println(s + " , ordinal : " + s.ordinal());
        }

        println("---------------------------------------");
        Burrito
                plain = new Burrito(Spiciness.NOT),
                greeChile = new Burrito(Spiciness.MEDIUM),
                jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        greeChile.describe();
        jalapeno.describe();


    }
}

enum Spiciness{
    NOT, MILD, MEDIUM, HOT, FLAMING
}
