package com.company;

public class Animal extends Organism {
    private double needEachWeek;
    private double eatenThisWeek;

    public Animal(double initRate, double initSize, double initNeed) {
        super(initRate, initSize);
        this.needEachWeek = initNeed;
    }

    public void simulateWeek() {
        super.simulateWeek();
        if(this.eatenThisWeek < this.needEachWeek) super.death();
        else this.eatenThisWeek = 0;
    }

    public double totalNeed() {
        return this.needEachWeek;
    }

    public void setNeed(double newNeed) {
        this.needEachWeek = newNeed;
    }

    public double stillNeed() {
        if(this.needEachWeek <= this.eatenThisWeek) return 0;
        return this.needEachWeek - this.eatenThisWeek;
    }

    public void eat(double amount) {
        this.eatenThisWeek += amount;
    }

}