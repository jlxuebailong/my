package com.citic.net.algo;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by gavin on 2018/9/27.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] items = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private void resize(int max){
        Item[] temp = (Item[])new Object[max];
        for(int i = 0; i < N; i++){
            temp[i] = items[i];
        }
        StdOut.println(items.length + " -->" +max);
        items = temp;
    }

    public void push(Item item){
        if(N == items.length ){
            resize( 2 * items.length);
        }
        items[N++] = item;
    }

    public Item pop(){
        Item item = items[--N];
        items[N] = null;
        if(N > 0 && N == items.length / 4){
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return items[--i];
        }
    }

    public static void main(String[] args){
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        Iterator<String> iterator = stack.iterator();
        while(iterator.hasNext()){
            StdOut.println(">"+iterator.next());
        }
    }
}

