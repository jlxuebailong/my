package com.my.pattern.templatemethod;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * Created by gavin on 2020/3/8.
 */
public class MyFrame extends JFrame {
    public MyFrame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        String msg = "I rule";
        graphics.drawString(msg, 100, 100);
        graphics.drawString(msg, 100, 150);
        graphics.drawString(msg, 100, 200);
    }

    public static void main(String[] args){
        MyFrame myFrame = new MyFrame("Head First Design Patterns");
        Hashtable hashtable = new Hashtable();
    }
}
