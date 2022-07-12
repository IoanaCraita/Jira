package com.ioana;

public class Task extends Issue {
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(type);
    }
}
