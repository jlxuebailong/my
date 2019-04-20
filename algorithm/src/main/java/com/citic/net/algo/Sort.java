package com.citic.net.algo;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by gavin on 2018/9/30.
 */
public class Sort {

    public static void print(Comparable[] a){
        for(Comparable c : a){
            StdOut.print(c + " ");
        }
        StdOut.println();
    }

    public static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1,N=a.length; i<N; i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    /**
     * 选择排序
     * @param a
     */
    public static void selectionSort(Comparable[] a){
        for(int i=0,N=a.length; i<N; i++){
            int min = i;
            for(int j=i+1; j<N; j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,i,min);
        }
    }

    /**
     * 插入排序
     * @param a
     */
    public static void insertionSort(Comparable[] a){
        for(int i=1,N=a.length; i<N; i++){
            for(int j=i; j>0 && less(a[j],a[j-1]); j--){
                exch(a,j,j-1);
            }

        }
    }

    public static void shellSort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while( h < N/3 ){
            h = 3*h+1;
        }
        while(h>=1){
            StdOut.println("h : "+h);
            for(int i=h; i<N; i++){
                for(int j=i; j>=h && less(a[j],a[j-h]); j-=h){
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args){
        String[] a = new String[]{"S","H","E","L","L","S","O","R","T","E","X","A","M","P","L","E"};

        print(a);
        //selectionSort(a);
        //insertionSort(a);
        shellSort(a);
        print(a);
        assert isSorted(a);

        int h = 1,N=10000;
        while( h < N/3 ){
            h = 3*h+1;
        }
        while(h>=1) {
            StdOut.println("-----" + h);
            h = h/3;
        }
    }
}
