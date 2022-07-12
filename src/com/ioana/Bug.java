package com.ioana;

public class Bug extends Issue {
    private String stepsToReproduce;

    public String getStepsToReproduce() {
        return stepsToReproduce;
    }

    public void setStepsToReproduce(String stepsToReproduce) {
        this.stepsToReproduce = stepsToReproduce;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(stepsToReproduce);
    }
}
