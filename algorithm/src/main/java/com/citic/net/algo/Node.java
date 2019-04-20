package com.citic.net.algo;

/**
 * Created by gavin on 2018/10/3.
 */
public class Node<Key,Value> {
    private Key key;
    private Value value;
    private Node next;
    public Node(Key key,Value value,Node next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
