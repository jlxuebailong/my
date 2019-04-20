package com.citic.net.algo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by gavin on 2018/10/7.
 */
public class DepthFirstPath {

    private boolean[] marked;//这个顶点上调用过dfs()了吗?
    private int[] edgeTo;//从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;//起点

    public DepthFirstPath(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }
    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args){
        String tinyGG = "/Volumes/mac/Applications/my/algorithm/src/main/java/com/citic/algo/tinyGG.txt";
        Graph G = new Graph(new In(tinyGG));
        int s = 0;//起点
        DepthFirstPath search = new DepthFirstPath(G, s);
        for(int v=0; v<G.V(); v++){
            StdOut.print(s + " to " + v + " : ");
            if(search.hasPathTo(v)){
                for(int x : search.pathTo(v)){
                    if(x == s){
                        StdOut.print(x);
                    }else{
                        StdOut.print("-" + x);
                    }
                }
            }
            StdOut.println();
        }
    }
}
