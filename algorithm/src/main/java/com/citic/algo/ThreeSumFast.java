package com.citic.algo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * Created by gavin on 2018/9/28.
 */
public class ThreeSumFast {
    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i=0; i<N; i++){
            StdOut.println( i );
            for(int j=i+1; j<N; j++) {
                if (BinarySearch.rank(-a[i] - a[j], a) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Stopwatch stopwatch = new Stopwatch();
        String txt = "/Volumes/mac/Applications/my/algorithm/src/main/resources/algs4-data/1Mints.txt";
        In in = new In(txt);
        int[] a = in.readAllInts();

        int cnt = count(a);
        StdOut.println(cnt + " times : "+stopwatch.elapsedTime());

    }
}
