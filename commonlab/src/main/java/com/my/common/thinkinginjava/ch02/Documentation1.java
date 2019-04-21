//: com.my.common.thinkinginjava.ch02/Documentation1.java
package com.my.common.thinkinginjava.ch02;

import java.util.Date;

/** A class comment
 * @author gavin
 * @since 2019/4/21.
 * @version 1.0
 */
public class Documentation1 {
    /** A field comment
     *  I am a int field
     */
    public int i;

    /** A method comment
     *
     */
    public void f(){}

    /** A printDate method
     *  <pre>
     *      System.out.println(new Date());
     *  </pre>
     *  You can <em>event</em> insert a list:
     *  <ol>
     *      <li>Item one</li>
     *      <li>Item two</li>
     *      <li>Item three</li>
     *  </ol>
     */
    public void printDate(){
        System.out.println(new Date());
    }
}///:~
