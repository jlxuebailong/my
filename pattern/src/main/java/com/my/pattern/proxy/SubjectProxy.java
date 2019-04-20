package com.my.pattern.proxy;

public class SubjectProxy implements Subject {

    private Subject subject;

    public SubjectProxy(){
        this.subject = subject = new SubjectImpl();
    }

    public SubjectProxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public void execute() {
        subject.execute();
    }

}
