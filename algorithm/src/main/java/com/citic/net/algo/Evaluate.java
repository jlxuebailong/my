package com.citic.net.algo;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by gavin on 2018/9/27.
 */
public class Evaluate {

    public static void main(String[] args){
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            //StdOut.println("'"+s+"' ");
            if (s.equals("(")) {
            }else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")
                    || s.equals("sqrt")){
                ops.push(s);
            }else if(s.equals(")")){
                String op = ops.pop();
                double d1 = vals.pop();
                if(op.equals("+")) {
                    vals.push(vals.pop() + d1);
                }else if(op.equals("-")){
                    vals.push(vals.pop() - d1);
                }else if(op.equals("*")){
                    vals.push(vals.pop() * d1);
                }else if(op.equals("/")){
                    vals.push(vals.pop() / d1);
                }else if(op.equals("sqrt")){
                    vals.push(Math.sqrt(d1));
                }
            }else if(s.equals("=")){
                StdOut.print(vals.pop());
            }else{
                vals.push(Double.parseDouble(s));
            }
        }

    }
}
