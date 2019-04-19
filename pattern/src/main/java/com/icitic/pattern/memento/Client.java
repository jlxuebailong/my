package com.icitic.pattern.memento;

/**
 * Created by gavin on 2018/10/24.
 */
public class Client {

    public static void main(String[] args){
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        originator.setState("0");
        caretaker.setMemento(originator.createMemento());
        System.out.println(originator.getState());

        originator.setState("1");
        caretaker.setMemento(originator.createMemento());
        System.out.println(originator.getState());

        originator.setState("2");
        System.out.println(originator.getState());

        originator.restoreMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
