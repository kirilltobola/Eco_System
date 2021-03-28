package com.company;

public class Herbivore extends Animal {

    public Herbivore(double initRate, double initSize, double initNeed) {
        super(initRate, initSize, initNeed);
    }

    public void nibble(Plant meal) {
        double half_plant_size = meal.getSize() / 2.;
        double ten_perscent_total_need = this.totalNeed() / 10.;
        double need_to_eat = this.stillNeed();
        double can_eat = Math.min(
                Math.min(half_plant_size, ten_perscent_total_need),
                need_to_eat
        );

        meal.nibbledOn(can_eat);
        this.eat(can_eat);
    }
}