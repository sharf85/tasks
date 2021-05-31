package de.telran;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Auto mazda = new Auto("Mazda", 2000);
        Auto chevrolet = new Auto("Chevrolet", 1500);
        Auto opel = new Auto("Opel", 3000);
        Auto bentley = new Auto("Mazda", 4000);
        Auto mers = new Auto("Bentley", 4000);


        TreeSet<Auto> autos = new TreeSet<>(new Comparator<Auto>() {
            @Override
            public int compare(Auto o1, Auto o2) {
                return o1.price - o2.price;
            }
        });

        System.out.println(autos.add(mazda));//true
        System.out.println(autos.add(chevrolet));//true
        System.out.println(autos.add(opel));//true
        System.out.println(autos.add(bentley));//true

        System.out.println(autos.add(mers));//false

        System.out.println(autos.contains(mers));//true
    }
}

class Auto {
    String make;
    int price;

    public Auto(String make, int price) {
        this.make = make;
        this.price = price;
    }
}
