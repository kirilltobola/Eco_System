package com.company;

public class Organism {
    private double rate;
    private double size;

    public Organism(double initRate, double initSize) {
        this.rate = initRate;
        this.size = initSize;
    }

    public void setRate(double newRate) {
        this.rate = newRate;
    }

    public void alterSize(double amount) {
        this.size += amount;
    }

    public boolean isAlive() {
        if(this.size > 0) return true;
        return false;
    }

    public double getSize() {
        return this.size;
    }

    public double getRate() {
        return this.rate;
    }

    public void death() {
        this.size = 0;
        this.rate = 0;
    }

    public void simulateWeek() {
        this.size += this.rate;
    }

}