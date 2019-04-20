package com.citic.net.algo;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;

/**
 * Created by gavin on 2018/9/26.
 */
public class BinarySearch {

    //二分查找
    public static int rank(int key, int[] array){
        int lo = 0;
        int hi = array.length - 1;
        while( lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < array[mid]){
                hi = mid - 1;
            }else if(key > array[mid]){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        int[] array = {1,2,3,5,6,7,8,10,100};
       /* Scanner sc = new Scanner(System.in);
        int key = Integer.parseInt(sc.nextLine());
        while( key != 0) {
            System.out.println("key = "+key);
            int location = rank(key, array);
            System.out.println(location);
            key = Integer.parseInt(sc.nextLine());
        }*/

        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key,array) != -1){
                StdOut.println(key);
            }
        }
    }
}
