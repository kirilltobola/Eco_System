package com.company;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    static Random random = new Random();
    static final int MANY_WEEDS = 2000;
    static final double WEED_SIZE = 15;
    static final double WEED_RATE = 2.5;

    static final int INIT_FISH = 300;
    static final double FISH_SIZE = 50;
    static final double FRACTION = 0.5;
    static final int AVERAGE_NIBBLES = 30;
    static final double BIRTH_RATE = 0.05;

    static void pondWeek(ArrayList<Herbivore> fishes, ArrayList<Plant> weeds){

        int manyIterations = AVERAGE_NIBBLES * fishes.size();
        for (int i = 0; i < manyIterations; ++i){
            Herbivore random_fish = fishes.get(
                    random.nextInt(fishes.size())
            );
            Plant random_plant = weeds.get(
                    random.nextInt(weeds.size())
            );

            random_fish.nibble(random_plant);
        }

        for (Plant plant : weeds) {
            plant.simulateWeek();
        }

        Iterator<Herbivore> iterFishes = fishes.iterator();
        while(iterFishes.hasNext()){
            Herbivore fish = iterFishes.next();
            fish.simulateWeek();
            if(!fish.isAlive()){
                iterFishes.remove();
            }
        }

        int newFishPopulation = (int) Math.floor(BIRTH_RATE * fishes.size());
        for (int i = 0; i < newFishPopulation; i++){
            fishes.add(new Herbivore (0, FISH_SIZE, FISH_SIZE * FRACTION));
        }
    }

    static double totalMass(ArrayList<Plant> weeds){
        double totalMass = 0;
        for(Plant plant: weeds){
            totalMass += plant.getSize();
        }
        return totalMass;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Plant> weeds = new ArrayList(MANY_WEEDS);
        ArrayList<Herbivore> fish = new ArrayList(INIT_FISH);

        Scanner in = new Scanner(System.in);
        int manyWeeks;   // Количество недель для моделирования
        int i;

        System.out.println("How many weeks shall I simulate? ");
        manyWeeks=in.nextInt();

        //Создание популяции травоядных рыб
        for (i=0; i < INIT_FISH; i++)
            fish.add(new Herbivore (0, FISH_SIZE, FISH_SIZE * FRACTION));

        //Создание популяции растений
        for (i=0; i < MANY_WEEDS; i++)
            weeds.add(new Plant(WEED_RATE, WEED_SIZE));

        //Моделирование жизни в пруду
        FileWriter fileWriter = new FileWriter("out.csv", false);
        for (i = 0; i < manyWeeks; i++){
            pondWeek(fish, weeds);
            System.out.println((i+1)+"\t"+fish.size() + "\t"+totalMass(weeds));

            fileWriter.append((i+1) + ";" + fish.size() + ";" + Math.round(totalMass(weeds)) + '\n');
        }
        fileWriter.flush();
    }
}
