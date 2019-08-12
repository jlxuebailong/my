package com.my.common.thinkinginjava.ch05;
import static com.my.common.thinkinginjava.util.Print.*;
/**
 *
 */
public class Rock {
    private String name = "initialize";
    private String address = initialAddr();

    private String initialAddr(){
        return "initial";
    }

    public Rock(){
        println(this.name);
        this.name = "constructor";
        println(this.name);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        println("finalize execute.");
    }

    public static void main(String[] args) throws Throwable {
        Rock rock = new Rock();
        rock = null;
        System.gc();
    }
}
