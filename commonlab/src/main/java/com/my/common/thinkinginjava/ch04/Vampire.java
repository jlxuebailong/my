package com.my.common.thinkinginjava.ch04;
import java.util.ArrayList;
import java.util.List;

import static com.my.common.thinkinginjava.util.Print.*;
/**
 * 吸血鬼数字
 * 例中以下数字就是吸血鬼数字
 * 1260 = 21 * 60
 * 1827 = 21 * 87
 * 2187 = 27 * 81
 */
public class Vampire {

    /**
     * 判断这两个数字的乘积是不是吸血鬼数字
     * @param n1
     * @param n2
     * @return
     */
    static boolean isVampire(int n1, int n2){
        String nr = String.valueOf(n1 * n2);
        String ns = String.valueOf(n1) + String.valueOf(n2);
        for(int i=0; i<ns.length(); i++){
           if(nr.indexOf(ns.charAt(i)) == -1){
               return false;
           }else{
               nr = nr.replaceFirst(String.valueOf(ns.charAt(i)),"#");
           }
        }
        return true;
    }

    public static void main(String[] args){

        //System.out.println(isVampire(21,60));
        //System.out.println(isVampire(21,87));
        //System.out.println(isVampire(27,81));

        List<String> vampireNums = new ArrayList<>();
        for(int i = 10; i < 99; i++){
            for(int j = 10; j < 99; j++){
                if(isVampire(i, j)) {
                    vampireNums.add((i * j) + "(=" +i + "*" + j+")");
                }
            }
        }

        println(vampireNums);
    }
}
