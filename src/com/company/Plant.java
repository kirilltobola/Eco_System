package com.company;

public class Plant extends Organism {

    public Plant(double initRate, double initSize) {
        super(initRate, initSize);
    }

    public void nibbledOn(double amount) {
        super.alterSize(-amount);
    }
}
