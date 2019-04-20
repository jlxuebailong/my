package com.my.algo;

import edu.princeton.cs.algs4.StdOut;

/**
 * 顺序查找(基于无序链表)
 *
 * Created by gavin on 2018/10/3.
 */
public class SequentialSearchST<Key,Value> {

    private Node<Key,Value> first;
    private int size = 0;

    public Value get(Key key){
        for(Node<Key,Value> n = first; n != null; n = n.getNext()){
            if(n.getKey().equals(key)){
                return n.getValue();
            }
        }
        return null;
    }

    public void put(Key key,Value value){
        for(Node<Key,Value> n = first; n != null; n = n.getNext()){
            if(n.getKey().equals(key)){
                n.setValue(value);
                return;
            }
        }
        first = new Node(key,value,first);
        size++;
    }

    public void delete(Key key){
        first = delete(first,key);
    }

    private Node delete(Node node,Key key){
        if(node == null){
            return null;
        }
        if(node.getKey().equals(key)){
            size--;
            return node.getNext();
        }
        node.setNext(delete(node.getNext(), key));
        return node;
    }


    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void show(){
        StdOut.println("Size : "+size()+", IsEmpty : "+isEmpty());
        for(Node<Key,Value> n = first; n != null; n = n.getNext()){
            StdOut.print(n.getKey()+":"+n.getValue()+" <-- ");
        }
        StdOut.println();
    }


    public static void main(String[] args){
        SequentialSearchST<String, Integer> ssst = new SequentialSearchST();
        ssst.put("a",1);
        ssst.put("b",2);
        ssst.put("c",3);

        ssst.put("d",4);
        ssst.show();
        ssst.delete("b");
        ssst.show();
        ssst.delete("a");
        ssst.show();
        ssst.delete("d");
        ssst.show();
        ssst.delete("c");
        ssst.show();
    }
}
