package com.my.pattern.memento;

/**
 * Created by gavin on 2018/10/24.
 */
//不带public, 包内可见
 class Memento {

    public String state;

    public Memento(Originator o) {
        this.state = o.getState();
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
