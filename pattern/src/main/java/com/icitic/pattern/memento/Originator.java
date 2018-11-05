package com.icitic.pattern.memento;

/**
 * Created by gavin on 2018/10/24.
 */
public class Originator {
    private String state;

    public Originator(){}
    // 创建一个备忘录对象
    public Memento createMemento() {
        return new Memento(this);
    }
    // 根据备忘录对象恢复原发器状态
    public void restoreMemento(Memento m) {
        state = m.state;
    }

    public void setState(String state) {
        this.state=state;
    }
    public String getState() {
        return this.state;
    }

}
