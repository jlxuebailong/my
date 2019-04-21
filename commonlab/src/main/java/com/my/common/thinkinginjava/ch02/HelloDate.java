//: com.my.common.thinkinginjava.ch02/HelloDate.java
package com.my.common.thinkinginjava.ch02;

import java.util.Date;

/** The first Thinking in Java example program.
 * Display a string and today`s date.
 * @author gavin.xue
 * @author www.samex.com
 * @date 2019/4/21
 * @version 1.0
 */
public class HelloDate {
    /** Entry point to class & application.
     *  @param args array of string arguments
     *  @throws exceptions No exceptions thrown
     */
    public static void main(String[] args){
        System.out.println("Hello it`s: \n"  + (new Date()));
    }
}/* Output: (55% match)
Hello it`s:
WSun Apr 21 10:49:39 CST 2019
*///:~
