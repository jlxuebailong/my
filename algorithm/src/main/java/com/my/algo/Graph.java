package com.my.algo;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by gavin on 2018/10/5.
 */
public class Graph {
    private final int V;
    private int E;
    private  Bag<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Bag[v];
        for(int i = 0; i<this.V; i++){
            adj[i] = new Bag<Integer>();
        }
    }

    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i=0; i<E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}
