package com.my.pattern.proxy;

public class SubjectImpl implements Subject {
    @Override
    public void execute() {
        System.out.print("execute.....");
    }
}
